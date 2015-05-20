package com.lumar.playground.collections;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.function.Consumer;

import com.lumar.playground.domain.Token;
import com.lumar.playground.domain.TokenComparator;
import com.lumar.playground.util.QueueConsumer;

/**
 * Application: Used in scheduling scenario, job with top priorty goes first
 * Notes: PriorityQueue is NOT thread safe, use PriorityBlockingQueue instead
 * Introduces in 1.5
 * 
 * Can use the @Consumer functional interface, rather than older implementation of using "poll".
 * @author Martin
 */
public class PriorityQueueExample {

	public static void main(String[] args) {
		Queue<Token> q = new PriorityBlockingQueue<Token>(10,
				new TokenComparator());
		q.add(new Token("1", "1", 1));
		q.add(new Token("100", "100", 100));
		q.add(new Token("2", "2", 2));
		q.add(new Token("50", "50", 50));

		q.forEach(new Consumer<Token>() {
			@Override
			public void accept(Token t) {
				System.out.println("Pulled " + t + " from the Queue");
			}
		});

		// Consumer - by threaad
		// new Thread(new QueueConsumer<Token>("Consumer 1", q)).start();
		// new Thread(new QueueConsumer<Token>("Consumer 2", q)).start();
	}

}
