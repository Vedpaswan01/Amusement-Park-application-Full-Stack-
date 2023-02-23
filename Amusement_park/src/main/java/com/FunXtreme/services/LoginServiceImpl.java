package com.FunXtreme.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.FunXtreme.exception.LoginException;
import com.FunXtreme.model.CurrentUserSession;
import com.FunXtreme.model.Customer;
import com.FunXtreme.model.LoginDTO;
import com.FunXtreme.repository.CustomerRepository;
import com.FunXtreme.repository.SessionDAO;

import net.bytebuddy.utility.RandomString;

public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private SessionDAO sessionDAO;

	@Override
	public String customerLogIntoAccount(LoginDTO logdto) throws LoginException {
		Customer existingCustomer = customerRepo.findByEmail(logdto.getEmail());
		if(existingCustomer == null)
			throw new LoginException("Invalid email");
			
		Optional<CurrentUserSession> validCustomerSessionOpt =  sessionDAO.findById(existingCustomer.getCustomerID());
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingCustomer.getAbstractUser().getPassword().equals(logdto.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerID(),key,LocalDateTime.now());
			
			sessionDAO.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");

	}

	@Override
	public String customerLogOutOfAccount(String key) throws LoginException {
		CurrentUserSession validCustomerSession = sessionDAO.findByUuid(key);

		if (validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");

		}

		sessionDAO.delete(validCustomerSession);
				
		return "Logged Out !";
	}

}
