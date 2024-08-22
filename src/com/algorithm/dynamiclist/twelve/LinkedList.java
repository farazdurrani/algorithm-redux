package com.algorithm.dynamiclist.twelve;

public class LinkedList<E> {

    private String name;
    private Node<E> first;
    private Node<E> last;
    
    public LinkedList() {
	this("Linked List");
    }

    public LinkedList(String name) {
	this.name = name;
	//symbolic representation
	first = last = null;
    }
    
    public void insertAtFront(E data) {
	Node<E> newNode = new Node<>(data);
	if(isEmpty()) {
	    first = last = newNode;
	} else {
	    newNode.next = first;
	    first = newNode;
	}
    }
    
    public boolean isEmpty() {
	return first == null;
    }

    public void print() {
	if(isEmpty()) {
	    System.out.println(this.name + " is empty.");
	    return;
	}
	
	Node<E> temp = first;
	while(temp != null) {
	    System.out.print(temp.data + " ");
	    temp = temp.next;
	}
	System.out.println();
    }

    public void insertAtBack(E data) {
	Node<E> newNode = new Node<>(data);
	if(isEmpty()) {
	    first = last = newNode;
	} else {
	   last.next = newNode;
	   last = newNode;
	}
    }

    public E removeFromFront() {
	if(isEmpty()) {
	    System.out.println(this.name + " is empty.");
	    return null;
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
	    System.out.println(this.name + " is empty.");
	    return null;
	}
	E data = last.data;
	if(first == last) {
	    first = last = null;
	} else {
	    Node<E> temp = first;
	    while(temp.next != last) {
		temp = temp.next;
	    }
	    last = temp;
	    last.next = null;
	}
	return data;
    }
}
