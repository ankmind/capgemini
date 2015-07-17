package org.capgemini.demo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ObjectOutDemo {
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ObjectOutDemo objdemo=new ObjectOutDemo();
		
		File file=new File("D:\\vidavid\\fileINfo\\employee.txt");
		
		FileOutputStream fout=null;
		ObjectOutputStream objout=null;
		
		try {
			fout=new FileOutputStream(file);
			objout=new ObjectOutputStream(fout);
			String choice=null;
			
			do{
			Employee emp=objdemo.getEmployee();
			
			objout.writeObject(emp);
			System.out.println("Do you want to continue?[y/n]");
			choice=sc.next();
			}while(choice.charAt(0)=='Y'|| choice.charAt(0)=='y');
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				objout.close();
				fout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
		FileInputStream fin=null;
		ObjectInputStream objIn=null;
		
		try {
			fin=new FileInputStream(file);
			objIn=new ObjectInputStream(fin);
			
			
		
			Employee employee=(Employee)objIn.readObject();
			
			while(employee!=null){
			System.out.println(employee);
			employee=(Employee)objIn.readObject();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (EOFException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			try {
				objIn.close();
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
	}
	
	
	public Employee getEmployee(){
		
		System.out.println("Enter Employee Id:");
		int empId=sc.nextInt();
		
		System.out.println("Enter Employee Name:");
		String empName=sc.next();
		
		System.out.println("Enter Employee Salary:");
		float empSal=sc.nextFloat();
		
		Address address=getAddress();
		
		Employee emp=new Employee(empId, empName, empSal,address);
		address.setEmpAddress(emp);
		
		return emp;
		
		
	}
	
	
	public Address getAddress(){
		
		System.out.println("Enter Street Name:");
		String streetName=sc.next();
		
		System.out.println("Enter City:");
		String city=sc.next();
		
		return new Address(streetName, city);
		
	}
	
	

}
