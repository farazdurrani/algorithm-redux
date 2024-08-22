package com.algorithm.dynamiclist.nine;

public class Stack<T> {
    private LinkedList<T> ll = new LinkedList<>();
    private int size;
    public void push(T data) {
	ll.insertAtFront(data);
	size++;
    }

    public T pop() {
	size--;
	return ll.removeFromFront();	
    }

    public void print() {
	ll.print();
    }

    public boolean isEmpty() {
	return ll.isEmpty();
    }

    public int size() {
	
	return size;
    }
}
