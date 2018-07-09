package com.sravan.randomizer.demo;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Prime implements Runnable{
	public ConcurrentLinkedQueue<Integer> inputQueue;
	public ConcurrentLinkedQueue<OutputFormat> outputQueue;
	
	
	public Prime(ConcurrentLinkedQueue<Integer> inputQueue, ConcurrentLinkedQueue<OutputFormat> outputQueue) {
		super();
		this.inputQueue = inputQueue;
		this.outputQueue = outputQueue;
	}


	@Override
	public void run() {
		int number;
		System.out.println("Prime number Checker Started");
		//get the element from the queue 
		
		//check for it is prime number or not
		try {
		for(int i=0;i<5;i++) {
			while(!inputQueue.isEmpty()) {
				number=inputQueue.poll();
				OutputFormat outputFormat=new OutputFormat(number, isPrime(number));
				outputQueue.add(outputFormat);
			}
			Thread.currentThread().sleep(500);
		}
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	// check given number is prime or not 
	public  boolean isPrime(int theNumber) {
		//check if n is a multiple of 2
		if(theNumber%2==0) return false;
	    
	    //if not, then just check the odds
	    for(int i=3;i*i<=theNumber;i+=2) {
	        if(theNumber%i==0)
	            return false;
	    }
	    return true;
	}

}
