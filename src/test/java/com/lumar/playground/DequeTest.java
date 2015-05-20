package com.lumar.playground;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Assert;
import org.junit.Test;

import com.lumar.playground.domain.Token;

/**
 * Dequeue:
 *  Dequeue supports add/removal from both ends, double ended Queue
 *
 * Methods:
 * 	addFirst/addLast | removeFirst/removeLast | getFirst/getLast | - these throw exceptions if Deque is full/empty
 *  offerFirst/offerLast | pollFirst/pollLast | peekFirst/peekLast | - these DO NOT throw exception
 *  
 * Application:
 * 	Queue system in a shop where someone purchases something but can then jump straight to the front of the queue
 *  New joiners join the end of the queue 
 * 
 * Implementations
 * 	1. ArrayDequue 
 *  2. ConcurrentDequeue   - More efficient, only locks subset 
 *  3. LinkedBlockingDeque - This is more of a legacy implementation that locks entire list whilst "removeFirst", "addFirst" etc
 *  4. LinkedList - implementation is pointers to and from the next item
 * 
 * @author Martin
 */
public class DequeTest {

	public static Deque<Token> arrayDeq = new ArrayDeque<Token>(1);
	
	@Test(expected=Exception.class)
	public void removeExceptionsIfEmpty() {
		arrayDeq = new ArrayDeque<Token>(); 
		arrayDeq.removeFirst();
	}

	@Test
	public void removeFirst() {
		arrayDeq.add(new Token("1","1",1));
		arrayDeq.add(new Token("2","2",2));
		Assert.assertTrue(arrayDeq.removeLast().getValue() == 2);
	}
	
	public void peekDoestThrowException() {
		arrayDeq = new ArrayDeque<Token>(); 
		Token t = arrayDeq.peekFirst();
		Assert.assertTrue(t == null);
	}

}
