package com.algorithm.tree.nine;

import com.algorithm.dynamiclist.nine.Queue;

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
	if (!isEmpty()) {
	    return root.data;
	}
	return null;
    }

    private boolean isEmpty() {
	return root == null;
    }

    public boolean contains(E data) {
	return contains(data, root) != null;
    }

    private TreeNode<E> contains(E data, TreeNode<E> node) {
	if (node == null) {
	    return node;
	}
	if (data.compareTo(node.data) < 0) {
	    return contains(data, node.left);
	} else if (data.compareTo(node.data) > 0) {
	    return contains(data, node.right);
	} else {
	    return node;
	}

    }

    public void levelOrderTraversalIterative() {
	int height = height();
	for (int level = 1; level <= height; level++) {
	    printNodeAtGivenLevel(root, level);
	}
	System.out.println();
    }

    private void printNodeAtGivenLevel(TreeNode<E> node, int level) {
	if(node == null) {
	    return;
	}
	if(level == 1) {
	    System.out.print(node.data + " ");
	}
	printNodeAtGivenLevel(node.left, level - 1);
	printNodeAtGivenLevel(node.right, level - 1);
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
	return (lh >= rh ? lh : rh) + 1;
    }

    public void levelOrderTraversalQueue() {
	Queue<TreeNode<E>> queue = new Queue<>();
	queue.enqueue(root);
	while(!queue.isEmpty()) {
	    TreeNode<E> node = queue.dequeue();
	    System.out.print(node.data + " ");
	    if(node.left != null) {
		queue.enqueue(node.left);
	    }
	    if(node.right != null) {
		queue.enqueue(node.right);
	    }
	}
	System.out.println();
    }

    public void remove(E data) {
	root = remove(data, root);
    }

    private TreeNode<E> remove(E data, TreeNode<E> node) {
	if(node == null) {
	    return node;
	}
	if(data.compareTo(node.data) < 0) {
	    node.left = remove(data, node.left);
	} else if(data.compareTo(node.data) > 0) {
	    node.right = remove(data, node.right);
	} else {
	    if(node.left==null && node.right == null) {
		node = null;
	    } else if(node.left == null) {
		node = node.right;
	    } else if(node.right == null) {
		node = node.left;
	    } else {
		TreeNode<E> temp = findMinOnRight(node.right);
		node.data = temp.data;
		node.right = remove(temp.data, node.right);
	    }
	}
	return node;
    }

    private TreeNode<E> findMinOnRight(TreeNode<E> node) {
	while(node.left != null) {
	    node = node.left;
	}
	return node;
    }

    public void invertTree() {
	root = invertTree(root);
    }

    private TreeNode<E> invertTree(TreeNode<E> node) {
	if(node == null) {
	    return node;
	}	
	TreeNode<E> left = invertTree(node.left);
	TreeNode<E> right = invertTree(node.right);
	
	
	node.left = right;
	node.right = left;
	
	return node;
    }

}
