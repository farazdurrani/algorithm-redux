package com.algorithm.dynamiclist.thirteen;

public class Stack<E extends Comparable<E>> {

    private LinkedList<E> list;

    public Stack() {
	this("Stack");
    }

    public Stack(String name) {
	list = new LinkedList<>(name);
    }

    public void push(E data) {
	list.insertAtBack(data);
    }

    public void print() {
	list.print();
    }

    public E pop() {
	return list.removeFromBack();
    }

}
