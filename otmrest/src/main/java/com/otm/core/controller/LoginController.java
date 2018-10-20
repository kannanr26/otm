package com.otm.core.controller;

import org.hibernate.cfg.CreateKeySecondPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.otm.core.model.Customer;
import com.otm.core.model.response.Credential;
import com.otm.core.model.response.Login;
import com.otm.core.services.CustomerService;
import com.otm.core.util.ConvertToCredential;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
public class LoginController {

	@Autowired
	CustomerService customerService;
	@PostMapping(value="/login")
	public ResponseEntity<Credential> register(@RequestBody Login login) {
		Credential credential=new Credential();
		Customer loginCustomer=customerService.findByCustomerUserId(login.getUserId());
		System.out.println(" User login :"+login.getUserId()+"  ::: "+login.getPassword());
		if(loginCustomer.getPassword().equals(login.getPassword())) {
			 credential=(ConvertToCredential.convert(loginCustomer));
			 credential.setPassword("");
			 credential.setName(loginCustomer.getName());
			return new ResponseEntity<Credential> (credential,HttpStatus.OK);
		}
		return new ResponseEntity<Credential>(credential,HttpStatus.NOT_ACCEPTABLE);
		
		
	}


}
