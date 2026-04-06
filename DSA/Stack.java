package org.stack;

public interface Stack {

	void push(int data);

	int pop() throws Exception;

	int peek() throws Exception;

	boolean isEmpty();

//	boolean isFull();

	void isFull2();

}
