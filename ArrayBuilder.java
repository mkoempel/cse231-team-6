package edu.oakland.production;

import java.util.*;
import edu.oakland.helper.PQueue;

public class ArrayBuilder{
	private int[] array1, array2, array3;
	private int arraySize1 = 20;
	private int arraySize2 = 2000;
	private int arraySize3 = 20000;
	
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
		PQueue pq = new PQueue(array1);
		pq.buildQueue();
		int[] values = pq.findValues();
		System.out.println(values[0]);
		System.out.println(values[1]);
	}
		
}