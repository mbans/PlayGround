package com.lumar.playground.domain;

public class GoldenToken extends Token {

	public GoldenToken(String id, String description, Integer value) {
		super(id, description, value);
		this.setColor("Gold");
	}
	
	@Override
	public String toString() {
		return super.toString() + "....I'm a golden token though.";
	}
}
