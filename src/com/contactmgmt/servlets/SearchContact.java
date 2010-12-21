package com.contactmgmt.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactmgmt.domain.Contact;
import com.contactmgmt.util.DatabaseConnection;

public class SearchContact extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		Contact contact = new Contact();
		contact.setFirstName(request.getParameter("fName"));
		contact.setEmail(request.getParameter("email"));

		Connection conn = DatabaseConnection.getConnection();
		if (null != conn) {
			String query1 = "select * from contact where firstName = \"" + contact.getFirstName() + "\"";
			
				
				Statement stmt;
				try {
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query1);
					if (contact.getFirstName().equals(rs.getString("firstName")))
					{
						out.println("Contact Found");
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
