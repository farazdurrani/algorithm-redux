package com.algorithm.tree.twentythree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.algorithm.dynamiclist.eighteen.doublelinkedlist.Queue;
import com.algorithm.dynamiclist.eighteen.doublelinkedlist.Stack;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class RedBlackTree<E extends Comparable<E>> {

	// helper
	private final TreeNode NIL;

	private TreeNode<E> root;
	private Color RED = Color.RED;
	private Color BLACK = Color.BLACK;

	public RedBlackTree() {
		NIL = TreeNode.NIL;
		NIL.color = BLACK;
		root = NIL;
	}

	public boolean insertRecursive(E data) {
		if (root == NIL) {
			root = new TreeNode<>(NIL, data);
			root.color = BLACK;
			root.left = NIL;
			root.right = NIL;
			return true;
		} else {
			TreeNode<E> z = root.insert(root, data);
			if (z != null) {
				z.left = NIL;
				z.right = NIL;
				z.color = RED;
				insertRBFixup(z);
				return true;
			}
		}
		return false;
	}

	private void insertRBFixup(TreeNode<E> z) {
		while (z.parent.color == RED) {
			if (z.parent == z.parent.parent.left) {
				TreeNode<E> y = z.parent.parent.right; // uncle
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
			} else { // symmetric
				TreeNode<E> y = z.parent.parent.left; // uncle
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

	public void levelOrderTraversalIterative() {
		int h = height();
		for (int level = 1; level <= h; level++) {
			printNodeAtGivenLevel(root, level);
		}
		System.out.println();
	}

	private void printNodeAtGivenLevel(TreeNode<E> node, int level) {
		if (node == NIL) {
			return;
		}
		if (level == 1) {
			System.out.print(node.data + " ");
			return;
		}
		printNodeAtGivenLevel(node.left, level - 1);
		printNodeAtGivenLevel(node.right, level - 1);
	}

	public E minRecursive() {
		return minR(root).data;
	}

	private TreeNode<E> minR(TreeNode<E> node) {
		if (node != NIL && node.left != NIL) {
			return minR(node.left);
		}
		return node;
	}

	public E maxRecursive() {
		return maxR(root).data;
	}

	private TreeNode<E> maxR(TreeNode<E> node) {
		if (node != NIL && node.right != NIL) {
			return maxR(node.right);
		}
		return node;
	}

	public TreeNode<E> getRoot() {
		return root;
	}

	public E successor(E data) {
		TreeNode<E> x = searchRecursive(data);
		if (x != NIL && x.right != NIL) {
			return minI(x.right).data;
		}
		TreeNode<E> y = x.parent;
		while (y != NIL && y.right == x) {
			x = y;
			y = x.parent;
		}
		return y.data;
	}

	public TreeNode<E> searchRecursive(E data) {
		return searchRecursive(root, data);
	}

	private TreeNode<E> searchRecursive(TreeNode<E> node, E data) {
		if (node == NIL) {
			return node;
		}
		if (data.compareTo(node.data) < 0) {
			return searchRecursive(node.left, data);
		} else if (data.compareTo(node.data) > 0) {
			return searchRecursive(node.right, data);
		}
		return node;
	}

	public void inorderTraversalIterative() {
		Stack<TreeNode<E>> stack = new Stack<>();
		TreeNode<E> curr = root;
		while (curr != NIL || !stack.isEmpty()) {
			while (curr != NIL) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
		System.out.println();
	}

	public E containsIterative(E data) {
		TreeNode<E> node = root;
		while (node != NIL && (data.compareTo(node.data) != 0)) {
			if (data.compareTo(node.data) < 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return node.data;
	}

	public void levelOrderTraversalQueue() {
		TreeNode<E> node = root;
		Queue<TreeNode<E>> stack = new Queue<>();
		stack.enqueue(node);
		while (!stack.isEmpty()) {
			TreeNode<E> curr = stack.dequeue();
			System.out.print(curr.data + " ");
			if (curr.left != NIL) {
				stack.enqueue(curr.left);
			}
			if (curr.right != NIL) {
				stack.enqueue(curr.right);
			}
		}
		System.out.println();
	}

	public void inorderTraversalResursive() {
		inorderHelper(root);
		System.out.println();
	}

	private void inorderHelper(TreeNode<E> node) {
		if (node == NIL) {
			return;
		}
		inorderHelper(node.left);
		System.out.print(node.data + " ");
		inorderHelper(node.right);
	}

	public boolean insertIterative(E data) {
		TreeNode<E> y = NIL;
		TreeNode<E> x = root;
		while (x != NIL) {
			y = x;
			if (data.compareTo(x.data) == 0) {
				System.out.println("Duplicate " + data);
				return false;
			} else if (data.compareTo(x.data) < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		TreeNode<E> z = new TreeNode<>(y, data);
		if (y == NIL) {
			root = z;
		} else if (data.compareTo(y.data) < 0) {
			y.left = z;
		} else {
			y.right = z;
		}
		z.left = NIL;
		z.right = NIL;
		z.color = RED;
		insertRBFixup(z);
		return true;
	}

	public void preorderTraversalRecursive() {
		preorderHelper(root);
		System.out.println();
	}

	private void preorderHelper(TreeNode<E> node) {
		if (node == NIL) {
			return;
		}
		System.out.print(node.data + " ");
		preorderHelper(node.left);
		preorderHelper(node.right);
	}

	public void preorderTraversalIterative() {
		Stack<TreeNode<E>> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode<E> node = stack.pop();
			System.out.print(node.data + " ");
			if (node.right != NIL) {
				stack.push(node.right);
			}
			if (node.left != NIL) {
				stack.push(node.left);
			}
		}
		System.out.println();
	}

	public void postorderTraversalRecursive() {
		postorderHelper(root);
		System.out.println();
	}

	private void postorderHelper(TreeNode<E> node) {
		if (node == NIL) {
			return;
		}
		postorderHelper(node.left);
		postorderHelper(node.right);
		System.out.print(node.data + " ");
	}

	public void postorderTraversalIterative() {
		Stack<TreeNode<E>> s1 = new Stack<>();
		Stack<TreeNode<E>> s2 = new Stack<>();
		s1.push(root);
		while (!s1.isEmpty()) {
			TreeNode<E> node = s1.pop();
			s2.push(node);
			if (node.left != NIL) {
				s1.push(node.left);
			}
			if (node.right != NIL) {
				s1.push(node.right);
			}
		}
		while (!s2.isEmpty()) {
			System.out.print(s2.pop() + " ");
		}
		System.out.println();
	}

	public void removeRecursive(E data) {
		root = removeR(root, data);
	}

	private TreeNode<E> removeR(TreeNode<E> node, E data) {
		if (node == NIL) {
			return node;
		}
		if (data.compareTo(node.data) < 0) {
			node.left = removeR(node.left, data);
		} else if (data.compareTo(node.data) > 0) {
			node.right = removeR(node.right, data);
		} else {
			if (node.left == NIL && node.right == NIL) {
				node = NIL;
			} else if (node.left == NIL) {
				node = node.right;
			} else if (node.right == NIL) {
				node = node.left;
			} else {
				TreeNode<E> temp = minR(node.right);
				node.data = temp.data;
				node.right = removeR(node.right, data);
			}
		}
		return node;
	}

	public int height() {
		return height(root);
	}

	private int height(TreeNode<E> node) {
		if (node == NIL) {
			return 0;
		}
		int lh = height(node.left);
		int rh = height(node.right);

		return (lh > rh ? lh : rh) + 1;
	}

	public void invertTree() {
		root = invert(root);
	}

	private TreeNode<E> invert(TreeNode<E> node) {
		if (node == NIL) {
			return node;
		}
		TreeNode<E> l = invert(node.left);
		TreeNode<E> r = invert(node.right);
		node.left = r;
		node.right = l;
		return node;
	}

	public void removeIteratively(E data) {
		TreeNode<E> z = searchRecursive(data);
		if (z == NIL) {
			System.out.println("Can't find " + data);
			return;
		}
		if (z.left == NIL) {
			transplant(z, z.right);
		} else if (z.right == NIL) {
			transplant(z, z.left);
		} else {
			TreeNode<E> y = minI(z.right);
			if (y.parent != z) {
				transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplant(z, y);
			y.left = z.left;
			y.parent.left = y;

		}
	}

	private void transplant(TreeNode<E> u, TreeNode<E> v) {
		if (u.parent == NIL) {
			root = v;
		} else if (u.parent.left == u) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		if (v != NIL) {
			v.parent = u.parent;
		}
	}

	private void leftRotate(TreeNode<E> x) {
		TreeNode<E> y = x.right;
		x.right = y.left;
		if (y.left != NIL) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == NIL) {
			root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}

	private void rightRotate(TreeNode<E> x) {
		TreeNode<E> y = x.left;
		x.left = y.right;
		if (y.right != NIL) {
			y.right.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == NIL) {
			root = y;
		} else if (x == x.parent.left) {
			x.parent.left = y;
		} else {
			x.parent.right = y;
		}
		y.right = x;
		x.parent = y;
	}

	public void removeIterativeRED_BLACK(E data) {
		TreeNode<E> z = searchRecursive(data);
		if (z == NIL) {
			System.out.println(data + " not found.");
			return;
		}
		TreeNode<E> y = z;
		TreeNode<E> x = null;
		Color orignalYColor = y.color;
		if (z.left == NIL) {
			x = z.right;
			rbTransplant(z, z.right);
		} else if (z.right == NIL) {
			x = z.left;
			rbTransplant(z, z.left);
		} else {
			y = minI(z.right);
			orignalYColor = y.color;
			x = y.right;
			if (y.parent == z) {
				x.parent = z;
			} else {
				rbTransplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			rbTransplant(z, y);
			y.left = z.left;
			y.left.parent = y;
			y.color = z.color;
		}
		if (orignalYColor == BLACK) {
			rbDeleteFixup(x);
		}
	}

	private void rbTransplant(TreeNode<E> u, TreeNode<E> v) {
		if (u.parent == NIL) {
			root = v;
		} else if (u == u.parent.left) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		v.parent = u.parent;
	}

	private void rbDeleteFixup(TreeNode<E> x) {
		while (x != root && x.color == BLACK) {
			if (x == x.parent.left) {
				TreeNode<E> w = x.parent.right;
				if (w.color == RED) { // case 1: sibbling is red
					w.color = BLACK;
					x.parent.color = RED;
					leftRotate(x.parent);
					w = x.parent.right;
				}
				if (w.left.color == BLACK && w.right.color == BLACK) {
					w.color = RED;
					x = x.parent;
				} else {
					if (x.right.color == BLACK) {
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
			} // symmetric
			else {
				TreeNode<E> w = x.parent.left;
				if (w.color == RED) { // case 1: sibbling is red
					w.color = BLACK;
					x.parent.color = RED;
					rightRotate(x.parent);
					w = x.parent.left;
				}
				if (w.left.color == BLACK && w.right.color == BLACK) {
					w.color = RED;
					x = x.parent;
				} else {
					if (x.left.color == BLACK) {
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
	}

	public E minIterative() {
		return minI(root).data;
	}

	private TreeNode<E> minI(TreeNode<E> node) {
		while (node != NIL && node.left != NIL) {
			node = node.left;
		}
		return node;
	}

	public E maxIterative() {
		return maxI(root).data;
	}

	private TreeNode<E> maxI(TreeNode<E> node) {
		while (node != NIL && node.right != NIL) {
			node = node.right;
		}
		return node;
	}

	public E predecessor(E data) {
		TreeNode<E> x = searchRecursive(data);
		if (x != NIL && x.left != NIL) {
			return maxI(x.left).data;
		}
		TreeNode<E> y = x.parent;
		while (y != NIL && y.left == x) {
			x = y;
			y = x.parent;
		}
		return y.data;
	}

	public void removeAll() {
		root = this.NIL;
	}

	public boolean insertIterativeBroken(E data) {
		TreeNode<E> y = NIL;
		TreeNode<E> x = root;
		while (x != NIL) {
			y = x;
			if (data.compareTo(x.data) == 0) {
				System.out.println("Duplicate " + data);
				return false;
			} else if (data.compareTo(x.data) < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		TreeNode<E> z = new TreeNode<>(y, data);
		if (y == NIL) {
			root = z;
		} else if (data.compareTo(y.data) < 0) {
			y.left = z;
		} else {
			y.right = z;
		}
		z.left = NIL;
		z.right = NIL;
		z.color = RED;
		return true;
	}

	public void printLeafNodesAndPath() {
		Map<String, String> path = new LinkedHashMap<>();
		traverseLeaves(root, path, "");
		path.forEach((k,v) -> System.out.println(k + ": " + v));
	}

	//practicing path to leave nodes for Huffman Coding
	private void traverseLeaves(TreeNode<E> node, Map<String, String> path, String string) {
		if (node == NIL) {
			return;
		}
		if (node.left == NIL && node.right == NIL) {
			path.put(String.valueOf(node.data), string);
			return;
		}
		traverseLeaves(node.left, path, string + "0");
		traverseLeaves(node.right, path, string + "1");
	}
}
