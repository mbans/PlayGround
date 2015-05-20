package com.lumar.playground.pattern.decorator;

public class Email implements IEmail {

	private String content;

	public Email(String content) {
		this.content = content;
	}

	@Override
	public String getContents() {
		return content;

	}
}
