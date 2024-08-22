package com.algorithm.tree.four;

public class TreeNode<E extends Comparable<E>> {
    TreeNode<E> left;
    TreeNode<E> right;
    E data;

    public TreeNode(E data) {
	this.data = data;
	left = right = null;
    }

    public void insert(E data) {
	if (data.compareTo(this.data) < 0) {
	    if (left == null) {
		left = new TreeNode<>(data);
	    } else {
		left.insert(data);
	    }
	} else if (data.compareTo(this.data) > 0) {
	    if (right == null) {
		right = new TreeNode<>(data);
	    } else {
		right.insert(data);
	    }
	}
    }
}
