package com.lumar.playground.domain;

public class Token {

	private String id; 
	
	private String description;
	
	private Integer value; 
	
	private String color; 
	
	public Token(String id, String description, Integer value) {
		this.id = id;
		this.description = description;
		this.value = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getId() {
		return id;
	}
	
	public Integer getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return id + "["+description+"]";
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
}
