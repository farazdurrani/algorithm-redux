package com.algorithm.dynamiclist.eleven.doublelinkedlist;

public class DoubleLinkedList<E> {

    private String name;
    private Node<E> first;
    private Node<E> last;

    public DoubleLinkedList() {
	this("Doubly-Linked Linked List");
    }

    public DoubleLinkedList(String name) {
	this.name = name;
	first = last = null;
    }

    public void insertAtFront(E data) {
	Node<E> newNode = new Node<>(data);
	if (isEmpty()) {
	    first = last = newNode;
	} else {
	    first.prev = newNode;
	    newNode.next = first;
	    first = newNode;
	}
    }

    private boolean isEmpty() {
	return first == null;
    }

    public void printFromFront() {
	if (isEmpty()) {
	    System.out.println(name + " is empty");
	    return;
	}
	Node<E> temp = first;
	while (temp != null) {
	    System.out.print(temp.data + " ");
	    temp = temp.next;
	}
	System.out.println();
    }

    public void printInReverse() {
	if (isEmpty()) {
	    System.out.println(name + " is empty");
	    return;
	}
	Node<E> temp = last;
	while (temp != null) {
	    System.out.print(temp.data + " ");
	    temp = temp.prev;
	}
	System.out.println();
    }

    public void insertAtBack(E data) {
	Node<E> newNode = new Node<>(data);
	if (isEmpty()) {
	    first = last = newNode;
	} else {
	    last.next = newNode;
	    newNode.prev = last;
	    last = newNode;
	}
    }

    public E removeFromFront() {
	if(isEmpty()) {
	    System.out.println(name + " is Empty");
	    return null;
	}
	E data = first.data;
	if(same()) {
	    first = last = null;
	} else {
	    first = first.next;
	    first.prev = null;
	}
	return data;
    }

    private boolean same() {
	return first == last;
    }

    public E removeFromBack() {
	if(isEmpty()) {
	    System.out.println(name + " is Empty");
	    return null;
	}
	E data = last.data;
	if(same()) {
	    first = last = null;
	} else {
	    last = last.prev;
	    last.next = null;
	}
	return data;
    }
}
