<jsp:useBean id="mybean" class="mypack.User" scope="session"/>
<jsp:setProperty property="*" name="mybean"/>
<%
	if(mybean.register())
	{
		out.println("successfully registered");
		out.println("<br><a href='view.jsp'>view bean data</a>");
	}
	else
	{
		out.println("not registered");
%>
<jsp:include page="index.html"/>
<%
	}
%>