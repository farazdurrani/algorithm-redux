package com.algorithm.dynamiclist.eleven;

public class Queue<E> {
    private LinkedList<E> list;
    
    public Queue() {
	this("Queue");
    }
    public Queue(String name) {
	this.list = new LinkedList<E>(name);
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
