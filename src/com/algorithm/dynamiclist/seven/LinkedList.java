package com.algorithm.dynamiclist.seven;

import java.util.NoSuchElementException;

public class LinkedList<E> {

    private Node<E> first;
    private Node<E> last;

    public void insertAtFront(E data) {
	if (isEmpty()) {
	    first = last = new Node<>(data);
	} else {
	    first = new Node<>(data, first);
	}
    }

    public void insertAtBack(E data) {
	if (isEmpty()) {
	    first = last = new Node<>(data);
	} else {
	    last = last.next = new Node<>(data);
	}
    }

    public E removeFromFront() {
	if (isEmpty()) {
	    throw new NoSuchElementException("It is empty");
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
	    throw new NoSuchElementException("It is empty");
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

    public void print() {
	if (isEmpty()) {
	    System.err.println("It is empty");
	    return;
	}

	Node<E> curr = first;
	while (curr != null) {
	    System.out.print(curr.data + " ");
	    curr = curr.next;
	}

	System.out.println();

    }

    boolean isEmpty() {
	return first == null;
    }

}
