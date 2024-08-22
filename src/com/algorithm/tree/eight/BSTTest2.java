package com.algorithm.tree.eight;

import java.util.List;

import com.algorithm.dynamiclist.nine.LinkedList;

public class BSTTest2 {
    public static void main(String[] args) {
	BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	List<Integer> l = List.of(47, 25, 77, 11, 43, 65, 93, 7);
	l.forEach(i -> bst.insert(i));
	System.out.println("Inorder Traversal Recursive");
	bst.inorderTraversalResursive();
	LinkedList<Integer> list = bst.inorderTraversalIterative();
	list.print();
    }
}
