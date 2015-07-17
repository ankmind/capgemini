package org.capgemini.listerner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListerDemo implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("My contextDestroyed");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
	
		System.out.println("My Initialized");
		Connection conn=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","india123");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		context.getServletContext().setAttribute("dbConnection", conn);
		
	}

}
