package com.otm.core.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otm.core.model.Customer;
import com.otm.core.model.SearchCustomer;
import com.otm.core.repo.CustomerRepository;
import com.otm.core.repo.CutomerRepo;
import com.otm.core.session.HibernateSession;
import com.otm.core.util.TokenProvider;
import com.otm.core.util.ValidationEnum;


@Service
public class CustomerImpl implements CustomerService {

	@Autowired
	CustomerRepository repository;
	@Autowired
	MailService mailService;
	@Autowired
	CutomerRepo searchRepository;


@Override
public List<Customer> getAllCustomer(Customer customer) {
	
	List<Customer> list = new ArrayList<>();

	Iterable<Customer> customers;
	if(customer.isAdmin())
	{ 
		customers=repository.findAll();// repository.findAll();
	}else 
	{
	/*	Session session=HibernateSession.getNewSession();
	*/
		
		SearchCustomer sc= new SearchCustomer("active", ":", true);
		SearchCustomer sc1= new SearchCustomer("profileFilled", ":", true);
		SearchCustomer sc3= new SearchCustomer("admin", ":", false);
		SearchCustomer sc2;
		if(customer.getGender().equalsIgnoreCase("Male"))
			sc2= new SearchCustomer("gender", ":", "Female");
		else
			sc2= new SearchCustomer("gender", ":", "Male");
			
		List<SearchCustomer> lsc = new ArrayList<SearchCustomer>();
		lsc.add(sc1);
		lsc.add(sc);
		lsc.add(sc2);
		lsc.add(sc3);
		customers=searchRepository.getAllCustomer(lsc);
		
	}
	

	customers.forEach(list::add);
	return list;
}


@Override
public Customer save(Customer customer) {
	customer.setActive(false);
	customer.setAdmin(false);
	customer.setProfileFilled(false);
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.MONTH, 6);
	customer.setDeActiveDate(cal.getTime());
	repository.save(customer);
	
	mailService.sendWelcomeMail(customer);
	return customer;
	
}

@Override
public void edit(Customer customer) {
	
	repository.save(customer);
	return;
}

@Override
public boolean updatePassword(String password,Long id) {
	// 
	try{
	Customer customer=repository.findById(id);
	customer.setPassword(password);
	repository.save(customer);
	return true;
	}catch(Exception e) {
		return false;
	}
}


@Override
public boolean delete(long id) {
	// TODO Auto-generated method stub
	try{
		repository.delete(id);
		return true;
	}catch(Exception e) {
		return false;
	}
	
}
@Override
public Customer findByCustomerUserId(String userId) {
		return repository.findByUserId(userId);
}

@Override
public Customer findByCustomerId(Long id) {
	
	return repository.findById(id);
}
}
