package com.contactmgmt.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.contactmgmt.domain.Contact;
import com.contactmgmt.util.DatabaseConnection;

public class AddContact extends HttpServlet {
	private static Logger logger = null;
	
	public void init() throws ServletException {
		logger = Logger.getLogger(AddContact.class);
		ServletContext context = getServletContext();			
		String path=context.getRealPath("log4j.properties") ;
		PropertyConfigurator.configure(path);

	}
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
		
		logger.info("invoked the AddContact...");
		logger.info(contact.getFirstName());

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
			Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
//			DatabaseConnection dbconn = new DatabaseConnection();
			//dbconn.executeQuery(query);
			out.println("Submitted contact");
			logger.info("record update successfully");
		}
	}
}
