package org.jsp.LoadAndRegisterTheDriverManually;

import java.sql.*;

public class InsertMultipleRecordsUsingStatement {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","admin");
			st=con.createStatement();
			st.executeUpdate("insert into person values(4,'laddu',654365,'laddu@123')");
			st.executeUpdate("insert into person values(5,'chintu',654364,'chintu@123')");
			st.executeUpdate("insert into person values(6,'bunny',654363,'bunny@123')");
			System.out.println("inserted records successfully");
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
