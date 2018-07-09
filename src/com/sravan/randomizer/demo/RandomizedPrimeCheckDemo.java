package com.sravan.randomizer.demo;

import java.util.concurrent.ConcurrentLinkedQueue;

public class RandomizedPrimeCheckDemo {

	public static void main(String[] args) {
		// generate random number and check the weather prime number or not
		
		ConcurrentLinkedQueue<Integer> theInputQueue = new ConcurrentLinkedQueue<Integer>();
		ConcurrentLinkedQueue<OutputFormat> theOutputQueue = new ConcurrentLinkedQueue<OutputFormat>();
		System.out.println("Sample run for Prime Checker:");
		
		Thread randomizer= new Thread(new Randomizer(theInputQueue,theOutputQueue));
		Thread prime= new Thread(new Prime(theInputQueue,theOutputQueue));
		randomizer.start();
		prime.start();
		

	}

}
