package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.response.Vehicle;


@FeignClient(name = "vehicle-service")
public interface ProxyVehicle {

	@GetMapping(value = "/vehicle/{id}")
	public ResponseEntity<Vehicle> getById(Long id);
}
