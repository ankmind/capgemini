package org.capgemini.demo;

import java.io.Serializable;

public class Address implements Serializable{
	
	private String stName;
	private String city;
	private Employee empAddress;
	
	public Address(){}
	
	public Address(String stName, String city) {
		super();
		this.stName = stName;
		this.city = city;
	}
	
	
	
	public Address(String stName, String city, Employee empAddress) {
		super();
		this.stName = stName;
		this.city = city;
		this.empAddress = empAddress;
	}

	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	public Employee getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(Employee empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "Address [stName=" + stName + ", city=" + city + ", empAddress="
				+ empAddress + "]";
	}

	
	
	

}
