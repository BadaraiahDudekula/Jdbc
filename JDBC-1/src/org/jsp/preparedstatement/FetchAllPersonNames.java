package org.jsp.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchAllPersonNames {

	public static void main(String[] args) {

		Connection con=null;
		PreparedStatement pst=null;
		String sql= "select name from person";
		ResultSet rs=null;
		Scanner sc=new Scanner(System.in);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","admin");
			pst=con.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("Name:"+rs.getString(1));
				System.out.println("==============");
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


