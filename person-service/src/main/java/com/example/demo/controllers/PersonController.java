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

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	private ServicePerson service;
	
	@Retry(name = "default")
	@RateLimiter(name = "default")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Person insertPerson(@RequestBody Person p) {
		return service.addPerson(p);
	}
	
	@Retry(name = "default")
	@RateLimiter(name = "default")
	@GetMapping
	public ResponseEntity<List<Person>> getAll() {
		List<Person> list =  service.getAll();
		return ResponseEntity.ok(list);
	}
	
	@RateLimiter(name = "default")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> getById(@PathVariable Long id) {
		Person p =  service.findById(id);
		return ResponseEntity.ok(p);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		this.service.deletePerson(id);
	}
	
}
