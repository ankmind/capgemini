package org.capgemini.model;

public class Login {
	
	private String userName;
	private String userPassword;
	
	public Login(){}
	
	public Login(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	@Override
	public String toString() {
		return "Login [userName=" + userName + ", userPassword=" + userPassword
				+ "]";
	}
	
	
	

}
