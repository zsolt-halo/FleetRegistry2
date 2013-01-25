package com.fleetregistry.drivers;

public class Driver {

	String phoneNumber;
	String firstName;
	String lastName;
	long ID;
	
	
	public static void getAllDrivers(){
		
	}
	
	@Override
	public String toString(){
		return lastName+" "+ firstName+" "+phoneNumber+" "+ID;
	}
	
	public Driver(String phoneNumber, String firstName, String lastName, long iD) {
		super();
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		ID = iD;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public long getID() {
		return ID;
	}
	
	public void setID(long iD) {
		ID = iD;
	}	
}
