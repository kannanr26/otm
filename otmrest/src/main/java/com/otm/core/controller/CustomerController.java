package com.otm.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.otm.core.model.Customer;
import com.otm.core.services.CustomerService;



@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping(value="/customer",  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>>getAll() {

		 return new ResponseEntity<List<Customer>>(customerService.getAllCustomer(), HttpStatus.OK);
	}
	
	@PostMapping(value="/postcustomer")
	public ResponseEntity<Customer> register(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>( customerService.save(customer),HttpStatus.OK);
		
	}

/*	@GetMapping(value="/findbylastname/{lastName}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findByLastName(@PathVariable String userId) {

		List<Customer> customers = repository.findByUserID(userId);
		return customers;
	}
	*/
	@DeleteMapping(value="/customer/{id}")
	public ResponseEntity deleteCustomer(@PathVariable long id){
		
		customerService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
