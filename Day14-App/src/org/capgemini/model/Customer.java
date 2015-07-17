package org.capgemini.model;

import java.util.Date;

public class Customer {
	
	private int custNo;
	private String custName;
	private String custType;
	private Date regDate;
	private String gender;
	
	public Customer(){}
	
	
	public Customer(int custNo, String custName, String custType, Date regDate,
			String gender) {
		super();
		this.custNo = custNo;
		this.custName = custName;
		this.custType = custType;
		this.regDate = regDate;
		this.gender = gender;
	}
	public int getCustNo() {
		return custNo;
	}
	public void setCustNo(int custNo) {
		this.custNo = custNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Customer [custNo=" + custNo + ", custName=" + custName
				+ ", custType=" + custType + ", regDate=" + regDate
				+ ", gender=" + gender + "]";
	}
	
	

}
