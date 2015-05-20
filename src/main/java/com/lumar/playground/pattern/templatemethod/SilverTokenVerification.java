package com.lumar.playground.pattern.templatemethod;

import com.lumar.playground.domain.Token;

public class SilverTokenVerification extends TokenValidationTemplate {
	
	@Override
	public void verifySpecificToken(Token token) {
		if(!token.getColor().equals("Silver")) {
			System.out.println(token + " failed the 'Silver' verification....");
		}
		else {
			System.out.println("Passed 'Gold' verification");
		}
	}
}
