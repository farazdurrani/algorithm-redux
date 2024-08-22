package com.algorithm.dynamiclist.two;

public class ListTest {
    public static void main(String[] args) {
	LinkedList<String> l = new LinkedList<>();
	l.insertAtFront("b");
	l.insertAtFront("a");
	l.print();
	l.insertAtBack("c");
	l.insertAtBack("d");
	l.print();
	l.removeFromFront();
	l.print();
	l.removeFromFront();
	l.print();
	l.removeFromBack();
	l.print();
	l.removeFromBack();
	l.print();
	
    }
}
