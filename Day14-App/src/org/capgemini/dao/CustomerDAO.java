package org.capgemini.dao;

import java.util.List;

import org.capgemini.model.Customer;
import org.capgemini.model.DBConnection;
import org.capgemini.model.Login;

public interface CustomerDAO {
	
	public boolean isValidUser(Login login,DBConnection dbConnection);

	
	public void saveCustomer(Customer customer,DBConnection dbConnection);

	
	public List<Customer> getAllCustomers(DBConnection dbConnection);

	
	public int deleteCustomer(int custId, DBConnection dbConnection);
}
