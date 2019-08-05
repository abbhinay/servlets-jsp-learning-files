package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		//obtain servletcontext o app1 from server
		ServletContext ctx1=getServletConfig().getServletContext();
		//obtain ref of servletcontext of app2 from servletcontext of app1
		ServletContext ctx2=ctx1.getContext("/app2");
		System.out.println("ctx2="+ctx2);
		if(ctx2!=null)
		{
			System.out.println("obtain successfully");
			RequestDispatcher rd=ctx2.getRequestDispatcher("/second");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("cant be obtain");
			out.println("either app2 is not deployed or server is not "
					+ "configured for cross context request");
		}
	}

}
