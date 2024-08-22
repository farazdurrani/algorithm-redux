package com.algorithm.tree.seven;

public class TreeNode<E extends Comparable<E>> {

    E data;
    TreeNode<E> left;
    TreeNode<E> right;

    public TreeNode(E data) {
	this.data = data;
	left = right = null;
    }

    public boolean insert(E data) {
	if (data.compareTo(this.data) < 0) {
	    if (left == null) {
		left = new TreeNode<>(data);
		return true;
	    } else {
		return left.insert(data);
	    }
	} else if (data.compareTo(this.data) > 0) {
	    if (right == null) {
		right = new TreeNode<>(data);
		return true;
	    } else {
		return right.insert(data);
	    }
	} else {
	    return false;
	}
    }

}
