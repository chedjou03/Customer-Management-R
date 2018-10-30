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
	@Transactional
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create the query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		//get the result 
		List<Customer> customers = theQuery.getResultList();
		
		//return the list of customer
		return customers;
	}

}
