<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.student.model.StudentBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="fetchStudents">
		<%
			List<StudentBean> studList = new ArrayList<StudentBean>();
			studList = (ArrayList) request.getAttribute("studList");
			Iterator itr = studList.iterator();
		%>
		<center>
			<table border='1' id="table2">
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>College</td>
					<td>Action</td>
				</tr>
				<%
					while (itr.hasNext()) {
						StudentBean s = (StudentBean) itr.next();
				%>
				<tr>
					<td><%=s.getId()%></td>
					<td><%=s.getName()%></td>
					<td><%=s.getCollege()%></td>
					<td><a href ="deleteStudent?id=<%=s.getId()%>">Delete </a></td>
				</tr>
				<%
					}
				%>
			</table>
		</center>
	</form>
</body>
</html>