package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.Traffic_ticket;
import com.example.demo.proxy.ProxyVehicle;
import com.example.demo.repositories.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository repository;
	
	@Autowired
	private ProxyVehicle proxy;
	
	public List<Traffic_ticket> getAll() {
		return repository.findAll();
	}
	
	public Traffic_ticket getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Id da  multa não encontrado " + id));
	}
	
	public Traffic_ticket insertTicket(Traffic_ticket tt) {
		validationTrafficTicket(tt);
		return repository.save(tt);
	}
	
	private void validationTrafficTicket(Traffic_ticket tt) {
		proxy.getById(tt.getVehicle_id());
	}
}
