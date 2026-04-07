package org.pranav;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList L1 = new LinkedList();
		L1.addAtLast(10);
		L1.addAtLast(20);
		L1.addAtLast(30);
//		L1.addAtFront(40);
		L1.display();

		System.out.println("Delect operation");
//		L1.delectAtFront();
//		L1.display();
		System.out.println(L1.delectAtLast());
		L1.display();

	}

}
