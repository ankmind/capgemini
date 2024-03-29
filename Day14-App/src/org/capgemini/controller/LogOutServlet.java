package org.capgemini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();

		HttpSession session=request.getSession();
		session.invalidate();
		
		response.sendRedirect("pages/home.html");
		
		/*Cookie[] cookies= request.getCookies();
		
		for(Cookie ck:cookies){
			out.println(ck.getName() +" --->" + ck.getValue());
			
			}	
		*/
	}

}
