package com.algorithm.tree.twenty;

public class TreeNode<E extends Comparable<E>> implements Comparable<TreeNode<E>>{
    E data;
    TreeNode<E> left;
    TreeNode<E> right;
    TreeNode<E> parent;
    Color color;

    public TreeNode() {
	this(null);
    }
    public TreeNode(E data) {
	this(null, data);
    }

    public TreeNode(TreeNode<E> parent, E data) {
	this.parent = parent;
	this.data = data;
	this.color = Color.BLACK;
    }

    public TreeNode<E> insert(TreeNode<E> p, E data) {
	if (data.compareTo(this.data) < 0) {
	    if (left == RedBlackTree.NIL) {
		left = new TreeNode<>(p, data);
		return left;
	    } else {
		return left.insert(left, data);
	    }
	} else if (data.compareTo(this.data) > 0) {
	    if (right == RedBlackTree.NIL) {
		right = new TreeNode<>(p, data);
		return right;
	    } else {
		return right.insert(right, data);
	    }
	}
	// ignore dup
	return RedBlackTree.NIL;
    }
    @Override
    public String toString() {
	return "data=" + this.data + ", p=" + this.parent.data + ", color=" + this.color;
    }
    @Override
    public int compareTo(TreeNode<E> o) {
	throw new RuntimeException("Don't use it");
    }
    
}
