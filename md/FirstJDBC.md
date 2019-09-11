package com.cognizant;
import java.sql.*;

public class FirstJDBC {

	public static void main(String[] args) throws Exception{

		System.out.println("Welcome tos JDBC\n");
		
		//Step 1: Loading & Registering the Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//Step 2: Creating & Establishing the connection [connection url, username, password are the args for getConnection]
		Connection conn =  DriverManager.getConnection ("jdbc:mysql://localhost:3306/test?useSSL=false","root","root");
		
		//Step 3: Create & Execute Query
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from trainee_detail");
		
		//Step 4: Processing the Result
		System.out.println("Trainee Detail Table\n");
		while(rs.next()) {
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}