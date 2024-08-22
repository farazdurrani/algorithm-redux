package com.algorithm.tree.six;

public class BSTNode<E extends Comparable<E>> {

    private TreeNode<E> root;

    private int size = 1;

    public void insert(E data) {

	if (root == null) {
	    root = new TreeNode<>(data);
	} else {
	    if (root.insert(data)) {
		size++;
	    }
	}
	
    }

    public void inorderTraversal() {
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

    public int getSize() {
	return size;
    }

    public boolean find(E data) {

	return find(data, root) != null;
    }

    private TreeNode<E> find(E data, TreeNode<E> node) {
	if (node == null) {
	    return node;
	}

	if (data.compareTo(node.data) < 0) {
	    return find(data, node.left);
	} else if (data.compareTo(node.data) > 0) {
	    return find(data, node.right);
	} else {
	    return node;
	}

    }

    public void remove(E data) {
	root = remove(data, root);
    }

    private TreeNode<E> remove(E data, TreeNode<E> node) {
	TreeNode<E> curr = node;
	if (curr == null) {
	    return curr;
	}

	if (data.compareTo(node.data) < 0) {
	    curr.left = remove(data, curr.left);
	} else if (data.compareTo(node.data) > 0) {
	    curr.right = remove(data, curr.right);
	} else {
	    if (curr.right == null && curr.left == null) {
		curr = null;
		size--;
	    } else if (curr.right == null) {
		curr = curr.left;
		size--;
	    } else if (curr.left == null) {
		curr = curr.right;
		size--;
	    } else {
		TreeNode<E> temp = findMinOnRight(node.right);
		curr.data = temp.data;
		curr.right = remove(temp.data, curr.right);
	    }
	}
	return curr;
    }

    private TreeNode<E> findMinOnRight(TreeNode<E> node) {
	while (node.left != null) {
	    node = node.left;
	}
	return node;
    }
}
