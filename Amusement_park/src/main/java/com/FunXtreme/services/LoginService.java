package com.FunXtreme.services;



import com.FunXtreme.exception.LoginException;
import com.FunXtreme.model.LoginDTO;

public interface LoginService {

	public String logIntoAccount(LoginDTO dto) throws LoginException;

	public String logOutFromAccount(String key) throws LoginException;

	public String adminLogIntoAccount(LoginDTO  dto) throws LoginException;

	public String adminLogOutFromAccount(String key) throws LoginException;

}
