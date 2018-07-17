package com.otm.core.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name = "refference")
public class Refference implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//	private static final long serialVersionUID = -3009157732242241606L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long refferenceId;

		@Column
		private String name;
		
		@Column
		private String relation;
		
		
		 	@ManyToOne(fetch = FetchType.LAZY)
		    @JoinColumn(name = "customerId")
			@JsonBackReference
		    private Customer customer;


			public long getRefferenceId() {
				return refferenceId;
			}


			public void setRefferenceId(long refferenceId) {
				this.refferenceId = refferenceId;
			}


			public String getName() {
				return name;
			}


			public void setName(String name) {
				this.name = name;
			}


			public String getRelation() {
				return relation;
			}


			public void setRelation(String relation) {
				this.relation = relation;
			}


			public Customer getCustomer() {
				return customer;
			}


			public void setCustomer(Customer customer) {
				this.customer = customer;
			}


			public static long getSerialversionuid() {
				return serialVersionUID;
			}
}
