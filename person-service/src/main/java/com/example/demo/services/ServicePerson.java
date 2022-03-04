package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.models.Person;
import com.example.demo.repositories.RepositoryPerson;

@Service
public class ServicePerson {

	@Autowired
	private RepositoryPerson repository;
	
	public List<Person> getAll() {
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Id não encontrado :" + id));
	}
	
	public Person addPerson(Person p) {
		this.ObjectValidation(p);
		return repository.save(p);
	}
	
	private void ObjectValidation(Person p) {
		if (p.getName() == null || p.getEmail() == null || p.getCpf() == null) {
			throw new BadRequestException("Erro: Dados Estão incompletos");
		}
	}
	
}
