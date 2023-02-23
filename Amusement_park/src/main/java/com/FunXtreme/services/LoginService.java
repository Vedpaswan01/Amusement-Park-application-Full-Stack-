package com.FunXtreme.services;

import com.FunXtreme.exception.LoginException;
import com.FunXtreme.model.LoginDTO;

public interface LoginService {
	public String customerLogIntoAccount(LoginDTO logdto) throws LoginException;
	public String customerLogOutOfAccount(String key) throws LoginException;
	
}
