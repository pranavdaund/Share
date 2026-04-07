package org.pranav;

public class LinkedList implements List {

	Node head, tail;

	public LinkedList() {
		// TODO Auto-generated constructor stub
		this.head = null;
		this.tail = null;

	}

	public LinkedList(int element) {
		Node newNode = new Node(element);

		if (isEmpty()) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void addAtFront(int element) {
		Node newNode = new Node(element);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			Node tempHead = head;
			head = newNode;
			head.next = tempHead;
		}
	}

	public void addAtLast(int element) {
		Node newNode = new Node(element);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}

	}

	public void addAtPosition(int element, int pos) {
		if (pos < 0) {
			return;
		}
		Node newNode = new Node(element);
		if (isEmpty()) {
			head = tail = newNode;
			return;
		}
		Node tempHead = head;

		if (pos == 1) {
			Node oldHead = tempHead;
			tempHead = newNode;
			newNode.next = oldHead;
			head = tempHead;
			return;
		}
		for (int i = 1; i < pos - 1; i++) {
			if (tempHead.next == null) {
				break;
			}
			tempHead = tempHead.next;
		}
		Node oldPos = tempHead.next;
		tempHead.next = newNode;
		newNode.next = oldPos;
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

	public int delectAtFront() {
		if (isEmpty()) {
			return Integer.MIN_VALUE;
		}
		Node tempNode = head;
		if (tempNode.next == null) {
			int element = tempNode.data;
			head = tail = null;
			return element;
		} else {
			int element = tempNode.data;
			tempNode = tempNode.next;
			head = tempNode;
			return element;
		}
	}

	public int delectAtLast() {
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

}
