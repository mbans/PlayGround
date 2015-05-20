package com.lumar.playground.pattern.templatemethod;

import com.lumar.playground.domain.Token;

public class GoldTokenVerification extends TokenValidationTemplate {

	@Override
	public void verifySpecificToken(Token token) {
		if(!token.getColor().equals("Gold")) {
			System.out.println(token + " failed the 'Gold' verification....");
		}
		else {
			System.out.println("Passed 'Gold' verification");
		}
	}
}
