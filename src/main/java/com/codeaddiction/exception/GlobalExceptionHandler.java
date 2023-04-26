package com.codeaddiction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(GlobalServiceException.class)
	 @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	 public String getGlobalException(GlobalServiceException e){ 
		return e.getMessage();
		 
	 }
}
