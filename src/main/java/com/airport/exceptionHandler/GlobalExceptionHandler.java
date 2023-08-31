package com.airport.exceptionHandler;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class )
	public ResponseEntity<String> handleMethodArgumentTypeMismatchException() {
		
		return new ResponseEntity<String>("Method Argument Type Mismatch Exception",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementEx() {
		
		return new ResponseEntity<String>("No Value Found",HttpStatus.NOT_FOUND);
	}
	
}
