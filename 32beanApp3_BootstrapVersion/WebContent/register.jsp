<jsp:useBean id="mybean" class="mypack.Emp"/>
<jsp:setProperty property="*" name="mybean"/>
<%
	if(mybean.register())
		out.println("successfully registered");
	else
		out.println("registration failed");
%>