package com.otm.core.services;

import java.util.List;

import com.otm.core.model.Customer;
import com.otm.core.model.MailDetail;


public interface MailerService {

 //public void sendWelcomeMail(MailDetail mailDetail, Customer customer, String token)throws Exception ;
 public List<MailDetail>  getUnSendMail();
 public void sendWelcomeMail(MailDetail mailDetail, Customer customer, String token) throws Exception ;

 
}
