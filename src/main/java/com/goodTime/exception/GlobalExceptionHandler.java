package com.goodTime.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<SystemErrorResponse> springHandlerNotFound(Exception exception, WebRequest request){
		SystemErrorResponse errors = new SystemErrorResponse();
		
		errors.setTimestamp(LocalDateTime.now()); //Sets error response current time
		errors.setError(exception.getMessage()); //Sets the exception message
		errors.setStatus(HttpStatus.NOT_FOUND.value()); //Sets error status to 404
		errors.setPath(request.getDescription(false));
		
		return new ResponseEntity<SystemErrorResponse>(errors, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<SystemErrorResponse> springHandlerBadRequest(Exception exception, WebRequest request){
		SystemErrorResponse errors = new SystemErrorResponse();
		
		errors.setTimestamp(LocalDateTime.now()); //Sets error response current time
		errors.setError(exception.getMessage()); //Sets the exception message
		errors.setStatus(HttpStatus.BAD_REQUEST.value()); //Sets error status
		errors.setPath(request.getDescription(false));
		
		return new ResponseEntity<SystemErrorResponse>(errors, HttpStatus.BAD_REQUEST);
	}

}
