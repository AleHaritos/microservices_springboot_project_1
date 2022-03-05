package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Traffic_ticket;
import com.example.demo.services.TicketService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

	@Autowired
	private TicketService service;

	@RateLimiter(name = "default")
	@Retry(name = "default")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Traffic_ticket addTicket(@RequestBody Traffic_ticket tt) {
		return this.service.insertTicket(tt);
	}

	@Retry(name = "default")
	@RateLimiter(name = "default")
	@GetMapping
	public ResponseEntity<List<Traffic_ticket>> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}
	
	@RateLimiter(name = "default")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Traffic_ticket> getById(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getById(id));
	}
	
	@Retry(name = "default")
	@RateLimiter(name = "default")
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void payTicket(@PathVariable Long id) {
		this.service.paymentTicket(id);
	}
	
	@Retry(name = "default")
	@RateLimiter(name = "default")
	@DeleteMapping(value ="/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTicket(@PathVariable Long id) {
		this.service.deleteTicket(id);
	}
	
	
}
