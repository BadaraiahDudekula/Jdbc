package org.jsp.preparedstatement;

import java.sql.*;

public class InsertMultipleRecords {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pst=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","admin");
			pst=con.prepareStatement("insert into person values(?,?,?,?)");
			
			pst.setInt(1,110);
			pst.setString(2,"chinnu");
			pst.setLong(3,234549);
			pst.setString(4,"chinnu@123");
			int r=pst.executeUpdate();
			
			pst.setInt(1,111);
			pst.setString(2,"loki");  
			pst.setLong(3,234654);
			pst.setString(4,"loki@123");
			int r1=pst.executeUpdate();
			
			pst.setInt(1,103);
			pst.setString(2,"mani");
			pst.setLong(3,98762376);
			pst.setString(4,"mani@123");
			int r2=pst.executeUpdate();
			System.out.println(r+r1+r2+"rows inserted");
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
