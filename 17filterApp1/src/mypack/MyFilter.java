package mypack;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


//@WebFilter("/MyFilter")
public class MyFilter implements Filter {

	FilterConfig cg;
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		cg=fConfig;
	}
  	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		String uri=req.getRequestURI();
		String url=cg.getInitParameter("url");
		if(uri.endsWith("html")||uri.endsWith(url))
		{
			chain.doFilter(request, response);
		}
		else
		{
			HttpSession session=req.getSession(false);
			if(session!=null)
			{
				System.out.println("session is not null");
				chain.doFilter(request, response);
				
			}
			else
			{
				System.out.println("session is null");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.forward(request, response);
			}
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}


}
