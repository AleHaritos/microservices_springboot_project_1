package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Vehicle;
import com.example.demo.services.VehicleService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/vehicle")
@Tag(name = "Vehicle Controller", description = "Controller of Vehicle service")
public class VehicleController {

	@Autowired
	private VehicleService service;
	
	@Operation(description = "Insert Vehicles in database", summary = "insertVehicle")
	@RateLimiter(name = "default")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vehicle insertVehicle(@RequestBody Vehicle v) {
		return service.addVehicle(v);
	}
	
	@Operation(summary = "getAllVehicle", description = "get all vehicles in database")
	@Retry(name = "default")
	@RateLimiter(name = "default")
	@GetMapping
	public ResponseEntity<List<Vehicle>> getAll() {
		List<Vehicle> list = service.getAll();
		return ResponseEntity.ok(list);
	}
	
	@Operation(summary = "getById", description = "Get vehicle by id")
	@RateLimiter(name = "default")
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Vehicle getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@Operation(summary = "findAllByPersonId", description = "Get vehicle by Person id")
	@Retry(name = "default")
	@RateLimiter(name = "default")
	@GetMapping(value = "/person/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Vehicle> findAllByPersonId(@PathVariable Long id) {
		return this.service.findAllByPerson_id(id);
	}
	
	@Operation(summary = "changeOwner", description = "Change person id -> change vehicles'owner")
	@Retry(name = "default")
	@RateLimiter(name = "default")
	@PutMapping(value = "/{id}/{person-id}")
	public ResponseEntity<Vehicle> changeOwner(@PathVariable("id") Long id, @PathVariable("person-id") Long person_id) {
		Vehicle v = this.service.changeOwner(id, person_id);
		return ResponseEntity.ok(v);
	}
	
	
}
