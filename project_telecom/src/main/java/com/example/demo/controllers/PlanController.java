package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Account;
import com.example.demo.beans.Plan;
import com.example.demo.data.AccountRepository;
import com.example.demo.data.PlanRepository;
import com.example.demo.services.TeleService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "https://telecom-remake.herokuapp.com")
@RestController
@RequestMapping("/plans")
//@CrossOrigin(origins = "*")
public class PlanController {
	
	@Autowired
	private TeleService service;
	
	
	@PostMapping(value = "/plan")
	public ResponseEntity<Plan> save(@RequestBody @Valid Plan plan, Account acct) {
		Plan body = service.savePlan(plan);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/plan")
	public List<Plan> getAllPlans() {
		return service.findAllPlans();
	}
	
	@GetMapping(value = "/plan/{plan_id}")
	public Plan getPlanById(@PathVariable int plan_id) {
		return service.findPlanById(plan_id);
	}
	
	@PutMapping(value = "{plan_id}/addPlan/{account_id}")
	public Account PlanEnrollment(@PathVariable int plan_id, @PathVariable int account_id) {
		Plan p = service.findPlanById(plan_id);
		Account a = service.findAccountById(account_id);
		service.putPlanToAccount(p, a);
		return service.findAccountById(account_id);
	}
	
//	@PutMapping("disconnect/{plan_id}")
//	public void PanDisconnect(@PathVariable int plan_id, )
	
	@DeleteMapping("/plan/{plan_id}")
	public void deletePlanById(@PathVariable int plan_id) {
		service.deletePlanById(plan_id);
	}
	
}
