package com.otm.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	@NotNull
	private String userId;
	
	@Column
	private boolean admin;
	
	@Column
	private boolean enable;
	
	@Column
	private boolean active;
	
	@Column
	private String token;
	
	@Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
  //  @NotNull
  
    private Date activeDate;
	
	@Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
    private Date deActiveDate;

	
	@Column
	private String password;
	
	//@JsonBackReference
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDetails customerDetail;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "refferenceId")
	@JsonManagedReference
	private List<Refference> refference = new ArrayList<>();
	
	protected Customer() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	/*public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}*/

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = new Date(Calendar.getInstance().getTime().getTime());
	}

	public Date getDeActiveDate() {
		return deActiveDate;
	}

	public void setDeActiveDate(Date deActiveDate) {
		this.deActiveDate = deActiveDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerDetails getCustomerDetail() {
		return customerDetail;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Refference> getRefference() {
		return refference;
	}

	public void setRefference(List<Refference> refference) {
		this.refference = refference;
	}

	public void setCustomerDetail(CustomerDetails customerDetail) {
		this.customerDetail = customerDetail;
	}
	@Override
	public String toString() {
		return String.format("Customer[id=%d, Enable='%s', active='%s']", id, enable, active);
	}
}