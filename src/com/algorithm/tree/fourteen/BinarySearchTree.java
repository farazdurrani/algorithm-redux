package com.algorithm.tree.fourteen;

import com.algorithm.dynamiclist.fourteen.Queue;

public class BinarySearchTree<E extends Comparable<E>> {

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
	}
	printNodeAtGivenLevel(level - 1, node.left);
	printNodeAtGivenLevel(level - 1, node.right);
    }

    public void levelOrderTraversalQueue() {
	Queue<TreeNode<E>> q = new Queue<>();
	if (null != root) {
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
	return root.data;
    }

    public boolean contains(E data) {
	return contains(data, root) != null;
    }

    private TreeNode<E> contains(E data, TreeNode<E> node) {
	if (node == null) {
	    return null;
	}
	if (data.compareTo(node.data) < 0) {
	    return contains(data, node.left);
	} else if (data.compareTo(node.data) > 0) {
	    return contains(data, node.right);
	} else if (data.compareTo(node.data) == 0) {
	    return node;
	}
	return null;

    }

    public void remove(E data) {
	root = remove(data, root);
    }

    private TreeNode<E> remove(E data, TreeNode<E> node) {
	if (node == null) {
	    return null;
	}
	if (data.compareTo(node.data) < 0) {
	    node.left = remove(data, node.left);
	} else if (data.compareTo(node.data) > 0) {
	    node.right = remove(data, node.right);
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
		node.right = remove(node.data, node.right);
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
	root = invertTree(root);
    }

    private TreeNode<E> invertTree(TreeNode<E> node) {
	if (node == null) {
	    return null;
	}

	TreeNode<E> left = invertTree(node.left);
	TreeNode<E> right = invertTree(node.right);
	node.left = right;
	node.right = left;
	return node;
    }

    public void preorderTraversalRecursive() {
	preorderHelper(root);
	System.out.println();
    }

    private void preorderHelper(TreeNode<E> node) {
	if (null == node) {
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
	if (null == node) {
	    return;
	}
	postorderHelper(node.left);
	postorderHelper(node.right);
	System.out.print(node.data + " ");
    }

}
