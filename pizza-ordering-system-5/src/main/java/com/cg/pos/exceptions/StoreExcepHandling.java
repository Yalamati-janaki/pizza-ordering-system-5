package com.cg.pos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class StoreExcepHandling {
	
	@ExceptionHandler(StoreExceptions.class)
	public ResponseEntity<ErrorDetails> errorHandle(StoreExceptions ex,WebRequest request){
		
		ErrorDetails details= new ErrorDetails(ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(details,HttpStatus.BAD_REQUEST);
		
	}

}
