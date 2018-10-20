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
/*@NamedQueries({
    @NamedQuery(
        name = "findCustomerAll",
        query = "from Customer cust where cust.gender = :gender && cust.profileFilled=true && cust.active=true"
        ),
    @NamedQuery(
        name = "findUsersByAccountId",
        query = "from User u where u.account.id = :id"
        ),
})*/
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

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "contactname")
	private String contactName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "email")
	private String eMail;

	@Column(name = "education")
	private String education;
	
	@Column(name = "religion")
	private String religion;

	@Column(name = "dobYear")
	private long dobYear;

	@Column(name = "wmReligion")
	private String wmReligion;
	
	@Column(name = "residenceDetails")
	private String residenceDetails;

	@Column(name = "worklocationDetails")
	private String worklocationDetails;

	@Column(name = "relocation")
	private boolean relocation;

	@Column(name = "contactRelation")
	private String contactRelation;

	@Column(name = "foodHabit")
	private String foodHabit;

	@Column(name = "wishtosay")
	private String wishToSay;
	
	@Column(name = "facebook")
	private String faceBook;
	
	@Column(name = "contactDetails")
	private String contactDetails;

	@Column
	private boolean admin;

	@Column
	private boolean enable;

	@Column
	private boolean active;
	
	@Column
	private boolean profileFilled;
	

	@Column
	private String token;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	// @NotNull

	private Date activeDate;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date deActiveDate;

	@Column
	private String password;

	

    private String residencalDetails;
    private String  residencalCity;
    private String  residencalCountry;
    private String  workPlaceDetails;
    private String  workPlaceCity;
    private String workPlaceCountry;
	public String getResidencalDetails() {
		return this.residenceDetails.split("\\:")[2];
	}

	public void setResidencalDetails(String residencalDetails) {
		this.residencalDetails = residencalDetails;
	}

	public String getResidencalCity() {
		return this.residenceDetails.split("\\:")[0];
	}

	public void setResidencalCity(String residencalCity) {
		this.residencalCity = residencalCity;
	}

	public String getResidencalCountry() {
		return this.residenceDetails.split("\\:")[1];
	}

	public void setResidencalCountry(String residencalCountry) {
		this.residencalCountry = residencalCountry;
	}

	public String getWorkPlaceDetails() {
		return this.worklocationDetails.split("\\:")[2];
	}

	public void setWorkPlaceDetails(String workPlaceDetails) {
		this.workPlaceDetails = workPlaceDetails;
	}

	public String getWorkPlaceCity() {
		return  this.worklocationDetails.split("\\:")[0];
	}

	public void setWorkPlaceCity(String workPlaceCity) {
		this.workPlaceCity = workPlaceCity;
	}

	public String getWorkPlaceCountry() {
		return  this.worklocationDetails.split("\\:")[1];
	}

	public void setWorkPlaceCountry(String workPlaceCountry) {
		this.workPlaceCountry = workPlaceCountry;
	}
	/*
	 * //@JsonBackReference
	 * 
	 * @JsonManagedReference
	 * 
	 * @OneToOne(cascade = CascadeType.ALL) private CustomerDetails customerDetail;
	 */
	/*
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "refferenceId")
	@JsonManagedReference
	private List<Refference> refference = new ArrayList<>();
*/
	protected Customer() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*
	 * public Customer(String firstName, String lastName) { this.firstName =
	 * firstName; this.lastName = lastName; }
	 */

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getWmReligion() {
		return wmReligion;
	}

	public void setWmReligion(String wmReligion) {
		this.wmReligion = wmReligion;
	}

	public String getResidenceDetails() {
		return this.residenceDetails = getResidencalCity()+"\\:"+getResidencalCountry()+"\\:"+getResidencalDetails();
	}

	public void setResidenceDetails(String residenceDetails) {
		this.residenceDetails = this.residencalCity+"\\:"+this.residencalCountry+"\\:"+this.residencalDetails;
	}

	public String getWorklocationDetails() {
		return worklocationDetails=getWorkPlaceCity()+"\\:"+getWorkPlaceCountry()+"\\:"+getWorkPlaceDetails();
	}

	public void setWorklocationDetails(String worklocationDetails) {
		this.worklocationDetails =this.workPlaceCity+"\\:"+this.workPlaceCountry+"\\:"+this.workPlaceDetails;
	}

	public boolean isRelocation() {
		return relocation;
	}

	public void setRelocation(boolean relocation) {
		this.relocation = relocation;
	}

	public String getContactRelation() {
		return contactRelation;
	}

	public void setContactRelation(String contactRelation) {
		this.contactRelation = contactRelation;
	}

	public String getFoodHabit() {
		return foodHabit;
	}

	public void setFoodHabit(String foodHabit) {
		this.foodHabit = foodHabit;
	}

	public String getWishToSay() {
		return wishToSay;
	}

	public void setWishToSay(String wishToSay) {
		this.wishToSay = wishToSay;
	}

	public String getFaceBook() {
		return faceBook;
	}

	public void setFaceBook(String faceBook) {
		this.faceBook = faceBook;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}


	public long getDobYear() {
		return dobYear;
	}

	public void setDobYear(long dobYear) {
		this.dobYear = dobYear;
	}

	public String getName() {
		return this.firstName+" "+this.lastName;
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

	public boolean isProfileFilled() {
		return profileFilled;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		System.out.println( "Religion  in Set :"+this.religion);
		this.religion = religion;
	}

	public void setProfileFilled(boolean profileFilled) {
		this.profileFilled = profileFilled;
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
	/*
	 * public CustomerDetails getCustomerDetail() { return customerDetail; }
	 */

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
/*
	public List<Refference> getRefference() {
		return refference;
	}

	public void setRefference(List<Refference> refference) {
		this.refference = refference;
	}
*/
	/*
	 * public void setCustomerDetail(CustomerDetails customerDetail) {
	 * this.customerDetail = customerDetail; }
	 */
	@Override
	public String toString() {
		return String.format("Customer[id=%d,name='%s',fistname='%s',lastname='%s', Enable='%s', active='%s']", id,getName(),firstName,lastName, enable, active);
	}
}