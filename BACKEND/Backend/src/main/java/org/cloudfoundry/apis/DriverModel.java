package org.cloudfoundry.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.cloudfoundry.sql.ConnectDb;

public class DriverModel {
	Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public ArrayList<Driver> getAllDriver() throws Exception {

		connect = ConnectDb.openConnection();
		preparedStatement = connect
				.prepareStatement("SELECT id, first_name, last_name, phone_number, rank, user_name, password, deleted FROM driver");
		resultSet = preparedStatement.executeQuery();

		ArrayList<Driver> list = new ArrayList<Driver>();
		while (resultSet.next()) {
			Driver currDriver = new Driver(resultSet);
			list.add(currDriver);
		}

		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		return list;

	}

	public Driver getById(String id) throws Exception {

		connect = ConnectDb.openConnection();
		preparedStatement = connect
				.prepareStatement("SELECT id, first_name, last_name, phone_number, rank, user_name, password, deleted FROM driver WHERE id="
						+ id);

		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		Driver driver = new Driver(resultSet);

		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		return driver;

	}

	public Driver addDriver(String first_name, String last_name,
			String phone_number, String rank, String user_name, String password) throws Exception {

		connect = ConnectDb.openConnection();
		String query = "insert into driver (id, first_name, last_name, phone_number, rank, user_name, password, deleted) values(?,?,?,?,?,?,?,?)";
		PreparedStatement stm = connect.prepareStatement(query);
		stm.setString(1, null);
		stm.setString(2, first_name);
		stm.setString(3, last_name);
		stm.setString(4, phone_number);
		stm.setString(5, rank);
		stm.setString(6, user_name);
		stm.setString(7, password);
		stm.setString(8, "0");
		stm.executeUpdate();
		
		preparedStatement = connect
				.prepareStatement("SELECT id, first_name, last_name, phone_number, rank, user_name, password, deleted FROM driver WHERE id = (SELECT max(id) FROM driver)");
		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		Driver dr = new Driver(resultSet);
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		
		return dr;
	}

	public Driver updateDriver(String id, String first_name, String last_name, String phone_number, String rank, String user_name, String password, String deleted) throws SQLException {
		connect = ConnectDb.openConnection();

		String query = "UPDATE driver SET first_name='"+first_name+"', last_name='"+last_name+"', phone_number='"+phone_number+"', rank='"+rank+"', user_name='"+user_name+"', password='"+password+"', deleted='"+deleted+"' WHERE id = "+id;
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.executeUpdate();	
		
		Driver dr = new Driver(id, first_name, last_name, phone_number, rank, user_name, password, deleted);
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		
		return dr;
	}
	
	public void deleteDriver(String id) throws SQLException {
		connect = ConnectDb.openConnection();

		String query = "DELETE FROM driver WHERE id="+id;
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.executeUpdate();
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
	}

}