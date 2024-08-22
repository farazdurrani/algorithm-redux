package com.algorithm.tree.four;

public class BSTNode<E extends Comparable<E>> {
    private TreeNode<E> root;

    public void insert(E data) {
	if (root == null) {
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
	if (node == null) {
	    return;
	}

	inorderHelper(node.left);
	System.out.print(node.data + " ");
	inorderHelper(node.right);
    }

    public boolean find(E data) {
	return find(data, root) != null;
    }

    private TreeNode<E> find(E data, TreeNode<E> node) {
	if(node == null) {
	    return node;
	}
	if(data.compareTo(node.data) < 0) {
	    return find(data, node.left);
	} else if(data.compareTo(node.data) > 0) {
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
	if(curr == null) {
	    return curr;
	}
	
	if(data.compareTo(node.data) < 0) {
	    curr.left = remove(data, node.left);
	} else if(data.compareTo(node.data) > 0) {
	    curr.right = remove(data, node.right);
	} else {
	    if(curr.left == null && curr.right == null) {
		curr = null;
	    } else if(curr.left == null) {
		curr = curr.right;
	    } else if (curr.right == null) {
		curr = curr.left;
	    } else {
		TreeNode<E> temp = findMaxOnRightSubTree(curr.right);
		curr.data = temp.data;
		curr.right = remove(temp.data, curr.right);
	    }
	}
	
	return curr;
    }

    private TreeNode<E> findMaxOnRightSubTree(TreeNode<E> node) {
	while(node.left != null) {
	    node = node.left;
	}
	return node;
    }
}
