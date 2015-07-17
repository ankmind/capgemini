package org.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.capgemini.model.Customer;
import org.capgemini.model.DBConnection;
import org.capgemini.service.CustomerService;
import org.capgemini.service.CustomerServiceImpl;


public class UpdateCustomerServlet extends HttpServlet {
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
		PrintWriter out=response.getWriter();
		CustomerService customerService=new CustomerServiceImpl();
		
		List<Customer> customers= customerService.getAllCustomers(dbConn);
		
		
		out.println("<html>");
		out.println("<head><title>ShowAllCutomer</title></head>");
		out.println("<body>");
		out.println("<br><br><h1 align='center'>Customer Application</h1>	<br>");
		out.println("<hr>");
		out.println("<a href='pages/newCustomer.html'>New Customer</a> &nbsp;&nbsp;&nbsp;&nbsp; |&nbsp;");
				out.println("<a href='ShowAllServlet'>Show All</a> &nbsp;&nbsp;&nbsp;&nbsp; |&nbsp;");
						out.println("<a href='#'>Search</a> &nbsp;&nbsp;&nbsp;&nbsp; |&nbsp;");
								out.println("<a href='#'>Update</a> &nbsp;&nbsp;&nbsp;&nbsp; |&nbsp;");

								out.println("<hr><div>");

		
		out.println("<table>");
		out.println("<tr> "
				+ "<th>Customer Id</th>"
				+ "<th>Name</th>"
				+ "<th>Type</th>"
				+ "<th>RegDate</th>"
				+ "<th>Gender</th>"
				+ "<th>Edit </th>"
				+ "</tr>");
		
		SimpleDateFormat myFormat=new SimpleDateFormat("dd-MM-YYYY");
		
		for(Customer cust:customers){
			Date myDate=new Date(cust.getRegDate().getTime());
		
			String myDateFormat=myFormat.format(myDate);
			
		out.println("<tr> "
				+ "<td>"+ cust.getCustNo() +"</td>"
				+ "<td>"+ cust.getCustName() +"</td>"
				+ "<td>"+ cust.getCustType() +"</td>"
				+ "<td>"+myDateFormat +"</td>"
				+ "<td>"+ cust.getGender() +"</td>"
				+ "<td> <a href='deleteCustomerServlet?custId="+cust.getCustNo()+"'> Delete </a> &nbsp;&nbsp;&nbsp;"
						+"<a href='editCustomerServlet'> Edit </a> &nbsp;&nbsp;&nbsp;</td>"
				
				+ "</tr>");
		}
		
		
		
		out.println("</table>");
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");
	}

}
