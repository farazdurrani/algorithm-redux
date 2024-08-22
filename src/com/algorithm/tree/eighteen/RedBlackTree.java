package com.algorithm.tree.eighteen;

public class RedBlackTree<E extends Comparable<E>> {

    private TreeNode<E> root;
    private TreeNode<E> NIL;
    private Color BLACK = Color.BLACK;
    private Color RED = Color.RED;

    public RedBlackTree() {
	this.NIL = new TreeNode<>(null, null);
	this.NIL.color = BLACK;
	this.root = NIL;
    }

    public boolean BSTInsertIterative(E data) {
	TreeNode<E> y = this.NIL;
	TreeNode<E> x = this.root;
	while (x != this.NIL) {
	    y = x;
	    if (x.data.compareTo(data) == 0) {
		return false;
	    } else if (data.compareTo(x.data) > 0) {
		x = x.right;
	    } else {
		x = x.left;
	    }
	}
	TreeNode<E> z = new TreeNode<>(y, data);
	if (y == NIL) {
	    root = z;
	} else if (data.compareTo(y.data) < 0) {
	    y.left = z;
	} else {
	    y.right = z;
	}
	z.left = this.NIL;
	z.right = this.NIL;
	z.color = RED;
	rbInsertFixup(z);
	return true;
    }

    private void rbInsertFixup(TreeNode<E> z) {
	while (z.parent.color == RED) {
	    if (z.parent == z.parent.parent.left) {
		TreeNode<E> y = z.parent.parent.right;
		if (y.color == RED) { // case 1 uncle is red
		    // color parent and uncle red, grandparent red, and move to grandparent
		    y.color = BLACK;
		    z.parent.color = BLACK;
		    z.parent.parent.color = RED;
		    z = z.parent.parent;
		} else {
		    if (z == z.parent.right) {// case 2 where z is right child
			// turn it into case 3
			z = z.parent;
			leftRotate(z);
		    }
		    // case 3 where z is left child
		    z.parent.color = BLACK;
		    z.parent.parent.color = RED;
		    rightRotate(z.parent.parent);
		}
	    } else {
		TreeNode<E> y = z.parent.parent.left;
		if (y.color == RED) {
		    y.color = BLACK;
		    z.parent.color = BLACK;
		    z.parent.parent.color = RED;
		    z = z.parent.parent;
		} else {
		    if (z == z.parent.left) {
			z = z.parent;
			rightRotate(z);
		    }
		    z.parent.color = BLACK;
		    z.parent.parent.color = RED;
		    leftRotate(z.parent.parent);
		}
	    }
	}
	root.color = BLACK;
    }

    private void rightRotate(TreeNode<E> x) {
	TreeNode<E> y = x.left;
	x.left = y.right;
	if (y.right != NIL) {
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

    private void leftRotate(TreeNode<E> x) {
	TreeNode<E> y = x.right;
	x.right = y.left;
	if (y.left != NIL) {
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

}
