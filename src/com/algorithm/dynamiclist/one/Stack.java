package com.algorithm.dynamiclist.one;

public class Stack<E> {

    private LinkedList<E> node;

    public Stack() {
	this("stack");
    }

    public Stack(String name) {
	node = new LinkedList<E>(name, null);
    }

    public void push(E data) {
	node.insertAtFront(data);
    }

    public E pull() {
	return node.removeFromFront();
    }
    
    public void print() {
	node.print();
    }
}
