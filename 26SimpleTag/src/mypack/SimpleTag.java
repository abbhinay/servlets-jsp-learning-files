package mypack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SimpleTag extends TagSupport {
	
	public int doStartTag()
	{
		JspWriter out=pageContext.getOut();
		try
		{
		out.println("It is generated by doStartTag().<br/>");
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		//return EVAL_BODY_INCLUDE;
		return SKIP_BODY;
	}
	public int doEndTag()
	{
		JspWriter out=pageContext.getOut();
		try
		{
		out.println("It is generated by doEndTag().<br/>");
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		//return EVAL_PAGE
		return SKIP_PAGE;
	}
	
}
