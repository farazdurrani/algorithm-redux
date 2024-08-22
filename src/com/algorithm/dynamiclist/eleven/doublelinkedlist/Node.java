package com.algorithm.dynamiclist.eleven.doublelinkedlist;

public class Node<E> {
    E data;
    Node<E> prev;
    Node<E> next;
    
    public Node(E data) {
	this.data = data;
	prev = next = null;
    }

    @Override
    public String toString() {
	return "[data=" + data + "]";
    }
}
