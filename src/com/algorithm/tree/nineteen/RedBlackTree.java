package com.algorithm.tree.nineteen;

import com.algorithm.dynamiclist.fifteen.Queue;
import com.algorithm.dynamiclist.fifteen.Stack;

public class RedBlackTree<E extends Comparable<E>> {

    private TreeNode<E> root;
    static TreeNode NIL;
    private Color RED = Color.RED;
    private Color BLACK = Color.BLACK;

    public RedBlackTree() {
	this.NIL = new TreeNode<>(null, null, Color.BLACK);
	this.root = this.NIL;
    }

    private TreeNode<E> insertRecusrively(E data) {
	if (root == NIL) {
	    root = new TreeNode<E>(NIL, data, Color.RED);
	    return root;
	} else {
	    return root.insert(root, data);
	}

    }

    public boolean insert(E data) {
	TreeNode<E> node = insertRecusrively(data);
	if (node == null) {
	    return false;
	}
	node.left = NIL;
	node.right = NIL;
	rbInsertFixup(node);

	return true;
    }

    private void rbInsertFixup(TreeNode<E> z) {
	while (z.p.color == RED) {
	    if (z.p == z.p.p.left) {
		TreeNode<E> y = z.p.p.right;
		if (y.color == RED) {
		    y.color = BLACK;
		    z.p.color = BLACK;
		    z.p.p.color = RED;
		    z = z.p.p;
		} else {
		    if (z == z.p.right) {
			z = z.p;
			leftRotate(z);
		    }
		    z.p.color = BLACK;
		    z.p.p.color = RED;
		    rightRotate(z.p.p);
		}
	    } else {
		TreeNode<E> y = z.p.p.left;
		if (y.color == RED) {
		    y.color = BLACK;
		    z.p.color = BLACK;
		    z.p.p.color = RED;
		    z = z.p.p;
		} else {
		    if (z == z.p.left) {
			z = z.p;
			rightRotate(z);
		    }
		    z.p.color = BLACK;
		    z.p.p.color = RED;
		    leftRotate(z.p.p);
		}
	    }
	}
	root.color = BLACK;
    }

    private void rightRotate(TreeNode<E> x) {
	TreeNode<E> y = x.left;
	x.left = y.right;
	if (y.right != null) {
	    y.right.p = x;
	}
	y.p = x.p;
	if (x.p == NIL) {
	    root = y;
	} else if (x == x.p.left) {
	    x.p.left = y;
	} else {
	    x.p.right = y;
	}
	y.right = x;
	x.p = y;
    }

    private void leftRotate(TreeNode<E> x) {
	TreeNode<E> y = x.right;
	x.right = y.left;
	if (y.left != null) {
	    y.left.p = x;
	}
	y.p = x.p;
	if (x.p == NIL) {
	    root = y;
	} else if (x == x.p.left) {
	    x.p.left = y;
	} else {
	    x.p.right = y;
	}
	y.left = x;
	x.p = y;
    }

    public void levelOrderTraversalIterative() {
	int height = height();
	for (int level = 1; level <= height; level++) {
	    printNodeAtGivenLevel(level, root);
	}
	System.out.println();
    }

    private void printNodeAtGivenLevel(int level, TreeNode<E> node) {
	if (node == NIL) {
	    return;
	}

	if (level == 1) {
	    System.out.print(node.data + " ");
	    return;
	}
	printNodeAtGivenLevel(level - 1, node.left);
	printNodeAtGivenLevel(level - 1, node.right);
    }

    public int height() {
	return height(root);
    }

    private int height(TreeNode<E> node) {
	if (node == NIL) {
	    return 0;
	}
	int lh = height(node.left);
	int rh = height(node.right);

	return (lh > rh ? lh : rh) + 1;
    }

    public E min() {
	return min(root).data;
    }

    private TreeNode<E> min(TreeNode<E> node) {
	if (node != NIL && node.left != NIL) {
	    return min(node.left);
	}
	return node;
    }

    public E max() {
	return max(root).data;
    }

    private TreeNode<E> max(TreeNode<E> node) {
	if (node != NIL && node.right != NIL) {
	    return max(node.right);
	}
	return node;
    }

    public TreeNode<E> getRoot() {
	return root;
    }

    public E successor(E data) {
	TreeNode<E> node = search(data);
	if (node != NIL && node.right != NIL) {
	    return min(node.right).data;
	}

	TreeNode<E> y = node.p;
	while (y != NIL && node == y.right) {
	    node = y;
	    y = y.p;
	}
	return y.data;
    }

    public TreeNode<E> search(E data) {
	return search(root, data);
    }

    private TreeNode<E> search(TreeNode<E> node, E data) {
	if (node == NIL || (node != NIL && node.data.compareTo(data) == 0)) {
	    return node;
	} else if (data.compareTo(node.data) < 0) {
	    return search(node.left, data);
	} else {
	    return search(node.right, data);
	}
    }

    public E predecessor(E data) {
	TreeNode<E> x = search(data);
	if (x != NIL && x.left != NIL) {
	    return max(x.left).data;
	}
	TreeNode<E> y = x.p;
	while (y != NIL && x == y.left) {
	    x = y;
	    y = y.p;
	}
	return y.data;
    }

    public void inorderTraversalIterative() {
	Stack<TreeNode<E>> s = new Stack<>();
	TreeNode<E> cur = root;
	while (cur != NIL || !s.isEmpty()) {
	    while (cur != NIL) {
		s.push(cur);
		cur = cur.left;
	    }
	    cur = s.pop();
	    System.out.print(cur.data + " ");
	    cur = cur.right;
	}
	System.out.println();
    }

    public boolean containsIterative(E data) {
	return containsIterative(root, data) != NIL;
    }

    private TreeNode<E> containsIterative(TreeNode<E> node, E data) {
	while (node != NIL && node.data.compareTo(data) != 0) {
	    if (data.compareTo(node.data) < 0) {
		node = node.left;
	    } else {
		node = node.right;
	    }
	}
	return node;
    }

    public void insertIterative(E data) {
	TreeNode<E> y = this.NIL;
	TreeNode<E> x = this.root;
	while (x != this.NIL) {
	    y = x;
	    if (data.compareTo(x.data) == 0) {
		System.out.println("Can't enter duplicate value " + data);
		return;
	    } else if (data.compareTo(x.data) < 0) {
		x = x.left;
	    } else {
		x = x.right;
	    }
	}

	TreeNode<E> z = new TreeNode<>(y, data, RED);
	if (y == this.NIL) {
	    root = z;
	} else if (data.compareTo(y.data) < 0) {
	    y.left = z;
	} else {
	    y.right = z;
	}
	z.left = this.NIL;
	z.right = this.NIL;
	rbInsertFixup(z);

    }

    public void levelOrderTraversalQueue() {
	Queue<TreeNode<E>> q = new Queue<>();
	if (root != NIL) {
	    q.enqueue(root);
	}
	while (!q.isEmpty()) {
	    TreeNode<E> node = q.dequeue();
	    System.out.print(node.data + " ");
	    if (node.left != NIL) {
		q.enqueue(node.left);
	    }
	    if (node.right != NIL) {
		q.enqueue(node.right);
	    }
	}
	System.out.println();
    }

    public void inorderTraversalResursive() {
	inorderTraversalResursive(root);
	System.out.println();

    }

    private void inorderTraversalResursive(TreeNode<E> node) {
	if (node == NIL) {
	    return;
	}
	inorderTraversalResursive(node.left);
	System.out.print(node.data + " ");
	inorderTraversalResursive(node.right);
    }

    public void preorderTraversalRecursive() {
	preorderHelper(root);
	System.out.println();
    }

    private void preorderHelper(TreeNode<E> node) {
	if (node == NIL) {
	    return;
	}
	System.out.print(node.data + " ");
	preorderHelper(node.left);
	preorderHelper(node.right);
    }

    public void preorderTraversalIterative() {
	Stack<TreeNode<E>> s = new Stack<>();
	s.push(root);
	while (!s.isEmpty()) {
	    TreeNode<E> node = s.pop();
	    System.out.print(node.data + " ");
	    if (node.right != NIL) {
		s.push(node.right);
	    }
	    if (node.left != NIL) {
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
	if (node == NIL) {
	    return;
	}
	postorderHelper(node.left);
	postorderHelper(node.right);
	System.out.print(node.data + " ");
    }

    public void postorderTraversalIterative() {
	Stack<TreeNode<E>> s1 = new Stack<>();
	Stack<TreeNode<E>> s2 = new Stack<>();
	s1.push(root);
	while (!s1.isEmpty()) {
	    TreeNode<E> node = s1.pop();
	    s2.push(node);
	    if (node.left != NIL) {
		s1.push(node.left);
	    }
	    if (node.right != NIL) {
		s1.push(node.right);
	    }
	}
	while (!s2.isEmpty()) {
	    System.out.print(s2.pop().data + " ");
	}
	System.out.println();
    }

    public void remove(E data) {
	root = remove(root, data);
    }

    private TreeNode<E> remove(TreeNode<E> node, E data) {
	if (node == NIL) {
	    return node;
	}

	if (data.compareTo(node.data) < 0) {
	    node.left = remove(node.left, data);
	} else if (data.compareTo(node.data) > 0) {
	    node.right = remove(node.right, data);
	} else {
	    if (node.left == NIL && node.right == NIL) {
		node = NIL;
	    } else if (node.left == NIL) {
		node = node.right;
	    } else if (node.right == NIL) {
		node = node.left;
	    } else {
		TreeNode<E> temp = min(node.right);
		node.data = temp.data;
		node.right = remove(node.right, node.data);
	    }
	}
	return node;
    }

    public void invertTree() {
	root = invert(root);
    }

    private TreeNode<E> invert(TreeNode<E> node) {
	if (node == NIL) {
	    return node;
	}
	TreeNode<E> left = invert(node.left);
	TreeNode<E> right = invert(node.right);

	node.left = right;
	node.right = left;
	return node;
    }

    public void removeIteratively(E data) {
	TreeNode<E> z = search(data);
	if (z == NIL) {
	    System.out.println(data + " not found");
	    return;
	}
	if (z.left == NIL) {
	    transplant(z, z.right);
	} else if (z.right == NIL) {
	    transplant(z, z.left);
	} else {
	    TreeNode<E> y = min(z.right);
	    if (y.p != z) {
		transplant(y, y.right);
		y.right = z.right;
		y.right.p = y;
	    }
	    transplant(z, y);
	    y.left = z.left;
	    y.left.p = y;
	}
    }

    private void transplant(TreeNode<E> u, TreeNode<E> v) {
	if (u.p == NIL) {
	    root = v;
	} else if (u == u.p.left) {
	    u.p.left = v;
	} else {
	    u.p.right = v;
	}
	if (v != NIL) {
	    v.p = u.p;
	}
    }

    void deleteIterative2(E data) {
	TreeNode<E> z = search(data);
	if (z == NIL) {
	    System.out.println(data + " not found.");
	    return;
	}
	delete(z);
    }

    private void delete(TreeNode<E> z) {
	if (z.right == NIL) {
	    transplant2(z, z.left);
	} else if (z.left == NIL) {
	    transplant2(z, z.right);
	} else {
	    TreeNode<E> y = min(z.right);
	    if (z != y.p) {
		transplant2(y, y.right);
		y.right = z.right;
		y.right.p = y;
	    }
	    transplant2(z, y);
	    y.left = z.left;
	    y.left.p = y;
	}
    }

    public void transplant2(TreeNode<E> u, TreeNode<E> v) {
	if ((u.p == NIL)) {
	    root = v;
	} else if (u.p.left == u) {
	    u.p.left = v;
	} else {
	    u.p.right = v;
	}
	if (v != NIL) {
	    v.p = u.p;
	}
    }

    public void removeRB(E data) {
	TreeNode<E> z = search(data);
	if (z == NIL) {
	    System.out.println(data + " not found");
	    return;
	}
	TreeNode<E> x = null, y;
	y = z;
	Color origYColor = y.color;
	if (z.left == NIL) {
	    x = z.right;
	    transplantRB(z, z.right);
	} else if (z.right == NIL) {
	    x = z.left;
	    transplantRB(z, z.left);
	} else {
	    y = min(z.right);
	    origYColor = y.color;
	    x = y.right;
	    if (y.p == z) {
		x.p = y;
	    } else {
		transplantRB(y, y.right);
		y.right = z.right;
		y.right.p = y;
	    }
	    transplantRB(z, y);
	    y.left = z.left;
	    y.left.p = y;
	    y.color = z.color;
	}
	if (origYColor == BLACK) {
	    rb_delete_fixup(x);
	}
    }

    private void rb_delete_fixup(TreeNode<E> x) {
    }

    private void transplantRB(TreeNode<E> u, TreeNode<E> v) {
	if (u.p == NIL) {
	    root = v;
	} else if (u == u.p.left) {
	    u.p.left = v;
	} else {
	    u.p.right = v;
	}
	v.p = u.p;
    }

    public void removeRB2(E data) {
	TreeNode<E> z = search(data);
	if (z == NIL) {
	    System.out.println(data + " not found");
	    return;
	}
	TreeNode<E> x = null, y = z;
	Color orig_y_color = y.color;
	if (z.right == NIL) {
	    x = z.left;
	    transplant(z, z.left);
	} else if (z.left == NIL) {
	    x = z.right;
	    transplant(z, z.right);
	} else {
	    y = min(z.right);
	    orig_y_color = y.color;
	    x = y.right;
	    if (y.p == z) {
		x.p = y;
	    } else {
		transplant(y, y.right);
		y.right = z.right;
		y.right.p = y;
	    }
	    transplant(z, y);
	    y.left = z.left;
	    y.color = z.color;
	    y.left.p = y;
	}
	if (orig_y_color == BLACK) {
	    rb_delete_fixup(x);
	}

    }

    void deleteIt2(E data) {
	TreeNode<E> z = search(data);
	if (z.left != NIL && z.right != NIL) {
	    TreeNode<E> y = min(z.right);
	    if (y.p != z) {
		transplant(y, y.right);
		y.right = z.right;
		y.right.p = y;
	    }
	    transplant(z, y);
	    y.left = z.left;
	    y.left.p = y;
	} else if (z.left == NIL) {
	    transplant(z, z.right);
	} else {
	    transplant(z, z.left);
	}
    }

}
