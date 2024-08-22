package com.algorithm.dynamiclist.two;

public class StackTest {
    public static void main(String[] args) {
	Stack<Integer> s = new Stack<>("My Stack");
	s.push(2);
	s.push(1);
	s.print();
	System.out.println(s.pop() + " popped");
	System.out.println(s.pop() + " popped");
	s.print();
	
    }
}
