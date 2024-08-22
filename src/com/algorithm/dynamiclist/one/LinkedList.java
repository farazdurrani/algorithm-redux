package com.algorithm.dynamiclist.one;

import java.util.NoSuchElementException;

public class LinkedList<E> {
    private ListNode<E> first;
    private ListNode<E> last;
    private String name;

    public LinkedList() {
	this("list", null);
    }

    public LinkedList(String name, ListNode<E> node) {
	this.name = name;
	first = last = node;
    }

    public void insertAtFront(E data) {
	if (isEmpty()) {
	    first = last = new ListNode<E>(data);
	} else {
	    first = new ListNode<E>(data, first);
	}
    }

    public void insertAtBack(E data) {
	if (isEmpty()) {
	    first = last = new ListNode<E>(data);
	} else {
	    last = last.nextNode = new ListNode<E>(data);
	}
    }

    public E removeFromFront() throws NoSuchElementException {
	if (isEmpty()) {
	    throw new NoSuchElementException(this.name + " has no elements!");
	}
	E dataToReturn = first.data;
	if (first == last) {
	    first = last = null;
	} else {
	    first = first.nextNode;
	}
	return dataToReturn;
    }
    
    public E removeFromBack() throws NoSuchElementException {
	if(isEmpty()) {
	    throw new NoSuchElementException(this.name + " has no elements!");
	}
	E dataToReturn = last.data;
	if(first == last) {
	    first = last = null;
	} else {
	    ListNode<E> current = first;
	    while(current.nextNode != last) {
		current = current.nextNode;
	    }
	    last = current;
	    last.nextNode = null;
	}
	return dataToReturn;
    }

    public boolean isEmpty() {
	return first == null;
    }

    public void print() {
	if (isEmpty()) {
	    System.out.println(this.name + " is empty");
	    return;
	} else {
	    ListNode<E> current = first;
	    while (null != current) {
		System.out.print(current.data + " ");
		current = current.nextNode;
	    }
	    System.out.println();
	}
    }

}
