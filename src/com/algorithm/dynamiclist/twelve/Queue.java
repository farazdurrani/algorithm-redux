package com.algorithm.dynamiclist.twelve;

public class Queue<E> {

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

    public E dequeue() {
	return list.removeFromFront();
    }

    public void print() {
	list.print();
    }

    public boolean isEmpty() {
	return list.isEmpty();
    }

}
