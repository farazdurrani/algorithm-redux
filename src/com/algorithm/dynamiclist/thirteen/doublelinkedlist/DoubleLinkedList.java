package com.algorithm.dynamiclist.thirteen.doublelinkedlist;

public class DoubleLinkedList<E extends Comparable<E>> {

    private Node<E> first;
    private Node<E> last;
    private String name;

    public DoubleLinkedList() {
	this("Doubly-Linked Linked List");
    }

    public DoubleLinkedList(String name) {
	this.name = name;
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
	    System.out.println(this.name + " is empty.");
	    return;
	}
	Node<E> temp = first;
	while (temp != null) {
	    System.out.print(temp.data + " ");
	    temp = temp.next;
	}
	System.out.println();
    }

    public void insertAtBack(E data) {
	Node<E> newNode = new Node<>(data);
	if (isEmpty()) {
	    first = last = newNode;
	} else {
	    newNode.prev = last;
	    last = last.next = newNode;
	}
    }

    public void printInReverse() {
	if (isEmpty()) {
	    System.out.println(this.name + " is empty.");
	    return;
	}
	Node<E> temp = last;
	while (temp != null) {
	    System.out.print(temp.data + " ");
	    temp = temp.prev;
	}
	System.out.println();
    }

    public E removeFromFront() {
	if (isEmpty()) {
	    System.out.println(this.name + " is empty.");
	    return null;
	}
	E data = first.data;
	if (first == last) {
	    first = last = null;
	} else {
	    first = first.next;
	    first.prev = null;
	}
	return data;
    }

    public E removeFromBack() {
	if (isEmpty()) {
	    System.out.println(this.name + " is empty.");
	    return null;
	}
	E data = last.data;
	if (first == last) {
	    first = last = null;
	} else {
	    last = last.prev;
	    last.next = null;
	}
	return data;
    }

    public boolean delete(E data) {
	if (isEmpty()) {
	    return false;
	}
	if (first.data.compareTo(data) == 0) {
	    return removeFromFront() != null;
	}
	if (last.data.compareTo(data) == 0) {
	    return removeFromBack() != null;
	}
	boolean del = false;
	Node<E> temp = first.next;
	while(temp != null && temp.data.compareTo(data) != 0) {
	    temp = temp.next;
	}
	if(temp != null && temp.data.compareTo(data) == 0) {
	    temp.next.prev = temp.prev;
	    temp.prev.next = temp.next;
	    del = true;
	}
	return del;
    }

    private class Node<V> {
	private Node<V> next;
	private Node<V> prev;
	private V data;

	public Node(V data) {
	    this.data = data;
	}
    }

}
