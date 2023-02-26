package com.FunXtreme.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FunXtreme.exception.LoginException;
import com.FunXtreme.model.Admin;
import com.FunXtreme.model.CurrentAdminSession;
import com.FunXtreme.model.CurrentUserSession;
import com.FunXtreme.model.Customer;
import com.FunXtreme.model.LoginDTO;
import com.FunXtreme.repository.AdminRepository;
import com.FunXtreme.repository.AdminSessionDAO;
import com.FunXtreme.repository.CustomerRepository;
import com.FunXtreme.repository.SessionDAO;

import net.bytebuddy.utility.RandomString;
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private SessionDAO sessionDAO;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired 
	private AdminSessionDAO adminSessionDAO;
	
	public static Admin admin;
	
	public static Customer customer;

	@Override
	public CurrentUserSession customerLogIntoAccount(LoginDTO logdto) throws LoginException {
		Customer existingCustomer = customerRepo.findByEmail(logdto.getEmail());
		if(existingCustomer == null)
			throw new LoginException("Invalid email");
			
		Optional<CurrentUserSession> validCustomerSessionOpt =  sessionDAO.findById(existingCustomer.getCustomerID());
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingCustomer.getPassword().equals(logdto.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerID(),key,LocalDateTime.now());
			
			sessionDAO.save(currentUserSession);
			
			customer = existingCustomer;

			return currentUserSession;
		}
		else
			throw new LoginException("Please Enter a valid password");

	}

	@Override
	public CurrentUserSession customerLogOutOfAccount(String key) throws LoginException {
		CurrentUserSession validCustomerSession = sessionDAO.findByUuid(key);

		if (validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");

		}

		sessionDAO.delete(validCustomerSession);
		
		customer = null;
				
		return validCustomerSession;
	}

	@Override
	public CurrentAdminSession adminLogin(LoginDTO dto) throws LoginException {
		Admin existingAdmin = adminRepo.findByEmail(dto.getEmail());

		if (existingAdmin == null) {
			throw new LoginException("Please Enter a valid email.");
		}

		Optional<CurrentAdminSession> validAdminSessionOpt = adminSessionDAO.findById(existingAdmin.getAdminID());

		if (validAdminSessionOpt.isPresent()) {
			throw new LoginException("User already Logged In with this email");
		}

		if (existingAdmin.getPassword().equals(dto.getPassword())) {
			String key = RandomString.make(6);
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminID(), key,
					LocalDateTime.now());
			adminSessionDAO.save(currentAdminSession);
			
			admin = existingAdmin;
			
			return currentAdminSession;

		} else
			throw new LoginException("Please Enter a valid password");
	}

	@Override
	public CurrentAdminSession adminLogout(String key) throws LoginException {
		CurrentAdminSession validAdminSession = adminSessionDAO.findByUuid(key);

		if (validAdminSession == null) {
			
			throw new LoginException("User Not Logged In with this email");

		}

		adminSessionDAO.delete(validAdminSession);
		
		admin = null;
		
		return validAdminSession;
	}

}
