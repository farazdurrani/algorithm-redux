package com.algorithm.dynamiclist.three;

public class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
	this(data, null);
    }

    public Node(E data, Node<E> node) {
	this.data = data;
	this.next = node;
    }

}
