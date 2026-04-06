//package org.stack;
//
//
//public class StackFunctions implements Stack  {
//	private int stack[];
//	private int top;
//	
//	public StackFunctions(int size) {
//		stack=new int[size];
//		top=-1;
//	}
//	
//	
//	
//	public void push(int data)throws Exception{
//		if(isFull()) {
//			throw new Exception("Stack is full");
////			return;
//		}
//		
//		top=top+1;
//		stack[top]=data;
//		System.out.println(top);
//	}
//	
//	public int pop() throws Exception {
//
//			if(isEmpty()) {
//				throw new Exception ("stack is empty");
//			}
//			int data= stack[top];
//			top=top-1;
//			return data;
//		
//	}
//	
//	public int peek() throws Exception{
//	
//			if(isEmpty()) {
//				throw new Exception ("stack is full");
//			}
//			return stack[top];
//	
//	
//	}
//	
//	
//	
//	public boolean isEmpty() {
//		return (top==-1);
//	}
//	
//	
//	
//	public void isFull() {
//		boolean isfull = (top==stack.length-1);
//		if(isfull) {
//			resizearray(stack);
//			
//			
//		}
//		else {
//			return isfull;
//		}
//	}
//	
//	public void resizearray(int arr[]) {
//		 int size = arr.length;
//		int copyarr[] = new int[size];
//		System.arraycopy(arr, 0, copyarr, 0, size);
//		 arr = new int[size*2];
//		 System.arraycopy(arr, size, arr, 0, size);
//		
//	}
//	
//}
