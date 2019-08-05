<%@ page import="java.sql.*" %>
<% 
	String name=request.getParameter("t1");
	String pass=request.getParameter("t2");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","abc123");
	PreparedStatement psmt=con.prepareStatement("select * from user9 where name=? and pass=?");
	psmt.setString(1, name);
	psmt.setString(2, pass);
	ResultSet rs=psmt.executeQuery();
	if(rs.next())
	{
		out.println(rs.getString(1)+" u are successfully login");
	}
	else
	{
		out.println("incorrect username & password,try again");
%>
<jsp:include page="index.jsp"/>
<% }%>