package com.example.demo.exceptions.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.StandardError;

@ControllerAdvice
@RestController
public class Handler {
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<StandardError> handlerNotFound(NotFoundException e, WebRequest request) {
		StandardError se = new StandardError(e.getMessage(), Instant.now(), request.getDescription(false));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<StandardError> handlerBadRequest(BadRequestException e, WebRequest request) {
		StandardError se = new StandardError(e.getMessage(), Instant.now(), request.getDescription(false));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<StandardError> handlerError(RuntimeException e, WebRequest request) {
		StandardError se = new StandardError(e.getMessage(), Instant.now(), request.getDescription(false));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<StandardError> handlerErrorException(Exception e, WebRequest request) {
		StandardError se = new StandardError(e.getMessage(), Instant.now(), request.getDescription(false));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
	}
}
