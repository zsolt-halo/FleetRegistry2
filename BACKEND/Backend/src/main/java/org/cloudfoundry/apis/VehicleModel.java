package org.cloudfoundry.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.cloudfoundry.sql.ConnectDb;

public class VehicleModel {
	Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public ArrayList<Vehicle> getAllVehicle() throws Exception {

		connect = ConnectDb.openConnection();
		preparedStatement = connect
				.prepareStatement("SELECT id, model, license_plate_number, color, station_id, deleted FROM vehicle");
		resultSet = preparedStatement.executeQuery();

		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		while (resultSet.next()) {
			Vehicle currVehicle = new Vehicle(resultSet);
			list.add(currVehicle);
		}

		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		return list;

	}

	public Vehicle getById(String id) throws Exception {

		connect = ConnectDb.openConnection();
		preparedStatement = connect
				.prepareStatement("SELECT id, model, license_plate_number, color, station_id, deleted FROM vehicle WHERE id="
						+ id);

		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		Vehicle st = new Vehicle(resultSet);

		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		return st;

	}

	public Vehicle addVehicle(String model, String license_plate_number,
			String color, String station_id) throws Exception {

		connect = ConnectDb.openConnection();
		String query = "insert into vehicle (id, model, license_plate_number, color, station_id, deleted) values(?,?,?,?,?)";
		PreparedStatement stm = connect.prepareStatement(query);
		stm.setString(1, null);
		stm.setString(2, model);
		stm.setString(3, license_plate_number);
		stm.setString(4, color);
		stm.setString(5, station_id);
		stm.setString(6, "0");
		stm.executeUpdate();
		
		preparedStatement = connect
				.prepareStatement("SELECT id, model, license_plate_number, color, station_id, deleted FROM vehicle WHERE id = (SELECT max(id) FROM vehicle)");
		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		Vehicle dr = new Vehicle(resultSet);
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		
		return dr;
	}

	public Vehicle updateVehicle(String id, String model, String license_plate_number,
			String color, String station_id, String deleted) throws SQLException {
		connect = ConnectDb.openConnection();

		String query = "UPDATE vehicle SET model='"+model+"', license_plate_number='"+license_plate_number+"', color='"+color+"', station_id='"+station_id+"', deleted='"+deleted+"' WHERE id = "+id;
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.executeUpdate();	
		
		Vehicle dr = new Vehicle(id, model, license_plate_number, color, station_id, deleted);
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		
		return dr;
	}
	
	public void deleteVehicle(String id) throws SQLException {
		connect = ConnectDb.openConnection();

		String query = "DELETE FROM vehicle WHERE id="+id;
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.executeUpdate();
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
	}

}