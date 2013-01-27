package org.cloudfoundry.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.cloudfoundry.sql.ConnectDb;

public class WorkModel {
	Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public ArrayList<Work> getAllWork() throws Exception {

		connect = ConnectDb.openConnection();
		preparedStatement = connect
				.prepareStatement("SELECT id, start_date, workTypeId, driver_id, longitude, latitude, vehicle_id, partner_id, deleted FROM work");
		resultSet = preparedStatement.executeQuery();

		ArrayList<Work> list = new ArrayList<Work>();
		while (resultSet.next()) {
			Work currWork = new Work(resultSet);
			list.add(currWork);
		}

		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		return list;

	}

	public Work getById(String id) throws Exception {

		connect = ConnectDb.openConnection();
		preparedStatement = connect
				.prepareStatement("SELECT id, start_date, workTypeId, driver_id, longitude, latitude, vehicle_id, partner_id, deleted FROM work WHERE id="
						+ id);

		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		Work work = new Work(resultSet);

		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		return work;

	}

	public Work addWork(String start_date, String workTypeId,
			String driver_id, String longitude, String latitude,
			String vehicle_id, String partner_id) throws Exception {

		connect = ConnectDb.openConnection();
		String query = "insert into work (id, start_date, workTypeId, driver_id, longitude, latitude, vehicle_id, partner_id, deleted) values(?,?,?,?,?,?,?,?)";
		PreparedStatement stm = connect.prepareStatement(query);
		stm.setString(1, null);
		stm.setString(2, start_date);
		stm.setString(3, workTypeId);
		stm.setString(4, driver_id);
		stm.setString(5, longitude);
		stm.setString(6, latitude);
		stm.setString(7, vehicle_id);
		stm.setString(8, partner_id);
		stm.setString(9, "0");
		stm.executeUpdate();
		
		preparedStatement = connect
				.prepareStatement("SELECT id, start_date, workTypeId, driver_id, longitude, latitude, vehicle_id, partner_id, deleted FROM work WHERE id = (SELECT max(id) FROM work)");
		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		Work dr = new Work(resultSet);
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		
		return dr;
	}

	public Work updateWork(String id, String start_date, String workTypeId,
			String driver_id, String longitude, String latitude,
			String vehicle_id, String partner_id, String deleted) throws SQLException {
		connect = ConnectDb.openConnection();

		String query = "UPDATE work SET start_date='"+start_date+"', workTypeId='"+workTypeId+"', driver_id='"+driver_id+"', longitude='"+longitude+"', latitude='"+latitude+"', vehicle_id='"+vehicle_id+"', partner_id='"+partner_id+"', deleted='"+deleted+"' WHERE id = "+id;
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.executeUpdate();	
		
		Work dr = new Work(id, start_date, workTypeId, longitude, latitude, vehicle_id, partner_id, deleted);
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		
		return dr;
	}
	
	public void deleteWork(String id) throws SQLException {
		connect = ConnectDb.openConnection();

		String query = "DELETE FROM work WHERE id="+id;
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.executeUpdate();
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
	}

}