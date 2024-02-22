package org.jsp.LoadAndRegisterTheDriverManually;

import java.sql.*;


public class FetchaAllTheRecordsFromPersonTable {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","admin");
			st=con.createStatement();
			rs=st.executeQuery("select * from person");
			//		boolean	res=st.execute("select * from person");
			//		if(res) {
			//			rs=st.getResultSet();
			//		}
			while(rs.next()) {
				System.out.println("Id:"+rs.getInt(1));
				System.out.println("Name:"+rs.getString(2));
				System.out.println("Phone:"+rs.getLong(3));
				System.out.println("Password:"+rs.getString(4));
				System.out.println("====================");
			}
		} catch (ClassNotFoundException | SQLException e) {
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
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(rs!=null) {
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
