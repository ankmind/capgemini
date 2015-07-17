package com.flp.ems.domain;

public class Department {
	private int departmentId;
	private String departmentName;
	private String description;
	
	public Department(int departmentId, String departmentName,
			String description) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.description = description;
	}
	public Department() {
		super();
		}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName="
				+ departmentName + ", description=" + description + "]";
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
