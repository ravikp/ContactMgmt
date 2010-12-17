package com.contactmgmt.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactmgmt.domain.Contact;
import com.contactmgmt.util.DatabaseConnection;

public class AddContact extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Contact contact = new Contact();
		contact.setFirstName(request.getParameter("fName"));
		contact.setMiddleName(request.getParameter("mName"));
		contact.setLastName(request.getParameter("lName"));
		contact.setAge(Integer.parseInt(request.getParameter("age")));
		contact.setGender(request.getParameter("gender"));
		contact.setEmail(request.getParameter("email"));

		Connection conn = DatabaseConnection.getConnection();
		if (null != conn) {
			String query = "INSERT INTO contact ( firstName, middleName, lastName,age, gender,email) "
					+ "VALUES ( \""
					+ contact.getFirstName()
					+ "\",\""
					+ contact.getMiddleName()
					+ "\",\""
					+ contact.getLastName()
					+ "\","
					+ contact.getAge()
					+ ",\""
					+ contact.getGender()
					+ "\",\""
					+ contact.getEmail() + "\")";
			DatabaseConnection dbconn = new DatabaseConnection();
			dbconn.executeQuery(query);
			out.println("Submitted contact");
		}
	}
}
