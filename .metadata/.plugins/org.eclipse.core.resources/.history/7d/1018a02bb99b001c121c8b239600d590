package com.example.demo.enums;

public enum Infraction {
	SPEEDING(1),
	DRUNK_DRIVING(2),
	WRONG_WAY(3),
	CELL_PHONE(4);
	
	private Integer code;
	
	Infraction(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return this.code;
	}
	
	public static Infraction valueOf(int code) {
		for (Infraction value: Infraction.values()) {
			if (value.getCode() == code) {
				return value;
			}
		} throw new IllegalArgumentException();	
	}
}
