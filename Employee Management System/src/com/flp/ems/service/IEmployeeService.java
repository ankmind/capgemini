package com.flp.ems.service;

import java.util.List;

import com.flp.ems.domain.Employee;

public interface IEmployeeService {
	
	public void addEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();

	public Employee searchEmployee( String kinId);
	
	public void modifyEmployee( Employee emp);
	
	public void removeEmployee( String kinId);

}
