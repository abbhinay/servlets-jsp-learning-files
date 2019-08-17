package mypack;

import javax.servlet.jsp.tagext.*;

public class RepeaterTag extends TagSupport {

	int counter;
	
	public void setCounter (String c)
	{
		this.counter=Integer.parseInt(c);
	}
	
	public int doStartTag()
	{
		return EVAL_BODY_INCLUDE;
		//return SKIP_BODY;
	}
	
	public int doAfterBody()
	{
		counter--;
		if(counter>0)
		return EVAL_BODY_AGAIN;
		else
		return SKIP_BODY;	
	}
	
}

