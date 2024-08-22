package com.algorithm.dynamiclist.thirteen;

public class LinkedList<E extends Comparable<E>>{

    private String name;
    private Node<E> first;
    private Node<E> last;

    public LinkedList() {
	this("Single Linked List");
    }

    public LinkedList(String name) {
	this.name = name;
    }

    public void print() {
	if (isEmpty()) {
	    System.out.println(this.name + " is empty");
	    return;
	}
	Node<E> temp = first;
	while (temp != null) {
	    System.out.print(temp.data + " ");
	    temp = temp.next;
	}
	System.out.println();
    }

    public boolean isEmpty() {
	return first == null;
    }

    public void insertAtFront(E data) {
	Node<E> newNode = new Node<>(data);
	if (isEmpty()) {
	    first = last = newNode;
	} else {
	    newNode.next = first;
	    first = newNode;
	}
    }

    public void insertAtBack(E data) {
	Node<E> newNode = new Node<>(data);
	if (isEmpty()) {
	    first = last = newNode;
	} else {
	    last.next = newNode;
	    last = newNode;
	}
    }

    public E removeFromFront() {
	if (isEmpty()) {
	    System.out.println(this.name + " is empty");
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
	    System.out.println(this.name + " is empty");
	    return null;
	}
	E data = last.data;
	if (first == last) {
	    first = last = null;
	} else {
	    Node<E> temp = first;
	    while (temp.next != last) {
		temp = temp.next;
	    }
	    last = temp;
	    last.next = null;
	}
	return data;
    }

    public boolean delete(E data) {
	if (isEmpty()) {
	    return false;
	}
	if (first.data.compareTo(data) == 0) {
	    removeFromFront();
	    return true;
	}
	if (last.data.compareTo(data) == 0) {
	    removeFromBack();
	    return true;
	}
	boolean found = false;
	Node<E> temp = first;
	while (temp != null && temp.next != null && temp.next.data.compareTo(data) != 0) {
	    temp = temp.next;
	}
	if (temp.next != null && temp.next.data.compareTo(data) == 0) {
	    temp.next = temp.next.next;
	    found = true;
	}
	return found;
    }

    private class Node<V> {
	private Node<V> next;
	private V data;

	public Node(V data) {
	    this.data = data;
	}

	@Override
	public String toString() {
	    return String.valueOf(data);
	}

    }
}
