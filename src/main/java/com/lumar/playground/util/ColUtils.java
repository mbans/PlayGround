package com.lumar.playground.util;

import java.util.Collection;
import java.util.Iterator;

import com.lumar.playground.domain.Token;

public class ColUtils <T extends Collection<Token>>  {

	public void populateCol(T col, int numberOfItems) {
		int i=0;
		while(i<numberOfItems) {
			col.add(new Token(i+1+"", i+1+"", i+1));
			i++;
		}
	}

	public void remove(T col, int numberOfItems) {
		Iterator<Token> iterator = col.iterator();
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
	}
}
