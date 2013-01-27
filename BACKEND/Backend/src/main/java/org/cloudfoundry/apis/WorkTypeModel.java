package org.cloudfoundry.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.cloudfoundry.sql.ConnectDb;

public class WorkTypeModel {
	Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public ArrayList<WorkType> getAllWorkType() throws Exception {

		connect = ConnectDb.openConnection();
		preparedStatement = connect
				.prepareStatement("SELECT id, type, time FROM workType");
		resultSet = preparedStatement.executeQuery();

		ArrayList<WorkType> list = new ArrayList<WorkType>();
		while (resultSet.next()) {
			WorkType currWorkType = new WorkType(resultSet);
			list.add(currWorkType);
		}

		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		return list;

	}

	public WorkType getById(String id) throws Exception {

		connect = ConnectDb.openConnection();
		preparedStatement = connect
				.prepareStatement("SELECT  id, type, time FROM workType WHERE id="
						+ id);

		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		WorkType st = new WorkType(resultSet);

		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		return st;

	}

	public WorkType addWorkType(String type, String time) throws Exception {

		connect = ConnectDb.openConnection();
		String query = "insert into WorkType ( id, type, time) values(?,?,?)";
		PreparedStatement stm = connect.prepareStatement(query);
		stm.setString(1, null);
		stm.setString(2, type);
		stm.setString(3, time);
		stm.executeUpdate();
		
		preparedStatement = connect
				.prepareStatement("SELECT id, type, time FROM workType WHERE id = (SELECT max(id) FROM WorkType)");
		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		WorkType dr = new WorkType(resultSet);
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		
		return dr;
	}

	public WorkType updateWorkType(String id, String type,String time) throws SQLException {
		connect = ConnectDb.openConnection();

		String query = "UPDATE workType SET type='"+type+"', time='"+time+"' WHERE id = "+id;
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.executeUpdate();	
		
		WorkType dr = new WorkType(id, type, time);
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		
		return dr;
	}
	
	public void deleteWorkType(String id) throws SQLException {
		connect = ConnectDb.openConnection();

		String query = "DELETE FROM workType WHERE id="+id;
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.executeUpdate();
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
	}

}