package mypack;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.*;

public class CaseChangerTag extends BodyTagSupport {

	String target;
	
	public void setTarget (String t)
	{
		target=t;
	}
		
	public int doStartTag()
	{
		return EVAL_BODY_BUFFERED;
	}
	public int doEndTag()
	{
		JspWriter out=pageContext.getOut();
		String body=bodyContent.getString();
		String str;
		if(target.equalsIgnoreCase("lower"))
			str=body.toLowerCase();
		else
			str=body.toUpperCase();
		try{
			out.println(str+"<br/>");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return EVAL_PAGE;	
	}	
}