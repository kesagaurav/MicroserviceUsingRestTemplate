package com.gaurav.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> generalException(Exception e){
		ErrorMessage er=new ErrorMessage();
		er.setError(HttpStatus.BAD_REQUEST.value());
		er.setMessage(e.getMessage());
		return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorMessage> employeeNotFoundException(EmployeeNotFoundException e){
		ErrorMessage er=new ErrorMessage();
		er.setError(HttpStatus.BAD_REQUEST.value());
		er.setMessage(e.getMessage());
		return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
	}
}
