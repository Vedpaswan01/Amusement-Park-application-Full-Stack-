package com.FunXtreme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FunXtreme.exception.LoginException;
import com.FunXtreme.model.LoginDTO;
import com.FunXtreme.services.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/customerLogin")
	public ResponseEntity<String> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {

		String result = loginService.customerLogIntoAccount(dto);
		if (result != null) {
			CustomerController.isLoggedin = true;
		}

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

	@PatchMapping("/customerLogout")
	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		String result = loginService.customerLogOutOfAccount(key);
		if (result != null) {
			CustomerController.isLoggedin = false;
		}
		return result;

	}
	
	@PostMapping("/adminLogin")
	public ResponseEntity<String> logInAdmin(@RequestBody LoginDTO dto) throws LoginException {

		String result = loginService.adminLogin(dto);
		if (result != null) {
			AdminController.isLoggedin = true;
		}

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

	@PatchMapping("/adminLogout")
	public String logoutAdmin(@RequestParam(required = false) String key) throws LoginException {
		
		String result = loginService.adminLogout(key);
		
		if (result != null) {
			AdminController.isLoggedin = false;
		}
		
		return result;

	}

}
