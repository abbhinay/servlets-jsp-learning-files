package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("t1");
		String pass = request.getParameter("t2");
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// Connection
			// con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root",
			// "abc123");
			ServletContext ctx = getServletConfig().getServletContext();
			String dclass = ctx.getInitParameter("dclass");
			String constr = ctx.getInitParameter("constr");
			String user = ctx.getInitParameter("user");
			String password = ctx.getInitParameter("pass");
			System.out.println(dclass + " " + constr + " " + user + " " + password);
			Class.forName(dclass);
			Connection con = DriverManager.getConnection(constr, user, password);
			PreparedStatement psmt = con.prepareStatement("select * from user where name=? and password=?");
			psmt.setString(1, name);
			psmt.setString(2, pass);
			ResultSet res = psmt.executeQuery();
			RequestDispatcher rd = null;
			if (res.next()) {
				String role = res.getString(3);
				request.setAttribute("user", role);
				rd = request.getRequestDispatcher("/welcome");
				rd.forward(request, response);
			} else {
				out.println("incorrect username & password try again");
				rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
