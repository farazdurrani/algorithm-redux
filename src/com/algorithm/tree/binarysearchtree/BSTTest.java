package com.algorithm.tree.binarysearchtree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BSTTest {
  public static void main(String[] args) {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    List<Integer> l = new ArrayList<>(new HashSet<>(List.of(15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9)));
    System.out.println("Inserting");
    l.forEach(bst::insertIterative);
    System.out.println();
    System.out.println("Level Order Traversal Iterative");
    bst.levelOrderTraversalQueue();

    System.out.println("MIN: " + bst.min());

    TreeNode<Integer> max = bst.max();

    System.out.println("MAX: " + max);

    TreeNode<Integer> root = bst.getRoot();

    TreeNode<Integer> successor = bst.successor(root);

    System.out.println("Successor of root " + root.data + ": " + successor.data);

    TreeNode<Integer> _13 = bst.search(Integer.valueOf(13));

    System.out.println("Found 13? " + _13);

    System.out.println("Successor of " + _13.data + ": " + bst.successor(_13));

    System.out.println("In-Order Traversal Iterative");
    bst.inorderTraversalIterative();

    System.out.println("Successor of 17: " + bst.successor(bst.search(Integer.valueOf(17))));

    System.out.println("Successor of 20: " + bst.successor(bst.search(Integer.valueOf(20))));
    //predecessor is too easy got rid of it since need a small photocopy.
    System.out.println("BST contains 15? (yes) " + bst.containsIterative(15));
    System.out.println("BST contains 999? (no) " + bst.containsIterative(999));
    System.out.println("BST contains 6? (yes) " + bst.containsIterative(6));
    System.out.println("BST contains -1? (no) " + bst.containsIterative(-1));


    System.out.println("In-Order Traversal Iterative");
    bst.inorderTraversalIterative();

    BinarySearchTree<Integer> bst3 = new BinarySearchTree<>();
    System.out.println("Inserting Iteratively");
    l.forEach(bst3::insertIterative);
    System.out.println();
    System.out.println("In-Order Traversal Iterative");
    bst3.inorderTraversalIterative();
    System.out.println("Level Order Traversal Iterative");
    bst3.levelOrderTraversalQueue();

    System.out.println("Level Order Traversal Using Queue");
    bst.levelOrderTraversalQueue();
    System.out.println("In-Order Traversal Recursive");
    bst.inorderTraversalResursive();
    BTreePrinter.printNode(bst.getRoot());
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
    bst.levelOrderTraversalQueue();
    System.out.println("removing 13 (exists)");
    bst.removeIteratively(13);
    bst.levelOrderTraversalQueue();
    System.out.println("removing 18 (exists)");
    bst.removeIteratively(18);
    bst.levelOrderTraversalQueue();
    System.out.println("removing 9 (exists)");
    bst.removeIteratively(9);
    bst.levelOrderTraversalQueue();
    System.out.println("removing 15 (exists)");
    bst.removeIteratively(15);
    bst.levelOrderTraversalQueue();
    System.out.println("removing 7 (exists)");
    bst.removeIteratively(7);
    bst.levelOrderTraversalQueue();
    System.out.println("removing 35 (doesn't exist)");
    bst.removeIteratively(35);
    bst.levelOrderTraversalQueue();
    System.out.println("Height : " + bst.height());
    System.out.println("root: " + bst.getRoot());
    System.out.println("Level Order Traversal ");
    bst.levelOrderTraversalQueue();

    System.out.println("New Tree");
    BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
    l.forEach(bst2::insertIterative);
    System.out.println("Level Order Traversal");
    bst2.levelOrderTraversalQueue();
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
    List<Integer> sorted = List.of(12, 5, 18, 2, 9, 15, 19, 13, 17);
    BinarySearchTree<Integer> bst5 = new BinarySearchTree<>();
    sorted.forEach(bst5::insertIterative);
    BTreePrinter.printNode(bst5.getRoot());
    bst5.levelOrderTraversalQueue();
    System.out.println("Height of a Tree (which in turn also does level order traversal iteratively using queues");
    System.out.println(bst5.heightIterativeWhichAlsoDoesLevelOrderTraversal());
    BTreePrinter.printNode(bst5.getRoot());
    bst5.invertTreeIterativelyWhichAlsoDoesLevelOrderTraversal();
    System.out.println("After inverting tree with iterative attempt that also does level order traversal");
    BTreePrinter.printNode(bst5.getRoot());
    List<Integer> l2 = List.of(5, 2, 1, 3, 7, 6, 8);
    BinarySearchTree<Integer> bst6 = new BinarySearchTree<>();
    l2.forEach(bst6::insertIterative);
    BTreePrinter.printNode(bst6.getRoot());
    bst6.invertTreeIterativelyWhichAlsoDoesLevelOrderTraversal();
    BTreePrinter.printNode(bst6.getRoot());
  }
}
