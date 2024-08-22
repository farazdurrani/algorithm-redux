package com.algorithm.dynamiclist.sisteen;

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

    boolean isEmpty() {
	return first == null;
    }

    public void insertAtFront(E data) {
	Node<E> node = new Node<>(data);
	if (isEmpty()) {
	    first = last = node;
	} else {
	    node.next = first;
	    first = node;
	}
    }

    public void insertAtBack(E data) {
	Node<E> node = new Node<>(data);
	if (isEmpty()) {
	    first = last = node;
	} else {
	    Node<E> temp = first;
	    while (temp != last) {
		temp = temp.next;
	    }
	    last.next = node;
	    last = node;
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
	    Node<E> tmp = first;
	    while (tmp.next != last) {
		tmp = tmp.next;
	    }
	    tmp.next = null;
	    last = tmp;
	}
	return data;
    }

    public E delete(E data) {
	if (isEmpty()) {
	    System.out.println("It is empty");
	    return null;
	}
	if (first.data.compareTo(data) == 0) {
	    removeFromFront();
	    return data;
	}
	if (last.data.compareTo(data) == 0) {
	    removeFromBack();
	    return data;
	}
	Node<E> tmp = first;
	boolean deleted = false;
	while (tmp.next != null && tmp.next.data.compareTo(data) != 0) {
	    tmp = tmp.next;
	}
	if (tmp.next != null && tmp.next.data.compareTo(data) == 0) {
	    tmp.next = tmp.next.next;
	    deleted = true;
	}
	return deleted ? data : null;
    }

    public void reverse() {
	if(isEmpty()) {
	    System.out.println("Nothing to reverse");
	    return;
	}
	last = first;
	Node<E> tmp = first;
	Node<E> prv = null;
	while(tmp != null) {
	    Node<E> next = tmp.next;
	    tmp.next = prv;
	    prv = tmp;
	    tmp = next;
	}
	first = prv;
    }

}
