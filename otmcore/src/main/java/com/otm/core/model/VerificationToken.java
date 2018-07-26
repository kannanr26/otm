package com.otm.core.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.otm.core.util.TokenProvider;
import com.otm.core.util.ValidationEnum;

@Entity
public class VerificationToken {
	
	private static final int EXPIRATION = 60 * 24;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String token;
/*	@OneToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id", foreignKey = @ForeignKey(name = "FK_VERIFY_USER"))
*/	
	@Column
	private Long customerId;
	@Column
	private Date expiryDate;

	/*@Column
	private boolean expiry;*/
	@Column
	private Date createdDate;
	@Column
	private String status;
	
	@Column
	private Date updatedDate;

	@Column
	private ValidationEnum validationEnum;
	
	public ValidationEnum getValidationEnum() {
		return validationEnum;
	}
	public void setValidationEnum(ValidationEnum validationEnum) {
		this.validationEnum = validationEnum;
	}
	public VerificationToken(){
		
	}
	public VerificationToken( Long customerId,String status,String token,ValidationEnum validationEnum ) {

		this.customerId = customerId;
		this.expiryDate = calculateExpiryDate(EXPIRATION);
		this.createdDate = new Date(Calendar.getInstance().getTime().getTime());
		this.status = status;
		this.token =token; 	
		this.validationEnum=validationEnum;
		
	}
	public Long getId() {

		return id;
 
	}

	public String getToken() {

		return token;

	}

	public void setToken(final String token) {

		this.token = token;

	}

	public Long getCustomerId() {

		return customerId;

	}

	public void setCustomer(Long customerId) {

		this.customerId = customerId;

	}

	public Date getExpiryDate() {

		return expiryDate;

	}

	public void setExpiryDate(final Date expiryDate) {

		this.expiryDate = expiryDate;

	}

	private Date calculateExpiryDate(final int expiryTimeInMinutes) {

		final Calendar cal = Calendar.getInstance();

		cal.setTimeInMillis(new Date().getTime());

		cal.add(Calendar.MINUTE, expiryTimeInMinutes);

		return new Date(cal.getTime().getTime());

	}


	public static int getExpiration() {
		return EXPIRATION;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*public boolean isExpiry() {
		return expiry;
	}
	public void setExpiry(boolean expiry) {
		this.expiry = expiry;
	}*/
	@Override

	public String toString() {

		final StringBuilder builder = new StringBuilder();

		builder.append("Token [String=").append(token).append("]").append("[Expires").append(expiryDate).append("]");

		return builder.toString();

	}
	public void setUpdatedDate(Date date) {
		// TODO Auto-generated method stub
		this.updatedDate=date;
	}

}