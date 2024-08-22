package com.algorithm.dynamiclist.eighteen.doublelinkedlist;

public class Queue<E extends Comparable<E>> {

	private DoubleLinkedList<E> list = new DoubleLinkedList<>();

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
