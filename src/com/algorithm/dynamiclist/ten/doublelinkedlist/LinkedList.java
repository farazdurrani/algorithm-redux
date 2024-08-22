package com.algorithm.dynamiclist.ten.doublelinkedlist;

public class LinkedList<E> {
    
    private Node<E> first;
    private Node<E> last;

    public void insertAtFront(E data) {
	Node<E> node = new Node<>(data);
	if(isEmpty()) {
	    first = last = node;
	} else {
	    first.prev = node;
	    node.next = first;
	    first = node;
	}
    }

    public E removeFromFront() {
	if(isEmpty()) {
	    throw new RuntimeException("Empty");
	}
	E data = first.data;
	if(first == last) {
	    first = last = null;
	} else {
	    first = first.next;
	    first.prev = null;
	}
	return data;
    }

    public void insertAtBack(E data) {
	Node<E> node = new Node<>(data);
	if(isEmpty()) {
	    first = last= node;
	} else {
	    last.next = node;
	    node.prev = last;
	    last = node;
	}
    }

    public E removeFromBack() {
	if(isEmpty()) {
	    throw new RuntimeException("Empty");
	}
	E data = last.data;
	if(first == last) {
	    first = last = null;
	} else {
	    last = last.prev;
	    last.next = null;
	}
	return data;
    }

    public boolean isEmpty() {
	return first == null;
    }

    public void printFromFront() {
	Node<E> cur = first;
	while(cur != null) {
	    System.out.print(cur.data + " ");
	    cur = cur.next;
	}
	System.out.println();
    }
    
    public void printInReverse() {
	Node<E> cur = last;
	while(cur != null) {
	    System.out.print(cur.data + " ");
	    cur = cur.prev;
	}
	System.out.println();
    }
}
