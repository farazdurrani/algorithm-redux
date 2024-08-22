package com.algorithm.dynamiclist.fourteen;

public class LinkedList<E extends Comparable<E>> {

    private Node<E> first;
    private Node<E> last;
    
    public LinkedList() { }

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
	if(isEmpty()) {
	    first = last = node;
	} else {
	    node.next = first;
	    first = node;
	}
    }

    public void insertAtBack(E data) {
	Node<E> node = new Node<>(data);
	if(isEmpty()) {
	    first = last = node;
	} else {
	    last = last.next = node;
	}
    }

    public E removeFromFront() {
	if(isEmpty()) {
	    System.out.println("Its empty");
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
	    System.out.println("Its empty");
	    return null;
	}
	E data = last.data;
	if(first == last) {
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
	boolean del = false;
	if(isEmpty()) {
	    return del;
	}
	if(first.data.compareTo(data) == 0) {
	    removeFromFront();
	    del = true;
	} else if(last.data.compareTo(data) == 0) {
	    removeFromBack();
	    del = true;
	} else {
	    Node<E> temp = first;
	    while(temp.next != null && temp.next.data.compareTo(data) != 0) {
		temp = temp.next;
	    }
	    if(temp != null && temp.next != null && temp.next.data.compareTo(data) == 0) {
		temp.next = temp.next.next;
		del = true;
	    }
	}
	return del;
    }

    private class Node<E> {
	private Node<E> next;
	private E data;

	public Node(E data) {
	    this.data = data;
	}

	@Override
	public String toString() {
	    return "Node [data=" + data + "]";
	}
	
    }

}
