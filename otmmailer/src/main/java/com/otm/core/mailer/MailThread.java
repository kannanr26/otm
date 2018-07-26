package com.otm.core.mailer;

import org.springframework.beans.factory.annotation.Autowired;

import com.otm.core.model.Customer;
import com.otm.core.model.MailDetail;
import com.otm.core.model.VerificationToken;
import com.otm.core.services.CustomerService;
import com.otm.core.services.MailService;
import com.otm.core.services.MailerService;

public class MailThread implements Runnable {

	private MailDetail mailDetail;

	public MailThread(MailDetail mailDetail, MailerService mailerService, MailService mailService, CustomerService customerService) {
		this.mailDetail=mailDetail;
		this.mailerService=mailerService;
		this.mailService=mailService;
		this.customerService=customerService;
	}

//	@Autowired
	private CustomerService customerService;
	
	private MailService mailService;
	
	private MailerService mailerService;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean isSend=false;
		if(customerService==null) {
			System.out.println(" customerService is null");
			return;
		}
		if(mailDetail==null) {
			System.out.println(" mailDetail is null");
			return;
		}
		if(mailService==null) {
			System.out.println(" mailService is null");
			return;
		}
		System.out.println("this.mailDetail.getUserId() :"+this.mailDetail.getUserId());
		Customer customer=customerService.findByCustomerId(this.mailDetail.getUserId());
		 VerificationToken verifyToken=mailService.getToken(this.mailDetail.getUserId());
		 if(customer==null) {
				System.out.println(" customer is null");
				return;
			}
			if(verifyToken==null) {
				System.out.println(" verifyToken is null");return;
			}
		 try {
			mailerService.sendWelcomeMail(this.mailDetail, customer, verifyToken.getToken());
			 this.mailDetail.setSend(true);
			 isSend=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			isSend=false;
			e.printStackTrace();
		}
		if(isSend)
		 mailService.save(this.mailDetail);
	}

}
