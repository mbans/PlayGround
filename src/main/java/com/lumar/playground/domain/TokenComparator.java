package com.lumar.playground.domain;

import java.util.Comparator;

public class TokenComparator implements Comparator<Token> {
	
	@Override
	public int compare(Token o1, Token o2) {
			if(o1.getValue() < o2.getValue()) {
			return -1;
		}
		else if (o1.getValue().equals(o2.getValue())) { 
			return 0; 
		}
		else {
			return 1;
		}
	}

}
