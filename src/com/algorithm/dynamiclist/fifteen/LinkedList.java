package com.algorithm.dynamiclist.fifteen;

public class LinkedList<E extends Comparable<E>> {

    private Node<E> first;
    private Node<E> last;

    public void print() {
	if (isEmpty()) {
	    System.out.println("It is empty");
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
	Node<E> node = new Node<E>(data);
	if (isEmpty()) {
	    first = last = node;
	} else {
	    node.next = first;
	    first = node;
	}
    }

    public void insertAtBack(E data) {
	Node<E> node = new Node<E>(data);
	if (isEmpty()) {
	    first = last = node;
	} else {
	    last = last.next = node;
	}
    }

    public E removeFromFront() {
	if (isEmpty()) {
	    System.out.println("It is empty");
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
	    System.out.println("It is empty");
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
	boolean deleted = false;
	if (isEmpty()) {
	    System.out.println("It is empty");
	    return false;
	}
	if (first.data.compareTo(data) == 0) {
	    removeFromFront();
	    deleted = true;
	} else if (last.data.compareTo(data) == 0) {
	    removeFromBack();
	    deleted = true;
	} else {
	    Node<E> temp = first;
	    while (temp.next != null && temp.next.data.compareTo(data) != 0) {
		temp = temp.next;
	    }
	    if (temp.next != null && temp.next.data.compareTo(data) == 0) {
		temp.next = temp.next.next;
		deleted = true;
	    }
	}
	return deleted;
    }

    public void reverse() {
	if(isEmpty()) {
	    System.out.println("It is empty");
	    return;
	}
	last = first;
	Node<E> cur = first;
	Node<E> prev = null;
	while(cur != null) {
	    Node<E> next = cur.next;
	    cur.next = prev;
	    prev = cur;
	    cur = next;
	}
	first = prev;
    }

    private class Node<E extends Comparable<E>> {
	E data;
	Node<E> next;

	public Node(E data) {
	    this.data = data;
	}

	@Override
	public String toString() {
	    return data.toString();
	}
    }

}
