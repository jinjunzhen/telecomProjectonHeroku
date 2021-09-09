package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Account;
import com.example.demo.beans.Phone;
import com.example.demo.beans.Plan;
import com.example.demo.data.AccountRepository;
import com.example.demo.data.PhoneRepository;
import com.example.demo.data.PlanRepository;



@Service
public class TeleService {
	
	@Autowired
	private PlanRepository planRepo;
	
	@Autowired
	private AccountRepository acctRepo;
	
	@Autowired
	private PhoneRepository phoneRepo;
	

	
	
	
	//--------------------------------------------------------------------->   Account part 
	public Account saveAccount(Account account) {
		return acctRepo.save(account);
	}
	
	public List<Account> findAllAccounts() {

		return acctRepo.findAll();
	}
	
	public void updateAccount(Account account, Integer id) {
		if ((account.getAccount_id() == id) && acctRepo.findById(account.getAccount_id()).isPresent()) {
			acctRepo.save(account);
		}else {
			throw new ValidationException(); // custom validator??
		}
	}
	
	public Account findAccountById(Integer id) {
		Optional<Account> optional = acctRepo.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}
	
	
	public void deleteAccountById(Integer account_id) {
		acctRepo.deleteById(account_id);
	}
	
	//--------------------------------------------------------------------->   Plan part 
	
	public Plan savePlan(Plan plan) {
		return planRepo.save(plan);
	}
	
	
	public List<Plan> findAllPlans() {

		return planRepo.findAll();
	}
	
	public void updatePlan(Plan plan, Integer id) {
		if ((plan.getPlan_id() == id) && planRepo.findById(plan.getPlan_id()).isPresent()) {
			planRepo.save(plan);
		}else {
			throw new ValidationException(); // custom validator??
		}
	}
	
	public Plan findPlanById(Integer id) {
		Optional<Plan> optional = planRepo.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	public Plan putPlanToAccount(Plan p, Account a) {
		p.setAccount(a);
		return planRepo.save(p);
	}
	
	public void deletePlanById(Integer plan_id) {
		planRepo.deleteById(plan_id);
	}
	
	//--------------------------------------------------------------------->   Phone part 
	
	public Phone savePhone(Phone phone) {
		return phoneRepo.save(phone);
	}
	
	
	public List<Phone> findAllPhones() {

		return phoneRepo.findAll();
	}
	
	public void updatePhone(Phone phone, Integer id) {
		if ((phone.getPhone_id() == id) && phoneRepo.findById(phone.getPhone_id()).isPresent()) {
			phoneRepo.save(phone);
		}else {
			throw new ValidationException(); // custom validator??
		}
	}
	
	public Phone findPhoneById(Integer id) {
		Optional<Phone> optional = phoneRepo.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}
	
	public Phone putPhoneToPlan(Phone ph, Plan pl ){
		ph.setPlan(pl);
		return phoneRepo.save(ph);
	}
	
	public void deletePhoneById(int phone_id) {
		Optional<Phone> optional = Optional.empty();
		phoneRepo.deleteById(phone_id);
	}
	
	public boolean isNumberInUse(String phoneNumber) {
		return phoneRepo.findByPhoneNumber(phoneNumber).isPresent();
	}
	

	public String generateNumber() {
		Random r=new Random();
		String phone_number ="";
		do {
			phone_number += r.nextInt(9)+1;
			for(int i=0;i<9;i++) {
				phone_number +=r.nextInt(10);
			}
			System.out.println(phone_number);
			
		}while(isNumberInUse(phone_number));
		return phone_number;
	}


}
