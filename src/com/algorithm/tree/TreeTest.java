package com.algorithm.tree;

import java.util.List;

public class TreeTest {
    public static void main(String[] args) {
	Tree<Integer> t = new Tree<>();
	List<Integer> list = List.of(49, 64, 14, 34, 85, 64, 46, 14, 37, 55);
	list.forEach(i -> t.insert(i));
//	t.preorderTraversal();
	System.out.println("Inorder Traversal (should print sorted)");
	t.inorderTraversal();
//	t.postorderTraversal();
	list.forEach(i -> t.find(i));
	list.forEach(i -> t.find(i + 1));
	t.find(13);
	t.deleteTreeNode(49);
	t.deleteTreeNode(64);
	t.deleteTreeNode(37);
	t.deleteTreeNode(999);
	System.out.println("Inorder Traversal (should print sorted)");
	t.inorderTraversal();
    }
}
