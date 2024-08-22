package com.algorithm.tree.five;

public class BSTNode<E extends Comparable<E>> {

    private TreeNode<E> root;

    public void insert(E data) {
	if (null == root) {
	    root = new TreeNode<>(data);
	} else {
	    root.insert(data);
	}
    }

    public void inorderTraversal() {
	inorderHelper(root);
	System.out.println();
    }

    private void inorderHelper(TreeNode<E> node) {
	if (null == node) {
	    return;
	}
	inorderHelper(node.left);
	System.out.print(node.data + " ");
	inorderHelper(node.right);
    }

    public boolean find(E data) {
	return find(root, data) != null;
    }
    
    public void remove(E data) {
	root = remove(root, data);
    }

    private TreeNode<E> find(TreeNode<E> node, E data) {
	if(node == null) {
	    return null;
	}
	if (data.compareTo(node.data) < 0) {
	    return find(node.left, data);
	} else if (data.compareTo(node.data) > 0) {
	    return find(node.right, data);
	} else {
	    return node;
	}
    }

    private TreeNode<E> remove(TreeNode<E> node, E data) {
	TreeNode<E> curr = node;
	if (curr == null) {
	    return curr;
	}

	if (data.compareTo(node.data) < 0) {
	    curr.left = remove(curr.left, data);
	} else if (data.compareTo(node.data) > 0) {
	    curr.right = remove(curr.right, data);
	} else {
	    if (curr.left == null && curr.right == null) {
		curr = null;
	    } else if (curr.left == null) {
		curr = curr.right;
	    } else if (curr.right == null) {
		curr = curr.left;
	    } else {
		TreeNode<E> temp = findMaxOnRight(curr.right);
		curr.data = temp.data;
		curr.right = remove(curr.right, temp.data);
	    }
	}
	return curr;
    }

    private TreeNode<E> findMaxOnRight(TreeNode<E> node) {
	while (node.left != null) {
	    node = node.left;
	}
	return node;
    }
}
