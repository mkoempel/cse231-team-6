package edu.oakland.helper;

import java.util.*;

/**
 * @author Team 6
 * @version 1.0.0 160409
 * @since 1.0.0
 */
public class JCFPQ {
	
	/**
	*startTime, endTime, elapsedTime are used to record time during run.
	* startTime is recorded once a JCFPQ class is created.
	* endTime is recorded once the getResults class ends.
	* elapsedTime is calculated from startTime and endTime.
	* results holds the first two even values within the specified range.
	*/
	private long startTime, endTime, elapsedTime;
	/**
	 * PriorityQueue object to be manipulated
	 */ 
	private PriorityQueue<Integer> pq;
	/**
	 * int array containing the two even elements greater than 800
	 */
	private int[] results = {-1,-1};
		
	/**
	 * Constructor that takes an int array and copies each value into
	 * a priority queue integer array called pq.
	 * @param theArray int[] Array to be the underlying structure for PriorityQueue
	 */
	public JCFPQ (int[] theArray) {
		startTimer();
		pq = new PriorityQueue<Integer>();
		for (int i = 0; i < theArray.length; i++) {
			pq.add(theArray[i]);
		}
	}
	
	/**
	 * stores the time value for when a JCFPQ is made.
	 */
	public void startTimer() {
		startTime = System.nanoTime();
	}
	/**
	 * stores the time value for when the first two even values are found within
	 * the getResults method.
	 */
	public void endTimer() {
		endTime = System.nanoTime();
	}
	/**
	 * @return long returns the time difference for when the class JCFPQ was created and when
	 * the getResults method ends.
	 */
	public long getTime() {
		elapsedTime = endTime - startTime;
		return elapsedTime;
	}
	/**
	 * prints out all numbers within the priority queue.
	 */
	public void printPQ() {
		PriorityQueue<Integer> temp = new PriorityQueue<Integer>(pq);
		while (temp.peek() != null) {
			System.out.println(temp.poll());
		}
	}
	
	/**
	*@return int[] with the int array containing the first two even numbers within the bounds.
	* The getResults method takes the "PriorityQueue<Integer> pq" and finds the first two even
	* numbers within pq and returns them in an int array.
	* @param lowBound lower intervel to be returned
	* @param highBound upper interval of the numbers being returned
	*/
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
	
	/**
	*Private inner class that creates an iterator over the priority queue
	*/ 
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
