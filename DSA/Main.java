package org.stack;

public class Main {
	public static void main(String[] args) {
		Stack stack = new StackFunctions2(4);
		stack.push(10);
		stack.push(12);
		stack.push(23);
		stack.push(13);
		stack.push(33);
		stack.push(63);
		try {

			System.out.println(stack.peek());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		} catch (Exception e) {
			// TODO Auto-generated catch block

			System.err.print("Error" + e.getMessage());
		}
//		

	}

}
