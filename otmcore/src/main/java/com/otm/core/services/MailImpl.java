package com.otm.core.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otm.core.model.Customer;
import com.otm.core.model.MailDetail;
import com.otm.core.model.VerificationToken;
import com.otm.core.model.response.Status;
import com.otm.core.repo.MailRepository;
import com.otm.core.repo.MailVerificationRepository;
import com.otm.core.util.Constant;
import com.otm.core.util.TokenProvider;
import com.otm.core.util.ValidationEnum;

@Service
public class MailImpl implements MailService {

	@Autowired
	MailRepository repository;
	@Autowired
	MailVerificationRepository verifyMailRepository;
	@Autowired
	CustomerService customerService;

	@Autowired
	Constant constant;

	@Override

	public void sendWelcomeMail(Customer customer) {

		try {
			String token = TokenProvider.getToken(customer.getEMail(),customer.getLastName(),ValidationEnum.WELCOMEMAILVALIDATION);
			customer.setToken(token);
			
			VerificationToken verifyToken = new VerificationToken(customer.getId(), Constant.pending, customer.getToken(),ValidationEnum.WELCOMEMAILVALIDATION);

			verifyMailRepository.save(verifyToken);

			MailDetail mailDetail = genrateMailDetail(customer);
			repository.save(mailDetail);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private MailDetail genrateMailDetail(Customer customer) {

		MailDetail mailDetail = new MailDetail();
		 mailDetail.setUserId(customer.getId());
		mailDetail.setUserName(customer.getContactName());
				//customer.getFirstName() + " " + customer.getLastName());
		mailDetail.setTo(customer.getEMail());
		mailDetail.setSend(false);
		mailDetail.setSubject(constant.welcomeSUB);
		return mailDetail;
	}

	@Override
	public Status verify(String token,Long customerId) {
		Status status = new Status();
		VerificationToken verificationToken = verifyMailRepository.findByToken(token);
		if (verificationToken != null) {

			System.out.println(" CUST_ ID" + verificationToken.getCustomerId());
			if( customerId!=verificationToken.getCustomerId()) {
				 status.setStatus(Constant.invalid);
				 return status;
			}
			if( ValidationEnum.WELCOMEMAILVALIDATION!=verificationToken.getValidationEnum()) {			 
				 return status;
			}
			Customer customer = customerService.findByCustomerId(verificationToken.getCustomerId());
			System.out.println(" :::::: " + customer.getFirstName());
			status.setUser(customer.getFirstName() + customer.getLastName());
			status.seteMail(customer.getEMail());

			if (verificationToken.getExpiryDate().after(new Date(Calendar.getInstance().getTime().getTime()))) {

				verificationToken.setStatus(Constant.verified);
				verificationToken.setUpdatedDate(new Date(Calendar.getInstance().getTime().getTime()));
				verifyMailRepository.save(verificationToken);
				customer.setActive(true);
				status.setStatus(Constant.registrationVerified);
				return status;

			} else if (verificationToken.getExpiryDate().before(new Date(Calendar.getInstance().getTime().getTime()))) {
				verificationToken.setStatus(Constant.expired);
				verificationToken.setUpdatedDate(new Date(Calendar.getInstance().getTime().getTime()));
				status.setStatus(Constant.expired);
				return status;

			}
		}
		status.setStatus(Constant.tokenError);
		return status;

	}


	@Override
	public Status verifyPassword(String token,Customer customer) {
		Status status = new Status();
		VerificationToken verificationToken = verifyMailRepository.findByToken(token);
		if (verificationToken != null) {

			System.out.println(" CUST_ ID" + verificationToken.getCustomerId());
			if( customer.getId()!=verificationToken.getCustomerId()) {
				 status.setStatus(Constant.invalid);
				 return status;
			}
			if( ValidationEnum.RESETPASSWORDVALIDATION!=verificationToken.getValidationEnum()) {
				 
				 return status;
			}
			
		//	Customer customer = customerService.findByCustomerId(verificationToken.getCustomerId());
			System.out.println(" :::::: " + customer.getFirstName());
			status.setUser(customer.getFirstName() + customer.getLastName());

			if (verificationToken.getExpiryDate().after(new Date(Calendar.getInstance().getTime().getTime()))) {

				verificationToken.setStatus(Constant.verified);
				verificationToken.setUpdatedDate(new Date(Calendar.getInstance().getTime().getTime()));
				verifyMailRepository.save(verificationToken);
				customer.setActive(true);
				status.setStatus(Constant.resetPasswordVerified);
				return status;

			} else if (verificationToken.getExpiryDate().before(new Date(Calendar.getInstance().getTime().getTime()))) {
				verificationToken.setStatus(Constant.expired);
				verificationToken.setUpdatedDate(new Date(Calendar.getInstance().getTime().getTime()));
				status.setStatus(Constant.expired);
				return status;

			}
			}
		status.setStatus(Constant.tokenError);
		return status;

	}

	@Override
	public List<MailDetail> getUnSendMail() {

		return repository.findBySend(false);
	}

	@Override
	public VerificationToken getToken(Long CustomerId) {
		// TODO Auto-generated method stub
		return verifyMailRepository.findByCustomerId(CustomerId);
	}

	@Override
	public void save(MailDetail mailDetail) {
		repository.save(mailDetail);

	}

}
