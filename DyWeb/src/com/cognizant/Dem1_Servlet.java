package com.cognizant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dem1_Servlet
 */
@WebServlet("/Dem1_Servlet")
public class Dem1_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dem1_Servlet() {
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
		response.getWriter().append("Welcome to " + request.getParameter("uname") + " to Servlet Programming");
		PrintWriter out = response.getWriter();
		Enumeration<String> headers = request.getHeaderNames();
		int i = 1;
		response.setContentType("text/html");
		out.println("<link rel='stylesheet' href='bootstrap.css'>");
		out.println(
				"<table class='table table-hover'> <tr><td>Sl no</td> <td> Header Name</td><td>Header Value</td></tr>");
		while (headers.hasMoreElements()) {
			String headerName = headers.nextElement();
			out.println("<tr><td>" + i + "</td><td> " + headerName + " </td><td>" + request.getHeader(headerName)
					+ "</td></tr>");
			i++;
		}
		out.println("</table>");
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
