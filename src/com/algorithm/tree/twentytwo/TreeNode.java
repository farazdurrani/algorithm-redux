package com.algorithm.tree.twentytwo;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class TreeNode<E extends Comparable<E>> implements Comparable<TreeNode<E>> {

	public Color color;
	public TreeNode<E> parent;
	public TreeNode<E> left;
	public TreeNode<E> right;
	public E data;

	public TreeNode() {
	}

	public TreeNode(TreeNode<E> parent, E data) {
		this.parent = parent;
		this.data = data;
		this.left = RedBlackTree.nil;
		this.right = RedBlackTree.nil;
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
		return RedBlackTree.nil;
	}

	@Override
	public int compareTo(TreeNode<E> o) {
		throw new RuntimeException("NOT IMPLEMENTED");
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + this.data + "]";
	}

}
