package com.otm.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.otm.core.model.Customer;
import com.otm.core.services.CustomerService;

@RestController
public class LoginController {

	@Autowired
	CustomerService customerService;
	@PostMapping(value="/login")
	public ResponseEntity<Customer> register(@RequestBody Customer customer) {
		
		Customer loginCustomer=customerService.findByCustomerUserId(customer.getUserId());
		if(loginCustomer.getPassword().equals(customer.getPassword()))
			return new ResponseEntity<Customer>(loginCustomer,HttpStatus.OK);
		return new ResponseEntity<Customer>(loginCustomer,HttpStatus.NOT_ACCEPTABLE);
		
		
	}


}
