package org.transformafrica.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;


@Entity
@Table(name = "DRIVERS")
public class Driver extends PanacheEntity{
	
	
	@Column(name = "name")
	private String name;
	@Column(name = "dob")
    private Date dob;
	@Column(name = "phone_number")
    private String phoneNumber;
	//@Column(name= "address")
	//private String address;
	
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
/*	public String getAddress(String address) {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}*/

	
	public static List<Driver> getAllDrivers() {
		return Driver.findAll().list();
		
	}
    	

}
