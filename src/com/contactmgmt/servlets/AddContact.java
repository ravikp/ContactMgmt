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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Contact contact = new Contact();
		contact.setFirstName((String) request.getAttribute("fName"));
		out.println("Submitted contact");
		Connection conn = DatabaseConnection.getConnection();
		if(null != conn){
			String query = "INSERT INTO contact (id, firstName, middleName, lastName,age, gender,email) " +
					"VALUES (1,"+ contact.getFirstName()+", \"\",\"\",0,\"\",\"\" )";
			DatabaseConnection dbconn = new DatabaseConnection();
			dbconn.executeQuery(query);
		}
//		RequestDispatcher dispatcher = getServletContext()
//				.getRequestDispatcher("/AddContact.jsp");
//		dispatcher.forward(request, response);
	}
}
