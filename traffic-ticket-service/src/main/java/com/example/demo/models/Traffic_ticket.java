package com.example.demo.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.enums.Infraction;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "`traffic_ticket`")
public class Traffic_ticket implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private Infraction type_infraction;
	
	@Column(nullable = false)
	private BigDecimal price;
	
	@Column(nullable = false)
	private boolean payable;
	
	@Column(nullable = false)
	private Long vehicle_id;

	public Traffic_ticket(Long id, Integer type_infraction_code, BigDecimal price, boolean payable, Long vehicle_id) {
		this.id = id;
		this.type_infraction = Infraction.valueOf(type_infraction_code);
		this.price = price;
		this.payable = payable;
		this.vehicle_id = vehicle_id;
	}
	
	
	
}
