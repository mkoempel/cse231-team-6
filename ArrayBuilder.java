package edu.oakland.production;

import java.util.*;
import edu.oakland.helper.PQueue;

public class ArrayBuilder{
	private int[] array1, array2, array3;
	private int arraySize1 = 20;
	private int arraySize2 = 2000;
	private int arraySize3 = 20000;
	int[] values;
	
	public static void main(String[] args){
		ArrayBuilder ab = new ArrayBuilder();
		ab.controlPQueue();
	}
	
	public ArrayBuilder(){
		array1 = new int[arraySize1];
		array2 = new int[arraySize2];
		array3 = new int[arraySize3];
		
		double temp;
		for (int i = 0; i < arraySize1; i++){
			temp = (Math.random() * 19980);
			array1[i] = (int)temp + 20;
		}
		
		for (int i = 0; i < arraySize2; i++){
			temp = (Math.random() * 19980);
			array2[i] = (int)temp + 20;
		}
		
		for (int i = 0; i < arraySize3; i++){
			temp = (Math.random() * 19980);
			array3[i] = (int)temp + 20;
		}
	}
	
	public void controlPQueue(){
		PQueue pq1 = new PQueue(array1);
		pq1.buildQueue();
		pq1.printQueue();
		values = pq1.findValues();
		System.out.println(values[0]);
		System.out.println(values[1]);
		System.out.println("elapsed time: " + pq1.getElapsedTime());
		
		PQueue pq2 = new PQueue(array2);
		pq2.buildQueue();
		values = pq2.findValues();
		System.out.println(values[0]);
		System.out.println(values[1]);
		System.out.println("elapsed time: " + pq2.getElapsedTime());
		
		PQueue pq3 = new PQueue(array3);
		pq3.buildQueue();
		values = pq3.findValues();
		System.out.println(values[0]);
		System.out.println(values[1]);
		System.out.println("elapsed time: " + pq3.getElapsedTime());
		
	}
		
}