package com.flp.ems.domain;

public class Role {

	private int roleId;
	private String roleName;
	private String description;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Role(int roleId, String roleName, String description) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
	}
	public Role() {}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName
				+ ", description=" + description + "]";
	}
	
	
}
