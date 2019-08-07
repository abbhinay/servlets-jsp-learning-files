<%@ page isErrorPage="true" %>
<%
	if(exception instanceof NumberFormatException)
		out.println("provide only no");
	else if(exception instanceof ArithmeticException)
		out.println("second no should ot be zero");
	else
		out.println(exception.toString());
%>