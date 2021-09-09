package com.example.demo.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//JPA annotations
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity // this is an object to be managed by Hibernate
@Table(name = "TELECOM_PLAN_TABLE")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Plan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int plan_id;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "plan", cascade = CascadeType.ALL,  orphanRemoval = true)
	private Set<Phone> phones = new HashSet<>();

	@NotNull
	@Column
	private String plan_type;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonBackReference
	@JoinColumn(name = "acc_id", referencedColumnName = "account_id")
	private Account account;

	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public String getPlan_type() {
		return plan_type;
	}

	public void setPlan_type(String plan_type) {
		this.plan_type = plan_type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void assignPlan(Account a) {
		this.account = a;
	}

	public Set<Phone> getPhones() { // not single term
		return phones;
	}

}
