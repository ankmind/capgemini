package com.flp.ems.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {

	private int employeeId;
	private String empName;
	private String kinId;
	private String emailId;
	private String phoneNo;
	private Date empdob;
	private Date empdoj;
	private String address;
	private Department department;
	private List<Project> project=new ArrayList<Project>();
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empName=" + empName
				+ ", kinId=" + kinId + ", emailId=" + emailId + ", phoneNo="
				+ phoneNo + ", empdob=" + empdob + ", empdoj=" + empdoj
				+ ", address=" + address + ", department=" + department
				+ ", project=" + project + ", role=" + role + "]";
	}
	public Employee() {
		super();
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getKinId() {
		return kinId;
	}
	public void setKinId(String kinId) {
		this.kinId = kinId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Date getEmpdob() {
		return empdob;
	}
	public void setEmpdob(Date empdob) {
		this.empdob = empdob;
	}
	public Date getEmpdoj() {
		return empdoj;
	}
	public void setEmpdoj(Date empdoj) {
		this.empdoj = empdoj;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Employee(int employeeId, String empName, String kinId,
			String emailId, String phoneNo, Date empdob, Date empdoj,
			String address, Department department, List<Project> project,
			Role role) {
		super();
		this.employeeId = employeeId;
		this.empName = empName;
		this.kinId = kinId;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.empdob = empdob;
		this.empdoj = empdoj;
		this.address = address;
		this.department = department;
		this.project = project;
		this.role = role;
	}
	private Role role;
}
