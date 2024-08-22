package com.algorithm.dynamiclist.seven;

public class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
	this(data, null);
    }

    public Node(E data, Node<E> next) {
	this.data = data;
	this.next = next;
    }
}
