package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.BadRequestException;
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
		tt.setPayable(true);
		return repository.save(tt);
	}
	
	public void paymentTicket(Long id) {
		Traffic_ticket tt = this.getById(id);
		tt.setPayable(false);
		this.repository.save(tt);
	}
	
	public void deleteTicket(Long id) {
		Traffic_ticket tt = this.getById(id);
		if (tt.isPayable() == true) {
			throw new BadRequestException("Não é possível deletar uma multa em aberto");
		} else {
			this.repository.deleteById(id);
		}
	}
	
	private void validationTrafficTicket(Traffic_ticket tt) {
		if (tt.getPrice() == null || tt.getType_infraction() == null || tt.getVehicle_id() == null) {
			throw new BadRequestException("Dados incompletos para realizar a multa");
		}
		proxy.getById(tt.getVehicle_id());
	}
}
