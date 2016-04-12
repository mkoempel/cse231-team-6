package edu.oakland.test;
import edu.oakland.helper.PQueue;
import junit.framework.*;	

/**
*@author CSE231 Team 6
*@version Version 1.0 160407
*@Since Version 1.0 160407
*/

/**
 * Test class to check the JCFPG class is working properly
 */
public class PriorityQTestb extends TestCase {
	/**
	 * int which will hold the first value in the array >800
	 */
	private int testResult;
	/**
	 * int which will hold the second value in the array >800
	 */
	private int testResult2;
	/**
	 * int value already known to be the first value in the array >800
	 */
	private int evenPass = 802;
	/**
	 * int value already known to be the second value in the array >800
	 */
	private int evenPass2 = 806;
	/**
	 * int array to be passed into the JCFPQ class to be tested
	 */
	private int[] arrayTest = {20, 705, 801, 802, 806, 914, 1002, 2056, 1724, 34, 29, 803};
	/**
	 * long to be assigned to the total time elapsed by the construction and getResults() method to be run
	 */
	private long timeElapsed;
	/**
	 *int array to hold the 1st and 2nd values above 800 
	 */
	private int[] resultArray;
	
	/**
	*Method for setting up the JCFPQ class to be tested
	*/
	public void setUp(){
		PQueue pQueue = new PQueue(arrayTest);
		System.out.println("Searching for elements between 800 and 8000");
		resultArray = pQueue.getResults(800, 8000);
		testResult = resultArray[0];
		testResult2 = resultArray[1];
		System.out.println("The first element between 800 and 8000 is " + resultArray[0]);
		System.out.println("The second element between 800 and 8000 is " + resultArray[1]);
		timeElapsed = pQueue.getTime();
		System.out.println("The time elapsed was: "+timeElapsed+" milliseconds");
	}
	
	/**
	 * Method to test the calculated results with the known results evenPass and evenPass2
	 */
	public void testPriorityQ() { 
		assertEquals(evenPass, testResult); //tests for the number we are searching for
		assertEquals(evenPass2, testResult2); //tests for the number we are searching for
	}		
}
