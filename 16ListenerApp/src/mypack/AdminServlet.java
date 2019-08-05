package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext ctx;
		ctx=getServletConfig().getServletContext();
		Integer c=(Integer)ctx.getAttribute("current");
		Integer t=(Integer)ctx.getAttribute("total");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("current="+c);
		out.println("<br>total="+t);
		out.println("<br><a href='admin'>refresh</a>");
	}

}
