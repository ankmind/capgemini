package org.capgemini.model;

public class DBConnection {
 private String driverName,connUrl,userName,userPwd;

 public DBConnection(){}
 
 
public DBConnection(String driverName, String connUrl, String userName,
		String userPwd) {
	super();
	this.driverName = driverName;
	this.connUrl = connUrl;
	this.userName = userName;
	this.userPwd = userPwd;
}

public String getDriverName() {
	return driverName;
}

public void setDriverName(String driverName) {
	this.driverName = driverName;
}

public String getConnUrl() {
	return connUrl;
}

public void setConnUrl(String connUrl) {
	this.connUrl = connUrl;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserPwd() {
	return userPwd;
}

public void setUserPwd(String userPwd) {
	this.userPwd = userPwd;
}
	
 
 
}
