package org.cloudfoundry.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.cloudfoundry.sql.ConnectDb;

public class StationModel {
	Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public ArrayList<Station> getAllStation() throws Exception {

		connect = ConnectDb.openConnection();
		preparedStatement = connect
				.prepareStatement("SELECT id, address, capacitiy, longitude, latitude, deleted FROM station");
		resultSet = preparedStatement.executeQuery();

		ArrayList<Station> list = new ArrayList<Station>();
		while (resultSet.next()) {
			Station currStation = new Station(resultSet);
			list.add(currStation);
		}

		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		return list;

	}

	public Station getById(String id) throws Exception {

		connect = ConnectDb.openConnection();
		preparedStatement = connect
				.prepareStatement("SELECT id, address, capacitiy, longitude, latitude, deleted FROM station WHERE id="
						+ id);

		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		Station st = new Station(resultSet);

		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		return st;

	}

	public Station addStation(String address,String capacitiy,String longitude,String latitude) throws Exception {

		connect = ConnectDb.openConnection();
		String query = "insert into station (id, address, capacitiy, longitude, latitude, deleted) values(?,?,?,?,?,?)";
		PreparedStatement stm = connect.prepareStatement(query);
		stm.setString(1, null);
		stm.setString(2, address);
		stm.setString(3, capacitiy);
		stm.setString(4, longitude);
		stm.setString(5, latitude);
		stm.setString(6, "0");
		stm.executeUpdate();
		
		preparedStatement = connect
				.prepareStatement("SELECT id, address, capacitiy, longitude, latitude, deleted FROM station WHERE id = (SELECT max(id) FROM station)");
		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		Station dr = new Station(resultSet);
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		
		return dr;
	}

	public Station updateStation(String id, String address,String capacitiy,String longitude,String latitude, String deleted) throws SQLException {
		connect = ConnectDb.openConnection();

		String query = "UPDATE station SET address='"+address+"', capacitiy='"+capacitiy+"', longitude='"+longitude+"', latitude='"+latitude+"', deleted='"+deleted+"' WHERE id = "+id;
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.executeUpdate();	
		
		Station dr = new Station(id, address, capacitiy, longitude, latitude);
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		
		return dr;
	}
	
	public void deleteStation(String id) throws SQLException {
		connect = ConnectDb.openConnection();

		String query = "DELETE FROM station WHERE id="+id;
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.executeUpdate();
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
	}

}