package com.learning.rest.webservices.restfulwebservices.helloworld.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learning.rest.webservices.restfulwebservices.helloworld.user.UserNotFoundException;


@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),request.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),request.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

			StringBuilder str = new StringBuilder();
			
			for(FieldError error : ex.getFieldErrors() ) {
				str.append(error.getDefaultMessage()+" || ");
			}
			
		
		ErrorDetails errorDetails = new ErrorDetails(str.toString(),request.getDescription(false),LocalDateTime.now());
		return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
	}
}




































