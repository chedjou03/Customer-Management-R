package com.CustomerManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.CustomerManagement.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the Hibernate session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create the query and sort by last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//get the result 
		List<Customer> customers = theQuery.getResultList();
		
		//return the list of customer
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
			
		//save the Customer
		currentSession.saveOrUpdate(theCustomer);
				
	}

	@Override
	public Customer getCustomer(int theCustomerId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get the customer for the theCustomerId
		Customer theCustomer = currentSession.get(Customer.class, theCustomerId);
		
		return theCustomer;
	}

	@Override
	public void DeleteCustomer(int theCustomerId) {
		
		//get the customer associate to this id
		Customer theCustomer = getCustomer(theCustomerId);
		
		//get the current hibernate session	
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete the customer
		currentSession.delete(theCustomer);		
		
	}

}
