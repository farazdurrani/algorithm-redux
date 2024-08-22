package com.algorithm.dynamiclist.one;

public class StackTest {
public static void main(String[] args) {
    Stack<Integer> s = new Stack<>("My Stack");
    s.push(-1);
    s.print();
    s.push(0);
    s.print();
    s.push(1);
    s.print();
    s.push(5);
    s.print();
    System.out.println(s.pull() + " removed");
    s.print();
    System.out.println(s.pull() + " removed");
    s.print();
    System.out.println(s.pull() + " removed");
    s.print();
    System.out.println(s.pull() + " removed");
    s.print();
}
}
