package com.algorithm.dynamiclist.fifteen.doublelinkedlist;

public class DoubleLinkedList<E extends Comparable<E>> {

    private Node<E> first;
    private Node<E> last;

    public void insertAtFront(E data) {
	Node<E> node = new Node<>(data);
	if (isEmpty()) {
	    first = last = node;
	} else {
	    node.next = first;
	    first.prev = node;
	    first = node;
	}
    }

    public boolean isEmpty() {
	return first == null;
    }

    public void printFromFrontRecursive() {
	printFromFromRecursive(first);
	System.out.println();
    }

    private void printFromFromRecursive(Node<E> node) {
	if (node == null) {
	    return;
	}
	System.out.print(node.data + " ");
	printFromFromRecursive(node.next);
    }

    public void printFromFront() {
	if (isEmpty()) {
	    System.out.println("It is empty");
	    return;
	}
	Node<E> node = first;
	while (node != null) {
	    System.out.print(node.data + " ");
	    node = node.next;
	}
	System.out.println();
    }

    public void printInReverse() {
	if (isEmpty()) {
	    System.out.println("It is empty");
	    return;
	}

	Node<E> node = last;
	while (node != null) {
	    System.out.print(node.data + " ");
	    node = node.prev;
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
	return data;
    }

    public boolean delete(E data) {
	if (isEmpty()) {
	    System.out.println("It is empty");
	    return false;
	}
	boolean deleted = false;
	if (first.data.compareTo(data) == 0) {
	    removeFromFront();
	    deleted = true;
	} else if (last != null && last.data.compareTo(data) == 0) {
	    removeFromBack();
	    deleted = true;
	} else {
	    Node<E> node = first;
	    while (node != null && node.data.compareTo(data) != 0) {
		node = node.next;
	    }
	    if (node != null && node.data.compareTo(data) == 0) {
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		prev.next = next;
		next.prev = prev;
		deleted = true;
	    }
	}

	return deleted;
    }

    private class Node<E extends Comparable<E>> {
	private Node<E> prev;
	private Node<E> next;
	private E data;

	public Node(E data) {
	    this.data = data;
	}

	@Override
	public String toString() {
	    return String.valueOf(data);
	}

    }

    public void reverse() {
	if(isEmpty()) {
	    return;
	}
	last = first;
	Node<E> fNode = first;
	Node<E> lNode = null;
	while(fNode != null) {
	    Node<E> prev = fNode.prev;
	    Node<E> next = fNode.next;
	    fNode.prev = next;
	    fNode.next = prev;
	    lNode = fNode;
	    fNode = next;
	}
	first = lNode;
    }

}
