package com.algorithm.dynamiclist.eight.doublelinkedlist;

public class LinkedList<E> {

    private Node<E> head;
    private Node<E> tail;

    public LinkedList() {
	head = tail = null;
    }

    public void insertAtFront(E data) {
	if (isEmpty()) {
	    head = tail = new Node<>(data);
	} else {
	    Node<E> newNode = new Node<>(data);
	    head.prev = newNode;
	    newNode.next = head;
	    head = newNode;

	}
    }

    public void insertAtBack(E data) {
	if (isEmpty()) {
	    head = tail = new Node<>(data);
	} else {
	    Node<E> newNode = new Node<>(data);
	    newNode.prev = tail;
	    tail.next = newNode;
	    tail = newNode;
	}
    }

    public E removeFromFront() {
	if (isEmpty()) {
	    throw new RuntimeException("It is empty");
	}
	E data = head.data;
	if (head == tail) {
	    head = tail = null;
	} else {
	    Node<E> curr = tail;
	    while (curr.prev != head) {
		curr = curr.prev;
	    }
	    curr.prev = null;
	    head = head.next;
	}
	return data;
    }

    private boolean isEmpty() {
	return head == null;
    }

    public void printInReverse() {
	if (isEmpty()) {
	    System.err.println("It is empty");
	    return;
	}

	Node<E> curr = tail;
	while (curr != null) {
	    System.out.printf("%4d", curr.data);
	    curr = curr.prev;
	}
	System.out.println();
    }

    public void printFromFront() {
	if (isEmpty()) {
	    System.err.println("It is empty");
	    return;
	}

	Node<E> curr = head;
	while (curr != null) {
	    System.out.printf("%4d", curr.data);
	    curr = curr.next;
	}
	System.out.println();
    }

    public E removeFromBack() {
	if (isEmpty()) {
	    throw new RuntimeException("It is empty");
	}
	E data = tail.data;
	if (head == tail) {
	    head = tail = null;
	} else {
	    tail = tail.prev;
	    Node<E> curr = head;
	    while (true) {
		curr = curr.next;
		if (curr == tail) {
		    curr.next = null;
		    break;
		}
	    }
	}
	return data;
    }

}
