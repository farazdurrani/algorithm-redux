package com.algorithm.dynamiclist.ten;

public class Stack<E> {
    
    private LinkedList<E> list = new LinkedList<>();

    public void push(E data) {
	list.insertAtFront(data);
    }

    public void print() {
	list.print();
    }

    public E pop() {
	return list.removeFromFront();
    }

    public boolean isEmpty() {
	return list.isEmpty();
    }

}
