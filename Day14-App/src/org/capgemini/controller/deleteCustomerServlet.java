package org.capgemini.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.capgemini.model.DBConnection;
import org.capgemini.service.CustomerService;
import org.capgemini.service.CustomerServiceImpl;


public class deleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	String driverName,connUrl,userName,userPwd;
	DBConnection dbConn;
	
	
	@Override
	public void init() throws ServletException {
		
		ServletContext servConext=getServletContext();
		
		driverName=servConext.getInitParameter("driverName");
		connUrl=servConext.getInitParameter("connUrl");
		userName=servConext.getInitParameter("userName");
		userPwd=servConext.getInitParameter("userPwd");
		dbConn=new DBConnection(driverName, connUrl, userName, userPwd);
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int custId=Integer.parseInt(request.getParameter("custId"));
		
		CustomerService customerService=new CustomerServiceImpl();
		
		int count=customerService.deleteCustomer(custId, dbConn);
		
		if(count>0)
			request.getRequestDispatcher("UpdateCustomerServlet").include(request, response);
		
			
		
		
	}

}
