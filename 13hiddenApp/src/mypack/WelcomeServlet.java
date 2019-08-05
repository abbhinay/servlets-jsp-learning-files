package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("t1");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("Welcome: "+name);
		out.println("<form action='tour'>");
		out.println("<input type=hidden name=t1 value=\""+name+"\">");
		out.println("<input type='submit' value='tour'>");
		out.println("</form>");
	}

}
