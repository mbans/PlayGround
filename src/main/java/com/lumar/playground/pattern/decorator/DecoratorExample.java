package com.lumar.playground.pattern.decorator;

/** 
 * Purpose:
 * 	Allows class behaviour to be extended at runtime without having to code additional behaviour into the object directly
 *  (Structural Design Pattern) - used to form a large structure from a number of smaller objects.
 * 
 * When To Use:
 * 	i.  Object responsibilities and behaviours should be dynamically modifiable
 *  ii. Concrete implementations should be decoupled from responsibilites and behaviours
 *  Note: 
 *  	Could achieve this by subclassing this by adding into the base class, however this is a bad thing
 *  	as it turns into a maintenance nightmare
 * 
 * Application:
 * 	Java I/O streams, stream class extend the base subclasses but add more features to the stream
 *  
 * Key points:
 * (i) The Decorators appear as IEmails them selves as they implement the interface
 * (ii) Powerful as we can chain together the Decorators
 * 
 * Where I have used:
 * 	RBS - When constructing emails with users portfolios. Depending on the Client we had to add different type of
 *  content onto the statement, different language etc. 
 *  We had a number of "Statement Decorators" used to handle this process.
 * 
 * @author Martin
 *
 */
public class DecoratorExample {

	public static void main(String[] args) {
		IEmail email = new Email("Hello Hong Kong...");

		System.out.println("Original Email >> " + email.getContents()); 
		
		//Chained the Decorators together
		IEmail toSend = new SecureEmailDecorator(new ExternalEmailDecorator(email));
		
		System.out.println("Decorated>>" + toSend.getContents());
	}	
}
