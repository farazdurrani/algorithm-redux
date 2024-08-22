package com.algorithm.tree.six;

import java.util.List;

public class BSTTest {
    public static void main(String[] args) {
	BSTNode<Integer> bst = new BSTNode<>();
	List<Integer> l  = List.of(49,14,64,34,55,85,46,37,46,37);
//	List<Integer> l  = List.of(1,2,2,3);
	l.forEach(i -> bst.insert(i));
	bst.inorderTraversal();
	System.out.println("size: " +  bst.getSize());
	
	System.out.println("BST contains 14? " + bst.find(14));
	System.out.println("BST contains 999? " + bst.find(999));
	System.out.println("BST contains 85? " + bst.find(85));
	System.out.println("BST contains -1? " + bst.find(-1));
	System.out.println("removing 55");
	bst.remove(55);
	System.out.println("removing 49");
	bst.remove(49);
	System.out.println("removing 64");
	bst.remove(64);
	System.out.println("removing 37");
	bst.remove(37);
	System.out.println("removing 35");
	bst.remove(35);
	bst.inorderTraversal();
	System.out.println("size: " +  bst.getSize());
    }
}
