package mypack;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
//@WebServlet("/Down  loadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path="d:\\";
		String name="Main.java";
		PrintWriter out=response.getWriter();
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition","attachement;filename=\""+name+"\"");
		FileInputStream fin=new FileInputStream(path+name);
		int a;
		while(true)
		{
			a=fin.read();
			if(a==-1)
				break;
				out.write(a);
		}
		out.close();
		fin.close();
	}

}
