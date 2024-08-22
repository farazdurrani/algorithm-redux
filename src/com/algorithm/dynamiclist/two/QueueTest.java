package com.algorithm.dynamiclist.two;

public class QueueTest {

    public static void main(String[] args) {
	Queue<Integer> q = new Queue<>("My Queue");
	q.enqueue(2);
	q.enqueue(3);
	q.print();
	System.out.println(q.dequeue() + " dequeued");
	System.out.println(q.dequeue() + " dequeued");
	q.print();
    }

}
