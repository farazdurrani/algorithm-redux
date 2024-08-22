package com.algorithm.dynamiclist.sisteen.doublelinkedlist;

public class Node<T> {
    T data;
    Node<T> prev;
    Node<T> next;
    
    public Node(T data) {
	this.data = data;
    }
}
