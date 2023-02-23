package com.FunXtreme.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.exception.TicketException;
import com.FunXtreme.model.Ticket;
import com.FunXtreme.services.TicketService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@PostMapping("/ticketBooking/{activity_id}")
	public ResponseEntity<Ticket> bookticket(@RequestBody Ticket tick, @PathVariable Integer activity_id)
			throws ActivityException, TicketException {

		Ticket ticket = ticketService.ticketBooking(tick, activity_id);

		return new ResponseEntity<>(ticket, HttpStatus.CREATED);
	}
	
	@PutMapping("/ticketBooking/updateTicket/{ticket_id}/{activity_id}")
	public ResponseEntity<Ticket> updateTicketHandler(@PathVariable Integer ticket_id,
			@PathVariable Integer activity_id) throws TicketException, ActivityException {

		Ticket ticket = ticketService.updateTicketBooking(ticket_id, activity_id);

		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}
	
	@DeleteMapping("/ticketBooking/deleteTicket/{ticket_id}")
	public ResponseEntity<Ticket> deleteTicketHandler(@PathVariable Integer ticket_id)
			throws TicketException {

		Ticket ticket = ticketService.deleteTicketBooking(ticket_id);

		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}

	@GetMapping("/getAllTickets")
	public ResponseEntity<List<Ticket>> getTicketsHandler()throws TicketException, CustomerException {

		List<Ticket> tickets = ticketService.viewAllTicketCustomer();

		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}
}
