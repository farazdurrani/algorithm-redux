package com.algorithm.tree.three;

import java.util.List;

public class BSTTest {
    public static void main(String[] args) {
	BSTNode<Integer> bst = new BSTNode<>();
	List<Integer> l  = List.of(49,14,64,34,55,85,46,37,46,37);
	l.forEach(i -> bst.insert(i));
	bst.inorderTraversal();
	System.out.println("BST contains 14? " + bst.find(14));
	System.out.println("BST contains 999? " + bst.find(999));
	bst.remove(49);
	bst.remove(64);
	bst.remove(37);
	bst.inorderTraversal();
    }
}
