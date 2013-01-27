package org.cloudfoundry.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDb {

	public static Connection openConnection() {
		String UserName = "ubm0qt9Vc9RUp";
		String Password = "ps9Oz8lsLg53Y";
		String URL = "jdbc:mysql://172.30.48.29:3306/da1a0273f59404934bcfaa9e5998df84b";
		Connection connect = null;

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(URL, UserName, Password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connect;

	}
	
	public static void closeConnection(Connection connect,Statement statement,ResultSet resultSet){
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}
}
