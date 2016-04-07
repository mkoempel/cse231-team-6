package edu.oakland.helper;

import java.util.*;

public class JCFPQ {
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
	
	public long getTime() {
		elapsedTime = endTime - startTime;
		return elapsedTime;
	}
	
	public void printPQ() {
		PriorityQueue<Integer> temp = new PriorityQueue<Integer>(pq);
		while (temp.peek() != null) {
			System.out.println(temp.poll());
		}
	}
	
	public int[] getResults(int lowBound, int highBound) {
		int[] internalResults = {-1, -1};
		boolean firstInRange = false, secondInRange = false;
		Integer currentInteger, secondInteger;
		Iterator<Integer> pqIterator = new Iterator<Integer>(pq);
		
		while (pqIterator.hasNext() && firstInRange == false) {
			currentInteger = pqIterator.next();
			if (currentInteger < lowBound) {
				firstInRange = false;
			}
			else if (currentInteger > lowBound && currentInteger < highBound) {
				if (currentInteger % 2 == 0) {
					firstInRange = true;
					internalResults[0] = currentInteger;
					//Once the first integer is found start checking for the second one
					while (pqIterator.hasNext() && secondInRange == false) {
						secondInteger = pqIterator.next();
						if (secondInteger < highBound) {
							if (secondInteger % 2 == 0) {
								internalResults[1] = secondInteger;
								secondInRange = true;
							}
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
	
	//Private inner class that creates an iterator over the priority queue
	private class Iterator<Integer> {
		private PriorityQueue<Integer> temp;
		
		public Iterator(PriorityQueue<Integer> pQueue) {
			temp = new PriorityQueue<Integer>(pQueue);	
		}
		
		public boolean hasNext() {
			return (temp.peek() != null);
		}
		
		public Integer next() {
			Integer tempInteger = temp.poll();
			return tempInteger;
		}
		
		public void remove() {
			temp.poll();
		}
	}
}
