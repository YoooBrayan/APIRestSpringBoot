package com.bytecode.core.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bytecode.core.modelo.common.RepBase;

@ControllerAdvice
public class Exceptions extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handledAnyException(Exception e, WebRequest request){
		
		String error = e.getLocalizedMessage();
		if(error == null) error = e.toString();
		
		RepBase errorMessage = new RepBase(error); 
		
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
