package org.stack;

public class StackFunctions2 implements Stack {
	private int stack2[];
	private int top;

	public StackFunctions2(int size) {
		stack2 = new int[size];
		top = -1;
	}

	public void push(int data) {
		if (top == stack2.length - 1) {
			resizearray(stack2);
		}
		top = top + 1;
		stack2[top] = data;
//		System.out.println(top);
	}

	public int pop() throws Exception {

		if (isEmpty()) {
			throw new Exception("stack is empty");
		}
		int data = stack2[top];
		top = top - 1;
		return data;

	}

	public int peek() throws Exception {

		if (isEmpty()) {
			throw new Exception("stack is full");
		}
		return stack2[top];

	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public void isFull2() {

		if (top == stack2.length - 1) {
			resizearray(stack2);

		}
	}

	public void resizearray(int stack2[]) {
		int size = stack2.length;
		int copyarr[] = new int[size];
		System.arraycopy(stack2, 0, copyarr, 0, size - 1);
		this.stack2 = new int[size * 2];
		System.arraycopy(copyarr, 0, this.stack2, 0, size - 1);

	}

}
