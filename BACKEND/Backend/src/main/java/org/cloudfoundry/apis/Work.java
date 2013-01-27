package org.cloudfoundry.apis;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Work {

	String id = null;
	String start_date = null;
	String workTypeId = null;
	String driver_id = null;
	String longitude = null;
	String latitude = null;
	String vehicle_id = null;
	String partner_id = null;
	String deleted = null;

	public Work() {
	}
	
	public Work(String start_date, String workTypeId,
			String driver_id, String longitude, String latitude,
			String vehicle_id, String partner_id,String deleted) {
		this.start_date = start_date;
		this.workTypeId = workTypeId;
		this.driver_id = driver_id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.vehicle_id = vehicle_id;
		this.partner_id = partner_id;
		this.deleted = deleted;
	}
	
	

	public Work(String id, String start_date, String workTypeId,
			String driver_id, String longitude, String latitude,
			String vehicle_id, String partner_id,String deleted) {
		this.id = id;
		this.start_date = start_date;
		this.workTypeId = workTypeId;
		this.driver_id = driver_id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.vehicle_id = vehicle_id;
		this.partner_id = partner_id;
		this.deleted = deleted;
	}

	public Work(ResultSet rs) {
		try {
			this.id = rs.getString(1);
			this.start_date = rs.getString(2);
			this.workTypeId = rs.getString(3);
			this.driver_id = rs.getString(4);
			this.longitude = rs.getString(5);
			this.latitude = rs.getString(6);
			this.vehicle_id = rs.getString(7);
			this.partner_id = rs.getString(8);
			this.deleted = rs.getString(9);
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

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getWorkTypeId() {
		return workTypeId;
	}

	public void setWorkTypeId(String workTypeId) {
		this.workTypeId = workTypeId;
	}

	public String getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
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

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	

}