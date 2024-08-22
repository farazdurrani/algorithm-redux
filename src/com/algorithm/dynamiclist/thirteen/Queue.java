package com.algorithm.dynamiclist.thirteen;

public class Queue<E extends Comparable<E>> {

    private LinkedList<E> list;

    public Queue() {
	this("Queue");
    }

    public Queue(String name) {
	list = new LinkedList<>(name);
    }

    public void enqueue(E data) {
	list.insertAtBack(data);
    }

    public void print() {
	list.print();
    }

    public E dequeue() {
	return list.removeFromFront();
    }

    public boolean isEmpty() {
	return list.isEmpty();
    }

}
