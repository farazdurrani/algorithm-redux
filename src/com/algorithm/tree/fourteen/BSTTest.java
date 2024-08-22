package com.algorithm.tree.fourteen;

import java.util.List;

public class BSTTest {
    public static void main(String[] args) {
	BinarySearchTree<Integer> bst = new BinarySearchTree<>();
//	List<Integer> l = List.of(47, 25, 77, 11, 43, 65, 93, 7, 17, 31, 44, 68);
	List<Integer> l = List.of(49, 14, 64, 34, 55, 85, 46, 37, 46, 37);
	System.out.println("Inserting");
	l.forEach(i -> System.out.print(i + " " + bst.insert(i)+ " "));
	System.out.println();
	System.out.println("Level Order Traversal Iterative");
	bst.levelOrderTraversalIterative();
	System.out.println("Level Order Traversal Using Queue");
	bst.levelOrderTraversalQueue();
	System.out.println("In-Order Traversal Recursive");
	bst.inorderTraversalResursive();
	System.out.println("Root is: " + bst.getRoot());
	System.out.println("BST contains 14? (yes) " + bst.contains(14));
	System.out.println("BST contains 999? (no) " + bst.contains(999));
	System.out.println("BST contains 85? (yes) " + bst.contains(85));
	System.out.println("BST contains -1? (no) " + bst.contains(-1));
	System.out.println("In-Order Traversal Recursive");
	bst.inorderTraversalResursive();
	System.out.println("removing 14 (exists)");
	bst.remove(14);
	bst.inorderTraversalResursive();
	System.out.println("removing 55 (exists)");
	bst.remove(55);
	bst.inorderTraversalResursive();
	System.out.println("removing 49 (exists)");
	bst.remove(49);
	bst.inorderTraversalResursive();
	System.out.println("removing 64 (exists)");
	bst.remove(64);
	bst.inorderTraversalResursive();
	System.out.println("removing 37 (exists)");
	bst.remove(37);
	bst.inorderTraversalResursive();
	System.out.println("removing 35 (doesn't exist)");
	bst.remove(35);
	bst.inorderTraversalResursive();
	System.out.println("Height : " + bst.height());
	System.out.println("root: " + bst.getRoot());
	System.out.println("Level Order Traversal ");
	bst.levelOrderTraversalQueue();

	System.out.println("New Tree");
	BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
	l.forEach(i -> bst2.insert(i));
	System.out.println("Level Order Traversal");
	bst2.levelOrderTraversalIterative();
	System.out.println("Inverting Tree");
	bst2.invertTree();
	System.out.println("Level Order Traversal");
	bst2.levelOrderTraversalQueue();
	System.out.println("Descending Order");
	bst2.inorderTraversalResursive();
	System.out.println("Preorder Traversal");
	bst2.preorderTraversalRecursive();
	System.out.println("Postorder Traversal");
	bst2.postorderTraversalRecursive();
    }
}
