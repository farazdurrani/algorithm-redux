package com.algorithm.tree.ten;

public class TreeNode<E extends Comparable<E>> {

    E data;
    TreeNode<E> left;
    TreeNode<E> right;
    
    public TreeNode(E data) {
	this.data = data;
	left = right = null;
    }
    
    public void insert(E data) {
	if(data.compareTo(this.data) < 0) {
	    if(left == null) {
		left = new TreeNode<>(data);
	    } else {
		left.insert(data);
	    }
	} else if(data.compareTo(this.data) > 0) {
	    if(right == null) {
		right = new TreeNode<E>(data);
	    } else {
		right.insert(data);
	    }
	}
	//ignore duplicates
    }
}
