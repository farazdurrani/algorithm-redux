package com.algorithm.tree.seventeen;

public class TreeNode<V extends Comparable<V>> implements Comparable<TreeNode<V>> {
    TreeNode<V> parent;
    TreeNode<V> left;
    TreeNode<V> right;
    V data;
    Color color;

    public TreeNode() {
	
    }
    public TreeNode(V data) {
	this.data = data;
    }
    
    public TreeNode(TreeNode<V> parent, V data) {
	this.parent = parent;
	this.data = data;
    }

    public boolean insert(TreeNode<V> parent, V data) {
	if (data.compareTo(this.data) < 0) {
	    if (left == null) {
		left = new TreeNode<>(parent, data);
		return true;
	    } else {
		return left.insert(left, data);
	    }
	} else if (data.compareTo(this.data) > 0) {
	    if (right == null) {
		right = new TreeNode<>(parent, data);
		return true;
	    } else {
		return right.insert(right, data);
	    }
	}
	// ignore duplicates
	return false;
    }

    @Override
    public String toString() {
	return data + " -> [parent: " + (parent != null ? parent.data : null) + "]";
    }

    @Override
    public int compareTo(TreeNode<V> o) {
	throw new RuntimeException("Don't use please.");
    }
}
