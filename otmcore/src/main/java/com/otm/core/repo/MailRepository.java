package com.otm.core.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.otm.core.model.Customer;
import com.otm.core.model.MailDetail;


public interface MailRepository extends CrudRepository<MailDetail, Long> {
	//List<Customer> findByUserID(String userId);
	List<MailDetail> findBySend(boolean send);
}