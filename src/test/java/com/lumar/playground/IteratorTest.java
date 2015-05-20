package com.lumar.playground;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import junit.framework.Assert;

import org.junit.Test;

import com.lumar.playground.domain.Token;
import com.lumar.playground.util.ColUtils;

public class IteratorTest {
	
	public ColUtils<List<Token>> utils = new ColUtils<List<Token>>(); 
	
	@Test
	public void listIterator() {
		List<Token> list = new ArrayList<Token>(); 
		utils.populateCol(list, 5);
		
		ListIterator<Token> listIterator = list.listIterator();
		
		//Move 3 forward
		Token t1 = listIterator.next();
		Token t2 = listIterator.next();
		Token t3 = listIterator.next();
		
		//Move 1 back
		Token item2 = listIterator.previous();
		Token previous = listIterator.previous();
		
	}
}
