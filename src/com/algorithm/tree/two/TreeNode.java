package com.algorithm.tree.two;

public class TreeNode<E extends Comparable<E>> {
    TreeNode<E> left;
    TreeNode<E> right;
    E data;

    public TreeNode(E data) {
	this(data, null, null);
    }

    private TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
	this.data = data;
	this.left = left;
	this.right = right;
    }

    public void insert(E insertData) {
	if (insertData.compareTo(data) < 0) {
	    if (left == null) {
		left = new TreeNode<>(insertData);
	    } else {
		left.insert(insertData);
	    }
	} else if (insertData.compareTo(data) > 0) {
	    if (right == null) {
		right = new TreeNode<>(insertData);
	    } else {
		right.insert(insertData);
	    }
	}
    }

    @Override
    public String toString() {
	return "[data=" + data + "]";
    }
    
    
}
