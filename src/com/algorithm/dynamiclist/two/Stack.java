package com.algorithm.dynamiclist.two;

public class Stack<E> {
    private LinkedList<E> list;

    public Stack() {
	this("Stack");
    }

    public Stack(String name) {
	list = new LinkedList<>(name);
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
