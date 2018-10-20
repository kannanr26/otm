package com.otm.core.services;


import java.util.List;

import com.otm.core.model.Customer;
import com.otm.core.model.MailDetail;
import com.otm.core.model.response.Status;
import com.otm.core.model.VerificationToken;

public interface MailService {
public void  sendWelcomeMail(Customer customer);

public  Status verify(String token,Long customerId) ;
public  Status verifyPassword(String token,Customer customerId) ;
public List<MailDetail> getUnSendMail();
public VerificationToken getToken(Long CustomerId);

public void save(MailDetail mailDetail);
}
