package com.lumar.playground.pattern.decorator;

/**
 * Decorator which will wrap the base email with extra functionality
 * We also implement the origianl interface as the decorator has to "pose" as an email
 * @author Martin
 */
public abstract class EmailDecorator implements IEmail {

	/** Hold a reference to the original **/ 
	IEmail originalEmail; 
	
	public abstract IEmail getEmail();
	
}