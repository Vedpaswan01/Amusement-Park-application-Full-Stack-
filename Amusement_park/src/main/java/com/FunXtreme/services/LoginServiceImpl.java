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
	private AdminRepository adminDao;

	@Autowired
	private CustomerRepository cDao;
	
	@Autowired
	private AdminSessionDAO aSessionDao;
	
	@Autowired
	private SessionDAO sDao;
	
	public static Admin admin;
	
	public static Customer customer;
	
	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		Customer existingCustomer = cDao.findByEmail(dto.getEmail());

		if (existingCustomer == null) {
			throw new LoginException("Please Enter a valid email or password");
		}

		Optional<CurrentUserSession> validCustomerSessionOpt = sDao.findById(existingCustomer.getCustomerID());

		if (validCustomerSessionOpt.isPresent()) {
			throw new LoginException("User already Logged In with this number");
		}

		if (existingCustomer.getPassword().equals(dto.getPassword())) {
			String key = RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerID(), key,
					LocalDateTime.now());
			sDao.save(currentUserSession);
			
			customer = existingCustomer;
			
			return currentUserSession.toString();

		} else
			throw new LoginException("Please Enter a valid password");
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {

		CurrentUserSession validCustomerSession = sDao.findByUuid(key);

		if (validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");

		}

		sDao.delete(validCustomerSession);
		
		customer = null;
		
		return "Logged Out !";

	}

	@Override
	public String adminLogIntoAccount(LoginDTO dto) throws LoginException {
		
		Admin existingAdmin = adminDao.findByEmail(dto.getEmail());

		if (existingAdmin == null) {
			throw new LoginException("Please Enter a valid email or password");
		}

		Optional<CurrentAdminSession> validAdminSessionOpt = aSessionDao.findById(existingAdmin.getAdminID());

		if (validAdminSessionOpt.isPresent()) {
			throw new LoginException("User already Logged In with this number");
		}

		if (existingAdmin.getPassword().equals(dto.getPassword())) {
			String key = RandomString.make(6);
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminID(), key,
					LocalDateTime.now());
			aSessionDao.save(currentAdminSession);
			
			admin = existingAdmin;
			
			return currentAdminSession.toString();

		} else
			throw new LoginException("Please Enter a valid password");

	}

	@Override
	public String adminLogOutFromAccount(String key) throws LoginException {
		
		CurrentAdminSession validAdminSession = aSessionDao.findByUuid(key);

		if (validAdminSession == null) {
			
			throw new LoginException("User Not Logged In with this email");

		}

		aSessionDao.delete(validAdminSession);
		
		admin = null;
		
		return "Logged Out !";
	}

}
