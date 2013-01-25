package org.cloudfoundry.samples;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Driver {

	String id = null;
	String first_name = null;
	String last_name = null;
	String phone_number = null;

	public Driver() {
	}
	
	public Driver( String first_name, String last_name,
			String phone_number) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
	}
	
	public Driver(String id, String first_name, String last_name,
			String phone_number) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
	}

	public Driver(ResultSet rs) {
		try {
			this.id = rs.getString(1);
			this.first_name = rs.getString(2);
			this.last_name = rs.getString(3);
			this.phone_number = rs.getString(4);
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

}