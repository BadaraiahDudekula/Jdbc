package org.jsp.LoadAndRegisterTheDriverforName;


public class LoadAndRegisterTheDriverForName {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//com.mysql.cj.jdbc.Driver
			System.out.println("Driver class loaded Successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
