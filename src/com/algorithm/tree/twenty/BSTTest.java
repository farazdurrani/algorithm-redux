package com.algorithm.tree.twenty;

import java.util.List;

public class BSTTest {
    public static void main(String[] args) {
	List<Integer> l;
	RedBlackTree<Integer> bst = new RedBlackTree<>();
//	digits from book pg 317
	l = List.of(11, 2, 14, 1, 7, 15, 5, 8, 11, 8);
	System.out.println("Inserting");
	l.forEach(i -> System.out.print(i + " " + bst.insertRecursive(i) + " "));
	System.out.println();
	System.out.println("Level Order Traversal Iterative");
	bst.levelOrderTraversalIterative();
	System.out.println("Inserting 4 that should change the root: " + bst.insertRecursive(4));
	System.out.println("Level Order Traversal Iterative");
	bst.levelOrderTraversalIterative();

	System.out.println("MIN: " + bst.minRecursive());

	System.out.println("MAX: " + bst.maxRecursive());
	
	System.out.println("MIN: " + bst.minIterative());

	System.out.println("MAX: " + bst.maxIterative());

	System.out.println("Successor of root " + bst.getRoot().data + " is: "
	    + bst.successor(bst.getRoot().data));

	BTreePrinter.printNode(bst.getRoot());

	System.out.println("Successor of 5 is: " + bst.successor(5));

	TreeNode<Integer> _11 = bst.searchRecursive(Integer.valueOf(11));

	System.out.println("Found 11? " + _11.data);

	System.out.println("Successor of " + _11.data + ": " + bst.successor(_11.data));

	System.out.println(
	    "Predecessor of 15: " + bst.predecessor(bst.searchRecursive(Integer.valueOf(15)).data));

	System.out.println(
	    "Predecessor of 11: " + bst.predecessor(bst.searchRecursive(Integer.valueOf(11)).data));

	System.out.println(
	    "Predecessor of 8: " + bst.predecessor(bst.searchRecursive(Integer.valueOf(8)).data));

	System.out.println("In-Order Traversal Iterative");
	bst.inorderTraversalIterative();

	System.out.println("BST contains 1? (yes) " + bst.containsIterative(1));
	System.out.println("BST contains 999? (no) " + bst.containsIterative(999));
	System.out.println("BST contains 15? (yes) " + bst.containsIterative(15));
	System.out.println("BST contains -1? (no) " + bst.containsIterative(-1));

	System.out.println("Level Order Traversal Using Queue");
	bst.levelOrderTraversalQueue();
	System.out.println("In-Order Traversal Recursive");
	bst.inorderTraversalResursive();

	System.out.println("\n\n\n\n\n NEW TREE");
	RedBlackTree<Integer> bst3 = new RedBlackTree<>();
	System.out.println("Inserting Iteratively");
	l.forEach(bst3::insertIterative);
	System.out.println();
	System.out.println("In-Order Traversal Iterative");
	bst3.inorderTraversalIterative();
	BTreePrinter.printNode(bst3.getRoot());
	System.out.println("Level Order Traversal Iterative");
	bst3.levelOrderTraversalIterative();
	System.out.println("Inserting 4 that should change the root: " + bst3.insertIterative(4));
	System.out.println("Level Order Traversal Iterative");
	bst3.levelOrderTraversalIterative();

	System.out.println("Level Order Traversal Using Queue");
	bst3.levelOrderTraversalQueue();
	System.out.println("In-Order Traversal Recursive");
	bst3.inorderTraversalResursive();
	System.out.println("Preorder Traversal Recursive");
	bst3.preorderTraversalRecursive();
	System.out.println("Preorder Traversal Iterative");
	bst3.preorderTraversalIterative();
	System.out.println("Postorder Traversal Recursive");
	bst3.postorderTraversalRecursive();
	System.out.println("Postorder Traversal Iterative");
	bst3.postorderTraversalIterative();
	System.out.println("\n\n\n\nDELETE OPERATION");
	bst3.inorderTraversalResursive();
	System.out.println("removing 14 (exists)");
	bst3.removeRecursive(14);
	bst3.inorderTraversalResursive();
	System.out.println("removing 15 (exists)");
	bst3.removeRecursive(15);
	bst3.inorderTraversalResursive();
	System.out.println("removing 8 (exists)");
	bst3.removeRecursive(8);
	bst3.inorderTraversalResursive();
	System.out.println("removing 15 (doesn't exist anymore)");
	bst3.removeRecursive(15);
	bst3.inorderTraversalResursive();
	System.out.println("removing 7 (exists)");
	bst3.removeRecursive(7);
	bst3.inorderTraversalResursive();
	System.out.println("removing 35 (doesn't exist)");
	bst3.removeRecursive(35);
	bst3.inorderTraversalResursive();

	System.out.println("Height : " + bst3.height());
	System.out.println("root: " + bst3.getRoot().data);
	System.out.println("Level Order Traversal ");
	bst3.levelOrderTraversalQueue();

	System.out.println("\n\n\n\nNew Tree");
	RedBlackTree<Integer> bst2 = new RedBlackTree<>();
	l.forEach(i -> bst2.insertRecursive(i));
	System.out.println("Level Order Traversal");
	bst2.levelOrderTraversalIterative();
	System.out.println("Inverting Tree");
	bst2.invertTree();
	System.out.println("Level Order Traversal");
	bst2.levelOrderTraversalQueue();
	System.out.println("Descending Order");
	bst2.inorderTraversalResursive();

	System.out.println("\n\n\n\nNew Tree");

	RedBlackTree<Integer> bst4 = new RedBlackTree<>();
	l.forEach(i -> bst4.insertRecursive(i));
	System.out.println("In-Order Traversal Recursive");
	bst4.inorderTraversalResursive();
	BTreePrinter.printNode(bst4.getRoot());
	bst4.removeIteratively(1);
	BTreePrinter.printNode(bst4.getRoot());
	bst4.removeIteratively(0);
	BTreePrinter.printNode(bst4.getRoot());
	bst4.removeIteratively(2);
	BTreePrinter.printNode(bst4.getRoot());
	bst4.removeIteratively(15);
	BTreePrinter.printNode(bst4.getRoot());
	bst4.removeIteratively(7);
	BTreePrinter.printNode(bst4.getRoot());
	bst4.removeIteratively(8);
	BTreePrinter.printNode(bst4.getRoot());

	System.out.println("\n\n\n\nNew Tree");
	List<Integer> sorted = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	RedBlackTree<Integer> bst5 = new RedBlackTree<>();
	sorted.forEach(i -> bst5.insertRecursive(i));
	BTreePrinter.printNode(bst5.getRoot());
	bst5.removeIterativeRED_BLACK(10);
	bst5.removeIterativeRED_BLACK(8);
	bst5.removeIterativeRED_BLACK(4);
	BTreePrinter.printNode(bst5.getRoot());
    }
}
