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
		//create instance of QueueControl;
		QueueControl qControl = new QueueControl(10);
		
		//insert() elements and print Queue;
		qControl.insert("10");
		qControl.printQueue();
		qControl.insert("15");
		qCOntrol.printQueue();
		qControl.insert("25");
		qControl.printQueue();
		
		//do a priorityInsert() and print Queue;
		qControl.performPriorityInsert("16");
		qControl.printQueue();
		qControl.performPriorityInsert("25");
		qCOntrol.printQueue();
		qControl.performPriorityInsert("17");
		qControl.printQueue();
		
		//remove the front element;
		qControl.performRemove();
		qControl.printQueue();
		qControl.performPriorityInsert("28");
		qControl.printQueue();
	}
	
	public void insert(String input){
		if(numberOfItems + 1 <= queueSize){
			queueArray[rear] = input;
			rear++;
			
			numberOfItems++;
			System.out.println();
			System.out.print(input + " was added to the the rear of the Queue\n");
			System.out.println("The rear element, R, is " + rear);
			System.out.println("The front element, F, is " + front);
			System.out.println("The number of items is " + numberOfItems);
		}
		else{
			System.out.println("Sorry, but the Queue is full!");
		}
		
	}
	
	void performPriorityInsert(String input){
		int i = 0;
		++rear;
		if(front > 0){
			--front;
		}
		numberOfItems++;
		
		System.out.println("Performing priority insert of " + input);
		System.out.println("The front element, F, is " + front);
		System.out.println("The rear element, R, is " + rear);
		System.out.println("the next element is " + input);
		System.out.println("The number of items is " + numberOfItems);
		
		if (numberOfItems == 0){
			insert(input);
		}
		
		else{
			for (i = (numberOfItems - 1); i >= 0; i--){
				if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])){
					queueArray[i+1] = queueArray[i];
				}
				else break;
			}
			queueArray[i + 1] = input;
		}
	}
	
	public String peek(){
		System.out.println("The front element, F, value is " + queueArray[front]
	}
}
	
