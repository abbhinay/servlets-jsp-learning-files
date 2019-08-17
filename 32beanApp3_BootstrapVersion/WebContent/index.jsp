<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="design.jsp"/>
<div class="container">
<form method="get" action="register.jsp">
<div class="form-group">
<label for="name">Name</label>
<input type="text" name="name" class="form-control" placeholder="enter name"><br>
</div>
<div class="form-group">
<label for="mail">Email</label>
<input type="email" name="mail" class="form-control" placeholder="enter mail"><br>
</div>
<div class="form-group">
<label for="password">Password</label>
<input type="password" name="pass" class="form-control" placeholder="enter pass"><br>
</div>
<button type="submit" class="btn btn-default">regiister</button>
</form>
</div>
</body>
</html>