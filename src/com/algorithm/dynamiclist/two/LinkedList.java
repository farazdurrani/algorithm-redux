package com.algorithm.dynamiclist.two;

import java.util.NoSuchElementException;

public class LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private String name;

    public LinkedList() {
	this("Linked List");
    }

    public LinkedList(String name) {
	this(name, null, null);
    }

    private LinkedList(String name, Node<E> first, Node<E> last) {
	this.name = name;
	this.first = first;
	this.last = last;
    }

    public void insertAtFront(E data) {
	if (isEmpty()) {
	    first = last = new Node<E>(data);
	} else {
	    first = new Node<E>(data, first);
	}
    }

    public void insertAtBack(E data) {
	if (isEmpty()) {
	    first = last = new Node<E>(data);
	} else {
	    last = last.next = new Node<E>(data);
	}
    }
    
    public E removeFromFront() {
	if(isEmpty()) {
	    throw new NoSuchElementException(this.name + " is empty");
	} 
	E data = first.data;
	if(first == last) {
	    first = last = null;
	} else {
	    first = first.next;
	}
	return data;
    }
    
    public E removeFromBack() {
	if(isEmpty()) {
	    throw new NoSuchElementException(this.name + " is empty");
	}
	
	E data = last.data;
	if(first == last) {
	    first = last = null;
	} else {
	    Node<E> current = first;
	    while(current.next != last) {
		current = current.next;
	    }
	    last = current;
	    last.next = null;
	}
	return data;
    }

    public void print() {
	if (isEmpty()) {
	    System.out.println(this.name + " is empty.");
	} else {
	    Node<E> current = first;
	    while (null != current) {
		System.out.print(current.data + " ");
		current = current.next;
	    }
	    System.out.println();
	}
    }

    public boolean isEmpty() {
	return first == null;
    }

}
