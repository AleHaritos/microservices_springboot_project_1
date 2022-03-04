package com.example.demo.response;

public enum Color {
	BLACK(1),
	WHITE(2),
	RED(3),
	BLUE(4),
	SILVER(5),
	GRAY(6),
	YELLOW(7);
	
	private Integer code;
	
	Color(int i) {
		this.code = i;
	}
	
	public Integer getCode() {
		return this.code;
	}
	
	public static Color valueOf(int code) {
		for (Color value: Color.values()) {
			if (value.getCode() == code) {
				return value;
			}
		} throw new IllegalArgumentException();	
	}
}
