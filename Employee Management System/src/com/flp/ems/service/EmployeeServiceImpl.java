package com.flp.ems.service;


import java.util.List;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.domain.Employee;

public class EmployeeServiceImpl implements IEmployeeService {
	static EmployeeDaoImplForList dataAccess = new EmployeeDaoImplForList();
	
	Employee employee= new Employee();
	
	
	public static boolean isUniqueEmailId( String emailId)
	{
			if (dataAccess.getAllEmployees().isEmpty())
			{
				return true;
			}
			else{
				for(Employee emp: dataAccess.getAllEmployees())
				{
					if (emailId== emp.getEmailId())
						return false;
				}
			}
			return true;
	}

	public static boolean isUniqueKinId( String kinId)
	{
			if (dataAccess.getAllEmployees().isEmpty())
			{
				return true;
			}
			else{
				for(Employee emp: dataAccess.getAllEmployees())
				{
					if (kinId== emp.getKinId())
						return false;
				}
			}
			return true;
	}
	
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		dataAccess.addEmployee(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return dataAccess.getAllEmployees();
	}

	@Override
	public Employee searchEmployee(String kinId) {
		// TODO Auto-generated method stub
		return dataAccess.searchEmployee(kinId);
	}

	@Override
	public void modifyEmployee(Employee emp) {
		// TODO Auto-generated method stub
		dataAccess.modifyEmployee(emp);
		
	}

	@Override
	public void removeEmployee(String kinId) {
		// TODO Auto-generated method stub
		dataAccess.removeEmployee(kinId);
		
	}
	
	

}
