package org.cloudfoundry.apis;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehicle {

	String id = null;
	String model = null;
	String license_plate_number = null;
	String color = null;
	String station_id = null;
	String deleted = null;

	public Vehicle() {
	}
	
	public Vehicle(String model, String license_plate_number,
			String color, String station_id, String deleted) {
		this.model = model;
		this.license_plate_number = license_plate_number;
		this.color = color;
		this.station_id = station_id;
		this.deleted = deleted;
	}
	

	public Vehicle(String id, String model, String license_plate_number,
			String color, String station_id, String deleted) {
		this.id = id;
		this.model = model;
		this.license_plate_number = license_plate_number;
		this.color = color;
		this.station_id = station_id;
		this.deleted = deleted;
	}

	public Vehicle(ResultSet rs) {
		try {
			this.id = rs.getString(1);
			this.model = rs.getString(2);
			this.license_plate_number = rs.getString(3);
			this.color = rs.getString(4);
			this.station_id = rs.getString(5);
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLicense_plate_number() {
		return license_plate_number;
	}

	public void setLicense_plate_number(String license_plate_number) {
		this.license_plate_number = license_plate_number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getStation_id() {
		return station_id;
	}

	public void setStation_id(String station_id) {
		this.station_id = station_id;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	

	

	

}