package org.cloudfoundry.apis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.cloudfoundry.sql.ConnectDb;

public class PartnerModel {
	Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public ArrayList<Partner> getAllPartner() throws Exception {

		connect = ConnectDb.openConnection();
		preparedStatement = connect
				.prepareStatement("SELECT id, name, address, phone_number, longitude, latitude, deleted FROM partner");
		resultSet = preparedStatement.executeQuery();

		ArrayList<Partner> list = new ArrayList<Partner>();
		while (resultSet.next()) {
			Partner currPartner = new Partner(resultSet);
			list.add(currPartner);
		}

		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		return list;

	}

	public Partner getById(String id) throws Exception {

		connect = ConnectDb.openConnection();
		preparedStatement = connect
				.prepareStatement("SELECT id, name, address, phone_number, longitude, latitude, deleted FROM partner WHERE id="
						+ id);

		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		Partner partner = new Partner(resultSet);

		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		return partner;

	}

	public Partner addPartner(String name, String address, String phone_number,
			String longitude, String latitude) throws Exception {

		connect = ConnectDb.openConnection();
		String query = "insert into partner (id, name, address, phone_number, longitude, latitude, deleted) values(?,?,?,?,?,?,?)";
		PreparedStatement stm = connect.prepareStatement(query);
		stm.setString(1, null);
		stm.setString(2, name);
		stm.setString(3, address);
		stm.setString(4, phone_number);
		stm.setString(5, longitude);
		stm.setString(6, latitude);
		stm.setString(7, "0");
		stm.executeUpdate();
		
		preparedStatement = connect
				.prepareStatement("SELECT id, name, address, phone_number, longitude, latitude, deleted FROM partner WHERE id = (SELECT max(id) FROM partner)");
		resultSet = preparedStatement.executeQuery();
		resultSet.next();
		Partner dr = new Partner(resultSet);
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		
		return dr;
	}

	public Partner updatePartner(String id, String name, String address, String phone_number,
			String longitude, String latitude, String deleted) throws SQLException {
		connect = ConnectDb.openConnection();

		String query = "UPDATE Partner SET name='"+name+"', address='"+address+"', phone_number='"+phone_number+"', longitude='"+longitude+"', latitude='"+latitude+"', deleted='"+deleted+"' WHERE id = "+id;
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.executeUpdate();	
		
		Partner dr = new Partner(id, name, address, phone_number, longitude, latitude, deleted);
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
		
		return dr;
	}
	
	public void deletePartner(String id) throws SQLException {
		connect = ConnectDb.openConnection();

		String query = "DELETE FROM partner WHERE id="+id;
		preparedStatement = connect.prepareStatement(query);
		preparedStatement.executeUpdate();
		
		ConnectDb.closeConnection(this.connect, this.preparedStatement,
				this.resultSet);
	}

}