package com.algorithm.tree.seven;

import java.util.List;

public class BSTTest {
    public static void main(String[] args) {
	BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	List<Integer> l = List.of(47, 25, 77, 11, 43, 65, 93, 7, 17, 31, 44, 68);
//	List<Integer> l = List.of(49, 14, 64, 34, 55, 85, 46, 37, 46, 37);
	l.forEach(i -> bst.insert(i));
	System.out.println("Level Order Traversal Iterative");
	bst.levelOrderTraversalIterative();
	System.out.println("Level Order Traversal Using Queue");
	bst.levelOrderTraversalUsingQueue();
	System.out.println("In-Order Traversal ");
	bst.inOrderTraversal();
	System.out.println("Root is: " + bst.getRoot());
	System.out.println("size: " + bst.getSize());
	System.out.println("BST contains 14? " + bst.find(14));
	System.out.println("BST contains 999? " + bst.find(999));
	System.out.println("BST contains 85? " + bst.find(85));
	System.out.println("BST contains -1? " + bst.find(-1));
	System.out.println("size: " + bst.getSize());
	System.out.println("removing 55 (exists)");
	bst.remove(55);
	bst.inOrderTraversal();
	System.out.println("removing 49 (exists)");
	bst.remove(49);
	bst.inOrderTraversal();
	System.out.println("removing 64 (exists)");
	bst.remove(64);
	bst.inOrderTraversal();
	System.out.println("removing 37 (exists)");
	bst.remove(37);
	bst.inOrderTraversal();
	System.out.println("removing 35 (doesn't exist)");
	bst.remove(35);
	bst.inOrderTraversal();
	System.out.println("size: " + bst.getSize());
	System.out.println("Height : " + bst.height());
	System.out.println("root: " + bst.getRoot());
	System.out.println("Level Order Traversal ");
	bst.levelOrderTraversalIterative();
	
	bst.isBinary();
    }
}
