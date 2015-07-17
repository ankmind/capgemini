package org.capgemini.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.capgemini.model.Customer;
import org.capgemini.model.DBConnection;
import org.capgemini.model.Login;

public class CustomerDaoImpl  implements CustomerDAO{

	@Override
	public boolean isValidUser(Login login, DBConnection dbConnection) {
		
		boolean flag=false;
		
		String sql="select * from userLogin where username=? and userpassword=?";
		try {
			PreparedStatement pst=getDBConnection(dbConnection).prepareStatement(sql);
			
			pst.setString(1, login.getUserName());
			pst.setString(2, login.getUserPassword());
			
			ResultSet rs= pst.executeQuery();
			if(rs.next())
				flag=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}


	
	public Connection getDBConnection(DBConnection dbConnection){
		Connection conn=null;
		
		try {
			Class.forName(dbConnection.getDriverName());
			conn=DriverManager.getConnection(dbConnection.getConnUrl(),dbConnection.getUserName(),dbConnection.getUserPwd());
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}



	@Override
	public void saveCustomer(Customer customer, DBConnection dbConnection) {
		
		String sql="insert into cust_info values(?,?,?,?,?)";
		
		try {
			PreparedStatement pst=getDBConnection(dbConnection).prepareStatement(sql);
			
			pst.setInt(1, customer.getCustNo());
			pst.setString(2, customer.getCustName());
			pst.setString(3, customer.getCustType());
			pst.setDate(4, new Date(customer.getRegDate().getTime()));
			pst.setString(5, customer.getGender());
			
			int count=pst.executeUpdate();
			
			
			if(count>0)
				System.out.println("REcord inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public List<Customer> getAllCustomers(DBConnection dbConnection) {
		
		List<Customer> lst=new ArrayList<Customer>();
		String sql="select * from cust_info";
		
		try {
			PreparedStatement pst=getDBConnection(dbConnection).prepareStatement(sql);
		
			ResultSet rs=pst.executeQuery();
		
			
			while(rs.next()){
				Customer cust=new Customer();
				cust.setCustNo(rs.getInt("custId"));
				cust.setCustName(rs.getString("custname"));
				cust.setCustType(rs.getString("custType"));
				cust.setRegDate(rs.getDate("regDate"));
				cust.setGender(rs.getString("gender"));
				lst.add(cust);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return lst;
	}



	@Override
	public int deleteCustomer(int custId, DBConnection dbConnection) {
		int count=0;
		String sql="delete from cust_info where custid=?";
		try {
			PreparedStatement pst=getDBConnection(dbConnection).prepareStatement(sql);
			pst.setInt(1, custId);
			
			count=pst.executeUpdate();
		
			if(count>0)
				System.out.println("Record Deleted");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
		
	}
	

}
