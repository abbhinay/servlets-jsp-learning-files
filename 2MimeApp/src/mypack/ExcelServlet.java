package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.crypto.provider.RSACipher;


//@WebServlet("/WordServlet")
public class ExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/vnd.ms-excel");
		PrintWriter out=response.getWriter();
		out.println("abhinav\tdeveloper\t50000");
		out.println("abhinav\tdeveloper\t50000");
		out.println("abhinav\tdeveloper\t50000");
		
	}

}
