<%-- 
    Document   : newjsp
    Created on : Jan 22, 2019, 12:34:47 PM
    Author     : 761093
--%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>0.
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save Page</title>
    </head>
    <body>
        <h1> Welcome <%=request.getParameter("traineename")%></h1>

        <%
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test", "root", "root");

                String query = "insert into TRAINEE_DETAIL values (?,?,?)";
                PreparedStatement pstmt = con.prepareCall(query);
                pstmt.setString(1, request.getParameter("traineename"));
                pstmt.setString(2, request.getParameter("branch"));
                pstmt.setString(3, request.getParameter("collegename"));
                int insCount = 0;
                insCount = pstmt.executeUpdate();
                if (insCount > 0) {
                    System.out.println("One Record Inserted Successfully!!!");
                    out.println("One Record Inserted Successfully!!!");
                    
                } else {
                    System.out.println("Unable to Insert data. Pls Check!!!");
                    out.println("Unable to Insert data. Pls Check!!!");
                }

                con.close();
            } catch (Exception e) {
                System.out.println(e);
                out.println(e.getMessage());
            }

        %>
    </body>
</html>
