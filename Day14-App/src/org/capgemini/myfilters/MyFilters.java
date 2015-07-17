package org.capgemini.myfilters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class MyFilters
 */
public class MyFilters implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilters() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("destroy method - Filter Invoked");
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			
		System.out.println("REquest Filter - Filter Invoked");
		HttpServletRequest myReq=(HttpServletRequest) request;
		
		
		chain.doFilter(request, response);
			
		System.out.println("REsponse Filter - Filter Invoked");

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init method - Filter Invoked");
		
	}

}
