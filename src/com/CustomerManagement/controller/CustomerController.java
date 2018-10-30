package com.CustomerManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.CustomerManagement.entity.Customer;
import com.CustomerManagement.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String getCustomers(Model theModel)
	{
		//get customers from the dao
		
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customer";
	}

}
