package com.FunXtreme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FunXtreme.exception.TicketException;
import com.FunXtreme.model.Ticket;
import com.FunXtreme.repository.TicketRepository;


@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepo;
	
	@Override
	public Ticket ticketBooking(Ticket ticket) throws TicketException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket updateTicketBooking(Integer ticket_id) throws TicketException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket deleteTicketBooking(Integer ticketId) throws TicketException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> viewAllTicketCustomer() throws TicketException {
		// TODO Auto-generated method stub
		return null;
	}

}
