package com.algorithm.dynamiclist.fifteen;

public class LinkedListsTest {
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
	System.out.println(list.removeFromFront() + " removed");
	System.out.println(list.removeFromBack() + " removed");
	list.print();
	System.out.println(list.removeFromFront() + " removed");
	System.out.println(list.removeFromBack() + " removed");
	list.print();
	deleteOperations(list);
	reverse(list);
	System.out.println(list.removeFromFront() + " removed");
	System.out.println(list.removeFromBack() + " removed");
	list.print();
	System.out.println("Deleted 3 " + list.delete(3) + " from the list");
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

    private static void reverse(LinkedList<Integer> list) {
	repopulate(list);
	System.out.println("Before reversing ::");
	list.print();
	list.reverse();
	System.out.println("After reversing ::");
	list.print();
    }

    private static void deleteOperations(LinkedList<Integer> list) {
	System.out.println("\n\nReinserting data to test deletion");
	repopulate(list);
	list.print();
	System.out.println("Deleted 2 " + list.delete(2) + " from the list");
	list.print();
	System.out.println("Deleted 5 " + list.delete(5) + " from the list");
	list.print();
	System.out.println("Deleted 4 " + list.delete(4) + " from the list");
	list.print();
	System.out.println("Deleted 3 " + list.delete(3) + " from the list");
	list.print();
	System.out.println("Deleted 2 " + list.delete(2) + " from the list");
	list.print();
	System.out.println("Deleted 1 " + list.delete(1) + " from the list");
	list.print();
	System.out.println("Deleted 6 " + list.delete(6) + " from the list");
	list.print();
    }

    private static void repopulate(LinkedList<Integer> list) {
	list.insertAtFront(3);
	list.insertAtFront(2);
	list.insertAtFront(1);
	list.insertAtBack(4);
	list.insertAtBack(5);
	list.insertAtBack(6);
    }
}
