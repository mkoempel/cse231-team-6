//This is the code from the monograph


package edu.oakland.production;

import java.util.*;

public class QueueControl extends PriorityQueue{
	
	private String[] queueArray;
	private int queueSize;
	private int front, numberOfItems, rear = 0;
	private DisplayQueue display;
	
	public Queue Control(int size){
		queueSize = size;
		queueArray = new String[size];
		//control what prints when queue is printed
		Arrays.fill(queueArray, "-1");
	}
	
	public static void main(String[] args) {
		
	}
	
	
	/*
	constructor takes 3 arrays
	3 return methods, one for each size
	*/
