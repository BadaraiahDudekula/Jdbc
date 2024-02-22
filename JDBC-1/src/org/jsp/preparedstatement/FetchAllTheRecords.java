package org.jsp.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchAllTheRecords {

	public static void main(String[] args) {

		Connection con=null;
		PreparedStatement pst=null;
		String sql= "select * from person ";
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","admin");
			pst=con.prepareStatement(sql);
			//System.out.println("Enter the id to fetch record details");
			//pst.setInt(1);
			rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("Id:"+rs.getInt(1));
				System.out.println("Name:"+rs.getString(2));
				System.out.println("Phone:"+rs.getLong(3));
				System.out.println("Password"+rs.getString(4));
				System.out.println("===============");
			}


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
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}


