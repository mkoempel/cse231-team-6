package edu.oakland.helper;

import java.util.*;

/**
 * @author Team 6
 * @version 1.0.0 160409
 * @since 1.0.0
 */

public class PQueue{
	
	/**
	* long time of class construction in milliseconds
	*/
	private long startTime;
	
	/**
	* long time completion of the linear search in milliseconds
	*/
	private long endTime;
	
	/**
	* long representing the total time to sort and return the values
	*/
	private long elapsedTime;
	
	/**
	 * int[] array containing the values 
	 */
	private int[] array;
	
	/**
	 *int[] array for the Priority Queue 
	 */ 
	private int[] queueArray;
	/**
	* Integers front of the queue, rear of the queue, and size of the queue.
	*/
	private int front, rear, queueSize = 0;
	
	/**
	* Constructor method for passing in an integer array
	* @param someArray The array being passed to constructor
	*/
	public PQueue(int[] someArray){
		startTimer();
		array = someArray;
		
		queueArray = new int[array.length];
		for (int temp : array){
			performPriorityInsert(temp);
		}
		
		
		
	}
	
	/**
	* The method to insert an integer to the rear of the queue
	* @param input The integer value to be inserted
	*/
	public void insert(int input){
		if (queueSize + 1 <= array.length){
			queueArray[rear] = input;
			queueSize++;
		}
		else{
			System.out.println("Sorry the queue is full");
		}
	}
	
	/**
	* The method to insert an integer in a position above the first value larger than itself
	* @param input The integer value to be inserted by ascending value
	*/
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
	
	/**
	* Finds the value of the integer currently at the front of the queue
	* @return Confirmation string
	*/
	public String peek(){
		System.out.println("The front element, F, value is " + queueArray[front]);
		return "-1";
	}
	
	/**
	* Method to remove the front value of the queue
	*/
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
	
	/**
	* Method to copy the front value of the queue and remove it
	* @return int value removed from the front
	*/
	public int pull(){
		int temp = queueArray[front];
		performRemove();
		return temp;
	}
	
	/**
	* Method to search for two even integer between the two integers passed in
	* @param lowBound Low bound search for
	* @param highBound High bound to search for
	* @return The integer array of size two
	*/
	public int[] getResults(int lowBound, int highBound){
		
		int temp;
		int hits = 0;
		int valuesSize = 2;
		int[] values = new int[valuesSize];
		for (int i = 0; i < array.length; i++){
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
			
	/**
	* Method prints out the queue
	*/
	public void printQueue(){
		System.out.println("The values of the first array are:");
		for (int i = front; i < queueSize + front; i++){
			System.out.print(" | " + queueArray[i]);
			if ((i + 1) % 10 == 0){
				System.out.print("\n\n");
			}
		}
		
	}
	
	/**
	* Method sets the start time
	*/
	public void startTimer(){
		startTime = System.nanoTime();
	}
	
	/**
	* Method sets the end time and finds the difference between start and end time
	*/
	public void endTimer(){
		endTime = System.nanoTime();
		elapsedTime = (endTime - startTime)/1000000;
	}
	
	/**
	* Getter method for time elapsed
	* @return long of the elapsed time. Only call after the getResults(int, int) method has been called.
	*/
	public long getTime(){
		return elapsedTime;
	}
	
	
}

/*note: underlying structure is useful because we can build a preliminary array
and build a priorit queue off of that, performing inserts for unimportant 
data and perform priority insert on the data we are looking for. */
