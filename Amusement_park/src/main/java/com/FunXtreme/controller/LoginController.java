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
import com.FunXtreme.model.CurrentAdminSession;
import com.FunXtreme.model.CurrentUserSession;
import com.FunXtreme.model.LoginDTO;
import com.FunXtreme.services.LoginService;


@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/customerLogin")
	public ResponseEntity<CurrentUserSession> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {

		CurrentUserSession result = loginService.customerLogIntoAccount(dto);
		if (result != null) {
			CustomerController.isLoggedin = true;
		}

		return new ResponseEntity<CurrentUserSession>(result, HttpStatus.OK);

	}

	@PatchMapping("/customerLogout")
	public CurrentUserSession logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		CurrentUserSession result = loginService.customerLogOutOfAccount(key);
		if (result != null) {
			CustomerController.isLoggedin = false;
		}
		return result;

	}
	
	@PostMapping("/adminLogin")
	public ResponseEntity<CurrentAdminSession> logInAdmin(@RequestBody LoginDTO dto) throws LoginException {

		CurrentAdminSession result = loginService.adminLogin(dto);
		if (result != null) {
			
			AdminController.isLoggedin = true;
		}

		return new ResponseEntity<CurrentAdminSession>(result, HttpStatus.OK);

	}

	@PatchMapping("/adminLogout")
	public CurrentAdminSession logoutAdmin(@RequestParam(required = false) String key) throws LoginException {
		
		CurrentAdminSession result = loginService.adminLogout(key);
		
		if (result != null) {
			AdminController.isLoggedin = false;
		}
		
		return result;

	}

}
