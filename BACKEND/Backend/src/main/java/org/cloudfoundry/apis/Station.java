package org.cloudfoundry.apis;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Station {

	String id = null;
	String address = null;
	String capacitiy = null;
	String longitude = null;
	String latitude = null;
	String deleted = null;

	public Station() {
	}
	
	public Station(String address, String capacitiy,
			String longitude, String latitude, String deleted) {
		this.address = address;
		this.capacitiy = capacitiy;
		this.longitude = longitude;
		this.latitude = latitude;
		this.deleted = deleted;
	}
	
	

	

	public Station(String id, String address, String capacitiy,
			String longitude, String latitude, String deleted) {
		this.id = id;
		this.address = address;
		this.capacitiy = capacitiy;
		this.longitude = longitude;
		this.latitude = latitude;
		this.deleted = deleted;
	}

	public Station(ResultSet rs) {
		try {
			this.id = rs.getString(1);
			this.address = rs.getString(2);
			this.capacitiy = rs.getString(3);
			this.longitude = rs.getString(4);
			this.latitude = rs.getString(5);
			this.deleted = rs.getString(6);
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCapacitiy() {
		return capacitiy;
	}

	public void setCapacitiy(String capacitiy) {
		this.capacitiy = capacitiy;
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