<%@ taglib uri="demo/tags" prefix="tm" %>

<%
String uname=request.getParameter("name");
%>

<tm:hello user="<%=uname %>"/>