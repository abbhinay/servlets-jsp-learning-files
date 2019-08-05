package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//this method is invoked by init(ServletConfig) method 
	//it is overloaded method in GenericServlet class
	@Override
	public void init() throws ServletException {
		
		ServletConfig  config=getServletConfig();
		System.out.println(config.getServletName()+" obj is created");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println(getServletConfig().getServletName()+" obj is created<br>" );
	}

}
