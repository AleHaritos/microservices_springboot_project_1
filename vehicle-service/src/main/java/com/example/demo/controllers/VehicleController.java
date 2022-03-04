package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Vehicle;
import com.example.demo.services.VehicleService;

@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vehicle insertVehicle(@RequestBody Vehicle v) {
		return service.addVehicle(v);
	}
	
	@GetMapping
	public ResponseEntity<List<Vehicle>> getAll() {
		List<Vehicle> list = service.getAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Vehicle> getById(Long id) {
		Vehicle v = service.getById(id);
		return ResponseEntity.ok(v);
	}
}
