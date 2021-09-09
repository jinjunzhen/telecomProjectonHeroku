package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Account;
import com.example.demo.beans.Phone;
import com.example.demo.beans.Plan;
import com.example.demo.services.TeleService;


@CrossOrigin(origins = "https://telecom-remake.herokuapp.com")
@RestController
@RequestMapping("/phones")
//@CrossOrigin(origins = "*")      //@CrossOrigin(origins = {"http://localhost:4200", "https://prod-server.com"})
public class PhoneController {
	
	@Autowired
	private TeleService service;
	
	
	@PostMapping("/phone")
	public Phone save(@RequestBody Phone phone) { // get the employee JSON from the HTTP request body
		return service.savePhone(phone);
	}
	
	@GetMapping("/phone")
	public List<Phone> findAll() {
		return service.findAllPhones();
	}
	
	@GetMapping("/phone/{phone_id}")
	public Phone findPhoneById(@PathVariable int phone_id) {
		return service.findPhoneById(phone_id);
	}
	
	@GetMapping("/phone/generateNumber")
	public String generateNumber() {
		return service.generateNumber();
	}
	
	@PutMapping("{phone_id}/addPhone/{plan_id}")
	public Plan PhoneEnrollment(@PathVariable int phone_id, @PathVariable int plan_id) {
		Phone ph = service.findPhoneById(phone_id);
		Plan pl = service.findPlanById(plan_id);
		service.putPhoneToPlan(ph, pl);
		return service.findPlanById(plan_id);
	}
	
	@DeleteMapping("/phone/{phone_id}")
	public void deletePhoneById(@PathVariable int phone_id) {
		service.deletePhoneById(phone_id);
	}

}
