package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "vehicle-service")
public interface ProxyVehicle {

	
}