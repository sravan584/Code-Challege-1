package com.sravan.randomizer.demo;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Randomizer implements Runnable {
	public ConcurrentLinkedQueue<Integer> inputQueue;
	public ConcurrentLinkedQueue<OutputFormat> outputQueue;
	
	
	
	public Randomizer(ConcurrentLinkedQueue<Integer> inputqueue, ConcurrentLinkedQueue<OutputFormat> outputqueue) {
		super();
		this.inputQueue = inputqueue;
		this.outputQueue = outputqueue;
	}



	@Override
	public void run() {
		// generate the positive random number and add it to the queue 
		
		Random random= new Random();
		System.out.println("Randomizer started");
		
		try {
			for(int i=0;i<5;i++) {
				int randomNumber=random.nextInt(1000);
				inputQueue.add(randomNumber);
				System.out.println("number added to the input queue from randomizer:" +randomNumber);
				Thread.currentThread().sleep(300);
				while(!outputQueue.isEmpty()) {
					OutputFormat outputFormat=outputQueue.poll();
					System.out.println("Integer number: "+outputFormat.number+" isPrime: "+outputFormat.result );
				}
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
