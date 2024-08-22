package com.algorithm.dynamiclist.sisteen.doublelinkedlist;

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

    private boolean isEmpty() {
	return first == null;
    }

    public void printFromFrontRecursive() {
	if (isEmpty()) {
	    System.out.println("It is empty");
	    return;
	}
	Node<E> tmp = first;
	printFromFrontRecursirve(tmp);
	System.out.println();
    }

    private void printFromFrontRecursirve(Node<E> node) {
	if (node != null) {
	    System.out.print(node.data + " ");
	    printFromFrontRecursirve(node.next);
	}
    }

    public void printFromFront() {
	if (isEmpty()) {
	    System.out.println("It is empty");
	    return;
	}
	Node<E> tmp = first;
	while (tmp != null) {
	    System.out.print(tmp.data + " ");
	    tmp = tmp.next;
	}
	System.out.println();
    }

    public void printInReverse() {
	if (isEmpty()) {
	    System.out.println("It is empty");
	    return;
	}
	Node<E> tmp = last;
	while (tmp != null) {
	    System.out.print(tmp.data + " ");
	    tmp = tmp.prev;
	}
	System.out.println();
    }

    public void insertAtBack(E data) {
	Node<E> node = new Node<>(data);
	if (isEmpty()) {
	    first = last = node;
	} else {
	    last.next = node;
	    node.prev = last;
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

    public E delete(E data) {
	if (isEmpty()) {
	    System.out.println("It is empty");
	    return null;
	}
	if (first.data.compareTo(data) == 0) {
	    removeFromFront();
	    return data;
	} else if (last.data.compareTo(data) == 0) {
	    removeFromBack();
	    return data;
	} else {
	    boolean deleted = false;
	    Node<E> tmp = first;
	    while (tmp != null && tmp.data.compareTo(data) != 0) {
		tmp = tmp.next;
	    }
	    if (tmp != null && tmp.data.compareTo(data) == 0) {
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;
		deleted = true;
	    }
	    if (deleted) {
		return data;
	    } else {
		return null;
	    }
	}
    }

    public void reverse() {
	if (isEmpty()) {
	    System.out.println("It is empty");
	    return;
	}
	last = first;
	Node<E> tmp = first;
	Node<E> futureFirst = null;
	while (tmp != null) {
	    Node<E> prev = tmp.prev;
	    Node<E> next = tmp.next;
	    tmp.prev = next;
	    tmp.next = prev;
	    futureFirst = tmp;
	    tmp = next;
	}
	first = futureFirst;
    }

}
