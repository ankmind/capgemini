package com.flp.ems.dao;

import java.util.List;

import com.flp.ems.domain.Employee;

public interface IemployeeDao {
	
		public void addEmployee(Employee employee);
	
		public List<Employee> getAllEmployees();

		public Employee searchEmployee( String kinId);
		
		public void modifyEmployee( Employee emp);
		
		public void removeEmployee( String kinId);

		
}
