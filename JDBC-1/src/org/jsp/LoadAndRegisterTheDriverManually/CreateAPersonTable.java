package org.jsp.LoadAndRegisterTheDriverManually;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAPersonTable {

	public static void main(String[] args) {
		String qry="create table person (id int not null,"
				+ " name varchar(40) not null,"
				+ " phone bigint(10) not null unique, "
				+ "password varchar(50) not null, primary key(id))";
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//1
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","admin");
			st=con.createStatement();
			st.execute(qry);
			System.out.println("table created");
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
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
