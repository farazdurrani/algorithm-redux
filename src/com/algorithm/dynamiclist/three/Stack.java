package com.algorithm.dynamiclist.three;

public class Stack<E> {

    private LinkedList<E> list;

    public Stack() {
	list = new LinkedList<>();
    }

    public void push(E data) {
	list.insertAtFront(data);
    }

    public E pop() {
	return list.removeFromFront();
    }

    public void print() {
	list.print();
    }
}
