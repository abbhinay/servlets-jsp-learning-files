package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;


//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String mail=request.getParameter("t1");
		String pass=request.getParameter("t2");
		User u=new User();
		u.setMail(mail);
		u.setPassword(pass);
		UserDao dao=new UserDao();
		/*String result=dao.login(u);
		if(result.equals("success"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("/success.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("/failure.jsp");
			rd.forward(request, response);
		}*/
		ResultSet rs=dao.login(u);
		if(rs.next())
		{
			String name=rs.getString(1);
			request.setAttribute("user", name);
			RequestDispatcher rd=request.getRequestDispatcher("/success.jsp");
			rd.forward(request, response);	
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("/failure.jsp");
			rd.forward(request, response);
		}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

}
