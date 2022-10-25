package com.premsh.jpaexperiment.controllers;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advisor {
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> notFound(EntityNotFoundException ex){
		return(new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND));
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> validationFailed(EntityNotFoundException ex){
		return(new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> commonException(Exception ex){
		return(new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
	}
}
