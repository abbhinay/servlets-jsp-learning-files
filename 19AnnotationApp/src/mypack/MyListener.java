package mypack;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class MyListener implements ServletContextListener {

	ServletContext ctx;
	public void contextInitialized(ServletContextEvent sce)  { 
        // TODO Auto-gnerated method stub
		ctx=sce.getServletContext();
		ctx.setAttribute("hitcount", 0);
		System.out.println("hitcount set to zero");
   }
        public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	
	
}
