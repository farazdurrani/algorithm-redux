package com.algorithm.dynamiclist.eleven.doublelinkedlist;

public class DoublyLinkedListTest {
    public static void main(String[] args) {
	DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
	System.out.println("Insert at Front 4,3,2,1 in this order.");
	list.insertAtFront(4);
	list.insertAtFront(3);
	list.insertAtFront(2);
	list.insertAtFront(1);
	System.out.println("Print From Front");
	list.printFromFront();
	System.out.println("Print in Reverse");
	list.printInReverse();
	System.out.println("Insert at Back 5");
	list.insertAtBack(5);
	System.out.println("Print From Front");
	list.printFromFront();
	System.out.println("Print in Reverse");
	list.printInReverse();
	System.out.println("Insert at Back 6");
	list.insertAtBack(6);
	System.out.println("Print From Front");
	list.printFromFront();
	System.out.println("Print in Reverse");
	list.printInReverse();
	System.out.println("-------------------------------------");
	System.out.println(list.removeFromFront() + " removed from front");
	System.out.println(list.removeFromFront() + " removed from front");
	System.out.println(list.removeFromFront() + " removed from front");
	System.out.println("Print From Front");
	list.printFromFront();
	System.out.println("Print in Reverse");
	list.printInReverse();
	System.out.println("Insert at Front 3");
	list.insertAtFront(3);
	System.out.println("Insert at Front 2");
	list.insertAtFront(2);
	System.out.println("Insert at Front 1");
	list.insertAtFront(1);
	System.out.println("Print From Front");
	list.printFromFront();
	System.out.println("Print in Reverse");
	list.printInReverse();
	System.out.println("-------------------------------------");
	System.out.println(list.removeFromBack() + " removed from back");
	System.out.println(list.removeFromBack() + " removed from back");
	System.out.println(list.removeFromBack() + " removed from back");
	System.out.println("Print From Front");
	list.printFromFront();
	System.out.println("Print in Reverse");
	list.printInReverse();
	System.out.println("-------------------------------------");
	System.out.println("Insert at Back 4");
	list.insertAtBack(4);
	System.out.println("Insert at Back 5");
	list.insertAtBack(5);
	System.out.println("Insert at Front 0");
	list.insertAtFront(0);
	System.out.println("Print From Front");
	list.printFromFront();
	System.out.println("Print in Reverse");
	list.printInReverse();
	
    }
}
