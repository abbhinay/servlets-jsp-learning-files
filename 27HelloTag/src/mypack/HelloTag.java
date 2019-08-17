package mypack;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class HelloTag extends TagSupport {

	//data member to store attribute value
	private String user;
	
	//setter method to set the value of attribute
	public void setUser(String user) {
		this.user = user;
	}
	
	//to display welcome message for the user
	public int doEndTag()
	{
		JspWriter out=pageContext.getOut();
		try
		{
		out.println("Welcome, "+user+"<br/>");
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		return EVAL_PAGE;
	}
	
}
