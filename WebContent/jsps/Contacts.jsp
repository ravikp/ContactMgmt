<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Management home page</title>
</head>
<body>
<table>
<tr><td>
<a href="jsps/AddContact.jsp" >Add Contact</a></td>
<td>
<form action="SearchContact" method="get" name="search">
<input type="text" name="firstName">First Name</input>
<input type="text" name="email">Email Id</input>
<input type="submit" name="Submit"></input>
</form>
</table>
</body>
</html>