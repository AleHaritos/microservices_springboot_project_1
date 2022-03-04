package com.example.demo.exceptions;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError {
	
	private String message;
	private Instant timestamp;
	private String details;
}
