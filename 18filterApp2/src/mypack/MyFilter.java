package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//@WebFilter("/MyFilter")
public class MyFilter implements Filter {

  	FilterConfig config;
  	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
  		config=fConfig;
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("filter is invoked");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("filter is invoked");
		chain.doFilter(request, response);
		System.out.println("control back to filter");
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
