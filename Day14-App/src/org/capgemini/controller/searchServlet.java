package org.capgemini.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.capgemini.model.Customer;
import org.capgemini.service.CustomerService;
import org.capgemini.service.CustomerServiceImpl;

/**
 * Servlet implementation class searchServlet
 */
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerService customerService=new CustomerServiceImpl();
		
		List<Customer> customers=customerService.getAllCustomers((Connection)getServletContext().getAttribute("dbConnection"));
		
		
		HttpSession session=request.getSession();
		session.setAttribute("lstCustomer", customers);
		
		response.sendRedirect("pages/listCustomer.jsp");
		
	}

}
