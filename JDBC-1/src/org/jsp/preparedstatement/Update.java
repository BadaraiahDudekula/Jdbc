package org.jsp.preparedstatement;

import java.sql.*;
import java.util.*;
public class Update {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pst=null;
		Scanner sc=new Scanner(System.in);
		String sql="update person set name=? ,phone=?, password=? where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","admin");
			pst=con.prepareStatement(sql);
			System.out.println("enter name , phone , password , id to update a record");
			pst.setString(1,sc.next());
			pst.setLong(2,sc.nextLong());
			pst.setString(3,sc.next());
			pst.setInt(4,sc.nextInt());
			int r=pst.executeUpdate();
			System.out.println(r+"rows updated");
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
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
		}
		
	}

}
