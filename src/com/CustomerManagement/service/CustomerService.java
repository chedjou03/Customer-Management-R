package com.CustomerManagement.service;

import java.util.List;

import com.CustomerManagement.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theCustomerId);

	public void DeleteCustomer(int theCustomerId);

}
