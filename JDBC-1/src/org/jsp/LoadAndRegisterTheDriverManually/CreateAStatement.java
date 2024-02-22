package org.jsp.LoadAndRegisterTheDriverManually;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAStatement {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//1
			System.out.println("Load And Register The Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","admin");//2
			System.out.println("Connection Established");
			st=con.createStatement();//3
			System.out.println("StatementCreated");
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
