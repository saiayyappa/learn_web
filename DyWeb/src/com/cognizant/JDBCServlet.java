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
@WebServlet("/JDBCServlet")
public class JDBCServlet extends HttpServlet {
       private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

       /**
       * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
       */
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
              // TODO Auto-generated method stub
              
              PrintWriter out = response.getWriter();
              String t=request.getParameter("uname");
              try {
              
                     
            
              Class.forName("com.mysql.jdbc.Driver");
              
              
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
            
              
              Statement stmt = conn.createStatement();
              System.out.println(t);
               
               java.sql.PreparedStatement ps = conn.prepareStatement("SELECT * from "+t);
               ResultSet rs=ps.executeQuery();  
               ResultSetMetaData rsmd=rs.getMetaData(); 
              
              
              
              System.out.println("Total columns: "+rsmd.getColumnCount()); 
              int d =rsmd.getColumnCount();
             // ResultSet rs=stmt.executeQuery("Select * from trainee_details1");
              out.println("<h1>******Trainee Details******</h1>");
              
                 
              
              int i=0;
              out.println("<table border='1'> <tr><td>S1 No</td><td>Header Name</td><td>Header Value</td></tr>");
                 while(rs.next())
                 { 
                        out.print("<tr><td>");
                        for(i=1;i<=d;i++)
                        {
                 out.print(rs.getString(i)+"</td><td>");
                        }
                        out.println("</td></tr>");
       }
                 out.println("</table>");
}catch(Exception e)
              {
                     out.println(e.getMessage());
              }
                 
       }

       /**
       * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
       */
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              // TODO Auto-generated method stub
              doGet(request, response);
       }

}

