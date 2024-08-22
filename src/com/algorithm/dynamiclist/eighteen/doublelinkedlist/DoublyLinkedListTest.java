package com.algorithm.dynamiclist.eighteen.doublelinkedlist;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DoublyLinkedListTest {
	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		System.out.println("Insert at Front 4,3,2,1 in this order.");
		list.insertAtFront(4);
		list.insertAtFront(3);
		list.insertAtFront(2);
		list.insertAtFront(1);
		System.out.println("Print From Front Recursive");
		list.printFromFrontRecursive();
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
		deleteOperation(list);

		repopulate(list);
		System.out.println("Before Reverse Print from front");
		list.printFromFront();
		System.out.println("Before Reverse Print from back");
		list.printInReverse();
		list.reverse();
		System.out.println("After Reverse Print from front");
		list.printFromFront();
		System.out.println("After Reverse Print from end");
		list.printInReverse();

		System.out.println("Queue operations");
		Queue<String> q = new Queue<>();
		q.enqueue("a");
		q.enqueue("b");
		q.enqueue("c");
		q.print();
		System.out.println(q.dequeue() + " dequeued");
		System.out.println(q.dequeue() + " dequeued");
		System.out.println(q.dequeue() + " dequeued");
		q.print();
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

	private static void repopulate(DoubleLinkedList<Integer> list) {
		list = new DoubleLinkedList<>();
		System.out.println("Insert at Front 4,3,2,1 in this order.");
		list.insertAtFront(4);
		list.insertAtFront(3);
		list.insertAtFront(2);
		list.insertAtFront(1);
	}

	private static void deleteOperation(DoubleLinkedList<Integer> list) {
		list = new DoubleLinkedList<>();
		System.out.println("Repopulating List to test delete operations");
		for (int i = 1; i < 10; i++) {
			list.insertAtBack(i);
		}
		System.out.println("After populating: Print from front ");
		list.printFromFront();
		System.out.println("After populating: Print from back ");
		list.printInReverse();
		List<Integer> rands = new Random().ints(1, 10).limit(15).boxed().collect(Collectors.toList());
		for (Integer integer : rands) {
			System.out.println("Deleting + " + integer + "? " + list.delete(integer));
			list.printFromFront();
			list.printInReverse();
		}
	}
}
