<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Management home page</title>
</head>
<body>

<table>
	<tr>
		<td><a href="AddContact.jsp">Add Contact</a></td>
	</tr>
	<tr>
		<td>
		<form action="../searchContact" method="post">First Name: <input
			type="text" name="fName" /><br>
		Email Id: <input type="text" name="email" /><br>
		<input type="submit" name="Submit" value="Search Contact"></form>
		</td>
	</tr>
</table>

</body>
</html>