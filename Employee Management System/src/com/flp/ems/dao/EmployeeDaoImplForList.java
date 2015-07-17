package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.List;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList implements IemployeeDao {
	
	static ArrayList<Employee> employeeList=new ArrayList<Employee>();
	static int employeeId=0;
	
	
	//why not use static for these methods
	@Override
	public  void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employee.setEmployeeId(++employeeId);
		employeeList.add(employee);
		}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeList;
	}

	@Override
	public Employee searchEmployee(String kinId) {
		// TODO Auto-generated method stub
		Employee employee= new Employee();
		employee=null;
		for(Employee emp: employeeList){
			if(kinId.equals(emp.getKinId()))
			{
				employee=emp;
				return employee;
			}
			
		}
		return employee;
	}

	@Override
	public void modifyEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Employee employee=  searchEmployee(emp.getKinId());
		employee.setAddress(emp.getAddress());
		employee.setDepartment(emp.getDepartment());
		employee.setEmailId(emp.getEmailId());
		employee.setEmpdob(emp.getEmpdob());
		employee.setEmpdoj(emp.getEmpdoj());
		employee.setEmployeeId(emp.getEmployeeId());
		employee.setEmpName(emp.getEmpName());
		employee.setKinId(emp.getKinId());
		employee.setPhoneNo(emp.getPhoneNo());
		employee.setProject(emp.getProject());
		employee.setRole(emp.getRole());
		
		
	}

	@Override
	public void removeEmployee(String kinId) {
		// TODO Auto-generated method stub
		Employee emp=null;
		for(Employee emp1: employeeList)
		{
			if(emp1.getKinId().equals(kinId));
				emp=emp1;
			//employeeList.remove(emp1);
		}
		employeeList.remove(emp);
	}
	

}
