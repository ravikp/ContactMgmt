package com.contactmgmt.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactmgmt.domain.User;
import com.contactmgmt.util.DatabaseConnection;

/**
 * Servlet implementation class Login1
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setUserName(request.getParameter("uName"));
		user.setPassword(request.getParameter("pwd"));
		// System.out.println("SearchContact doPost Entry");

		if (!user.getUserName().equals("") && !user.getPassword().equals("")) {

			Connection conn = DatabaseConnection.getConnection();
			if (null != conn) {
				String query2 = "select * from user where userName = \""
						+ user.getUserName() + "\" and password = \""
						+ user.getPassword() + "\"";
				Statement stmt;
				try {
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query2);
					while (rs.next()) {
						if (user.getUserName().equalsIgnoreCase(
								rs.getString("userName"))
								&& user.getPassword().equals(
										rs.getString("passWord")))
							response.sendRedirect("jsps/Contacts.jsp");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		} else
			response.sendRedirect("jsps/Login.jsp");
	}
}
