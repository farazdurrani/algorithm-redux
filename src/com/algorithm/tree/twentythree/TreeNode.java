package com.algorithm.tree.twentythree;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TreeNode<E extends Comparable<E>> implements Comparable<TreeNode<E>> {

	TreeNode<E> left;
	TreeNode<E> right;
	TreeNode<E> parent;
	E data;
	Color color;
	static TreeNode NIL = new TreeNode<>();

	public TreeNode() {
		
	}

	public TreeNode(TreeNode<E> parent, E data) {
		this.parent = parent;
		this.data = data;
		this.left = NIL;
		this.right = NIL;
	}

	public TreeNode<E> insert(TreeNode<E> parent, E data) {
		if (data.compareTo(this.data) < 0) {
			if (left == NIL) {
				left = new TreeNode<>(parent, data);
				return left;
			} else {
				return left.insert(left, data);
			}
		} else if (data.compareTo(this.data) > 0) {
			if (right == NIL) {
				right = new TreeNode<>(parent, data);
				return right;
			} else {
				return right.insert(right, data);
			}
		} // ignore duplicates
		return null;
	}

	@Override
	public int compareTo(TreeNode<E> o) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public String toString() {
		return String.valueOf(this.data);
	}
}
