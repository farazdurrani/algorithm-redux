package com.algorithm.tree.twentyone;

@SuppressWarnings("unchecked")
public class TreeNode<E extends Comparable<E>> implements Comparable<TreeNode<E>> {

    TreeNode<E> parent;
    TreeNode<E> left;
    TreeNode<E> right;
    Color color;
    E data;

    public TreeNode() {
	this(null);
    }

    public TreeNode(E data) {
	this(null, data);
    }

    public TreeNode(TreeNode<E> parent, E data) {
	this.parent = parent;
	this.data = data;
    }

    public TreeNode<E> insert(TreeNode<E> parent, E data) {

	if (data.compareTo(this.data) < 0) {
	    if (left == RedBlackTree.nil) {
		left = new TreeNode<>(parent, data);
		return left;
	    } else {
		return left.insert(left, data);
	    }
	} else if (data.compareTo(this.data) > 0) {
	    if (right == RedBlackTree.nil) {
		right = new TreeNode<>(parent, data);
		return right;
	    } else {
		return right.insert(right, data);
	    }
	}

	// ignore duplicates
	return RedBlackTree.nil;
    }

    @Override
    public int compareTo(TreeNode<E> o) {
	throw new RuntimeException("Not Implemented");
    }

}
