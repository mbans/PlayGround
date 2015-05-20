package com.lumar.playground.pattern.templatemethod;

import com.lumar.playground.domain.Token;

public abstract class TokenValidationTemplate {

	public void validate(Token token) { 
		checkIdIsLargerThanZero(token); 
		verifySpecificToken(token);
	}

	public abstract void verifySpecificToken(Token token);

	private void checkIdIsLargerThanZero(Token token) {
		if(Integer.parseInt(token.getId()) > 0 ) {
			System.out.println(token + " Id verification passed");
		}
	}
}
