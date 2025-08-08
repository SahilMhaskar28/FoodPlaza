package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Impl.OrderDaoImpl;
import POJO.OrderFood;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession session;
	OrderFood o;
	OrderDaoImpl odimpl= new OrderDaoImpl();
	boolean flag;
	String msg,errmsg;
	RequestDispatcher rd;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=(String) request.getParameter("process");
		
		if(process!=null && process.equals("myOrders")) {
			session=request.getSession();
			String emailId=(String)session.getAttribute("userName");
			List oList=odimpl.showMyOrderHistory(emailId);
			
			if(oList==null && oList.isEmpty()) {
				errmsg="Order is not Placed ... Try Again!!";
				request.setAttribute("errmsg",errmsg);
				rd=request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
				
			}
			else {
				request.setAttribute("oList",oList);
				rd=request.getRequestDispatcher("OrderList.jsp");
				rd.forward(request, response);
			}
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session=request.getSession();
		PrintWriter out = response.getWriter();
		String process =request.getParameter("process");
		if(process!=null && process.equals("placeOrder")) {
			
			String emailId=(String)session.getAttribute("userName");
			String OrderStatus="OrderConfirm";
			o=new OrderFood();
			o.setEmailId(emailId);
			o.setOrderStatus(OrderStatus);
			
			flag=odimpl.placeOrder(o);
			
			if(flag) {
				msg="Order Placed Successfully";
				request.setAttribute("msg",msg);
				rd=request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
				
			}
			else {
				errmsg="Order Not Placed Successfully";
				request.setAttribute("errmsg",errmsg);
				rd=request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
				
			}
			 
		}
		
	}

}
