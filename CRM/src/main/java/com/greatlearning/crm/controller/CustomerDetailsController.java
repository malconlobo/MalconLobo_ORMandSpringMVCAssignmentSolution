package com.greatlearning.crm.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.crm.service.CustomerDetailsService;

import com.greatlearning.crm.entities.CustomerDetails;

@Controller
@RequestMapping("/customer")
public class CustomerDetailsController {
	
	@Autowired
	private CustomerDetailsService custDetailsService;
	
	@RequestMapping("/list")
	public String listCustomerDetails(Model model) {
		List<CustomerDetails> custDetails = custDetailsService.findAll();
		model.addAttribute("Customers", custDetails);
		
		return "list-details";
		
	}
	
	@RequestMapping("/delete")
	public String deleteCustomerDetails(@RequestParam("custId") int id) {
		
		custDetailsService.deleteById(id);
		
		return "redirect:/customer/list";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		CustomerDetails custDetails = new CustomerDetails();
		// set Customers as a model attribute to pre-populate the form
		theModel.addAttribute("Customers", custDetails);

		// send over to form
		return "customerdetails-entry";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("custId") int id, Model theModel) {

		//Find customer entry
		CustomerDetails custDetails = custDetailsService.findById(id);
		// set Customers as a model attribute to pre-populate the form
		theModel.addAttribute("Customers", custDetails);

		// send over to form
		return "customerdetails-entry";
	}
	
	@PostMapping("/save")
	public String saveCustomerDetails(@RequestParam("id") int id, @RequestParam("firstname") String firstName,
			@RequestParam("lastname") String lastName, @RequestParam("email") String email) {

		//System.out.println(id);
		CustomerDetails custDetails;
		if (id != 0) {
			custDetails = custDetailsService.findById(id);
			custDetails.setFirstName(firstName);
			custDetails.setLastName(lastName);
			custDetails.setEmail(email);
		} else {
			custDetails = new CustomerDetails(firstName, lastName, email);
		}
		// save the entry
		custDetailsService.save(custDetails);

		// use a redirect to prevent duplicate submissions
		return "redirect:/customer/list";

	}
}
