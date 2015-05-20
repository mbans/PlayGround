package com.lumar.playground;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

import com.lumar.playground.domain.Token;

/**
 * !!!!!Stack extends VECTOR....it is NOT part of the Collections framework!!!!!
 * 
 * Stack (LIFO):
 *  The Stack class represents a last-in-first-out (LIFO) stack of objects. 
 *  It extends class Vector with five operations that allow a vector to be treated as a stack. 
 *  The usual push and pop operations are provided, as well as a method to peek at the top item on the stack. 
 *  A method to test for whether the stack is empty, and a method to search the stack for an item and discover how far it 
 *  is from the top.
 *
 * Methods:
 * 	empty - is it empty 
 *  peek - looks at the item at top without removing (EmptyStackException)
 *  pop - remove last item off the stack (EmptyStackException)
 *  push - add an item to the stack 
 *  search -returns how far the object is from top of the stack
 *  
 * Application:
 * 	Job redundancy - offten LIFO, lower redundancy payment
 *  "Stack of paper" - that is where it is named after
 * 
 * Implementations
 * 	1. ArrayDequue 
 *  2. ConcurrentDequeue   - More efficient, only locks subset 
 *  3. LinkedBlockingDeque - This is more of a legacy implementation that locks entire list whilst "removeFirst", "addFirst" etc
 *  4. LinkedList - implementation is pointers to and from the next item
 * 
 * @author Martin
 */
public class StackTest {

	public static Stack<Token> stack = new Stack<Token>();
	
	@Test(expected=EmptyStackException.class)
	public void failsWhenEmpty() {
		stack = new Stack<Token>();
		stack.pop();
	}
	
	@Test
	public void populate() {
		stack = new Stack<Token>();
		stack.push(new Token("1","1",1));
		stack.push(new Token("2","2",2));
		stack.push(new Token("3","3",3));
		
		Token t = stack.pop();
		Assert.assertTrue(t.getValue() == 3);
		
		//Assert size
		Assert.assertTrue(stack.capacity() == 2);
	}
	

}
