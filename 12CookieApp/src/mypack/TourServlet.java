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
public class TourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name="guest";
		Cookie[] ck=request.getCookies();
		if(ck!=null)
		{
			name=ck[0].getValue();
			out.println("sorry: "+name+" site is underconstructing visit again later----");
		}
		else {
			out.println("sorry: "+name+" site is underconstructing visit again later.....");
		}
	}

}
