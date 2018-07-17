package com.otm.core.services;


import java.util.List;

import com.otm.core.model.Customer;
import com.otm.core.model.MailDetail;
import com.otm.core.model.Status;
import com.otm.core.model.VerificationToken;

public interface MailService {
public void  sendMail(Customer customer);

public  Status verify(String token) ;
public List<MailDetail> getUnSendMail();
public VerificationToken getToken(Long CustomerId);

public void save(MailDetail mailDetail);
}
