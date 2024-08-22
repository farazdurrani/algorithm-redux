package com.algorithm.dynamiclist.sisteen;

public class Stack<E extends Comparable<E>> {

    private LinkedList<E> list = new LinkedList<>();
    
    public void push(E data) {
	list.insertAtBack(data);
    }

    public E pop() {
	return list.removeFromBack();
    }

    public void print() {
	list.print();
    }
    
    public boolean isEmpty() {
	return list.isEmpty();
    }

}
