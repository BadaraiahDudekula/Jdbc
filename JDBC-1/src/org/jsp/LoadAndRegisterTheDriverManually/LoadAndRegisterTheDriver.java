package org.jsp.LoadAndRegisterTheDriverManually;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class LoadAndRegisterTheDriver {

	public static void main(String[] args) {
		Driver d;
		try {
			d = new Driver();
			DriverManager.registerDriver(d);
			System.out.println("Driver class Loaded and Registered Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}
		
	}

}
