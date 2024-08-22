package com.algorithm.tree.fifteen;

import com.algorithm.dynamiclist.fifteen.Queue;
import com.algorithm.dynamiclist.fifteen.Stack;

public class BinarySearchTree<E extends Comparable<E>> {

    private class TreeNode<V extends Comparable<V>> implements Comparable<TreeNode<V>> {
	private TreeNode<V> left;
	private TreeNode<V> right;
	private V data;

	public TreeNode(V data) {
	    this.data = data;
	}

	public boolean insert(V data) {
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
	    }
	    // ignore duplicates
	    return false;
	}

	@Override
	public int compareTo(TreeNode<V> o) {
	    throw new RuntimeException("Don't use please.");
	}
    }

    private TreeNode<E> root;

    public boolean insert(E data) {
	if (root == null) {
	    root = new TreeNode<>(data);
	    return true;
	} else {
	    return root.insert(data);
	}
    }

    public void levelOrderTraversalIterative() {
	int height = height();
	for (int level = 1; level <= height; level++) {
	    printNodeAtGivenLevel(level, root);
	}
	System.out.println();
    }

    private void printNodeAtGivenLevel(int level, TreeNode<E> node) {
	if (node == null) {
	    return;
	}

	if (level == 1) {
	    System.out.print(node.data + " ");
	    return;
	}
	printNodeAtGivenLevel(level - 1, node.left);
	printNodeAtGivenLevel(level - 1, node.right);

    }

    public void levelOrderTraversalQueue() {
	Queue<TreeNode<E>> q = new Queue<>();
	if (root != null) {
	    q.enqueue(root);
	}
	while (!q.isEmpty()) {
	    TreeNode<E> node = q.dequeue();
	    System.out.print(node.data + " ");
	    if (node.left != null) {
		q.enqueue(node.left);
	    }
	    if (node.right != null) {
		q.enqueue(node.right);
	    }
	}
	System.out.println();
    }

    public void inorderTraversalResursive() {
	inorderHelper(root);
	System.out.println();
    }

    private void inorderHelper(TreeNode<E> node) {
	if (node == null) {
	    return;
	}
	inorderHelper(node.left);
	System.out.print(node.data + " ");
	inorderHelper(node.right);
    }

    public E getRoot() {
	if (root != null) {
	    return root.data;
	}
	return null;
    }

    public boolean contains(E data) {
	return contains(root, data) != null;
    }

    private TreeNode<E> contains(TreeNode<E> node, E data) {
	if (node == null) {
	    return node;
	}
	if (data.compareTo(node.data) < 0) {
	    return contains(node.left, data);
	} else if (data.compareTo(node.data) > 0) {
	    return contains(node.right, data);
	} else {
	    return node;
	}
    }

    public void remove(E data) {
	root = remove(root, data);
    }

    private TreeNode<E> remove(TreeNode<E> node, E data) {
	if (node == null) {
	    return node;
	}

	if (data.compareTo(node.data) < 0) {
	    node.left = remove(node.left, data);
	} else if (data.compareTo(node.data) > 0) {
	    node.right = remove(node.right, data);
	} else {
	    if (node.left == null && node.right == null) {
		node = null;
	    } else if (node.left == null) {
		node = node.right;
	    } else if (node.right == null) {
		node = node.left;
	    } else {
		TreeNode<E> temp = findMinOnRight(node.right);
		node.data = temp.data;
		node.right = remove(node.right, node.data);
	    }
	}
	return node;
    }

    private TreeNode<E> findMinOnRight(TreeNode<E> node) {
	while (node.left != null) {
	    node = node.left;
	}
	return node;
    }

    public int height() {
	return height(root);
    }

    private int height(TreeNode<E> node) {
	if (node == null) {
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
	if (node == null) {
	    return node;
	}

	TreeNode<E> left = invert(node.left);
	TreeNode<E> right = invert(node.right);

	node.left = right;
	node.right = left;

	return node;
    }

    public void preorderTraversalRecursive() {
	preorderHelper(root);
	System.out.println();
    }

    private void preorderHelper(TreeNode<E> node) {
	if (node == null) {
	    return;
	}
	System.out.print(node.data + " ");
	preorderHelper(node.left);
	preorderHelper(node.right);
    }

    public void preorderTraversalIterative() {
	Stack<TreeNode<E>> s = new Stack<>();
	if (root != null) {
	    s.push(root);
	}
	while (!s.isEmpty()) {
	    TreeNode<E> node = s.pop();
	    System.out.print(node.data + " ");
	    if (node.right != null) {
		s.push(node.right);
	    }
	    if (node.left != null) {
		s.push(node.left);
	    }
	}
	System.out.println();
    }

    public void postorderTraversalRecursive() {
	postorderHelper(root);
	System.out.println();
    }

    private void postorderHelper(TreeNode<E> node) {
	if (node == null) {
	    return;
	}
	postorderHelper(node.left);
	postorderHelper(node.right);
	System.out.print(node.data + " ");
    }

    public void postorderTraversalIterative() {
	Stack<TreeNode<E>> one = new Stack<>();
	Stack<TreeNode<E>> two = new Stack<>();
	if (root != null) {
	    one.push(root);
	}

	while (!one.isEmpty()) {
	    TreeNode<E> node = one.pop();
	    two.push(node);
	    if (node.left != null) {
		one.push(node.left);
	    }
	    if (node.right != null) {
		one.push(node.right);
	    }
	}

	while (!two.isEmpty()) {
	    System.out.print(two.pop().data + " ");
	}
	System.out.println();
    }

    public void inorderTraversalInterative() {
	Stack<TreeNode<E>> q = new Stack<>();
	TreeNode<E> cur = root;
	while (cur != null || !q.isEmpty()) {
	    while (cur != null) {
		q.push(cur);
		cur = cur.left;
	    }
	    cur = q.pop();
	    System.out.print(cur.data + " ");
	    cur = cur.right;
	}
	System.out.println();
    }
}
