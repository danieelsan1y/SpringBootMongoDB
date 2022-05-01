package com.danielsantana.springmongodb.resource.exeptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.danielsantana.springmongodb.services.exception.ObjectNotFoungException;
@ControllerAdvice
public class ResourceExceptionhandler {
	
	@ExceptionHandler(ObjectNotFoungException .class)
	public ResponseEntity<StandardError> resourceNotFound(ObjectNotFoungException e, HttpServletRequest request) {
		String error = "Não encontrado!";
		HttpStatus status =  HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()) ;
		return ResponseEntity.status(status).body(err);
	}
	

}
