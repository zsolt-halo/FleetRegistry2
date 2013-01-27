package org.cloudfoundry.apis;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Driver {

	String id = null;
	String first_name = null;
	String last_name = null;
	String phone_number = null;
	String rank = null;
	String user_name = null;
	String password = null;
	String deleted = null;

	public Driver() {
	}
	
	public Driver( String first_name, String last_name,
			String phone_number, String rank, String user_name, String password, String deleted) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.rank = rank;
		this.user_name = user_name;
		this.password = password;
		this.deleted = deleted;
	}
	
	public Driver(String id, String first_name, String last_name,
			String phone_number, String rank,String user_name, String password,String deleted) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.rank = rank;
		this.user_name = user_name;
		this.password = password;
		this.deleted = deleted;
	}

	public Driver(ResultSet rs) {
		try {
			this.id = rs.getString(1);
			this.first_name = rs.getString(2);
			this.last_name = rs.getString(3);
			this.phone_number = rs.getString(4);
			this.rank = rs.getString(5);
			this.user_name = rs.getString(6);
			this.password = rs.getString(7);
			this.deleted = rs.getString(8);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	
}