<%!
	String name;
	public String show()
	{
		return "hello: "+name;
	}
%>
<% 
// 	String name=request.getParameter("t1");
	name=request.getParameter("t1");
	out.println("welcome: "+name);
	
%>
<%=show() %> 