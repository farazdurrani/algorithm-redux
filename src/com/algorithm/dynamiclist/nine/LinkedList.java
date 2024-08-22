package com.algorithm.dynamiclist.nine;

public class LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    

    public void insertAtFront(E data) {
	if (isEmpty()) {
	    first = last = new Node<>(data);
	} else {
	    Node<E> newNode = new Node<>(data);
	    newNode.next = first;
	    first = newNode;
	}
    }

    public void insertAtBack(E data) {
	if (isEmpty()) {
	    first = last = new Node<>(data);
	} else {
	    Node<E> newNode = new Node<>(data);
	    last.next = newNode;
	    last = newNode;
	}
    }

    boolean isEmpty() {
	return first == null;
    }

    public void print() {
	if (isEmpty()) {
	    System.err.println("List is empty");
	    return;
	}
	Node<E> curr = first;
	while (curr != null) {
	    System.out.print(curr.data + " ");
	    curr = curr.next;
	}
	System.out.println();
    }

    public E removeFromFront() {
	if (isEmpty()) {
	    System.err.println("LinkedList is empty");
	    return null;
	}
	E data = first.data;
	if (first == last) {
	    first = last = null;
	} else {
	    first = first.next;
	}
	return data;
    }

    public E removeFromBack() {
	if (isEmpty()) {
	    System.err.println("LinkedList is empty");
	    return null;
	}
	E data = last.data;
	if (first == last) {
	    first = last = null;
	} else {
	    Node<E> curr = first;
	    while (curr.next != last) {
		curr = curr.next;
	    }
	    last = curr;
	    last.next = null;
	}
	return data;
    }
}
