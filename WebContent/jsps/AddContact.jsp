<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add your contact</title>
</head>
<body>
<form action="../addContact" method="post">
First Name: <input	type="text" name="fName" /><br>
Middle Name:<input type="text" name="mName" /><br>
Last Name: <input type="text" name="lName" /><br>
Age: <input type="text" name="age" /><br>
Gender: <input type="text" name="gender" /> <br>
Email: <input type="text" name="email" /><br>
<input type="submit" value="Submit Contact"></input></form>
</body>
</html>
