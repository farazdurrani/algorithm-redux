package com.algorithm.tree.two;

public class BSTNode<E extends Comparable<E>> {
    private TreeNode<E> root;

    public void insert(E data) {
	if (null == root) {
	    root = new TreeNode<>(data);
	} else {
	    root.insert(data);
	}
    }

    public void inOrderTraversal() {
	inOrderHelper(root);
	System.out.println();
    }

    private void inOrderHelper(TreeNode<E> node) {
	if (null == node) {
	    return;
	}
	inOrderHelper(node.left);
	System.out.print(node.data + " ");
	inOrderHelper(node.right);
    }

    public boolean contains(E findData) {
	return find(root, findData) != null;
    }

    private TreeNode<E> find(TreeNode<E> node, E findData) {
	if (null != node) {
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

    public void remove(E removeData) {
	root = remove(root, removeData);
    }

    private TreeNode<E> remove(TreeNode<E> node, E removeData) {
	TreeNode<E> cur = node;

	if (null == cur) {
	    return cur;
	}

	if (removeData.compareTo(cur.data) < 0) {
	    cur.left = remove(cur.left, removeData);
	} else if (removeData.compareTo(cur.data) > 0) {
	    cur.right = remove(cur.right, removeData);
	} else {
	    if (cur.left == null && cur.right == null) {
		cur = null;
	    } else if (cur.left == null) {
		cur = cur.right;
	    } else if (cur.right == null) {
		cur = cur.left;
	    } else {
		TreeNode<E> temp = findMinOnRight(cur.right);
		cur.data = temp.data;
		cur.right = remove(cur.right, temp.data);
	    }
	}

	return cur;
    }

    private TreeNode<E> findMinOnRight(TreeNode<E> node) {
	while (node.left != null) {
	    node = node.left;
	}
	return node;
    }

}
