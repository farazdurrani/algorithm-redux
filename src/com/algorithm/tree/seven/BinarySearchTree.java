package com.algorithm.tree.seven;

import com.algorithm.dynamiclist.seven.Queue;

public class BinarySearchTree<E extends Comparable<E>> {
    private TreeNode<E> root;
    private long size;

    public void insert(E data) {
	if (root == null) {
	    root = new TreeNode<>(data);
	    size++;
	} else {
	    if (root.insert(data)) {
		size++;
	    }
	}
    }

    public void inOrderTraversal() {
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

    public long getSize() {
	return this.size;
    }

    public boolean find(E data) {
	return find(data, root) != null;
    }

    private TreeNode<E> find(E data, TreeNode<E> node) {
	if (node == null) {
	    return null;
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

	    if (curr.left == null && curr.right == null) {
		curr = null;
		size--;
	    } else if (curr.left == null) {
		curr = curr.right;
		size--;
	    } else if (curr.right == null) {
		curr = curr.left;
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

    public E getRoot() {
	if (root != null) {
	    return root.data;
	}
	return null;
    }

    public int height() {
	return height(root);
    }

    private int height(TreeNode<E> node) {
	if (node == null) {
	    return 0;
	}
	int leftHeight = height(node.left);
	int rightHeight = height(node.right);
	return (leftHeight >= rightHeight ? leftHeight : rightHeight) + 1;
    }

    public void levelOrderTraversalIterative() {
	int h = height();
	for (int level = 1; level <= h; level++) {
	    givenLevelTraversal(root, level);
	}
	System.out.println();
    }

    public void levelOrderTraversalUsingQueue() {
	Queue<TreeNode<E>> q = new Queue<>();
	q.enqueue(root);
	while (!q.isEmpty()) {
	    TreeNode<E> temp = q.dequeue();
	    System.out.print(temp.data + " ");
	    if (temp.left != null) {
		q.enqueue(temp.left);
	    }

	    if (temp.right != null) {
		q.enqueue(temp.right);
	    }
	}
	System.out.println();
    }

    private void givenLevelTraversal(TreeNode<E> node, int level) {
	if (node == null) {
	    return;
	}

	if (level == 1) {
	    System.out.print(node.data + " ");

	}
	givenLevelTraversal(node.left, level - 1);
	givenLevelTraversal(node.right, level - 1);

    }

    public void isBinary() {
	
    }

}
