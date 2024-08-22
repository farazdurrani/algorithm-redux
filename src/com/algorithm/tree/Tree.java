package com.algorithm.tree;

public class Tree<E extends Comparable<E>> {
    private TreeNode<E> root;

    public Tree() {
	root = null;
    }

    public void insert(E data) {
	if (null == root) {
	    root = new TreeNode<>(data);
	} else {
	    root.insert(data);
	}
    }

    public boolean find(E findData) {
	TreeNode<E> node = find(root, findData);
	if (null == node) {
	    System.out.println(findData + " not found");
	    return false;
	} else {
	    System.out.println("Found " + findData);
	    return true;
	}
    }

    private TreeNode<E> find(TreeNode<E> node, E findData) {
	System.out.println("Finding " + findData);
	if (node != null) {
	    if (findData.compareTo(node.data) < 0) {
		return find(node.left, findData);
	    } else if (findData.compareTo(node.data) > 0) {
		return find(node.right, findData);
	    } else {
		return node;
	    }
	}
	return null;
    }

    void deleteTreeNode(E deleteData) {
	root = deleteTreeNode(root, deleteData);
    }

    private TreeNode<E> deleteTreeNode(TreeNode<E> node, E deleteData) {
	TreeNode<E> cur = node;
	if (cur == null) {
	    return cur;
	}
	if (deleteData.compareTo(cur.data) < 0) {
	    cur.left = deleteTreeNode(cur.left, deleteData);
	} else if (deleteData.compareTo(cur.data) > 0) {
	    cur.right = deleteTreeNode(cur.right, deleteData);
	} else {
	    if (cur.left == null && cur.right == null) {
		cur = null;
	    } else if (cur.left == null) {
		cur = cur.right;
	    } else if (cur.right == null) {
		cur = cur.left;
	    } else {
		TreeNode<E> temp = findMinFromRight(cur.right);
		cur.data = temp.data;
		cur.right = deleteTreeNode(cur.right, temp.data);
	    }
	}
	return cur;
    }

    private TreeNode<E> findMinFromRight(TreeNode<E> node) {
	while (node.left != null) {
	    node = node.left;
	}
	return node;
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

    public void preorderTraversal() {
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

    public void postorderTraversal() {
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
