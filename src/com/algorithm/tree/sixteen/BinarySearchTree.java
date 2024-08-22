package com.algorithm.tree.sixteen;

import com.algorithm.dynamiclist.fifteen.Queue;
import com.algorithm.dynamiclist.fifteen.Stack;

public class BinarySearchTree<E extends Comparable<E>> {

    private TreeNode<E> root;

    public boolean insert(E data) {
	if (root == null) {
	    root = new TreeNode<>(null, data);
	    return true;
	} else {
	    return root.insert(root, data);
	}
    }

    public TreeNode<E> max() {
	return max(root);
    }

    private TreeNode<E> max(TreeNode<E> node) {
	if (node.right != null) {
	    return max(node.right);
	}
	return node;
    }

    public TreeNode<E> min() {
	return min(root);
    }

    private TreeNode<E> min(TreeNode<E> node) {
	if (node.left != null) {
	    return min(node.left);
	}
	return node;
    }

    public TreeNode<E> successor(TreeNode<E> x) {
	if (x != null && x.right != null) {
	    return min(x.right);
	}
	TreeNode<E> y = x.parent;
	while (y != null && x == y.right) {
	    x = y;
	    y = y.parent;
	}
	return y;
    }

    public TreeNode<E> predecessor(TreeNode<E> x) {
	if (x != null && x.left != null) {
	    return max(x.left);
	}

	TreeNode<E> y = x.parent;
	while (y != null && x == y.left) {
	    x = y;
	    y = y.parent;
	}
	return y;
    }

    public TreeNode<E> search(E key) {
	return search(root, key);
    }

    private TreeNode<E> search(TreeNode<E> node, E key) {
	if (node == null || (node != null) && node.data.compareTo(key) == 0) {
	    return node;
	} else if (key.compareTo(node.data) < 0) {
	    return search(node.left, key);
	} else {
	    return search(node.right, key);
	}
    }

    public void levelOrderTraversalIterative() {
	int height = height();
	System.out.printf("%4s %4s%n", "P", "C");
	for (int level = 1; level <= height; level++) {
	    printNodeAtGivenLevel(level, root);
	}
	System.out.println();
    }

    private void printNodeAtGivenLevel(int level, TreeNode<E> node) {
	if (node == null) {
	    return;
	}
	if (level == 1) {
	    System.out.printf("%4s %4s%n", node.parent != null ? node.parent.data : null, node.data);
	    return;
	}
	printNodeAtGivenLevel(level - 1, node.left);
	printNodeAtGivenLevel(level - 1, node.right);

    }

    public void levelOrderTraversalQueue() {
	Queue<TreeNode<E>> q = new Queue<>();
	if (root != null) {
	    q.enqueue(root);
	}
	while (!q.isEmpty()) {
	    TreeNode<E> node = q.dequeue();
	    System.out.print(node.data + " ");
	    if (node.left != null) {
		q.enqueue(node.left);
	    }
	    if (node.right != null) {
		q.enqueue(node.right);
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

    public TreeNode<E> getRoot() {
	return root;
    }

    public boolean containsIterative(E data) {
	return contains(root, data) != null;
    }

    private TreeNode<E> contains(TreeNode<E> node, E data) {
	while (node != null && node.data.compareTo(data) != 0) {
	    if (data.compareTo(node.data) < 0) {
		node = node.left;
	    } else {
		node = node.right;
	    }
	}
	return node;
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
		TreeNode<E> parent = node.parent;
		node = node.right;
		node.parent = parent;
	    } else if(node.right == null) {
		TreeNode<E> parent = node.parent;
		node = node.left;
		node.parent = parent;
	    } else {
		TreeNode<E> temp = min(node.right);
		node.data = temp.data;
		node.right = remove(node.right, node.data);
	    }
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
	return (lh > rh ? lh : rh) + 1;
    }

    public void invertTree() {
	root = invert(root);
    }

    private TreeNode<E> invert(TreeNode<E> node) {
	if(node == null) {
	    return node;
	}
	TreeNode<E> ln = invert(node.left);
	TreeNode<E> rn = invert(node.right);
	node.left = rn;
	node.right = ln;
	return node;
    }

    public void preorderTraversalRecursive() {
	preorderHelper(root);
	System.out.println();
    }

    private void preorderHelper(TreeNode<E> node) {
	if (node == null) {
	    return;
	}
	System.out.print(node.data + " ");
	preorderHelper(node.left);
	preorderHelper(node.right);
    }

    public void preorderTraversalIterative() {
	Stack<TreeNode<E>> s = new Stack<>();
	if (root != null) {
	    s.push(root);
	}
	while (!s.isEmpty()) {
	    TreeNode<E> node = s.pop();
	    System.out.print(node.data + " ");
	    if (node.right != null) {
		s.push(node.right);
	    }
	    if (node.left != null) {
		s.push(node.left);
	    }
	}
	System.out.println();
    }

    public void postorderTraversalRecursive() {
	postorderHelper(root);
	System.out.println();
    }

    private void postorderHelper(TreeNode<E> node) {
	if (node == null) {
	    return;
	}
	postorderHelper(node.left);
	postorderHelper(node.right);
	System.out.print(node.data + " ");
    }

    public void postorderTraversalIterative() {
	Stack<TreeNode<E>> s1 = new Stack<>();
	Stack<TreeNode<E>> s2 = new Stack<>();
	if (root != null) {
	    s1.push(root);
	}
	while (!s1.isEmpty()) {
	    TreeNode<E> node = s1.pop();
	    s2.push(node);
	    if (node.left != null) {
		s1.push(node.left);
	    }
	    if (node.right != null) {
		s1.push(node.right);
	    }
	}

	while (!s2.isEmpty()) {
	    System.out.print(s2.pop().data + " ");
	}
	System.out.println();
    }

    public void inorderTraversalInterative() {
	Stack<TreeNode<E>> s = new Stack<>();
	TreeNode<E> curr = root;
	while (!s.isEmpty() || null != curr) {
	    while (null != curr) {
		s.push(curr);
		curr = curr.left;
	    }
	    curr = s.pop();
	    System.out.print(curr.data + " ");
	    curr = curr.right;
	}
	System.out.println();
    }

    /**
     * Using Auxillary space. We can improve...
     */
    public E successorWithoutTrackingParentUsingStack(E data) {
	Stack<TreeNode<E>> s = new Stack<>();
	TreeNode<E> cur = root;
	while (cur != null || !s.isEmpty()) {

	    while (cur != null) {
		s.push(cur);
		cur = cur.left;
	    }
	    cur = s.pop();
	    if (cur.data.compareTo(data) > 0) {
		return cur.data;
	    }
	    cur = cur.right;
	}
	return null;
    }

    /**
     * Most improved. No more using Auxillary space.
     */
    public E successorWithoutTrackingParentWithoutAuxilaryStorage(E key) {
	TreeNode<E> node = search(key);
	if (node != null && node.right != null) {
	    E data = min(node.right).data;
	    System.out.println("successor of " + key + " is -> " + data);
	    return data;
	}
	node = new TreeNode<>(null, null);
	inorderForSucessor(root, key, node);
	System.out.println("successor of " + key + " is -> " + node.data);
	return node.data;
    }

    /**
     * Best performance out of all 3 approaches as we can cut out rest of the
     * right-subtree calls once successor is found.
     */
    private void inorderForSucessor(TreeNode<E> node, E key, TreeNode<E> suc) {
	if (node == null || suc.data != null) {
	    return;
	}
	inorderForSucessor(node.left, key, suc);
	if (node.data.compareTo(key) > 0 && suc.data == null
		|| (suc.data != null && node.data.compareTo(suc.data) < 0)) {
	    suc.data = node.data;
	}
	if (suc.data == null) {
	    inorderForSucessor(node.right, key, suc);
	}
    }

    /**
     * A bit unintuitive but works. It's a bit efficent compare to Queue approach in
     * terms of saving space. But it can be improved.
     */
    private void inorderForSucessor2(TreeNode<E> node, E key, TreeNode<E> suc) {
	if (node == null || suc.data != null && node.data.compareTo(suc.data) > 0) {
	    return;
	}
	inorderForSucessor(node.left, key, suc);
	if (node.data.compareTo(key) == 0) {
	    suc.parent = node;
	}
	if (suc.parent != null && node.data.compareTo(suc.parent.data) > 0) {
	    if (suc.data == null) {
		suc.data = node.data;
	    } else if (suc.data != null && node.data.compareTo(suc.data) < 0) {
		suc.data = node.data;
	    }

	}
	inorderForSucessor(node.right, key, suc);
    }

    public E predecessorWithoutTrackingParent(E key) {
	TreeNode<E> node = search(key);
	if (node != null && node.left != null) {
	    E data = max(node.left).data;
	    System.out.println("predecessor of " + key + " is -> " + data);
	    return data;
	}
	if (node != null) {
	    node = new TreeNode<>(null, key);
	    inOrderForPredeccor(root, key, node);
	    System.out.println("predecessor of " + key + " is -> " + (node.data == key ? null : node.data));
	    return node.data == key ? null : node.data;
	}
	return null;
    }

    private void inOrderForPredeccor(TreeNode<E> node, E key, TreeNode<E> pred) {
	if (node == null) {
	    return;
	}
	inOrderForPredeccor(node.left, key, pred);
	if (node.data.compareTo(key) < 0) {
	    pred.data = node.data;
	}
	inOrderForPredeccor(node.right, key, pred);
    }

    public void insertIterative(E data) {
	TreeNode<E> newNode = new TreeNode<>(null, data);
	if (root == null) {
	    root = newNode;
	    return;
	}
	TreeNode<E> curr = root;
	TreeNode<E> track = null;
	while (curr != null) {
	    track = curr;
	    if (data.compareTo(curr.data) < 0) {
		curr = curr.left;
	    } else if (data.compareTo(curr.data) > 0) {
		curr = curr.right;
	    }
	}
	if (data.compareTo(track.data) < 0) {
	    track.left = newNode;
	} else if (data.compareTo(track.data) > 0) {
	    track.right = newNode;
	}
	newNode.parent = track;
    }

    public boolean containsRecursive(E data) {
	return containsRecursive(root, data) != null;
    }

    private TreeNode<E> containsRecursive(TreeNode<E> node, E data) {
	if(node == null || (node != null && node.data.compareTo(data) == 0)) {
	    return node;
	}
	if(data.compareTo(node.data) < 0) {
	    return containsRecursive(node.left,data);
	}
	if(data.compareTo(node.data) > 0) {
	    return containsRecursive(node.right, data);
	}
	return null;
    }

}
