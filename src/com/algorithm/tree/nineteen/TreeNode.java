package com.algorithm.tree.nineteen;

public class TreeNode<V extends Comparable<V>> implements Comparable<TreeNode<V>> {
	TreeNode<V> left;
	TreeNode<V> right;
	TreeNode<V> p;
	V data;
	Color color;

	public TreeNode(TreeNode<V> parent, V data, Color color) {
	    this.p = parent;
	    this.data = data;
	    this.color = color;
	}

	@Override
	public String toString() {
	    return data + "," + color + "[parent=" + p.data + " " + p.color + "]";
	}

	@Override
	public int compareTo(TreeNode<V> o) {
	    throw new RuntimeException("NOT IMPLEMENTED");
	}

	public TreeNode<V> insert(TreeNode<V> node, V data) {
	    if (data.compareTo(this.data) < 0) {
		if (left == RedBlackTree.NIL) {
		    left = new TreeNode<>(node, data, Color.RED);
		    return left;
		} else {
		    return left.insert(left, data);
		}
	    } else if (data.compareTo(this.data) > 0) {
		if (right == RedBlackTree.NIL) {
		    right = new TreeNode<>(node, data, Color.RED);
		    return right;
		} else {
		    return right.insert(right, data);
		}
	    } else {
		return null;
	    }
	}
}

