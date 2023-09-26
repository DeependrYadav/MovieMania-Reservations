package com.moviesmania.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyExceptionClass> exception(Exception ex, WebRequest web){
		MyExceptionClass mec = new MyExceptionClass(ex.getMessage(), web.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<MyExceptionClass>(mec,HttpStatus.BAD_REQUEST);
	}
}
