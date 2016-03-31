package edu.oakland.team6;

import java.util.*;

public class JCFPQ {
	//None of these need to be static in final code
	private long startTime, endTime, elapsedTime;
	private PriorityQueue<Integer> pq;
	private int[] results = {-1,-1};
		
	public JCFPQ (int[] theArray) {
		startTimer();
		pq = new PriorityQueue<Integer>();
		for (int i = 0; i < theArray.length; i++) {
			pq.add(theArray[i]);
		}
	}
	
	public void startTimer() {
		startTime = System.currentTimeMillis();
	}
	
	public void endTimer() {
		endTime = System.currentTimeMillis();
	}
	
	public long getElapsedTime() {
		elapsedTime = endTime - startTime;
		return elapsedTime;
	}
	
	public void printPQ() {
		PriorityQueue<Integer> temp = new PriorityQueue<Integer>(pq);
		while (temp.peek() != null) {
			System.out.println(temp.poll());
		}
	}
	
	public int[] linearSearch(int lowBound, int highBound) {
		int[] internalResults = {-1, -1};
		boolean firstInRange = false, secondInRange = false;
		Integer currentInteger, secondInteger;
		
		PriorityQueue<Integer> temp = new PriorityQueue<Integer>(pq);
		while (temp.peek() != null && firstInRange == false) {
			currentInteger = temp.poll();
			if (currentInteger < lowBound) {
				firstInRange = false;
			}
			else if (currentInteger > lowBound && currentInteger < highBound) {
				if (currentInteger % 2 == 0) {
					firstInRange = true;
					internalResults[0] = currentInteger;
					//Once the first integer is found start checking for the second one
					while (temp.peek() != null && temp.peek() < highBound && secondInRange == false) {
						secondInteger = temp.poll();
						if (secondInteger % 2 == 0) {
							internalResults[1] = secondInteger;
							secondInRange = true;
						}
					}
				}
			}
			//Once the upper bound is exceeded set the in range true just to exit the search
			else {
				firstInRange = true;
			}
		}
		endTimer();
		return internalResults;
	}
}