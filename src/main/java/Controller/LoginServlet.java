package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Impl.LoginDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LoginDaoImpl limpl = new LoginDaoImpl();
	boolean flag;
	String login,msg,errmsg;
	HttpSession session;
	RequestDispatcher rd;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session=request.getSession();
		
		session.invalidate();
		
		request.setAttribute("errmsg","Logged Out Successfully !!");
		rd=request.getRequestDispatcher("MyIndex.jsp");
		rd.forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		PrintWriter out = response.getWriter();
		String userName= request.getParameter("userName");
		String password= request.getParameter("password");
		flag = limpl.userLogin(userName,password);
		
		if(flag) {
			login="customer";
			session.setAttribute("login",login);
			session.setAttribute("userName",userName );
			msg="Login sucessfully by Customer";
			request.setAttribute("msg",msg);
			rd=request.getRequestDispatcher("MyIndex.jsp");
			rd.forward(request, response);
		}
		else {
		flag=limpl.adminLogin(userName, password);
			if(flag) {
				login="admin";
				session.setAttribute("login",login);
				session.setAttribute("userName",userName );
				msg="Login sucessfully by Admin";
				request.setAttribute("msg",msg);
				rd=request.getRequestDispatcher("MyIndex.jsp");
				rd.forward(request, response);
				
			}
			else {
				login=null;
				errmsg="Invlid username or password";
				request.setAttribute("errmsg",errmsg);
				rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		}
		
	}

}
