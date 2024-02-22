package org.jsp.preparedstatement;

import java.sql.*;
import java.util.*;
public class VerifyPersonNameAndPassword {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pst=null;
		String sql="select * from person where name=? and password=?";
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","admin");
			pst=con.prepareStatement(sql);
			System.out.println("Enter Name and Password To Get Person Details");
			pst.setString(1,sc.next());
			pst.setString(2,sc.next());
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				System.out.println("Id:"+rs.getInt(1));
				System.out.println("Name:"+rs.getString(2));
				System.out.println("Phone:"+rs.getLong(3));
				System.out.println("password:"+rs.getString(4));
			}else {
				System.out.println("Invalid Name or Password");
			}
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
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
