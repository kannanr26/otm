package com.otm.core.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.otm.core.model.Customer;
import com.otm.core.model.VerificationToken;


public interface MailVerificationRepository extends CrudRepository<VerificationToken, Long> {
	VerificationToken findByToken(String token);

	 @Query("SELECT token FROM VerificationToken token where token.customerId = ?1") 
	VerificationToken findByCustomerId(Long customerId);
	
	// List<VerificationToken> findBySend(boolean send);
 
}