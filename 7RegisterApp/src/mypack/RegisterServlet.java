package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("t1");
		String mail=request.getParameter("t2");
		String pass=request.getParameter("t3");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "abc123");
			PreparedStatement psmt=con.prepareStatement("insert into user9 values(?,?,?)");
			psmt.setString(1, name);
			psmt.setString(2, mail);
			psmt.setString(3, pass);
			int a=psmt.executeUpdate();
			if(a>0)
				out.println("successfully inserted");
			else
				out.println("registration failed");
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
