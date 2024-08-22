package com.algorithm.dynamiclist.eleven;

public class LinkedList<E> {
    
    private Node<E> first;
    private Node<E> last;
    private String name;
    
    public LinkedList() {
	this("LinkedList");
    }
    
    public LinkedList(String name) {
	this.name = name;
	first = last = null;
    }

    public void insertAtFront(E data) {
	if(isEmpty()) {
	    first = last = new Node<>(data);
	} else {
	    Node<E> newNode = new Node<>(data);
	    newNode.next = first;
	    first = newNode;
	}
    }
    
    public void insertAtBack(E data) {
	if(isEmpty()) {
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
	if(isEmpty()) {
	    System.out.println(name + " is empty");
	    return;
	} 
	Node<E> node = first;
	while(node != null) {
	    System.out.print(node.data);
	    node = node.next;
	}
	System.out.println();
    }

    public E removeFromFront() {
	if(isEmpty()) {
	    System.out.println(name + " is empty");
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
	    System.err.println(name + " is empty");
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
