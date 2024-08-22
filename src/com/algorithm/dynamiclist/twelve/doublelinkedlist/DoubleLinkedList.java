package com.algorithm.dynamiclist.twelve.doublelinkedlist;

public class DoubleLinkedList<E extends Comparable<E>> {

    private Node<E> first;
    private Node<E> last;
    private String name;

    public DoubleLinkedList() {
	this("Double LinkedList");
    }

    public DoubleLinkedList(String name) {
	this.name = name;
	first = last = null; // symbolic representation
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

    public void printInReverse() {
	if (isEmpty()) {
	    System.out.println(this.name + " is empty");
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
	    newNode.prev = last;
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
	    first.prev = null;
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
	    last = last.prev;
	    last.next = null;
	}
	return data;
    }

    public boolean remove(E data) {
	if (isEmpty()) {
	    return false;
	}
	if (first.data.compareTo(data) == 0) {
	    first = first.next;
	    first.prev = null;
	    return true;
	}

	if (last.data.compareTo(data) == 0) {
	    last = last.prev;
	    last.next = null;
	    return true;
	}
	boolean removed = false;
	Node<E> temp = first.next;
	while (last != temp && null != temp) {
	    if (temp.data.compareTo(data) == 0) {
		temp.prev.next = temp.next;
		removed = true;
		temp = last;
	    } else {
		temp = temp.next;
	    }
	}
	return removed;
    }

    private class Node<S> {

	private Node<S> prev;
	private Node<S> next;
	private S data;

	public Node(S data) {
	    this.data = data;
	    prev = next = null; // symbolic representation
	}

	@Override
	public String toString() {
	    return "[data=" + data + "]";
	}
    }
}
