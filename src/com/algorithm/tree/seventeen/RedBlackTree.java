package com.algorithm.tree.seventeen;

import com.algorithm.dynamiclist.fifteen.Queue;
import com.algorithm.dynamiclist.fifteen.Stack;


enum Color {
    RED,
    BLACK
}
public class RedBlackTree<E extends Comparable<E>> {

    private TreeNode<E> root;
    private TreeNode<E> NIL;
    
    public RedBlackTree() {
	this.NIL = new TreeNode<>();
	this.NIL.color = Color.BLACK;
	this.root = this.NIL;
    }
    
    public boolean BSTInsertIterative(E data) {
	TreeNode<E> y = NIL;
	TreeNode<E> x = root;
	while (x != NIL) {
	    y = x;
	    if (data.compareTo(x.data) < 0) {
		x = x.left;
	    } else if (data.compareTo(x.data) > 0) {
		x = x.right;
	    } else if (data.compareTo(x.data) == 0) {
		return false;
	    }
	}
	TreeNode<E> node = new TreeNode<>(data);
	node.parent = y;
	if (y == NIL) {
	    root = node;
	} else if (data.compareTo(y.data) < 0) {
	    y.left = node;
	} else {
	    y.right = node;
	}
	node.left = NIL;
	node.right = NIL;
	node.color = Color.RED;
	RB_INSERT_FIXUP(node);
	return true;
    }

    private void RB_INSERT_FIXUP(TreeNode<E> z) {
	while(z.parent.color == Color.RED) {
	    if(z.parent == z.parent.parent.left) {
		TreeNode<E> y  = z.parent.parent.right;
		if(y.color == Color.RED) { //case 1
		    y.color = Color.BLACK;
		    z.parent.color = Color.BLACK;
		    z.parent.parent.color = Color.RED;
		    z = z.parent.parent;
		} else {
		    if(z == z.parent.right) { //case 2
			z = z.parent; //turn case 2 into case 3
			leftRotate(z);
		    }
		    z.parent.color = Color.BLACK; //case 3
		    z.parent.parent.color = Color.RED;
		    rightRotate(z.parent.parent);
		}
	    } else {
		TreeNode<E> y = z.parent.parent.left;
		if(y.color == Color.RED) { //case 1
		    y.color = Color.BLACK;
		    z.parent.color = Color.BLACK;
		    z.parent.parent.color = Color.RED;
		    z = z.parent.parent;
		} else {
		    if(z == z.parent.left) { //case 2
			z = z.parent; //turn case 2 into case 3
			rightRotate(z);
		    }
		    z.parent.color = Color.BLACK; //case 3
		    z.parent.parent.color = Color.RED;
		    leftRotate(z.parent.parent);
		}
	    }
	}
	root.color = Color.BLACK;
    }

    public void levelOrderTraversalIterative() {
	int h = height(root);
	System.out.printf("%4s %4s%n", "P", "C");
	for (int level = 1; level <= h; level++) {
	    printNodeAtGivenLevel(level, root);
	}
	System.out.println();
    }

    private void printNodeAtGivenLevel(int level, TreeNode<E> node) {
	if (node == null) {
	    return;
	}
	if (level == 1) {
	    System.out.printf("%4s %4s%n", node.parent != null ? node.parent.data : null,
	        node.data);
	    return;
	}
	printNodeAtGivenLevel(level - 1, node.left);
	printNodeAtGivenLevel(level - 1, node.right);
    }

    private int height(TreeNode<E> node) {
	if (node == NIL || node == null) {
	    return 0;
	}
	int lh = height(node.left);
	int rh = height(node.right);
	return (lh > rh ? lh : rh) + 1;
    }

    public void levelOrderTraversalQueue() {
	Queue<TreeNode<E>> q = new Queue<>();
	if (root != null) {
	    q.enqueue(root);
	}
	while (!q.isEmpty()) {
	    TreeNode<E> node = q.dequeue();
	    System.out.print(node.data + " ");
	    if (node.left != null) {
		q.enqueue(node.left);
	    }
	    if (node.right != null) {
		q.enqueue(node.right);
	    }
	}
	System.out.println();
    }

    public void inorderTraversalResursive() {
	inorderHelper(root);
	System.out.println();
    }

    private void inorderHelper(TreeNode<E> node) {
	if (node == NIL) {
	    return;
	}
	inorderHelper(node.left);
	System.out.print(node.data + " ");
	inorderHelper(node.right);
    }

    public void inorderTraversalIterative() {
	Stack<TreeNode<E>> s = new Stack<>();
	TreeNode<E> node = root;

	while (node != null || !s.isEmpty()) {
	    while (node != null) {
		s.push(node);
		node = node.left;
	    }
	    node = s.pop();
	    System.out.print(node.data + " ");
	    node = node.right;
	}
	System.out.println();
    }

    public void prettyPrint() {
	BTreePrinter.printNode(root);
    }

    /**
     * Assuming x.right is not null Steps: 1) identify y 2) set x's right child to
     * y's left child 2a) if y's left child is not null, update y's left child's
     * parent to x 3) set y's parent to x's parent 4) figure out x place 4a) if x's
     * parent is null, that means x is root. Now root points to y 4b) if x is its
     * parent's left child, make y the parent's left child 4c) if x is its parent's
     * right child, make y the parent's right child 5) make x y's left child 6)
     * update x's parent to y.
     */
    public void leftRotate(E data) {
	TreeNode<E> x = search(data);
	leftRotate(x);
    }

    private void leftRotate(TreeNode<E> x) {
	TreeNode<E> y = x.right;
	x.right = y.left;
	if (y.left != null) {
	    y.left.parent = x;
	}
	y.parent = x.parent;
	if (x.parent == NIL) {
	    root = y;
	} else if (x == x.parent.left) {
	    x.parent.left = y;
	} else {
	    x.parent.right = y;
	}
	y.left = x;
	x.parent = y;
    }

    public void rightRotate(E data) {
	TreeNode<E> x = search(data);
	rightRotate(x);
    }

    private void rightRotate(TreeNode<E> x) {
	TreeNode<E> y = x.left;
	x.left = y.right;
	if(y.right!= null) {
	    y.right.parent = x;
	}
	y.parent = x.parent;
	if (x.parent == NIL) {
	    root = y;
	} else if (x == x.parent.left) {
	    x.parent.left = y;
	} else {
	    x.parent.right = y;
	}
	y.right = x;
	x.parent = y;
    }

    public TreeNode<E> successor(E data) {
	return successor(search(data));
    }

    private TreeNode<E> successor(TreeNode<E> x) {
	if (x != null) {
	    if (x.right != null) {
		return min(x.right);
	    }

	    TreeNode<E> y = x.parent;
	    while (y != null && x == y.right) {
		x = y;
		y = y.parent;
	    }
	    return y;
	}
	return null;
    }

    public TreeNode<E> predecessor(E data) {
	return predecessor(search(data));
    }

    private TreeNode<E> predecessor(TreeNode<E> x) {
	if (x != null) {
	    if (x.left != null) {
		return max(x.left);
	    }

	    TreeNode<E> y = x.parent;
	    while (y != null && x == y.left) {
		x = y;
		y = y.parent;
	    }
	    return y;
	}
	return null;
    }

    private TreeNode<E> max(TreeNode<E> node) {
	if (node != null && node.left != null) {
	    return max(node.left);
	}
	return node;
    }

    private TreeNode<E> min(TreeNode<E> node) {
	if (node.left != null) {
	    return min(node.left);
	}
	return node;
    }

    public TreeNode<E> search(E key) {
	return search(root, key);
    }

    private TreeNode<E> search(TreeNode<E> node, E key) {
	if (node == null || (node != null) && node.data.compareTo(key) == 0) {
	    return node;
	} else if (key.compareTo(node.data) < 0) {
	    return search(node.left, key);
	} else {
	    return search(node.right, key);
	}
    }

    public void inorderTraversalReverseResursive() {
	inorderReverseTraversal(root);
	System.out.println();
    }

    private void inorderReverseTraversal(TreeNode<E> node) {
	if (node == null) {
	    return;
	}
	inorderReverseTraversal(node.right);
	System.out.print(node.data + " ");
	inorderReverseTraversal(node.left);
    }

    public void inorderTraversalRecursive(E data) {
	TreeNode<E> node = search(data);
	inorderReverseTraversal(node);
    }

}
