package com.test.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;
@ControllerAdvice
public class Responseexceptionhandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Defineerror> handleAllException(Exception ex, WebRequest request) throws Exception
	{
		Defineerror er=new Defineerror(request.getDescription(false),ex.getMessage(),LocalDateTime.now());
		return new ResponseEntity<Defineerror>(er,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Defineerror> handleAllUserNotFoundException(Exception ex, WebRequest request) throws Exception
	{
		Defineerror er=new Defineerror(request.getDescription(false),ex.getMessage(),LocalDateTime.now());
		return new ResponseEntity<Defineerror>(er,HttpStatus.NOT_FOUND);
	}
	//MethodArgumentNotValidException
	
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) 
{
		Defineerror er=new Defineerror(request.getDescription(false),ex.getFieldErrors().iterator().toString(),LocalDateTime.now());
		return new ResponseEntity(er,HttpStatus.BAD_REQUEST);
	}

	@Override 
	public ResponseEntity<Object> handleNoResourceFoundException(
			NoResourceFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Defineerror er=new Defineerror(request.getDescription(false),ex.getMessage(),LocalDateTime.now());

		return new ResponseEntity<Object>(er,HttpStatus.BAD_GATEWAY);
	}


	
}
