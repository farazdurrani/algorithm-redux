package com.algorithm.dynamiclist.eight.doublelinkedlist2;

public class Node<E> {
    E data;
    Node<E> prev;
    Node<E> next;

    public Node(E data) {
	this.data = data;
    }
}
