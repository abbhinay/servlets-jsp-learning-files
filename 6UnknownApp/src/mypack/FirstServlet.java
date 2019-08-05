package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
		Enumeration<String> pnames=request.getParameterNames();
		while(pnames.hasMoreElements())
		{
			String pname=pnames.nextElement();
			out.println("parameter-name="+pname);
			String[] data=request.getParameterValues(pname);
			for(String value: data)
				out.println(value+"<br>");
			
		}
	}

}
