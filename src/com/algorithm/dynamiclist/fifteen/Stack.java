package com.algorithm.dynamiclist.fifteen;

public class Stack<E extends Comparable<E>> {

    private LinkedList<E> list = new LinkedList<>();

    public void push(E data) {
	list.insertAtBack(data);
    }

    public void print() {
	list.print();
    }

    public E pop() {
	return list.removeFromBack();
    }

    public boolean isEmpty() {
	return list.isEmpty();
    }

}
