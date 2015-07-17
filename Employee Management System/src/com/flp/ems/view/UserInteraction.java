package com.flp.ems.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;
import com.flp.ems.util.Validate;

public class UserInteraction {
	
	static Scanner sc; //what difference does the static keyword makes here?
	
	public static Employee addEmployee()
	{
		
		sc=new Scanner(System.in);
		Employee emp=new Employee();
		String kinId;
		boolean flag=false;
		String empName;
		String empDob;
		String empDoj;
		String address;
		String phoneNumber;
		String emailId;
		//Date date= new Date();   don't need it!
		
		// validating employee's name
		do{
			System.out.println("Enter Employee Name:");
			empName=sc.nextLine();
			
			flag=Validate.isValidEmployeeName(empName);
			if(!flag)
				System.out.println("Invalid Employee Name!!!!");
			
			}while(!flag);
			emp.setEmpName(empName);
			
			//to validate Address
			
			do{
			System.out.println("Enter Employee Address:");
			address=sc.nextLine();
			
			flag=Validate.isValidAddress(address);
			if(!flag)
				System.out.println("Invalid Address!");
			
			}while(!flag);
			emp.setAddress(address);
			
			//to validate kinid
			do{
			System.out.println("Enter kin Id");
			kinId= sc.next();
			if(!Validate.isValidKinId(kinId))
			{
				System.out.println("Invalid KinId Format!");
			}
			}while (!Validate.isValidKinId(kinId));
			
			emp.setKinId(kinId);
		
			//to validate Email
			
			do {
				System.out.println("Enter EmailId");
				emailId = sc.next();
				if (!Validate.isValidEmailId(emailId)) {
					System.out.println("Invalid emailId Format!");
				}
				} while (!Validate.isValidEmailId(emailId));
			
			emp.setEmailId(emailId);
			
			//to validate Date of birth
			do{
			System.out.println("Enter Employee Date of Birth:");
			empDob=sc.next();
			
			flag=Validate.isValidDate(empDob);
			if(!flag)
				System.out.println("Invalid Date Format(dd-MMM-yyyy)!");
			
			}while(!flag);
			emp.setEmpdob(new Date(empDob));
			
			//to validate Date of joining
			do{
			System.out.println("Enter Employee Date of Joining:");
			empDoj=sc.next();
			
			flag=Validate.isValidDate(empDoj);
			if(!flag)
				System.out.println("Invalid Date Format(dd-MMM-yyyy)!");
			
			}while(!flag);
			emp.setEmpdoj(new Date(empDoj));
			
			//to validate phone number
			do{
				System.out.println("Enter Employee Phone number:");
				phoneNumber=sc.next();
				flag= Validate.isValidPoneNumber(phoneNumber);
				
				if(!flag)
				{
					System.out.println("Invalid PhoneNumber");	
				}
			}while(!flag);
			emp.setPhoneNo(phoneNumber);
			
			//setting and validating the department
			Department dept;
			
			dept= getDepartment();
			emp.setDepartment(dept);
			
			// validating the role
			
			Role role=null;
			do{
				role= getRole();
				if(role== null)
					System.out.println("Invalid Role");
				}
			while(role == null);
			emp.setRole(role);
			
			// validating the list of projects
			
			List <Project> projectList= new ArrayList<Project>();
			
			do {
				projectList = getProjects();
				if (projectList.isEmpty()) {
					System.out.println("Invalid List of projects");
				}
			} while (projectList.isEmpty());
			emp.setProject(projectList);
			
	return emp;

}
	public static String getEmailId()
	{
		String emailId;
		do {
			System.out.println("Enter EmailId");
			emailId = sc.next();
			if (!Validate.isValidEmailId(emailId)) {
				System.out.println("Invalid emailId Format!");
			}
			} while (!Validate.isValidEmailId(emailId));
		
	return emailId;
		}
	
	public static String getKinId()
	{
		String kinId;
		do {
			System.out.println("Enter KinId");
			kinId = sc.next();
			if (!Validate.isValidKinId(kinId)) {
				System.out.println("Invalid kinId Format!");
			}
			} while (!Validate.isValidKinId(kinId));
		
	return kinId;
		}
	
	public static List<Department> getAllDepartments(){
		List<Department> departments=new ArrayList<Department>();
		departments.add(new Department(101, "TDI", "Technology Developement And Integration"));
		departments.add(new Department(102, "Cards", "All type of cards"));
		departments.add(new Department(103, "Testing", "Testing Domain"));
		departments.add(new Department(104, "L&C", "Learning And Culture"));
		departments.add(new Department(105, "Payments", "All Payment"));
		departments.add(new Department(106, "PEN", "INfra management"));
		
		//System.out.println(departments) - only prints the first entry
		return departments;
	}
	
public static Department getDepartment(){
		
		Department department=null;
		sc=new Scanner(System.in);
		System.out.println("Choose The Department:");
		
		for(Department dept:getAllDepartments()){
			System.out.println(dept);
		}
		System.out.println("Enter Deperment Id:");
		int deptId=sc.nextInt();
		
		for(Department dept:getAllDepartments()){
			if(dept.getDepartmentId()==deptId){
				department=dept;
			break;
			}
}
		
		return department;
	}
	
public static List<Role> getAllRoles(){
	List<Role> roles=new ArrayList<Role>();
	roles.add(new Role(11, "Developer", "Smarty pants"));
	roles.add(new Role(12, "Tester", "Developer wannabe"));
	roles.add(new Role(13, "RnD", "ingenius"));
	roles.add(new Role(14, "Technician", "maintainence"));
	roles.add(new Role(15, "Manager", "supervisor"));
	roles.add(new Role(16, "Project lead", "the Shephard"));
	
	return roles;
}
public static Role getRole(){
	
	Role role =null;
	sc=new Scanner(System.in);
	System.out.println("Select The Role:");
	
	for(Role rl:getAllRoles()){
		System.out.println(rl);
	}
	System.out.println("Enter Role Id:");
	int roleId=sc.nextInt();
	
	for(Role rl:getAllRoles()){
		if(rl.getRoleId()==roleId){
			role=rl;
		break;
		}
//	else{
//			System.out.println("invalid Role Id");
//			role= getRole();
//		}
	}
	
	return role;
}

public static List<Project> getAllProjects(){
	List<Project> projects=new ArrayList<Project>();
	projects.add(new Project(1, "Morgan", "Morgan"));
	projects.add(new Project(2, "Barclays", "Barclays"));
	projects.add(new Project(3, "HSBC", "HSBC"));
	projects.add(new Project(4, "Scope", "Scope"));
	projects.add(new Project(5, "TRansUnion", "TRansUnion"));
	projects.add(new Project(6, "CITI", "CITI"));
	
	return projects;
}

public static List<Project> getProjects(){
	
	List <Project> projectList= new ArrayList<Project>();
	String choice= null;
		System.out.println("Select a project");
		do {
		for (Project prjct : getAllProjects()) {
			System.out.println(prjct);
		}
		System.out.println("Enter the project Id");
		int projectId = sc.nextInt();
		for (Project prjct : getAllProjects()) {
			if (projectId == prjct.getProjectId()) {
				projectList.add(prjct);
				break;
			}
			}
		System.out.println("Do you want to continue [y/n]");
			choice = sc.next();
			
	} while (choice.charAt(0)=='y' || choice.charAt(0)=='Y');
	
	return projectList;
}
/*---------------------------------------------------------------------------------*/

public static Employee modifyEmployee(Employee empOld)

{

		Employee empNew= empOld;
	sc=new Scanner(System.in);
	Employee emp=new Employee();
	String choice;
	
	
	System.out.println("Select the feild to modify:");
	do{
		String kinId;
		boolean flag=false;
		String empName = null;
		String empDob;
		String empDoj;
		String address;
		String phoneNumber;
		String emailId;
		int option;
		
		
		
		
	System.out.println("1- Name:");
	System.out.println("2- address:");	
	System.out.println("3- emailId:");
	System.out.println("4- phone number:");
	System.out.println("5- date of birth:");
	System.out.println("6- date of joining");
	System.out.println("7- DepartmentId");
	System.out.println("8- RoleId");
	System.out.println("9- Projects:");
	System.out.println("10- stop modifications:");
	
	option= sc.nextInt();
	
	switch (option) {
		
	case 1 :
		
		while(!flag){
			System.out.println("Enter Employee Name:");
			empName=sc.nextLine();
			
			flag=Validate.isValidEmployeeName(empName);
			if(!flag)
				System.out.println("Invalid Employee Name!!!!");
			
			}
			empOld.setEmpName(empName);
		break;	
		
			case 2 :
				
				do{
					System.out.println("Enter Employee Address:");
					address=sc.nextLine();
					
					flag=Validate.isValidAddress(address);
					if(!flag)
						System.out.println("Invalid Address!");
					
					}while(!flag);
					empOld.setAddress(address);
				break;
			
			
			
			
		case 3:
			
			do {
				System.out.println("Enter EmailId");
				emailId = sc.next();
				if (!Validate.isValidEmailId(emailId)) {
					System.out.println("Invalid emailId Format!");
				}
				} while (!Validate.isValidEmailId(emailId));
			
			empOld.setEmailId(emailId);
			
			break;
			
		case 4:
			do{
				System.out.println("Enter Employee Phone number:");
				phoneNumber=sc.next();
				flag= Validate.isValidPoneNumber(phoneNumber);
				
				if(!flag)
				{
					System.out.println("Invalid PhoneNumber");	
				}
			}while(!flag);
			empOld.setPhoneNo(phoneNumber);
			break;
			
		case 5:
			do{
				System.out.println("Enter Employee Date of Birth:");
				empDob=sc.next();
				
				flag=Validate.isValidDate(empDob);
				if(!flag)
					System.out.println("Invalid Date Format(dd-MMM-yyyy)!");
				
				}while(!flag);
				empOld.setEmpdob(new Date(empDob));
			break;
		case 6:
			do{
				System.out.println("Enter Employee Date of Joining:");
				empDoj=sc.next();
				
				flag=Validate.isValidDate(empDoj);
				if(!flag)
					System.out.println("Invalid Date Format(dd-MMM-yyyy)!");
				
				}while(!flag);
				empOld.setEmpdoj(new Date(empDoj));
			break;
		case 7:
			Department dept;
			
			dept= getDepartment();
			empOld.setDepartment(dept);
			break;
			
		
		case 8:
			
			List <Project> projectList= new ArrayList<Project>();
			
			do {
				projectList = getProjects();
				if (projectList.isEmpty()) {
					System.out.println("Invalid List of projects");
				}
			} while (projectList.isEmpty());
			empOld.setProject(projectList);
			break;

		
			
			
			
		case 9:
			Role role=null;
			do{
				role= getRole();
				if(role== null)
					System.out.println("Invalid Role");
				}
			while(role == null);
			empOld.setRole(role);
			break;

		case 10:
			return empOld;
			
				
			
		default:
			System.out.println("press Y to Exit");
			 choice= sc.next();
	}
	
	
	

return empOld;

}while(!(choice.charAt(0)=='y'|| choice.charAt(0)=='Y'));
	
}
}
