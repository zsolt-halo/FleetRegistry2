package org.cloudfoundry.apis;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Partner {

	String id = null;
	String name = null;
	String address = null;
	String phone_number = null;
	String longitude = null;
	String latitude = null;
	String deleted = null;

	public Partner() {
	}
	
	public Partner( String name, String address, String phone_number,
			String longitude, String latitude, String deleted) {
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.longitude = longitude;
		this.latitude = latitude;
		this.deleted = deleted;
	}
	
	

	public Partner(String id, String name, String address, String phone_number,
			String longitude, String latitude, String deleted) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.longitude = longitude;
		this.latitude = latitude;
		this.deleted = deleted;
	}

	public Partner(ResultSet rs) {
		try {
			this.id = rs.getString(1);
			this.name = rs.getString(2);
			this.address = rs.getString(3);
			this.phone_number = rs.getString(4);
			this.longitude = rs.getString(5);
			this.latitude = rs.getString(6);
			this.deleted = rs.getString(7);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	

}