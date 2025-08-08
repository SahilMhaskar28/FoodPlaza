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

import Impl.CartDaoImpl;
import POJO.Cart;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Cart cart;
    HttpSession session;
    boolean flag;
    String msg,errmsg;
    List cList;
    RequestDispatcher rd ;
    CartDaoImpl cdimpl=new CartDaoImpl();
   
    
    public CartServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
			
		PrintWriter out = response.getWriter();
		String process=request.getParameter("process");
		session=request.getSession();
		
		if(process!=null && process.equals("addToCart")) {
			
			int foodId = Integer.parseInt(request.getParameter("foodId"));
			int quantity =1;
			String email = (String) session.getAttribute("userName");
			
			cart=new Cart();
			cart.setFoodid(foodId);
			cart.setFquantity(quantity);
			cart.setcEmail(email);
			
			flag=cdimpl.addToCart(cart);
			
			if(flag) {
				msg="Item Added into Cart";
				request.setAttribute("msg",msg);
				rd = request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);

			}
			else {
				errmsg=" Something Wrong !! Not Added into Cart";
				request.setAttribute("errmsg",msg);
			    rd = request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);

			}
			
		}
		else if(process!=null && process.equals("showMyCart")) {
			
			String email = (String) session.getAttribute("userName");
			
			cList= cdimpl.searchCartByEmailId(email);
			request.setAttribute("cObj",cList);
			rd=request.getRequestDispatcher("CartList.jsp");
			rd.forward(request, response);
			
		}
		else if(process!=null && process.equals("deleteItem")) {
			int cartId=Integer.parseInt(request.getParameter("cartid"));
			flag=cdimpl.deleteCartById(cartId);
			if(flag) {
				msg="Item Successfully deleted from Cart";
				request.setAttribute("msg",msg);
			    rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}
			else {
				errmsg="Item Not deleted from Cart";
				request.setAttribute("errmsg",msg);
			    rd = request.getRequestDispatcher("CartList.jsp");
				rd.forward(request, response);
			}
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String process=request.getParameter("process");
		session=request.getSession();
		
		if(process!=null && process.equals("updateCartQuantity")) {
			int cartid=Integer.parseInt(request.getParameter("cartid"));
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			
			flag=cdimpl.updateCart(cartid, quantity);
			if(flag) {
				cart=cdimpl.searchCartById(cartid);
				double totalPrice=cart.getTotalPrice();
				out.print(totalPrice);
			}
			
		}
	}

}
