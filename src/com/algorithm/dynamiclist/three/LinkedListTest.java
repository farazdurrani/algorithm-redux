package com.algorithm.dynamiclist.three;

public class LinkedListTest {
    public static void main(String[] args) {
	LinkedList<Integer> l = new LinkedList<>();
	l.print();
	l.insertAtFront(3);
	l.insertAtFront(2);
	l.insertAtFront(1);
	l.print();
	l.insertAtBack(4);
	l.insertAtBack(5);
	l.insertAtBack(6);
	l.print();
	System.out.println(l.removeFromFront() + " removed");
	System.out.println(l.removeFromFront() + " removed");
	System.out.println(l.removeFromFront() + " removed");
	l.print();
	System.out.println(l.removeFromBack() + " removed");
	System.out.println(l.removeFromBack() + " removed");
	System.out.println(l.removeFromBack() + " removed");
	System.out.println(l.removeFromBack() + " removed");
	l.print();
	
    }
}
