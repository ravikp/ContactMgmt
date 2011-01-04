package com.contactmgmt.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactmgmt.domain.Contact;
import com.contactmgmt.util.DatabaseConnection;

public class SearchContact extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Contact contact = new Contact();
		contact.setFirstName(request.getParameter("fName"));
		contact.setEmail(request.getParameter("email"));
		// System.out.println("SearchContact doPost Entry");
		List<Contact> searchcontacts = new ArrayList<Contact>();

		if (!contact.getFirstName().equals("")
				|| !contact.getEmail().equals("")) {

			Connection conn = DatabaseConnection.getConnection();
			if (null != conn) {
				String query1 = "select * from contact where firstName = \""
						+ contact.getFirstName() + "\" or email = \""
						+ contact.getEmail() + "\"";
				Statement stmt;
				try {
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query1);
					while (rs.next()) {
						// if (contact.getFirstName().equalsIgnoreCase(
						// rs.getString("firstName"))) {
						// out.println("First name = "
						// + rs.getString("firstName"));
						// out.println("Middle name = "
						// + rs.getString("middleName"));
						// out.println("Last name = " +
						// rs.getString("lastName"));
						// }
						// System.out.println("********Gender*********"+
						// rs.getString("gender"));
						contact.setFirstName(rs.getString("firstName"));
						contact.setMiddleName(rs.getString("middleName"));
						contact.setLastName(rs.getString("lastName"));
						// contact.setAge(Integer
						// .parseInt(request.getParameter("age")));
						contact.setAge(rs.getInt("age"));
						contact.setGender(rs.getString("gender"));
						contact.setEmail(rs.getString("email"));

						searchcontacts.add(contact);
					}
					request.setAttribute("searchedcontacts", searchcontacts);

				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("/jsps/Search.jsp").forward(
						request, response);
			}
		} else
			response.sendRedirect("jsps/Error.jsp");
	}
}
