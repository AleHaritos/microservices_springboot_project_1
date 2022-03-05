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
		this.validationPerson(v.getPersonId());
		return this.repository.save(v);
	}
	
	public Vehicle getById(Long id) {
		return this.repository.findById(id).orElseThrow(() -> new NotFoundException("Id não encontrado: " + id));
	}
	
	public List<Vehicle> getAll() {
		return this.repository.findAll();
	}
	
	public List<Vehicle> findAllByPerson_id(Long id) {
		return this.repository.findByPersonId(id);
	}
	
	public List<Vehicle> findAllByModel(String model) {
	return this.repository.findByModel(model);
}
	
	public Vehicle changeOwner(Long id, Long person_id) {
		this.validationPerson(person_id);
		Vehicle v = this.getById(id);
		v.setPersonId(person_id);
		return this.repository.save(v);
	}
	
	private void validationPerson(Long id) {
		if(id == null) {
			
		} else {
			proxy.getById(id);
		}
	}
	
}
