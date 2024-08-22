package com.algorithm.dynamiclist.one;

public class ListNode<E> {

    E data;
    ListNode<E> nextNode;

    public ListNode(E data) {
	this(data, null);
    }

    public ListNode(E data, ListNode<E> nextNode) {
	this.data = data;
	this.nextNode = nextNode;
    }

    public E getData() {
	return data;
    }

    public void setData(E data) {
	this.data = data;
    }

    public ListNode<E> getNextNode() {
	return nextNode;
    }

    public void setNextNode(ListNode<E> nextNode) {
	this.nextNode = nextNode;
    }
}
