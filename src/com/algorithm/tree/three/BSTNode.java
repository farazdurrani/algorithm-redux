package com.algorithm.tree.three;

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
	inorderTraversal(root);
	System.out.println();
    }

    private void inorderTraversal(TreeNode<E> node) {
	if (null == node) {
	    return;
	}
	inorderTraversal(node.left);
	System.out.print(node.data + " ");
	inorderTraversal(node.right);
    }

    public boolean find(E findData) {
	return null != find(findData, root);

    }

    private TreeNode<E> find(E findData, TreeNode<E> node) {
	if (null != node) {
	    if (findData.compareTo(node.data) < 0) {
		return find(findData, node.left);
	    } else if (findData.compareTo(node.data) > 0) {
		return find(findData, node.right);
	    } else {
		return node;
	    }
	}
	return null;
    }

    public void remove(E deleteData) {
	root = remove(deleteData, root);
    }

    private TreeNode<E> remove(E deleteData, TreeNode<E> node) {
	TreeNode<E> curr = node;
	if (null == curr) {
	    return curr;
	}

	if (deleteData.compareTo(node.data) < 0) {
	    curr.left = remove(deleteData, curr.left);
	} else if (deleteData.compareTo(node.data) > 0) {
	    curr.right = remove(deleteData, curr.right);
	} else {
	    if (null == curr.left && null == curr.right) {
		curr = null;
	    } else if (null == curr.left) {
		curr = curr.right;
	    } else if (null == curr.right) {
		curr = curr.left;
	    } else {
		TreeNode<E> temp = findMinOnRight(curr.right);
		curr.data = temp.data;
		curr.right = remove(temp.data, curr.right);
	    }
	}
	return curr;
    }

    private TreeNode<E> findMinOnRight(TreeNode<E> node) {
	while (null != node.left) {
	    node = node.left;
	}
	return node;
    }
}
