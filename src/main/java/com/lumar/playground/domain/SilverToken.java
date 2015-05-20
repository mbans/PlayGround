package com.lumar.playground.domain;

public class SilverToken extends Token {
	
	public SilverToken(String id, String description, Integer value) {
		super(id, description, value);
		this.setColor("Silver");
	}
	
	@Override
	public String toString() {
		return super.toString() + "....I'm a silver token though.";
	}
	
}
