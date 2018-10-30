package com.CustomerManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/list")
	public String getCustomers(Model theModel)
	{
		return "list-customer";
	}

}
