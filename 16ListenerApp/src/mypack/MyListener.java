package mypack;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


//@WebListener
public class MyListener implements ServletContextListener, HttpSessionListener {

	ServletContext ctx;
	public void contextInitialized(ServletContextEvent sce)  { 
        ctx=sce.getServletContext();
        ctx.setAttribute("current", 0);
        ctx.setAttribute("total", 0);
        System.out.println("context initialized counters are set");
   }
	
	public void contextDestroyed(ServletContextEvent sce)  { 
        // TODO Auto-generated method stub
   }

	
      public void sessionCreated(HttpSessionEvent se)  { 
         
    	  Integer c=(Integer)ctx.getAttribute("current");
    	  c=c+1;
    	  ctx.setAttribute("current", c);
    	  Integer t=(Integer)ctx.getAttribute("total");
    	  t=t+1;
    	  ctx.setAttribute("total", t);
    	  System.out.println("session created, counter are incremented,"+c+" "+t);
    	  
    }

	public void sessionDestroyed(HttpSessionEvent se)  { 
		Integer c=(Integer)ctx.getAttribute("current");
  	  	c=c-1;
  	  	ctx.setAttribute("current", c);
  	  System.out.println("session destroyed, counter are decremented,"+c);
    }


	
}
