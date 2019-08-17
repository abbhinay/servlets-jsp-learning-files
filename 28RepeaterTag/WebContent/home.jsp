<%@ taglib uri="demo/tags" prefix="tm" %>

<%
String uname=request.getParameter("name");
%>

<tm:repeat counter="10">
<tm:hello user="<%=uname %>"/>
</tm:repeat>
