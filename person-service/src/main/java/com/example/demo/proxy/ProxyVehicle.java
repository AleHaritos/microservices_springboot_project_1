package com.example.demo.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.response.Vehicle;


@FeignClient(name = "vehicle-service")
public interface ProxyVehicle {

	@GetMapping(value = "/vehicle/{id}")
	public ResponseEntity<Vehicle> getById(Long id);
	
	@GetMapping(value = "/vehicle/person/{id}")
	public List<Vehicle> findAllByPersonId(@PathVariable Long id);
}
