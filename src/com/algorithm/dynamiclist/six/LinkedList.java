package com.algorithm.dynamiclist.six;

import java.util.NoSuchElementException;

public class LinkedList<E> {
    
    private Node<E> first;
    private Node<E> last;

    public LinkedList() {
	first = last = null;
    }

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

    private boolean isEmpty() {
	return first == null;
    }

    public void print() {
	if(isEmpty()) {
	    System.out.println("List is empty");
	    return;
	}
	Node<E> curr = first;
	while (curr != null) {
	    System.out.print(curr.data + " ");
	    curr = curr.next;
	}
	System.out.println();
    }

}
