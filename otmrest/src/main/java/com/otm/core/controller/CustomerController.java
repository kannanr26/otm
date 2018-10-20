package com.otm.core.controller;

import java.util.List;

import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otm.core.model.Customer;
import com.otm.core.services.CustomerService;


@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping(value="/customershow/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>>getAll(@PathVariable("id") int id) {
System.out.println(" customershow  %%%%% id= "+id);
		Customer customer = customerService.findByCustomerId(Long.valueOf(id));
		
		
		 return new ResponseEntity<List<Customer>>(customerService.getAllCustomer(customer), HttpStatus.OK);
	}
	
	@GetMapping(value="/getProfile/{id}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer>getProfile(@PathVariable("id") int id) {

		Customer customer = customerService.findByCustomerId(Long.valueOf(id));
		customer.setPassword("");
		
		 return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@PostMapping(value="/postcustomer")
	public ResponseEntity<HttpStatus> register(@RequestBody Customer customer) {
		
		try {
			System.out.println( "customer in server "+customer.toString());
			customerService.save(customer);
			return new ResponseEntity<HttpStatus>( HttpStatus.OK);
			
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<HttpStatus>( HttpStatus.CONFLICT);
			
		}
		
		
	}
	
	@PostMapping(value="/editprofile/{id}")
	public ResponseEntity<HttpStatus> editProfile(@PathVariable("id") long id,@RequestBody Customer customer) {
		try {
			
			Customer customerDB = customerService.findByCustomerId(Long.valueOf(id));
			if(customerDB.getEMail().equalsIgnoreCase(customer.getEMail()))
			{
				customerDB.setFirstName(customer.getFirstName());
				customerDB.setLastName(customer.getLastName());
				customerDB.setGender(customer.getGender());
				customerDB.setReligion(customer.getReligion());
				customerDB.setDobYear(customer.getDobYear());
				customerDB.setEducation(customer.getEducation());
				customerDB.setFoodHabit(customer.getFoodHabit());
				customerDB.setFaceBook(customer.getFaceBook());
				customerDB.setWmReligion(customer.getWmReligion());
				customerDB.setRelocation(customer.isRelocation());
				customerDB.setResidenceDetails(customer.getResidenceDetails());
				customerDB.setWorklocationDetails(customer.getWorklocationDetails());
				customerDB.setWishToSay(customer.getWishToSay());
				customerDB.setContactName(customer.getContactName());
				customerDB.setContactRelation(customer.getContactRelation());
			//	customerDB.setRefference(customer.getRefference());
				customerDB.setProfileFilled(true);
				
				customerService.edit(customerDB);
			}
			return new ResponseEntity<HttpStatus>( HttpStatus.OK);
			
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<HttpStatus>( HttpStatus.CONFLICT);
			
		}
		
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
