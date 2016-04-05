package edu.oakland.team6;

import java.util.*;


public class PQueue{
	
	private long startTime;
	private long endTime;
	private long elapsedTime;
	
	private int[] array;
	private int size;
	
	private int[] queueArray;
	private int front, rear, queueSize = 0;
	
	
	public PQueue(int[] someArray){
		startTimer();
		array = someArray;
		size = array.length;
		
		queueArray = new int[size];
		for (int temp : array){
			performPriorityInsert(temp);
		}
		
		
		
	}
	
	public void insert(int input){
		if (queueSize + 1 <= size){
			queueArray[rear] = input;
			queueSize++;
		}
		else{
			System.out.println("Sorry the queue is full");
		}
	}
	
	
	public void performPriorityInsert(int input){
		int i = 0;
		if(front > 0){
			--front;
		}
		
		if (queueSize == 0){
			insert(input);
		}
		else{
			rear++;
			for (i = (queueSize - 1); i >= 0; i--){
				if(input < queueArray[i]){
					queueArray[i + 1] = queueArray[i];
				}
				else break;
			}
			queueArray[i + 1] = input;
			queueSize++;
		}
		
	}
	
	public String peek(){
		System.out.println("The front element, F, value is " + queueArray[front]);
		return "-1";
	}
	
	public void performRemove(){
		if(queueSize > 0 ){
			queueArray[front]= -1;
			front++;
			queueSize--;
		}
		else{
			System.out.println("Sorry the queue is empty");
		}
	}
	
	public int pull(){
		int temp = queueArray[front];
		performRemove();
		return temp;
	}
	
	public int[] linearSearch(int lowBound, int highBound){
		
		int temp;
		int hits = 0;
		int valuesSize = 2;
		int[] values = new int[valuesSize];
		for (int i = 0; i < queueSize; i++){
			temp = pull();
			if (temp >= lowBound && temp <= highBound && temp % 2 == 0){
				values[hits] = temp;
				hits++;
			}
			if(hits >= 2){
				break;
			}
		}
		endTimer();
		return values;
	}
			
	
	public void printQueue(){
		System.out.println("The values of the first array are:");
		for (int i = front; i < queueSize + front; i++){
			System.out.print(" | " + queueArray[i]);
			if ((i + 1) % 10 == 0){
				System.out.print("\n\n");
			}
		}
		
	}
	
	public void startTimer(){
		startTime = System.currentTimeMillis();
	}
	
	public void endTimer(){
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
	}
	
	public long getElapsedTime(){
		return elapsedTime;
	}
	
	
}

/*note: underlying structure is useful because we can build a preliminary array
and build a priorit queue off of that, performing inserts for unimportant 
data and perform priority insert on the data we are looking for. */