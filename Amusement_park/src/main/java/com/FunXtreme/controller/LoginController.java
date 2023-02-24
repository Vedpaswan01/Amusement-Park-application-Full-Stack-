package com.FunXtreme.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FunXtreme.exception.LoginException;
import com.FunXtreme.model.LoginDTO;
import com.FunXtreme.services.CustomerService;
import com.FunXtreme.services.LoginService;


@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private CustomerService cService;

	@Autowired
	private LoginService userLogin;

	@PostMapping("/customerlogin")
	public ResponseEntity<String> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {

		String result = userLogin.logIntoAccount(dto);
		if (result != null) {
		  CustomerController.isLoggedin = true;
		}

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

	@PatchMapping("/customerlogout")
	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		String result = userLogin.logOutFromAccount(key);
		if (result != null) {
			CustomerController.isLoggedin = true;
		}
		return result;

	}
	
	@PostMapping("/adminLogin")
	public ResponseEntity<String> logInAdmin(@RequestBody LoginDTO dto) throws LoginException {

		String result = userLogin.adminLogIntoAccount(dto);
		if (result != null) {
			AdminController.isLoggedin = true;
		}

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

	@PatchMapping("/adminLogout")
	public String logoutAdmin(@RequestParam(required = false) String key) throws LoginException {
		
		String result = userLogin.adminLogOutFromAccount(key);
		
		if (result != null) {
			AdminController.isLoggedin = true;
		}
		
		return result;

	}

}
