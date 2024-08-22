package com.algorithm.dynamiclist.ten;

public class Queue<E> {

    private LinkedList<E> list = new LinkedList<>();
    
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
