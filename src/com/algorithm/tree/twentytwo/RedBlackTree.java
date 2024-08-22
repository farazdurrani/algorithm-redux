package com.algorithm.tree.twentytwo;

import com.algorithm.dynamiclist.seventeen.doublelinkedlist.QueueDoublyLinked;
import com.algorithm.dynamiclist.seventeen.doublelinkedlist.StackDoublyLinked;

@SuppressWarnings({ "rawtypes", "static-access", "unchecked" })
public class RedBlackTree<E extends Comparable<E>> {

	private TreeNode<E> root;
	static TreeNode nil;
	private Color RED = Color.RED;
	private Color BLACK = Color.BLACK;

	public RedBlackTree() {
		this.nil = new TreeNode<>();
		this.nil.color = BLACK;
		this.root = this.nil;
		this.root.parent = this.nil;
	}

	public boolean insertRecursive(E data) {
		if (root == nil) {
			root = new TreeNode<>(nil, data);
			root.color = BLACK;
			root.left = nil;
			root.right = nil;
			return true;
		} else {
			TreeNode<E> z = root.insert(root, data);
			if (z != nil) {
				z.left = nil;
				z.right = nil;
				z.color = RED;
				insertRBFixup(z);
				return true;
			}
			return false;
		}

	}
	
	public void removeRecursive(E data) {
		root = remove(root, data);
	}

	private TreeNode<E> remove(TreeNode<E> node, E data) {
		if (node == nil) {
			return node;
		}
		if (data.compareTo(node.data) < 0) {
			node.left = remove(node.left, data);
		} else if (data.compareTo(node.data) > 0) {
			node.right = remove(node.right, data);
		} else {
			if (node.left == nil) {
				node = node.right;
			} else if (node.right == nil) {
				node = node.left;
			} else {
				TreeNode<E> temp = minR(node.right);
				node.data = temp.data;
				node.right = remove(node.right, node.data);
			}
		}
		return node;
	}
	
	public TreeNode<E> searchRecursive(E data) {
		return searchR(root, data);
	}

	private TreeNode<E> searchR(TreeNode<E> node, E data) {
		if (node == nil || (node != nil && node.data.compareTo(data) == 0)) {
			return node;
		} else if (data.compareTo(node.data) < 0) {
			return searchR(node.left, data);
		} else {
			return searchR(node.right, data);
		}
	}
	
	public void inorderTraversalResursive() {
		inorderHelper(root);
		System.out.println();
	}

	private void inorderHelper(TreeNode<E> node) {
		if (node == nil) {
			return;
		}
		inorderHelper(node.left);
		System.out.print(node.data + " ");
		inorderHelper(node.right);
	}
	
	public void preorderTraversalRecursive() {
		preorderHelper(root);
		System.out.println();
	}

	private void preorderHelper(TreeNode<E> node) {
		if (node == nil) {
			return;
		}
		System.out.print(node.data + " ");
		preorderHelper(node.left);
		preorderHelper(node.right);
	}


	public void postorderTraversalRecursive() {
		postorderHelper(root);
		System.out.println();
	}

	private void postorderHelper(TreeNode<E> node) {
		if (node == nil) {
			return;
		}
		postorderHelper(node.left);
		postorderHelper(node.right);
		System.out.print(node.data + " ");
	}
	
	public E minIterative() {
		return minI(root);
	}

	private E minI(TreeNode<E> node) {
		while (node != nil && node.left != nil) {
			node = node.left;
		}
		return node.data;
	}

	public E maxIterative() {
		return maxI(root);
	}

	private E maxI(TreeNode<E> node) {
		while (node != nil && node.right != nil) {
			node = node.right;
		}
		return node.data;
	}
	public void invertTree() {
		root = invert(root);
	}

	private TreeNode<E> invert(TreeNode<E> node) {
		if (node == nil) {
			return node;
		}
		TreeNode<E> left = invert(node.left);
		TreeNode<E> right = invert(node.right);
		node.left = right;
		node.right = left;
		return node;
	}
	
	private void insertRBFixup(TreeNode<E> z) {
		while (z.parent.color == RED) {
			if (z.parent == z.parent.parent.left) {
				TreeNode<E> y = z.parent.parent.right;
				if (y.color == RED) {
					y.color = BLACK;
					z.parent.color = BLACK;
					z.parent.parent.color = RED;
					z = z.parent.parent;
				} else {
					if (z == z.parent.right) {
						z = z.parent;
						leftRotate(z);
					}
					z.parent.color = BLACK;
					z.parent.parent.color = RED;
					rightRotate(z.parent.parent);
				}
			} else {
				TreeNode<E> y = z.parent.parent.left;
				if (y.color == RED) {
					y.color = BLACK;
					z.parent.color = BLACK;
					z.parent.parent.color = RED;
					z = z.parent.parent;
				} else {
					if (z == z.parent.left) {
						z = z.parent;
						rightRotate(z);
					}
					z.parent.color = BLACK;
					z.parent.parent.color = RED;
					leftRotate(z.parent.parent);
				}
			}
		}
		root.color = BLACK;
	}

	private void rightRotate(TreeNode<E> x) {
		TreeNode<E> y = x.left;
		x.left = y.right;
		if (y.right != nil) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == nil) {
			root = y;
		} else if (x == x.parent.right) {
			x.parent.right = y;
		} else {
			x.parent.left = y;
		}
		y.right = x;
		x.parent = y;
	}

	private void leftRotate(TreeNode<E> x) {
		TreeNode<E> y = x.right;
		x.right = y.left;
		if (y.left != nil) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == nil) {
			root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}

	public void levelOrderTraversalIterative() {
		int height = height();
		for (int level = 1; level <= height; level++) {
			printNodeAtGivenLevel(root, level);
		}
		System.out.println();
	}

	private void printNodeAtGivenLevel(TreeNode<E> node, int level) {
		if (node == nil) {
			return;
		}
		if (level == 1) {
			System.out.print(node.data + " ");
			return;
		}
		printNodeAtGivenLevel(node.left, level - 1);
		printNodeAtGivenLevel(node.right, level - 1);
	}

	public int height() {
		return height(root);
	}

	private int height(TreeNode<E> node) {
		if (node == nil) {
			return 0;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		return (lh > rh ? lh : rh) + 1;
	}

	public E minRecursive() {
		return minR(root).data;
	}

	private TreeNode<E> minR(TreeNode<E> node) {
		if (node != nil && node.left != nil) {
			return minR(node.left);
		}
		return node;
	}

	public E maxRecursive() {
		return maxR(root).data;
	}

	private TreeNode<E> maxR(TreeNode<E> node) {
		if (node != nil && node.right != nil) {
			return maxR(node.right);
		}
		return node;
	}

	public TreeNode<E> getRoot() {
		return root;
	}

	public E successor(E data) {
		TreeNode<E> x = searchRecursive(data);
		if (x != nil && x.right != nil) {
			return minR(x.right).data;
		}
		TreeNode<E> y = x.parent;
		while (y != nil && x == y.right) {
			x = y;
			y = y.parent;
		}
		return y.data;
	}

	public E containsIterative(E data) {
		TreeNode<E> node = root;
		while (node != nil && node.data.compareTo(data) != 0) {
			if (data.compareTo(node.data) < 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return node.data;
	}

	public void levelOrderTraversalQueue() {
		QueueDoublyLinked<TreeNode<E>> q = new QueueDoublyLinked<>();
		q.enqueue(root);
		while (!q.isEmpty()) {
			TreeNode<E> node = q.dequeue();
			System.out.print(node.data + " ");
			if (node.left != nil) {
				q.enqueue(node.left);
			}
			if (node.right != nil) {
				q.enqueue(node.right);
			}
		}
		System.out.println();
	}

	public boolean insertIterative(E data) {
		TreeNode<E> y = nil;
		TreeNode<E> x = root;
		while (x != nil) {
			y = x;
			if (data.compareTo(x.data) == 0) {
				System.out.println("Can't enter duplicate");
				return false;
			} else if (data.compareTo(x.data) < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}

		TreeNode<E> z = new TreeNode<>(y, data);
		if (y == nil) {
			root = z;
		} else if (data.compareTo(y.data) < 0) {
			y.left = z;
		} else {
			y.right = z;
		}
		z.left = nil;
		z.right = nil;
		z.color = RED;
		insertRBFixup(z);
		return true;
	}
	
	public void inorderTraversalIterative() {
		StackDoublyLinked<TreeNode<E>> s = new StackDoublyLinked<>();
		TreeNode<E> curr = root;
		while (curr != nil || !s.isEmpty()) {
			while (curr != nil) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
		System.out.println();
	}

	public void preorderTraversalIterative() {
		StackDoublyLinked<TreeNode<E>> s = new StackDoublyLinked<>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode<E> node = s.pop();
			System.out.print(node.data + " ");
			if (node.right != nil) {
				s.push(node.right);
			}
			if (node.left != nil) {
				s.push(node.left);
			}
		}
		System.out.println();
	}

	public void postorderTraversalIterative() {
		StackDoublyLinked<TreeNode<E>> s1 = new StackDoublyLinked<>();
		StackDoublyLinked<TreeNode<E>> s2 = new StackDoublyLinked<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			TreeNode<E> node = s1.pop();
			s2.push(node);
			if (node.left != nil) {
				s1.push(node.left);
			}
			if (node.right != nil) {
				s1.push(node.right);
			}
		}
		while (!s2.isEmpty()) {
			System.out.print(s2.pop().data + " ");
		}
		System.out.println();

	}

	public void removeIteratively(E data) {
		TreeNode<E> z = searchRecursive(data);
		if (z == nil) {
			System.out.println("Can't find it");
			return;
		}
		if (z.left == nil) {
			transplant(z, z.right);
		} else if (z.right == nil) {
			transplant(z, z.left);
		} else {
			TreeNode<E> y = minR(z.right);
			if (y.parent != z) {
				transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplant(z, y);
			y.left = z.left;
			y.left.parent = y;
		}
	}

	private void deleteRBFixup(TreeNode<E> x) {
		while (x != root && x.color == BLACK) {
			if (x == x.parent.left) {
				TreeNode<E> w = x.parent.right;
				if (w.color == RED) {
					w.color = BLACK;
					x.parent.color = RED;
					leftRotate(x.parent);
					w = x.parent.right;
				}
				if (w.left.color == BLACK && w.right.color == BLACK) {
					w.color = RED;
					x = x.parent;
				} else {
					if (w.right.color == BLACK) {
						w.left.color = BLACK;
						w.color = RED;
						rightRotate(w);
						w = x.parent.right;
					}
					w.color = x.parent.color;
					x.parent.color = BLACK;
					w.right.color = BLACK;
					leftRotate(x.parent);
					x = root;
				}
			} else {
				TreeNode<E> w = x.parent.left;
				if (w.color == RED) {
					w.color = BLACK;
					x.parent.color = RED;
					rightRotate(x.parent);
					w = x.parent.left;
				}
				if (w.left.color == BLACK && w.right.color == BLACK) {
					w.color = RED;
					x = x.parent;
				} else {
					if (w.left.color == BLACK) {
						w.right.color = BLACK;
						w.color = RED;
						leftRotate(w);
						w = x.parent.left;
					}
					w.color = x.parent.color;
					x.parent.color = BLACK;
					w.left.color = BLACK;
					rightRotate(x.parent);
					x = root;
				}
			}
		}
		x.color = BLACK;
	}

	private void transplant(TreeNode<E> u, TreeNode<E> v) {
		if (u.parent == nil) {
			root = v;
		} else if (u == u.parent.left) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		if (v != nil) {
			v.parent = u.parent;
		}
	}

	public void removeIterativeRED_BLACK(E data) {
		TreeNode<E> z = searchRecursive(data);
		if (z == nil) {
			System.out.println("Can't find it");
			return;
		}
		TreeNode<E> y = z;
		Color orig_y_color = y.color;
		TreeNode<E> x = null;
		if (z.left == nil) {
			x = z.right;
			transplantRB(z, z.right);
		} else if (z.right == nil) {
			x = z.left;
			transplantRB(z, z.left);
		} else {
			y = minR(z.right);
			orig_y_color = y.color;
			x = y.right;
			if (y.parent == z) {
				x.parent = z;
			} else {
				transplantRB(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplantRB(z, y);
			y.left = z.left;
			y.left.parent = y;
			y.color = z.color;
		}
		if (orig_y_color == BLACK) {
			deleteRBFixup(x);
		}
	}

	private void transplantRB(TreeNode<E> u, TreeNode<E> v) {
		if (u.parent == nil) {
			root = v;
		} else if (u == u.parent.left) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		v.parent = u.parent;
	}

	public E predecessor(E data) {
		TreeNode<E> x = searchRecursive(data);
		if (x != nil && x.left != nil) {
			return maxR(x.left).data;
		}
		TreeNode<E> y = x.parent;
		while (y != nil && x == y.left) {
			x = y;
			y = y.parent;
		}
		return y.data;
	}

	public void removeAll() {
		this.nil = new TreeNode<>();
		this.nil.color = BLACK;
		this.root = this.nil;
		this.root.parent = this.nil;
	}
}
