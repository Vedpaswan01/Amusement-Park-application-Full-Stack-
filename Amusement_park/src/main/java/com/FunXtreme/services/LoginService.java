package com.FunXtreme.services;

import com.FunXtreme.exception.LoginException;
import com.FunXtreme.model.LoginDTO;

public interface LoginService {
	public String customerLogIntoAccount(LoginDTO logdto) throws LoginException;
	public String customerLogOutOfAccount(String key) throws LoginException;
	public String adminLogin(LoginDTO dto) throws LoginException;
	public String adminLogout(String key) throws LoginException;
}
