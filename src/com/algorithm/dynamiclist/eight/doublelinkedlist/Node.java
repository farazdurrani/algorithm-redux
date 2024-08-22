package com.algorithm.dynamiclist.eight.doublelinkedlist;

public class Node<E> {

    Node<E> prev;
    Node<E> next;
    E data;

    public Node(E data) {
	this(data, null, null);
    }

    public Node(E data, Node<E> prev, Node<E> next) {
	this.data = data;
	this.prev = prev;
	this.next = next;
    }
}
