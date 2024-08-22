package com.algorithm.tree.two;

public class BSTTest {
    public static void main(String[] args) {
	BSTNode<Integer> bst = new BSTNode<>();
	bst.insert(49);
	bst.insert(14);
	bst.insert(64);
	bst.insert(34);
	bst.insert(55);
	bst.insert(85);
	bst.insert(46);
	bst.insert(37);
	bst.insert(46); // dup
	bst.insert(37); // dup

	System.out.println("In Order Traversal (sorted)");
	bst.inOrderTraversal();

	System.out.println("5 is present " + bst.contains(5));
	System.out.println("34 is present " + bst.contains(34));

	System.out.println("In Order Traversal (sorted)");
	bst.inOrderTraversal();

	System.out.println("Removing 49, 64, 37");
	bst.remove(49);
	bst.remove(64);
	bst.remove(37);
	bst.remove(999);

	System.out.println("In Order Traversal (sorted)");
	bst.inOrderTraversal();

    }
}
