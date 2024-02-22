package org.jsp.LoadAndRegisterTheDriverManually;

import java.sql.*;

public class SavePerson {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","admin");
			st=con.createStatement();
			st.execute("insert into person values(1,'badar',123456,'badar@123')");
			System.out.println("Record Inserted");
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
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
