package com.otm.core.controller;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.otm.core.services.CustomerService;
import com.otm.core.services.MailService;
import com.otm.core.util.Constant;
import com.otm.core.model.Customer;
import com.otm.core.model.response.Status;

@RestController
// @RequestMapping(value="OTM")
public class ValidationController {

	//private final Logger logger = LoggerFactory.getLogger(ValidationController.class);

	@Autowired
	MailService mailService;

	@Autowired
	CustomerService customerService;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/emailVerification/{token}/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable String token,@PathVariable String id, Model model) {

			System.out.println(" Inside : Mail verification" + token);
			Status status = mailService.verify(token,Long.parseLong(id));
			System.out.println("status :"+status.getStatus()+" ,Customer :"+status.getUser()+"Customer :"+status.geteMail());
			model.addAttribute("Status", status);
			if (status.getStatus().equals(Constant.tokenError) || status.getStatus().equals(Constant.invalid) ) {
				model.addAttribute("msg","invalid Token");
				
			}else if (status.getStatus().equals(Constant.expired)  ) {
				model.addAttribute("msg"," Registation token expired");
				
			}
			
			model.addAttribute("msg"," Registation token verified");
			return "/verified";

		}
		 
	@GetMapping(value = "/resetVerification/{token}/{id}")
	public String resetVerify(@PathVariable String token,@PathVariable String id,Model model) {
		System.out.println(" Inside : Mail verification" + token);
		Customer customer =customerService.findByCustomerId(Long.parseLong(id));
		Status status = mailService.verifyPassword(token,customer);
		if (status.getStatus().equals(Constant.tokenError) || status.getStatus().equals(Constant.invalid) ) {
			model.addAttribute("msg","invalid Token");
			return "/verified";
		}else if (status.getStatus().equals(Constant.expired)  ) {
			model.addAttribute("msg"," Reset password  token expired");
			return "/verified";
		}
		
		model.addAttribute("msg"," Reset password token verified");
		
		return "redirect:http://localhost:8080\\otmweb\\resetpassword\\"+id+"\\"+customer.getUserId();
	}
	
	
}
