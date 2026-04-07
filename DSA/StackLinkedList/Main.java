package org.pranav;

public class Main {

	public static void main(String[] args) {

		StackLinkedList s1 = new StackLinkedList();
		s1.push(10);
		s1.push(20);
		s1.push(30);

		System.out.println(s1.pop());

		s1.display();
	}

}
