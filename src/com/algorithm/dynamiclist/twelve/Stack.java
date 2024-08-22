package com.algorithm.dynamiclist.twelve;

public class Stack<E> {
    
    private String name;
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
