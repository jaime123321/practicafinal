<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h1>Register</h1>
    <form action="RegisterServlet" method="post">
    
    	<label>First Name :: </label>
    	<input name="fname" id="n1" type="text"/>
    	<br><br>
    	
    	<label>Last Name :: </label>
    	<input name="lname" id="n2" type="text"/>
    	<br><br>
    	
    	<label>Email :: </label>
    	<input name="email" id="n3" type="text"/>
    	<br><br>
    	
    	<label>Password :: </label>
    	<input name="pword" id="n4" type="password"/>
    	<br><br>
    	
    	<input name="submit" type="submit" value="Submit">
    	
    </form>
</body>
</html>