package com.flp.ems.view;

import java.util.Scanner;

import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeServiceImpl;

public class Boot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menuSelection();
		

	}
	
	public static void menuSelection()	//could it have been non static method and still work?
	{
		EmployeeServiceImpl empService=new EmployeeServiceImpl();
		Scanner sc=new Scanner(System.in);
		int option;
		String choice;
		Employee employee= new Employee();
		String kinId;
		
		
		do{
			System.out.println("1.Add Employee");
			System.out.println("2.Modify Employee");
			System.out.println("3.Remove Employee");
			System.out.println("4.Search Employee");
			System.out.println("5.Get All Employee");
			System.out.println("6.Exit");
			System.out.println("Enter your option:");
			option=sc.nextInt();
			
			switch(option)
			{
			case 1:
				employee= UserInteraction.addEmployee();
				while(!EmployeeServiceImpl.isUniqueEmailId(employee.getEmailId()))
				{
					System.out.println("This Email Id Already Exists");
					String emailId=UserInteraction.getEmailId();
					employee.setEmailId(emailId);
				}
				
				while(!EmployeeServiceImpl.isUniqueKinId(employee.getKinId()))
				{
					System.out.println("This Kin Id Already Exists");
					kinId=UserInteraction.getKinId();
					employee.setEmailId(kinId);
				}
				
				empService.addEmployee(employee);
				System.out.println(employee);
				
				break;
				
			case 2:
				
				 kinId= UserInteraction.getKinId();
				
				
				 Employee  empOld= empService.searchEmployee(kinId);
				 
				  Employee empNew= UserInteraction.modifyEmployee(empOld);
				if(empNew.getEmailId()== empOld.getEmailId())
				{
					empService.modifyEmployee(empNew);
				}
				else
					if(EmployeeServiceImpl.isUniqueEmailId(empNew.getEmailId()))
					{
						empService.modifyEmployee(empNew);
					}
				
					 
				break;
				
			case 3:
				System.out.println("Enter kin id of the record to be deleted");
				kinId= UserInteraction.getKinId();
				empService.removeEmployee(kinId);
				System.out.println("record deleted");
				
				break;
				
			case 4:
				
					System.out.println("Enter the kinId of the employee");
					 kinId = sc.next();
					employee = empService.searchEmployee(kinId);
					if (employee == null) {
						System.out.println("No record Found");
					}
					else
						System.out.println(employee);
				break;
				
			case 5:
				System.out.println(empService.getAllEmployees());
				break;
				
			case 6:
				
				System.exit(0);
				//break;
				
				default:
					System.out.println("Incorrect option");
					//System.exit(0);
			}
			
			
			System.out.println("Do you want to continue? -yes/no");
			choice= sc.next();
			
		}
		while(choice.charAt(0)=='y'|| choice.charAt(0)=='Y');
	}

}
