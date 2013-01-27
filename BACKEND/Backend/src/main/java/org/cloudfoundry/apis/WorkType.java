package org.cloudfoundry.apis;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WorkType {

	String id = null;
	String type = null;
	String time = null;

	public WorkType() {
	}
	
	public WorkType(String type, String time) {
		this.type = type;
		this.time = time;
	}
	
	

	public WorkType(String id, String type, String time) {
		this.id = id;
		this.type = type;
		this.time = time;
	}

	public WorkType(ResultSet rs) {
		try {
			this.id = rs.getString(1);
			this.type = rs.getString(2);
			this.time = rs.getString(3);
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

		

	

}