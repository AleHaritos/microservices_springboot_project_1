package com.example.demo.response;

import com.example.demo.enums.Color;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Vehicle {

	private Long id;
	
	private String model;
	
	private String license_plate;
	
	private Color color;

	private Long person_id;
	
	
	public Vehicle(Long id, String model, String license_plate, Integer colorCode, Long person) {
		this.id = id;
		this.model = model;
		this.license_plate = license_plate;
		this.color = Color.valueOf(colorCode );
		this.person_id = person;
	}
	
}
