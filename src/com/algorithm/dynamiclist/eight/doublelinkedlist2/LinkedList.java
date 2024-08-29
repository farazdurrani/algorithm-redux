package com.algorithm.dynamiclist.eight.doublelinkedlist2;

public class LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    int size;

    public void insertAtFront(E data) {
	Node<E> newNode = new Node<>(data);
	size++;
	if (isEmpty()) {
	    first = last = newNode;
	} else {
	    first.prev = newNode;
	    newNode.next = first;
	    first = newNode;
	}
    }

    public void insertAtBack(E data) {
	Node<E> newNode = new Node<>(data);
	size++;
	if (isEmpty()) {
	    first = last = newNode;
	} else {
	    last.next = newNode;
	    newNode.prev = last;
	    last = newNode;
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
	    first.prev = null;
	}
	size--;
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
	    last = last.prev;
	    last.next = null;
	}
	size--;
	return data;
    }

    private boolean isEmpty() {
	return first == null;
    }

    public void printFromFront() {
	if (isEmpty()) {
	    System.out.println("It is empty");
	    return;
	}

	Node<E> cur = first;
	while (cur != null) {
	    System.out.print(cur.data + " ");
	    cur = cur.next;
	}
	System.out.println();
    }

    public void printInReverse() {
	if (isEmpty()) {
	    System.out.println("It is empty");
	    return;
	}

	Node<E> curr = last;
	while (curr != null) {
	    System.out.print(curr.data + " ");
	    curr = curr.prev;
	}
	System.out.println();

    }

}
