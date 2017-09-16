package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Customer;
import com.boot.repository.CustomerRepository;

@RestController
@RequestMapping("/v1")
public class HomeController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping("/")
	public String home(){
		return "Das Boot, reporting for duty!";
	}
	
	@RequestMapping(value="/customers", method = RequestMethod.GET)
	public List<Customer> showCustomers(){
		return (List<Customer>) customerRepository.findAll();
	}
}
