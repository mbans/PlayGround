package com.lumar.playground.util;

import java.util.Queue;

public class QueueConsumer<T> implements Runnable {
	
	private String name; 
	
	private Queue<T> q; 
	
	public QueueConsumer(String name, Queue<T> q) {
		this.name = name;
		this.q = q;
	}
	
	//Consume from the queue
	public void run() {
		
		while(true) {
			T item = q.poll();
			System.out.println(name+":" + "Pulled " + item + " from the Queue");
			sleep(1);
			if(item == null) {
				break;
			}
		}
	}
	
	private static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		}
		catch(Exception e) {
			
		}
		
	}
	
	
}
