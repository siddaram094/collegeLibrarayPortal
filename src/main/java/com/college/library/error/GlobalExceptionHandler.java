package com.college.library.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<Object> studentException(StudentException ex, WebRequest request) {
		ErrorDetails error = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object> (error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookException.class)
	public ResponseEntity<Object> BookException(BookException ex,WebRequest request){
		ErrorDetails error = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object> (error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookIssueException.class)
	public ResponseEntity<Object> bookIssueException(BookIssueException ex,WebRequest request){
		ErrorDetails error = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object> (error, HttpStatus.BAD_REQUEST);
	}
}
