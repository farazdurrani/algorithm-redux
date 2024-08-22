package com.algorithm.tree.eighteen;

import java.util.List;

public class BSTTest {
    public static void main(String[] args) {
	List<Integer> l = null;
	RedBlackTree<Integer> bst = new RedBlackTree<>();
	l = List.of(11,2,14,1,7,15,5,8,1);
	System.out.println("creating a BST initially");
	l.forEach(i -> System.out.print(i + " " + bst.BSTInsertIterative(i) + " "));
	System.out.println();
	System.out.println("In-Order Traversal Recursive");
	bst.inorderTraversalResursive();
	bst.BSTInsertIterative(4);
	System.out.println("After inserting 4");
	bst.inorderTraversalResursive();
	
    }

}
