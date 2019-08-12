<jsp:useBean id="mybean" class="mypack.User" scope="session"/>
<h1>Following data found in session scope</h1>
<hr>
Name:<jsp:getProperty property="name" name="mybean"/><br>
Mail:<jsp:getProperty property="mail" name="mybean"/><br>
Pass:<jsp:getProperty property="pass" name="mybean"/><br>