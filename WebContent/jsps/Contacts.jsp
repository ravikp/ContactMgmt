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
<%
   Cookie cookie = null;
   Cookie[] cookies = null;
   // Get an array of Cookies associated with this domain
   cookies = request.getCookies();
   if( cookies != null ){
      out.println("<h2> Found Cookies Name and Value</h2>");
      for (int i = 0; i < cookies.length; i++){
         cookie = cookies[i];
         out.print("Name : " + cookie.getName( ) + ",  ");
         out.print("Value: " + cookie.getValue( )+",  ");
         out.print("Age: " + cookie.getMaxAge( )+" <br/>");
      }
  }else{
      out.println("<h2>No cookies founds</h2>");
  }
%>


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