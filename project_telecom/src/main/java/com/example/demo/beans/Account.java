package com.example.demo.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//JPA annotations
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Hibernate annotations (JPA)
 * ORM framework - object relational mapping
 * 
 * JPA - standard for ORM frameworks
 * Hibernate implements that standard
 * 
 */
@Entity // this is an object to be managed by Hibernate
@Table(name = "TELECOM_ACCOUNT_TABLE")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Account{
	
	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int account_id;
	
	@JsonIgnore
	@JsonManagedReference
    @OneToMany(mappedBy = "account", cascade = CascadeType.MERGE)
    private Set<Plan> plans = new HashSet<>();
	
	@NotNull
	@Column
	private String log_in_email;
	
	@NotNull
	@Column
	private String log_in_pass_word;
	
	
	public Account() {
		super();
	}

	public String getLog_in_email() {
		return log_in_email;
	}

	public void setLog_in_email(String log_in_email) {
		this.log_in_email = log_in_email;
	}

	public String getLog_in_pass_word() {
		return log_in_pass_word;
	}

	public void setLog_in_pass_word(String log_in_pass_word) {
		this.log_in_pass_word = log_in_pass_word;
	}


	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}


	public int getAccount_id() {
		return account_id;
	}

	public Set<Plan> getPlans() {   //not single term
		return plans;
	}

	public void setPlans(Set<Plan> plans) {
		this.plans = plans;
	}
	
}
