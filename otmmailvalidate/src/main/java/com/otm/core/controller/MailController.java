package com.otm.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.otm.core.services.MailService;
import com.otm.core.model.Status;

@RestController
// @RequestMapping(value="OTM")
public class MailController {

	@Autowired
	MailService mailService;

	@CrossOrigin(origins = "*")
	@GetMapping(value = "/emailVerification/{token}")
	public ResponseEntity<Status> verify(@PathVariable String token) {
		System.out.println(" Inside : Mail verification" + token);
		Status status = mailService.verify(token);
		return new ResponseEntity<Status>(status, HttpStatus.OK);

	}
}
