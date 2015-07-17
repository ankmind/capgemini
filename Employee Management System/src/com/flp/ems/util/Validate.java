package com.flp.ems.util;

public class Validate {
	
	// why are all the methods static
	public static boolean isValidKinId(String kinId)
	{
		return( kinId.matches("[G][0-9]{8}"));
	}
	
	public static boolean isValidEmailId(String emailId)
	{
		return( emailId.matches("[a-zA-Z0-9_]+@[a-z]+.[a-z]+"));
				//"[a-zA-Z0-9_]+@[a-z]+.[a-z]" what's missing here?
	}
	
	public static boolean isValidAddress(String address)
	{
		return( address.matches("[a-zA-Z0-9_/\\- ]+"));
	}
	public static boolean isValidEmployeeName(String empName)
	{
		return empName.matches("[A-Z][a-zA-Z ]*");
	}
	public static boolean isValidDate(String myDate)
	{
		return myDate.matches("[0123][0-9]-(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)-[12][089]\\d{2}");
	}
	
	public static boolean isValidPoneNumber(String phoneNumber)
	{
		return phoneNumber.matches("[0-9]{10}");
	}
	
}
