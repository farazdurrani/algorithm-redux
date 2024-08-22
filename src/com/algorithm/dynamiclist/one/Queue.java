package com.algorithm.dynamiclist.one;

public class Queue<E> {

    private LinkedList<E> node;

    public Queue() {
	this("Queue");
    }

    public Queue(String name) {
	node = new LinkedList<E>(name, null);
    }

    public void enqueue(E data) {
	node.insertAtBack(data);
    }

    public E dequeue() {
	return node.removeFromFront();
    }

    public void print() {
	node.print();

    }

	public boolean isEmpty() {
		return node.isEmpty();
	}
}
