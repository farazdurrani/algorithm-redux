package com.algorithm.dynamiclist.eight.doublelinkedlist2;

public class NodeListTest {
    public static void main(String[] args) {
	LinkedList<Integer> list = new LinkedList<>();
	list.insertAtFront(4);
	list.insertAtFront(3);
	list.insertAtFront(2);
	list.insertAtFront(1);
	list.printFromFront();
	list.printInReverse();
	list.insertAtBack(5);
	list.printFromFront();
	list.printInReverse();
	list.insertAtBack(6);
	list.printFromFront();
	list.printInReverse();
	System.out.println("-------------------------------------");
	System.out.println(list.removeFromFront() + " removed");
	System.out.println(list.removeFromFront() + " removed");
	System.out.println(list.removeFromFront() + " removed");
	list.printFromFront();
	list.printInReverse();
	list.insertAtFront(3);
	list.insertAtFront(2);
	list.insertAtFront(1);
	list.printFromFront();
	list.printInReverse();
	System.out.println("-------------------------------------");
	System.out.println(list.removeFromBack() + " removed");
	System.out.println(list.removeFromBack() + " removed");
	System.out.println(list.removeFromBack() + " removed");
	list.printFromFront();
	list.printInReverse();
	System.out.println("-------------------------------------");
	list.insertAtBack(4);
	list.insertAtBack(5);
	list.insertAtFront(0);
	list.printFromFront();
	list.printInReverse();
	
	System.out.println("Stack operations");
	Stack<Long> s = new Stack<>();
	s.push(3L);
	s.push(2L);
	s.push(1L);
	s.print();
	System.out.println(s.pop() + " popped");
	System.out.println(s.pop() + " popped");
	System.out.println(s.pop() + " popped");
	s.print();
	
    }
}
