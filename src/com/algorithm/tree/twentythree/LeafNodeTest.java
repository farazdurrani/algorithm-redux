package com.algorithm.tree.twentythree;

import java.util.List;

public class LeafNodeTest {
	public static void main(String[] args) {
		// Leaf Operation
		List<String> sortedStrings = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i","j");

		// broken RED-BLACK-TREE == basically Binary Search Tree
		RedBlackTree<String> bst1 = new RedBlackTree<>();
		sortedStrings.forEach(s -> bst1.insertIterativeBroken(s));
		//Working for strings. It is lopsided but RBT is balanced for Strings
//		BTreePrinter.printNode(bst1.getRoot());
		// end of broken RED-BLACK-TREE

		sortedStrings = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o");
		RedBlackTree<String> bst2 = new RedBlackTree<>();
		sortedStrings.forEach(s -> bst2.insertIterative(s));
		BTreePrinter.printNode(bst2.getRoot());
		bst2.printLeafNodesAndPath();
		
	}
}
