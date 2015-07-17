package org.capgemini.demo;

import java.io.Serializable;

public class Employee implements Serializable {
	
	private int empId;
	private String empName;
	transient private float empSalary;
	private static String compyName="Capgemini";
	private Address address;
	
	public Employee(){}
	
	public Employee(int empId, String empName, float empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}
	
	
	
	public Employee(int empId, String empName, float empSalary, Address address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.address = address;
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	public static String getCompyName() {
		return compyName;
	}

	public static void setCompyName(String compyName) {
		Employee.compyName = compyName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empSalary=" + empSalary + ", address= ]";
	}

	
	
	
	

}
