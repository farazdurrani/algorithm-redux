package com.algorithm.dynamiclist.three;

public class LinkedList<E> {
    Node<E> first;
    Node<E> last;

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

    private boolean isEmpty() {
	return first == null;
    }

    public void print() {
	if (isEmpty()) {
	    System.out.println("It is empty");
	    return;
	}
	Node<E> cur = first;
	while (null != cur) {
	    System.out.print(cur.data + " ");
	    cur = cur.next;
	}
	System.out.println();
    }

    public E removeFromFront() {
	if (isEmpty()) {
	    System.out.println("Nothing to delete");
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
	    System.out.println("Nothing to delete");
	    return null;
	}
	E data = last.data;
	if (first == last) {
	    first = last = null;
	} else {
	    Node<E> cur = first;
	    while (cur.next != last) {
		cur = cur.next;
	    }
	    last = cur;
	    last.next = null;
	}
	return data;
    }
}
