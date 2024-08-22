package com.algorithm.dynamiclist.seventeen.doublelinkedlist;

public class StackDoublyLinked<E extends Comparable<E>> {

    private DoubleLinkedList<E> list = new DoubleLinkedList<>("Stack");

    public void push(E data) {
	list.insertAtFront(data);
    }

    public void print() {
	list.printFromFront();
    }

    public E pop() {
	return list.removeFromFront();
    }

    public boolean isEmpty() {
	return list.isEmpty();
    }

}
