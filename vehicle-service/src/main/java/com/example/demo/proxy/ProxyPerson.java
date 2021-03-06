package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.response.Person;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@FeignClient(name = "person-service")
public interface ProxyPerson {

	@RateLimiter(name = "default")
	@GetMapping(value = "/person/{id}")
	public ResponseEntity<Person> getById(@PathVariable Long id);
}
