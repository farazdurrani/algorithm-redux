package com.algorithm.tree.sixteen;

import java.util.List;

public class BSTTest {
    public static void main(String[] args) {
	BinarySearchTree<Integer> bst = new BinarySearchTree<>();
	List<Integer> l = List.of(15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9);
	System.out.println("Inserting");
	l.forEach(i -> System.out.print(i + " " + bst.insert(i) + " "));
	System.out.println();
	System.out.println("Level Order Traversal Iterative");
	bst.levelOrderTraversalIterative();
	
	System.out.println("MIN: " + bst.min());

	TreeNode<Integer> max = bst.max();

	System.out.println("MAX: " + max);
	
	TreeNode<Integer> root = bst.getRoot();
	
	TreeNode<Integer> successor = bst.successor(root);
	
	System.out.println("Successor of root " + root.data + ": " + successor.data);
	
	TreeNode<Integer> _13 = bst.search(Integer.valueOf(13));
	
	System.out.println("Found 13? " + _13);
	
	System.out.println("Successor of " + _13.data + ": " + bst.successor(_13));
	
	System.out.println("Predecessor of 15: " + bst.predecessor(bst.search(Integer.valueOf(15))));
	
	System.out.println("In-Order Traversal Iterative");
	bst.inorderTraversalInterative();
	
	System.out.println("Successor of 17: " + bst.successor(bst.search(Integer.valueOf(17))));
	
	System.out.println("Successor of 20: " + bst.successor(bst.search(Integer.valueOf(20))));
	
	System.out.println("Predecessor of 9: " + bst.predecessor(bst.search(Integer.valueOf(9))));
	
	System.out.println("Predecessor of 7: " + bst.predecessor(bst.search(Integer.valueOf(7))));
	
	System.out.println("Predecessor of 2: " + bst.predecessor(bst.search(Integer.valueOf(2))));
	
	System.out.println("BST contains 15? (yes) " + bst.containsIterative(15));
	System.out.println("BST contains 999? (no) " + bst.containsIterative(999));
	System.out.println("BST contains 6? (yes) " + bst.containsIterative(6));
	System.out.println("BST contains -1? (no) " + bst.containsIterative(-1));
	

	System.out.println("In-Order Traversal Iterative");
	bst.inorderTraversalInterative();
	System.out.println("Successor of 13 (without keeping track of parent): " + bst.successorWithoutTrackingParentUsingStack(13));
	System.out.println("Successor of 15 (without keeping track of parent): " + bst.successorWithoutTrackingParentUsingStack(15));
	System.out.println("Successor of 2 (without keeping track of parent): " + bst.successorWithoutTrackingParentUsingStack(2));
	System.out.println("Successor of 20 (without keeping track of parent): " + bst.successorWithoutTrackingParentUsingStack(20));
	
	System.out.println("In-Order Traversal Iterative");
	bst.inorderTraversalInterative();
	bst.successorWithoutTrackingParentWithoutAuxilaryStorage(2);
	bst.successorWithoutTrackingParentWithoutAuxilaryStorage(3);
	bst.successorWithoutTrackingParentWithoutAuxilaryStorage(4);
	bst.successorWithoutTrackingParentWithoutAuxilaryStorage(6);
	
	bst.successorWithoutTrackingParentWithoutAuxilaryStorage(7);
	bst.successorWithoutTrackingParentWithoutAuxilaryStorage(9);
	bst.successorWithoutTrackingParentWithoutAuxilaryStorage(13);
	bst.successorWithoutTrackingParentWithoutAuxilaryStorage(15);
	
	bst.successorWithoutTrackingParentWithoutAuxilaryStorage(17);
	bst.successorWithoutTrackingParentWithoutAuxilaryStorage(18);
	bst.successorWithoutTrackingParentWithoutAuxilaryStorage(20);
	
	System.out.println("In-Order Traversal Iterative");
	bst.inorderTraversalInterative();
	bst.predecessorWithoutTrackingParent(2);
	bst.predecessorWithoutTrackingParent(3);
	bst.predecessorWithoutTrackingParent(4);
	bst.predecessorWithoutTrackingParent(6);
	
	bst.predecessorWithoutTrackingParent(7);
	bst.predecessorWithoutTrackingParent(9);
	bst.predecessorWithoutTrackingParent(13);
	bst.predecessorWithoutTrackingParent(15);
	
	bst.predecessorWithoutTrackingParent(17);
	bst.predecessorWithoutTrackingParent(18);
	bst.predecessorWithoutTrackingParent(20);

	BinarySearchTree<Integer> bst3 = new BinarySearchTree<>();
	System.out.println("Inserting Iteratively");
	l.forEach(bst3::insertIterative);
	System.out.println();
	System.out.println("In-Order Traversal Iterative");
	bst3.inorderTraversalInterative();
	System.out.println("Level Order Traversal Iterative");	
	bst3.levelOrderTraversalIterative();
	
	System.out.println("Level Order Traversal Using Queue");
	bst.levelOrderTraversalQueue();
	System.out.println("In-Order Traversal Recursive");
	bst.inorderTraversalResursive();
	System.out.println("Preorder Traversal Recursive");
	bst.preorderTraversalRecursive();
	System.out.println("Preorder Traversal Iterative");
	bst.preorderTraversalIterative();
	System.out.println("Postorder Traversal Recursive");
	bst.postorderTraversalRecursive();
	System.out.println("Postorder Traversal Iterative");
	bst.postorderTraversalIterative();
	System.out.println("Root is: " + bst.getRoot());
	System.out.println("BST contains (Iterative) 13? (yes) " + bst.containsIterative(13));
	System.out.println("BST contains (Iterative) 999? (no) " + bst.containsIterative(999));
	System.out.println("BST contains (Iterative) 18? (yes) " + bst.containsIterative(18));
	System.out.println("BST contains (Iterative) -1? (no) " + bst.containsIterative(-1));
	
	System.out.println("BST contains (recursive) 13? (yes) " + bst.containsRecursive(13));
	System.out.println("BST contains (recursive) 999? (no) " + bst.containsRecursive(999));
	System.out.println("BST contains (recursive) 18? (yes) " + bst.containsRecursive(18));
	System.out.println("BST contains (recursive) -1? (no) " + bst.containsRecursive(-1));
	System.out.println("Level-Order Traversal lIterative");
	bst.levelOrderTraversalIterative();
	System.out.println("removing 13 (exists)");
	bst.remove(13);
	bst.levelOrderTraversalIterative();
	System.out.println("removing 18 (exists)");
	bst.remove(18);
	bst.levelOrderTraversalIterative();
	System.out.println("removing 9 (exists)");
	bst.remove(9);
	bst.levelOrderTraversalIterative();
	System.out.println("removing 15 (exists)");
	bst.remove(15);
	bst.levelOrderTraversalIterative();
	System.out.println("removing 7 (exists)");
	bst.remove(7);
	bst.levelOrderTraversalIterative();
	System.out.println("removing 35 (doesn't exist)");
	bst.remove(35);
	bst.levelOrderTraversalIterative();
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
	System.out.println("Preorder Traversal Recursive");
	bst2.preorderTraversalRecursive();
	System.out.println("Preorder Traversal Iterative");
	bst2.preorderTraversalIterative();
	System.out.println("Postorder Traversal Recursive");
	bst2.postorderTraversalRecursive();
	System.out.println("Postorder Traversal Iterative");
	bst2.postorderTraversalIterative();
	
	System.out.println("\n\n\n\nNew Tree");
	List<Integer> sorted = List.of(1,2,3, 4,5,6,7,8,9,10);
	BinarySearchTree<Integer> bst5 = new BinarySearchTree<>();
	sorted.forEach(i -> bst5.insert(i));
	BTreePrinter.printNode(bst5.getRoot());

    }

}
