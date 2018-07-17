package com.otm.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "customerDetails")
public class CustomerDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "email")
	private String eMail;

	/*@Column(name = "street")
	private String street;

	@Column(name = "postalCode")
	private Integer postalCode;*/

	@OneToOne
	@PrimaryKeyJoinColumn
	
	//@JsonManagedReference
	@JsonBackReference
	private Customer customer;


	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public String getEMail() {
		return eMail;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "PersonDetail{" + "id=" + id + ", "
				//+ "street='" + street + '\'' + ", postalCode=" + postalCode 
				+ '}';
	}
}
