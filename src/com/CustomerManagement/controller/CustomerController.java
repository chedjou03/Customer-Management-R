package com.CustomerManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CustomerManagement.entity.Customer;
import com.CustomerManagement.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	@Autowired
	private CustomerService customerService;
	
	// add an inibinder ... to convert trimp inputs strings
	// remove leading and trailing whitespace from any string input
	@InitBinder
	public void initBinder ( WebDataBinder binder )
	{
		StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringtrimmer);
	 }
	
	@GetMapping("/list")
	public String getCustomers(Model theModel)
	{
		//get customers from the dao
		
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customer";
	}
	
	@GetMapping("/showCustomerAddForm")
	public String showCustomerAddForm(Model theModel)
	{
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "add-customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer,BindingResult theBindingResult)
	{
		//there was validation error on the form, all fields were not filled
		if(theBindingResult.hasErrors())
		{
			//return to customer add form page
			return "add-customer-form";
		}
		//all fields were filled
		else
		{
			//save the customer
			customerService.saveCustomer(theCustomer);
			
			return "redirect:/customer/list";
		}
		
	}
	
	@GetMapping("/updateCustomer")
	public String UpdateCustomer(@RequestParam("customerId") int theCustomerId,Model theModel)
	{
		//get the customer from the DB
		Customer theCustomer = customerService.getCustomer(theCustomerId);
		
		//set the customer to the model attribute
		theModel.addAttribute("customer", theCustomer);
		
		//return the customer save/update form
		return "add-customer-form";
	}
	
	@GetMapping("/deleteCustomer")
	public String DeleteCustomer (@RequestParam("customerId") int theCustomerId)
	{
		customerService.DeleteCustomer(theCustomerId);
		
		//return the customer list 
		return "redirect:/customer/list";
		
	}

}
