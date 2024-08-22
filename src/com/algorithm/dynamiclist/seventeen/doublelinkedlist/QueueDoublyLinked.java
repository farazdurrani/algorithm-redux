package com.algorithm.dynamiclist.seventeen.doublelinkedlist;

public class QueueDoublyLinked<E extends Comparable<E>> {

    private DoubleLinkedList<E> list = new DoubleLinkedList<>("Queue");

    public void enqueue(E data) {
	list.insertAtBack(data);
    }

    public void print() {
	list.printFromFront();
    }

    public E dequeue() {
	return list.removeFromFront();
    }

    public boolean isEmpty() {
	return list.isEmpty();
    }

}
