package com.flp.ems.domain;

public class Project {

	private int projectId;
	private String projectName;
	private String description;
	private Department department;
	
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName="
				+ projectName + ", description=" + description
				+ ", department=" + department + "]";
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Project() {
		super();
	}
	public Project(int projectId, String projectName, String description) {
		//super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
	}
	public Project(int projectId, String projectName, String description,
			Department department) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.department = department;
	}
}
