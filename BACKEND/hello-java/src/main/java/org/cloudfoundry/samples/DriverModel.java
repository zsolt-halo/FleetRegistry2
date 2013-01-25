package org.cloudfoundry.samples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DriverModel {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public ArrayList<Driver> getAllDriver() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://172.30.48.30:3306/d9c078884824248d39c6406c266d1337e","uQgZzkyligNqv","pGuQBm7txObVm");
			preparedStatement = connect.prepareStatement("SELECT id, first_name, last_name, phone_number FROM driver");
			resultSet = preparedStatement.executeQuery();

			ArrayList<Driver> list = new ArrayList<Driver>();
			while (resultSet.next()) {
				Driver currDriver = new Driver(resultSet.getString(1),
						resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
				list.add(currDriver);
			}

			return list;
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}
	
	public Driver getById(String id) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://172.30.48.30:3306/d9c078884824248d39c6406c266d1337e","uQgZzkyligNqv","pGuQBm7txObVm");
			preparedStatement = connect
					.prepareStatement("SELECT id, first_name, last_name, phone_number FROM driver WHERE id="+id);
			
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			Driver driver = new Driver(resultSet);
			
			return driver;
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}
	
	public void createDriver(String first_name, String last_name, String phone_number) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://172.30.48.30:3306/d9c078884824248d39c6406c266d1337e","uQgZzkyligNqv","pGuQBm7txObVm");
			String query=  "insert into driver (id, first_name, last_name, phone_number) values(?,?,?,?)";
			PreparedStatement stm = connect.prepareStatement(query);
			stm.setString(1, null);
			stm.setString(2, first_name);
			stm.setString(3, last_name);
			stm.setString(4, phone_number);
			stm.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}
	
	
	// You need to close the resultSet
	private void close() {
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