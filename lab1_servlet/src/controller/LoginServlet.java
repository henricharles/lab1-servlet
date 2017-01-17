package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	User user;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		user=new User();
		user.setUserName(uname);
		user.setPassword(pwd);
		String errormessage="";
		UserService uservice=new UserService();
		HttpSession session=request.getSession();
		session.setAttribute("user",uname);
		if(uservice.userAut(user))
		{
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			rd.forward(request,response);
			
		}
		else
		{
			errormessage=errormessage+"sorry your enter wrong username and password";
			session.setAttribute("msg",errormessage);
			RequestDispatcher rd=request.getRequestDispatcher("LoginServlet.jsp");
			rd.forward(request,response);
		}
		
	}

}
