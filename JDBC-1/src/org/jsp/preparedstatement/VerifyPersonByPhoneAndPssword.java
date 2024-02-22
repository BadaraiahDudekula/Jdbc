package org.jsp.preparedstatement;

import java.sql.*;
import java.util.*;
public class VerifyPersonByPhoneAndPssword {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from person where phone=? and password=? ";
		Scanner sc=new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","admin");
			pst=con.prepareStatement(sql);
			System.out.println("Verify Person By Phone and password");
			pst.setLong(1,sc.nextLong());
			pst.setString(2,sc.next());
			rs=pst.executeQuery();
			if(rs.next()) {
				System.out.println("Id:"+rs.getInt(1));
				System.out.println("Name:"+rs.getString(2));
				System.out.println("Phone:"+rs.getLong(3));
				System.out.println("password:"+rs.getString(4));
			}else {
				System.out.println("entered invalid phone or password");
			}
			
			
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
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
