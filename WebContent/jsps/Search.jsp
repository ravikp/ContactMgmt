<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.contactmgmt.domain.Contact"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search results</title>
<style>
.border{
color:green;
}
</style>
</head>
<body>

<%List<Contact> arrContact =(List<Contact>)request.getAttribute("searchedcontacts");%>
<table>
	<tr>
    	<th colspan="6" style="background-color:#7c2f97;">Search Results:</th>
    </tr>
	<tr style="background-color:#f0a64e;">
        <th class="border">First Name</th>
        <th class="border">Middle Name</th>
        <th class="border">Last Name</th>
        <th class="border">Age</th>
        <th class="border">Gender</th>
        <th class="border">Email</th>
       
    </tr>
   <% for(Contact arrsearchcontact: arrContact)
    	 //for(int i = 0;i < arrName.size();i++)
    	{
    	%>
        <tr>
        	<td><%= arrsearchcontact.getFirstName() %></td>
            <td><%= arrsearchcontact.getMiddleName() %></td>
            <td><%= arrsearchcontact.getLastName() %></td>
            <td><%= arrsearchcontact.getAge() %></td>
            <td><%= arrsearchcontact.getGender() %></td>
            <td><%= arrsearchcontact.getEmail() %></td>
        </tr>
        <%}%>
</table><br />
</body>
</html>
