package com.algorithm.dynamiclist.three;

public class QueueTest {
    public static void main(String[] args) {
	Queue<String> q = new Queue<>();
	q.enqueue("1");
	q.enqueue("2");
	q.print();
	System.out.println(q.dequeue() + " dequeued");
	System.out.println(q.dequeue() + " dequeued");
	System.out.println(q.dequeue() + " dequeued");
	q.print();
    }
}
