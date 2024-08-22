package com.algorithm.tree.ten;

import com.algorithm.dynamiclist.eleven.Queue;

public class BinarySearchTree<E extends Comparable<E>> {

    private TreeNode<E> root;

    public void insert(E data) {
	if (root == null) {
	    root = new TreeNode<>(data);
	} else {
	    root.insert(data);
	}
    }

    public void inorderTraversalResursive() {
	inorderTraversalHelper(root);
	System.out.println();
    }

    private void inorderTraversalHelper(TreeNode<E> node) {
	if (node == null) {
	    return;
	}
	inorderTraversalHelper(node.left);
	System.out.print(node.data + " ");
	inorderTraversalHelper(node.right);
    }

    public E getRoot() {
	return root.data;
    }

    public boolean contains(E data) {
	return contains(root, data) != null;
    }

    private TreeNode<E> contains(TreeNode<E> node, E data) {
	if (node == null) {
	    return null;
	} else if (data.compareTo(node.data) < 0) {
	    return contains(node.left, data);
	} else if (data.compareTo(node.data) > 0) {
	    return contains(node.right, data);
	}
	return node;
    }

    public void remove(E data) {
	root = remove(root, data);
    }

    private TreeNode<E> remove(TreeNode<E> node, E data) {
	if (node == null) {
	    return null;
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
		node.right = remove(node.right, temp.data);
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

    public void levelOrderTraversalIterative() {
	int height = height();
	for (int level = 1; level <= height; level++) {
	    printNodeAtGivenLevel(root, level);
	}
	System.out.println();
    }

    private void printNodeAtGivenLevel(TreeNode<E> node, int level) {
	if (node == null) {
	    return;
	}

	if (level == 1) {
	    System.out.print(node.data + " ");
	}
	printNodeAtGivenLevel(node.left, level - 1);
	printNodeAtGivenLevel(node.right, level - 1);
    }

    int height() {
	return height(root);
    }

    private int height(TreeNode<E> node) {
	if (node == null) {
	    return 0;
	}

	int lh = height(node.left);
	int rh = height(node.right);

	return (lh >= rh ? lh : rh) + 1;
    }

    public void levelOrderTraversalQueue() {
	Queue<TreeNode<E>> q = new Queue<>("Binary Search Tree");
	if (root != null) {
	    q.enqueue(root);
	}
	while (!q.isEmpty()) {
	    TreeNode<E> node = q.dequeue();
	    System.out.print(node.data + " ");
	    if(node.left != null) {
		q.enqueue(node.left);
	    }
	    if(node.right != null) {
		q.enqueue(node.right);
	    }
	}
	System.out.println();
    }

    public void invertTree() {
	root = invert(root);
    }

    private TreeNode<E> invert(TreeNode<E> node) {
	if(node == null) {
	    return node;
	}
	
	TreeNode<E> left = invert(node.left);
	TreeNode<E> right = invert(node.right);
	
	node.left = right;
	node.right = left;
	return node;
    }
}
