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

import Impl.FoodDaoImpl;
import POJO.Food;


@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FoodDaoImpl fdimpl = new FoodDaoImpl();
	List flist;
	boolean flag;
	String msg,errmsg;
	HttpSession session;
	Food f;
	RequestDispatcher rd;
    
    public FoodServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String process=request.getParameter("process");
		session=request.getSession();
		if(process!=null && process.equals("allFood")) {
			flist=fdimpl.getAllFood();
			session.setAttribute("flistObj", flist);
			response.sendRedirect("FoodList.jsp");
			
		}
		else if(process!=null && process.equals("updateFood")){
			int foodId = Integer.parseInt(request.getParameter("foodId"));
			f=fdimpl.searchFood(foodId);
			session.setAttribute("fObj",f);
			response.sendRedirect("UpdateFood.jsp");
		}
		else if(process!=null && process.equals("deleteFood")) {
			int foodId = Integer.parseInt(request.getParameter("foodId"));
			flag=fdimpl.deleteFood(foodId);
			if(flag) {
				msg="Sucessfully Deleted";
				request.setAttribute("msg",msg);
				RequestDispatcher rd = request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			}
			else {
				errmsg="Not deleted";
				request.setAttribute("errmsg",errmsg);
				RequestDispatcher rd = request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			}
		}
		
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
		PrintWriter out=response.getWriter(); 
		String Process=request.getParameter("process");
		HttpSession session = request.getSession();
		
		if(Process!=null && Process.equals("addFood")) {
			String foodName = request.getParameter("foodName");
			String foodType = request.getParameter("foodType");
			String foodCategory = request.getParameter("foodCategory");
			String foodDescription = request.getParameter("foodDescription");
			double foodPrice =Double.parseDouble(request.getParameter("foodPrice"));
			String foodImage = request.getParameter("foodImage");
			
			Food f= new Food(foodName,foodType,foodCategory,foodDescription,foodPrice,foodImage);
			flag=fdimpl.addFood(f);
			
			if(flag) {
				
				msg="Successfully Inserted";
				request.setAttribute("msg",msg);
				RequestDispatcher rd = request.getRequestDispatcher("AddFood.jsp");
				rd.forward(request, response);
				
			}
			else {
				errmsg="Not inserted";
				request.setAttribute("errmsg",errmsg);
				RequestDispatcher rd = request.getRequestDispatcher("AddFood.jsp");
				rd.forward(request, response);
			}
			
		}
	
		else if(Process!=null && Process.equals("editFood")) {
			int foodId = Integer.parseInt(request.getParameter("foodId"));
			String foodName = request.getParameter("foodName");
			String foodType = request.getParameter("foodType");
			String foodCategory = request.getParameter("foodCategory");
			String foodDescription = request.getParameter("foodDescription");
			double foodPrice =Double.parseDouble(request.getParameter("foodPrice"));
			String foodImage = request.getParameter("foodImage");
			
			f= new Food(foodId,foodName,foodType,foodCategory,foodDescription,foodPrice,foodImage);
			flag=fdimpl.updateFood(f);
			
			if(flag) {
				msg="Successfully Updated";
				request.setAttribute("msg",msg);
				RequestDispatcher rd = request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			}
			else {
				errmsg="Not Updated";
				request.setAttribute("errmsg",errmsg);
				RequestDispatcher rd = request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			}
			
		}
	}

}
