package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Account;
import com.example.demo.beans.Plan;
import com.example.demo.data.AccountRepository;
import com.example.demo.services.TeleService;

@CrossOrigin(origins = "https://telecom-remake.herokuapp.com/")
@RestController
@ResponseBody
@RequestMapping("/accounts")
//@CrossOrigin(origins = "*")      //@CrossOrigin(origins = {"http://localhost:4200", "https://prod-server.com"})
public class AccountController {
	
	@Autowired
	private TeleService service;
	
	
	/**
	 *     @RequestMapping(method = RequestMethod.POST, value = "/employee")  HandlerMapping: knows all of the potential "routes" for Dispatcher to refer
	 *     @ResponseBody // whatever is returned is written directly to the HTTP response body
	 *     by default: DispatcherServlet is going to expect a String to give to a ViewResolver to send the user to another HTML/JSP/page
	 * 
	 */
	@PostMapping(value = "/account")
	public Account save(@RequestBody Account account) { // get the employee JSON from the HTTP request body
		return service.saveAccount(account);
	}
	
	@GetMapping("/account")
	public List<Account> findAll() {
		return service.findAllAccounts();
	}
	
	@GetMapping("/account/{account_id}")
	public Account getAccountById(@PathVariable int account_id) {
		return service.findAccountById(account_id);
	}
	
	@PostMapping(value = "/login")
	public Account getOneAccount(@RequestBody Account account) { // get the employee JSON from the HTTP request body
		List<Account> accounts = service.findAllAccounts();
		for (Account a : accounts) {
			if (a.getLog_in_email().equals( account.getLog_in_email() ) && a.getLog_in_pass_word().equals(account.getLog_in_pass_word())) {
				return a;
			}
		}
		return null;
	}
	
	@DeleteMapping("/account/{account_id}")
	public void deleteAccount(@PathVariable int account_id) {
		service.deleteAccountById(account_id);
	}
	
	
}
