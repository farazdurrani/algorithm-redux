package com.algorithm.tree.twelve;

import com.algorithm.dynamiclist.twelve.Queue;

public class BinarySearchTree<E extends Comparable<E>> {

    private TreeNode<E> root;

    public void insert(E data) {
	if (root == null) {
	    root = new TreeNode<>(data);
	} else {
	    root.insert(data);
	}
    }

    public void levelOrderTraversalIterative() {
	int height = height();
	for (int level = 1; level <= height; level++) {
	    printTreeAtGivenLevel(root, level);
	}
	System.out.println();
    }

    private void printTreeAtGivenLevel(TreeNode<E> node, int level) {
	if (node == null) {
	    return;
	}
	if (level == 1) {
	    System.out.print(node.data + " ");
	}
	printTreeAtGivenLevel(node.left, level - 1);
	printTreeAtGivenLevel(node.right, level - 1);
    }

    public void levelOrderTraversalQueue() {
	Queue<TreeNode<E>> queue = new Queue<>();
	if (root != null) {
	    queue.enqueue(root);
	}
	while (!queue.isEmpty()) {
	    TreeNode<E> node = queue.dequeue();
	    System.out.print(node.data + " ");
	    if (node.left != null) {
		queue.enqueue(node.left);
	    }
	    if (node.right != null) {
		queue.enqueue(node.right);
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
	if(node == null) {
	    return null;
	}
	if(data.compareTo(node.data) < 0) {
	    return contains(node.left, data);
	} else if(data.compareTo(node.data) > 0) {
	    return contains(node.right, data);
	} else {
	    return node;
	}
    }

    public void remove(E data) {
	root = remove(root, data);
    }

    private TreeNode<E> remove(TreeNode<E> node, E data) {
	if(node == null) {
	    return node;
	}
	
	if(data.compareTo(node.data) < 0) {
	    node.left = remove(node.left, data);
	} else if(data.compareTo(node.data) > 0) {
	    node.right = remove(node.right, data);
	} else {
	    if(node.left == null && node.right == null) {
		node = null;
	    } else if(node.left == null) {
		node = node.right;
	    } else if(node.right == null) {
		node = node.left;
	    } else {
		TreeNode<E> tempNode = findMinOnRight(node.right);
		node.data = tempNode.data;
		node.right = remove(node.right, node.data);
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

    public void preorderTraversalRecursive() {
	preorderHelper(root);
	System.out.println();
    }

    private void preorderHelper(TreeNode<E> node) {
	if(node == null) {
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
	if(node == null) {
	    return;
	}
	preorderHelper(node.left);
	preorderHelper(node.right);
	System.out.print(node.data + " ");
    }

    private class TreeNode<S extends Comparable<S>> {
	private TreeNode<S> left;
	private TreeNode<S> right;
	private S data;

	public TreeNode(S data) {
	    this.data = data;
	    // symbolic representation
	    this.left = this.right = null;
	}

	public void insert(S data) {
	    if (data.compareTo(this.data) < 0) {
		if (this.left == null) {
		    this.left = new TreeNode<>(data);
		} else {
		    this.left.insert(data);
		}
	    } else if (data.compareTo(this.data) > 0) {
		if (this.right == null) {
		    this.right = new TreeNode<>(data);
		} else {
		    this.right.insert(data);
		}
	    }
	    // ignore duplicates
	}

    }

}
