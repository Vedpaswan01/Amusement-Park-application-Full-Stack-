package com.FunXtreme.services;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FunXtreme.controller.CustomerController;
import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.exception.TicketException;
import com.FunXtreme.model.Activity;
import com.FunXtreme.model.Ticket;
import com.FunXtreme.repository.ActivityRepository;
import com.FunXtreme.repository.CustomerRepository;
import com.FunXtreme.repository.TicketRepository;


@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepo;
	
	@Autowired
	ActivityRepository activityRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public Ticket ticketBooking(Ticket ticket, Integer activity_id) throws ActivityException, TicketException {
		// TODO Auto-generated method stub
		
		Optional<Activity> optionalactivity = activityRepo.findById(activity_id);

		if (optionalactivity.isPresent()) {

			ticket.setActivity(optionalactivity.get());

			Ticket tic = ticketRepo.save(ticket);

			return tic;

		} else {

			throw new ActivityException("Please Enter Correct Activity ID : ");

		}
	}

	@Override
	public Ticket updateTicketBooking(Integer ticket_id, Integer activity_id)
			throws ActivityException, TicketException {
		// TODO Auto-generated method stub
		
		Optional<Ticket> optionalTicket = ticketRepo.findById(ticket_id);

		if (optionalTicket.isPresent()) {

			Ticket ticket = optionalTicket.get();
			
			Optional<Activity> optionalActivity = activityRepo.findById(activity_id);
			
			if (optionalActivity.isPresent()) {
				
				ticket.setActivity(optionalActivity.get());
	
				return ticketRepo.save(ticket);
	
			} else {
			
				throw new ActivityException("Please Enter Correct Activity Id :");
			}

		} else {
			throw new TicketException("Please Enter Correct Ticket id :");
		}
	}

	@Override
	public Ticket deleteTicketBooking(Integer ticketId) throws TicketException {
		// TODO Auto-generated method stub
		
		Optional<Ticket> optionalTicket = ticketRepo.findById(ticketId);

		if (optionalTicket.isPresent()) {

			ticketRepo.delete(optionalTicket.get());
			
			return optionalTicket.get();

		} else {

			throw new TicketException("Please Enter Correct ticket Id :");
		}
	}

	@Override
	public List<Ticket> viewAllTicketCustomer() throws TicketException, CustomerException {
		// TODO Auto-generated method stub
	
		List<Ticket> tickets = ticketRepo.getAllTicketsByCustomerId(null);

		if (tickets.isEmpty()) {
			throw new TicketException("Tickets is Empty");
		} else {
			return tickets;
		}
	}
}
