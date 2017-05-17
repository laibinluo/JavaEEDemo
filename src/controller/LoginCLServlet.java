package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class LoginCLServlet
 */
@WebServlet("/Login")
public class LoginCLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		User user =  new User(account, password);
		try{
			if(user.isExist()){
				response.sendRedirect("/JavaEEDemo/Welcome");
			}else {
				response.sendRedirect("/JavaEEDemo/Error");
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
//		if("admin".equals(account) && "123456".equals(password)){
//			response.sendRedirect("/JavaEEDemo/Welcome");
//		}else {
//			response.sendRedirect("/JavaEEDemo/Error");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
