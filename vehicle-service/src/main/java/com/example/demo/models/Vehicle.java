package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.enums.Color;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "`vehicle`")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 120)
	private String model;
	
	@Column(nullable = false, length = 7, unique = true)
	private String license_plate;
	
	@Column(nullable = false, length = 25)
	private Color color;

	@Column(name ="person_id")
	private Long personId;
	
	
	public Vehicle(Long id, String model, String license_plate, Integer colorCode, Long person) {
		this.id = id;
		this.model = model;
		this.license_plate = license_plate;
		this.color = Color.valueOf(colorCode );
		this.personId = person;
	}
	
}
