package com.lumar.playground.pattern.decorator;

public class SecureEmailDecorator extends EmailDecorator {
	private String content;

	public SecureEmailDecorator(IEmail basicEmail) {
		originalEmail = basicEmail;
	}

	@Override
	public String getContents() {
		// secure original
		content = encrypt(originalEmail.getContents());
		return content;
	}
	
	@Override
	public IEmail getEmail() {
		return new Email(content);
	}

	private String encrypt(String message) {
		return "encrypted("+message+")";
	}
}