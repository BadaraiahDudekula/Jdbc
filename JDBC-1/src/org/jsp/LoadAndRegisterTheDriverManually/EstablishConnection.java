package org.jsp.LoadAndRegisterTheDriverManually;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnection {

	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//1
			System.out.println("Load And Register The Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","admin");//2
			 System.out.println("Connection is Established");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
					System.out.println("connection Colosed");
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
