package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.Vehicle;
import com.example.demo.proxy.ProxyPerson;
import com.example.demo.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository repository;
	
	@Autowired
	private ProxyPerson proxy;
	
	public Vehicle addVehicle(Vehicle v) {
		this.validationPerson(v.getPerson_id());
		return this.repository.save(v);
	}
	
	public Vehicle getById(Long id) {
		return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Id não encontrado: " + id));
	}
	
	public List<Vehicle> getAll() {
		return this.repository.findAll();
	}
	
	private void validationPerson(Long id) {
		if(id == null) {
			
		} else {
			proxy.getById(id);
		}
	}
	
}