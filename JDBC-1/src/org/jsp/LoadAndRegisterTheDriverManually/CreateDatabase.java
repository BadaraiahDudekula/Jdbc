// 4.Execute Queries
package org.jsp.LoadAndRegisterTheDriverManually;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

	public static void main(String[] args) {
		String qry="create  database jdbc";
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//1
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","admin");//2
			st=con.createStatement();//3
			boolean rs=st.execute(qry);//4
			System.out.println("Database Created");
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
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
