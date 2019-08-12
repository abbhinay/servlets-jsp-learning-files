<jsp:useBean id="mybean" class="mypack.User"/>
<jsp:setProperty property="*" name="mybean"/>
<%
	if(mybean.register())
		out.println("successfully registered");
	else
	{
		out.println("not registered");
%>
<jsp:include page="index.html"/>
<%
	}
%>