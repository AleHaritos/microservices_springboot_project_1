package com.example.demo.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.response.Vehicle;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;


@FeignClient(name = "vehicle-service")
public interface ProxyVehicle {

	@RateLimiter(name = "default")
	@GetMapping(value = "/vehicle/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Vehicle getById(@PathVariable Long id);
	
	@RateLimiter(name = "default")
	@Retry(name = "default")
	@GetMapping(value = "/vehicle/person/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Vehicle> findAllByPersonId(@PathVariable Long id);
	
	
}
