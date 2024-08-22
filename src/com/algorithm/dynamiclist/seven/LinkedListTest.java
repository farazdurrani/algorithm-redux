package com.algorithm.dynamiclist.seven;

public class LinkedListTest {
    public static void main(String[] args) {
	System.out.println("List operations");
	LinkedList<Integer> list = new LinkedList<>();
	list.print();
	list.insertAtFront(3);
	list.insertAtFront(2);
	list.insertAtFront(1);
	list.print();
	list.insertAtBack(4);
	list.insertAtBack(5);
	list.insertAtBack(6);
	list.print();
	System.out.println(list.removeFromFront() + " removed");
	System.out.println(list.removeFromBack() + " removed");
	list.print();
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
}
