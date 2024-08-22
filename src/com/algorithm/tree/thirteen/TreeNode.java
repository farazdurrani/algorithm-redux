package com.algorithm.tree.thirteen;

public class TreeNode<V extends Comparable<V>> implements Comparable<TreeNode<V>> {

    TreeNode<V> left;
    TreeNode<V> right;
    V data;

    public TreeNode(V data) {
	this.data = data;
    }

    public void insert(V data) {
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

    @Override
    public int compareTo(TreeNode<V> o) {
	throw new RuntimeException("not implemented");
    }
}
