package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		String tableName = request.getParameter("tname");
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			Statement stmt = conn.createStatement();
			System.out.println(tableName);
			java.sql.PreparedStatement ps = conn.prepareStatement("SELECT * from " + tableName);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("Total columns: " + rsmd.getColumnCount());
			int columnCount = rsmd.getColumnCount();
			out.println("<h1>******<a href='SelectTable'>show table</a>******</h1>");
			out.println("<h1>******" + tableName + "******</h1>");
			out.print("<table border='1'><tr>");
			int i = 0, j = 0;
			for (j = 1; j <= columnCount; j++) {
				out.print("<td>" + rsmd.getColumnName(j) + "</td>");
			}
			out.print("</tr>");
			while (rs.next()) {
				out.print("<tr>");
				for (i = 1; i <= columnCount; i++) {
					out.print("<td>" + rs.getString(i) + "</td>");
				}
				out.print("</tr>");
			}
			out.println("</table>");
		} catch (Exception e) {
			out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
