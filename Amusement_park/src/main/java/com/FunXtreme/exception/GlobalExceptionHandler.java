package com.FunXtreme.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> inputValidationHandler(MethodArgumentNotValidException ms, WebRequest req) {
		return new ResponseEntity<>(new ErrorDetails(LocalDateTime.now(), "Validation Error", ms.getBindingResult().getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<ErrorDetails> AdminExceptionHandler(AdminException ms, WebRequest req) {
		return new ResponseEntity<>(new ErrorDetails(LocalDateTime.now(), ms.getMessage(), req.getDescription(false)), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> CustomerExceptionHandler(CustomerException ms, WebRequest req) {
		return new ResponseEntity<>(new ErrorDetails(LocalDateTime.now(), ms.getMessage(), req.getDescription(false)), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TicketException.class)
	public ResponseEntity<ErrorDetails> TicketExceptionHandler(TicketException ms, WebRequest req) {
		return new ResponseEntity<>(new ErrorDetails(LocalDateTime.now(), ms.getMessage(), req.getDescription(false)), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ActivityException.class)
	public ResponseEntity<ErrorDetails> ActivityExceptionHandler(ActivityException ms, WebRequest req) {
		return new ResponseEntity<>(new ErrorDetails(LocalDateTime.now(), ms.getMessage(), req.getDescription(false)), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorDetails> LoginExceptionHandler(LoginException ms, WebRequest req) {
		return new ResponseEntity<>(new ErrorDetails(LocalDateTime.now(), ms.getMessage(), req.getDescription(false)), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> ExceptionHandler(Exception ms, WebRequest req) {
		return new ResponseEntity<>(new ErrorDetails(LocalDateTime.now(), ms.getMessage(), req.getDescription(false)), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> NoHandlerExceptionHandler(NoHandlerFoundException ms, WebRequest req) {
		return new ResponseEntity<>(new ErrorDetails(LocalDateTime.now(), ms.getMessage(), req.getDescription(false)), HttpStatus.BAD_REQUEST);
	}

}
