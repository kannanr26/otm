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

	public MailThread(MailDetail mailDetail) {
		this.mailDetail=mailDetail;
	}

	@Autowired
	CustomerService customerService;
	@Autowired
	MailService mailService;
	@Autowired
	MailerService mailerService;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean isSend=false;
		Customer customer=customerService.findByCustomerId(this.mailDetail.getUserId());
		 VerificationToken verifyToken=mailService.getToken(this.mailDetail.getUserId());
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
