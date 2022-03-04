package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Traffic_ticket;
import com.example.demo.services.TicketService;

@RestController
@RequestMapping(name = "/ticket")
public class TicketController {

	@Autowired
	private TicketService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Traffic_ticket insertTicket(@RequestBody Traffic_ticket tt) {
		return this.service.insertTicket(tt);
	}

	@GetMapping
	public ResponseEntity<List<Traffic_ticket>> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Traffic_ticket> getById(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getById(id));
	}
}
