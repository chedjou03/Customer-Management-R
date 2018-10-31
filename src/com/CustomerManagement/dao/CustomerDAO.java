package com.CustomerManagement.dao;

import java.util.List;

import com.CustomerManagement.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theCustomerId);

	public void DeleteCustomer(int theCustomerId);

}
