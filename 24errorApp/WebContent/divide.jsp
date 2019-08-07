<%@ page errorPage="error.jsp" %>
<%
	int a=Integer.parseInt(request.getParameter("t1"));
	int b=Integer.parseInt(request.getParameter("t2"));
	int c=a/b;
	out.println("result="+c);
%>