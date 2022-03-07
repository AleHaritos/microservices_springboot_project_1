package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Person;
import com.example.demo.services.ServicePerson;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/person")
@Tag(name = "Person controller", description = "Apis of person service")
public class PersonController {

	@Autowired
	private ServicePerson service;
	
	@Operation(description = "Insert person in database", summary = "insertPerson")
	@Retry(name = "default")
	@RateLimiter(name = "default")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person insertPerson(@RequestBody Person p) {
		return service.addPerson(p);
	}
	
	@Operation(description = "Get all people", summary = "getAllPerson")
	@Retry(name = "default")
	@RateLimiter(name = "default")
	@GetMapping
	public ResponseEntity<List<Person>> getAll() {
		List<Person> list =  service.getAll();
		return ResponseEntity.ok(list);
	}
	
	@Operation(description = "Get person by Id", summary = "getById")
	@RateLimiter(name = "default")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> getById(@PathVariable Long id) {
		Person p =  service.findById(id);
		return ResponseEntity.ok(p);
	}
	
	@Operation(description = "Delete person by Id", summary = "deleteById")
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		this.service.deletePerson(id);
	}
	
}
