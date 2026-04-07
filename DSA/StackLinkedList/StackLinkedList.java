package org.pranav;

public class StackLinkedList implements List {

	Node head, tail;

	public StackLinkedList() {
		// TODO Auto-generated constructor stub
		this.head = null;
		this.tail = null;

	}

	public StackLinkedList(int element) {
		Node newNode = new Node(element);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void push(int element) {
		Node newNode = new Node(element);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public int pop() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;

		}
		Node tempHead = head;
		while (tempHead.next.next != null) {
			tempHead = tempHead.next;
		}
		int element = tempHead.next.data;
		tail = tempHead;
		tempHead.next = tail.next = null;
		return element;
	}

	public boolean isEmpty() {
		return (head == null && tail == null);
	}

	public void display() {
		Node tempHead = head;
		while (tempHead != null) {
			System.out.print(tempHead.data + " -> ");
			tempHead = tempHead.next;
		}
		System.out.println("null");
	}

	public int top() {
		if (isEmpty()) {
			return 0;
		}
		return tail.data;
	}

}
