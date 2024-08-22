package com.algorithm.tree.seventeen;

import java.util.List;

public class BSTTest {
    public static void main(String[] args) {
	List<Integer> l = null;
	RedBlackTree<Integer> bst = new RedBlackTree<>();
//	digits from book pg 290
//	l = List.of(15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9, 13, 9);
//	digits from book pg 314
//	l = List.of(7,4,11,3,6,9,18,2,14,19,12,17,22,20);
//	digits from book pg 317
	l = List.of(11,2,14,1,7,15,5,8);
	System.out.println("creating a BST initially");
	l.forEach(i -> System.out.print(i + " " + bst.BSTInsertIterative(i) + " "));
	System.out.println();
//	System.out.println("Level Order Traversal Iterative");	
//	bst.levelOrderTraversalIterative();
//	System.out.println("Level Order Traversal Using Queue");
//	bst.levelOrderTraversalQueue();
	System.out.println("In-Order Traversal Recursive");
	bst.inorderTraversalResursive();
//	System.out.println("In-Order Traversal Iterative");
//	bst.inorderTraversalIterative();
//	bst.prettyPrint();
//	bst.leftRotate(11);
//	System.out.println("After left rotation of 11");
//	bst.prettyPrint();
//	bst.rightRotate(18);
//	System.out.println("After right rotation of 18");
//	bst.prettyPrint();
//	System.out.println("Reverse In-Order Traversal Recursive");
//	bst.inorderTraversalReverseResursive();
	bst.BSTInsertIterative(4);
	System.out.println("After inserting 4");
	bst.inorderTraversalResursive();
	
    }

}
