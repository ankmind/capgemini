package org.capgemini.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.capgemini.model.DBConnection;
import org.capgemini.model.Login;
import org.capgemini.service.CustomerService;
import org.capgemini.service.CustomerServiceImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	String driverName,connUrl,userName,userPwd;
	DBConnection dbConn;
	
	
	@Override
	public void init() throws ServletException {
		System.out.println(getServletContext());
		System.out.println(getServletContext().getContextPath());
		
		driverName=getServletContext().getInitParameter("driverName");
		connUrl=getServletContext().getInitParameter("connUrl");
		userName=getServletContext().getInitParameter("userName");
		userPwd=getServletContext().getInitParameter("userPwd");
		dbConn=new DBConnection(driverName, connUrl, userName, userPwd);
		
		
		
		
	}






	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//ServletContext servConext=getServletContext();
		
		
		CustomerService customerService=new CustomerServiceImpl();
		
		String uname=request.getParameter("uname");
		String userpwd=request.getParameter("upwd");
		
		Login login=new Login(uname, userpwd);
		
		
		
		boolean flag=customerService.isValidUser(login,dbConn);
		
		if(flag){
			response.sendRedirect("pages/home.html");
			//request.getRequestDispatcher("pages/home.html").forward(request, response);
		}else
			response.sendRedirect("pages/login.html");
		
	}

}
