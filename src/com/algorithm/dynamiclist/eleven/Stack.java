package com.algorithm.dynamiclist.eleven;

public class Stack<E> {
    private LinkedList<E> linkedList;
    
    public Stack() {
	this("Stack");
    }

    public Stack(String name) {
	linkedList = new LinkedList<>(name);
    }

    public void push(E data) {
	linkedList.insertAtBack(data);
    }

    public E pop() {
	return linkedList.removeFromBack();
    }

    public void print() {
	linkedList.print();
    }
}
