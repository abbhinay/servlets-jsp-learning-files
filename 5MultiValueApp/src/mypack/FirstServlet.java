package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("t1");
		String mail=request.getParameter("t2");
		String[] data=request.getParameterValues("course");
		out.println("Welcome :"+name);
		out.println("U have shown intrest in following courses...");
		for(String value: data)
			out.println(value+"<br>");
		out.println("<br>Our course counsellor will contact u soon on ur mail id: "+mail);
	}

}
