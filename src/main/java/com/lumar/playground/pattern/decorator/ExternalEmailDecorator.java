package com.lumar.playground.pattern.decorator;

/**
 * Implementation of the ConcreteDecorator
 * 
 * This decorates the original emails with a "Company Disclaimer" as they are extenal.
 * <br>
 * This functionality is completely decoupled from the Email implementation
 * 
 * @author Martin
 *
 */
public class ExternalEmailDecorator extends EmailDecorator {

	private String content;

	public ExternalEmailDecorator(IEmail basicEmail) {
		originalEmail = basicEmail;
	}

	@Override
	public String getContents() {
		// secure original
		content = addDisclaimer(originalEmail.getContents());
		return content;
	}

	@Override
	public IEmail getEmail() {
		return new Email(content);
	}

	private String addDisclaimer(String message) {
		// append company disclaimer to message
		return message + " External Company Disclaimer";
	}

}