package org.capgemini.service;

import java.util.List;

import org.capgemini.dao.CustomerDAO;
import org.capgemini.dao.CustomerDaoImpl;
import org.capgemini.model.Customer;
import org.capgemini.model.DBConnection;
import org.capgemini.model.Login;

public class CustomerServiceImpl implements CustomerService{

	
	private CustomerDAO custDao=new CustomerDaoImpl();
	
	@Override
	public boolean isValidUser(Login login, DBConnection dbConnection) {
		
		return custDao.isValidUser(login, dbConnection);
	}

	@Override
	public void saveCustomer(Customer customer, DBConnection dbConnection) {
		custDao.saveCustomer(customer, dbConnection);
	}

	@Override
	public List<Customer> getAllCustomers(DBConnection dbConnection) {
		
		return custDao.getAllCustomers(dbConnection);
	}

	@Override
	public int deleteCustomer(int custId, DBConnection dbConnection) {
		return custDao.deleteCustomer(custId, dbConnection);
	}

}
