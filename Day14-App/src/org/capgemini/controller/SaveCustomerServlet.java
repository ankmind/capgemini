package org.capgemini.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.capgemini.model.Customer;
import org.capgemini.model.DBConnection;
import org.capgemini.service.CustomerService;
import org.capgemini.service.CustomerServiceImpl;


public class SaveCustomerServlet extends HttpServlet {
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




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerService customerService=new CustomerServiceImpl();
		
		int custNo=Integer.parseInt(request.getParameter("custId"));
		String custName=request.getParameter("custName");
		String custType=request.getParameter("custType");
		String regDate=request.getParameter("regDate");
		String gender=request.getParameter("gender");
		
		//yyyy-mm-dd
		
		int year=Integer.parseInt(regDate.substring(0, 4));
		int month=Integer.parseInt(regDate.substring(5, 7));
		int date=Integer.parseInt(regDate.substring(8));
		
		//dd/mm/yyyy
		
		//SimpleDateFormat myFormat=new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		Date custReg=new Date(year,month-1,date);
		
		Customer customer=new Customer(custNo, custName, custType, custReg, gender);
		
		
		customerService.saveCustomer(customer, dbConn);
		
		response.sendRedirect("pages/newCustomer.html");
		
		
	}

}
