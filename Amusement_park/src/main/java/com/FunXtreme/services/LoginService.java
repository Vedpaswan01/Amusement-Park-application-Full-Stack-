package com.FunXtreme.services;

import com.FunXtreme.exception.LoginException;
import com.FunXtreme.model.CurrentAdminSession;
import com.FunXtreme.model.CurrentUserSession;
import com.FunXtreme.model.LoginDTO;

public interface LoginService {
	public CurrentUserSession customerLogIntoAccount(LoginDTO logdto) throws LoginException;
	public String customerLogOutOfAccount(String key) throws LoginException;
	public CurrentAdminSession adminLogin(LoginDTO dto) throws LoginException;
	public String adminLogout(String key) throws LoginException;
}
