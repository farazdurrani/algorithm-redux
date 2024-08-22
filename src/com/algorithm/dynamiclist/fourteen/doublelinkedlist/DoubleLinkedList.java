package com.algorithm.dynamiclist.fourteen.doublelinkedlist;

public class DoubleLinkedList<E extends Comparable<E>> {

    private Node<E> first;
    private Node<E> last;

    public DoubleLinkedList() {
    }

    public void insertAtFront(E data) {
	Node<E> node = new Node<>(data);
	if (isEmpty()) {
	    first = last = node;
	} else {
	    first.prev = node;
	    node.next = first;
	    first = node;
	}
    }

    private boolean isEmpty() {
	return first == null;
    }

    public void printFromFront() {
	if (isEmpty()) {
	    printEmpty();
	    return;
	}
	Node<E> temp = first;
	while (temp != null) {
	    System.out.print(temp.data + " ");
	    temp = temp.next;
	}
	System.out.println();
    }

    public void printFromFrontRecursive() {
	printFromFrontRecursive(first);
	System.out.println();
    }

    private void printFromFrontRecursive(Node<E> node) {
	if (node == null) {
	    return;
	}
	System.out.print(node.data + " ");
	printFromFrontRecursive(node.next);
    }

    private void printEmpty() {
	System.out.println("It is empty");
    }

    public void printInReverse() {
	if (isEmpty()) {
	    printEmpty();
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
	Node<E> node = new Node<>(data);
	if (isEmpty()) {
	    first = last = node;
	} else {
	    node.prev = last;
	    last.next = node;
	    last = node;
	}

    }

    public E removeFromFront() {
	if (isEmpty()) {
	    printEmpty();
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
	    printEmpty();
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
	boolean del = false;
	if (isEmpty()) {
	    return del;
	}

	if (first.data.compareTo(data) == 0) {
	    del = removeFromFront() != null;
	} else if (last.data.compareTo(data) == 0) {
	    del = removeFromBack() != null;
	} else {
	    Node<E> temp = first;
	    while (temp != null && temp.data.compareTo(data) != 0) {
		temp = temp.next;
	    }

	    if (temp != null && temp.data.compareTo(data) == 0) {
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		del = true;
	    }
	}
	return del;
    }

    private class Node<E> {
	private Node<E> prev;
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
