package com.algorithm.dynamiclist.ten;

public class LinkedList<E> {

    private Node<E> first;
    private Node<E> last;

    public void insertAtFront(E data) {
	if (first == null) {
	    first = last = new Node<>(data);
	} else {
	    Node<E> newNode = new Node<>(data);
	    newNode.next = first;
	    first = newNode;
	}
    }

    public E removeFromFront() {
	if (first == null) {
	    throw new RuntimeException("It is empty");
	} else {
	    E data = first.data;
	    if (first == last) {
		first = last = null;
	    } else {
		first = first.next;
	    }
	    return data;
	}
    }

    public void insertAtBack(E data) {
	if (first == null) {
	    first = last = new Node<>(data);
	} else {
	    Node<E> newNode = new Node<>(data);
	    last.next = newNode;
	    last = newNode;
	}
    }    

    public E removeFromBack() {
	if (first == null) {
	    throw new RuntimeException("It is empty");
	} else {
	    E data = last.data;
	    if (first == last) {
		first = last = null;
	    } else {
		Node<E> curr = first;
		while(curr.next != last) {
		    curr = curr.next;
		}
		last = curr;
		last.next = null;
	    }
	    return data;
	}
    }

    public void print() {
	if (first == null) {
	    return;
	}
	Node<E> node = first;
	while (node != null) {
	    System.out.print(node.data + " ");
	    node = node.next;
	}
	System.out.println();
    }

    public boolean isEmpty() {
	return first == null;
    }

}
