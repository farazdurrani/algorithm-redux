package com.algorithm.tree.twentyone;

import com.algorithm.dynamiclist.sisteen.Queue;
import com.algorithm.dynamiclist.sisteen.Stack;

@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
public class RedBlackTree<E extends Comparable<E>> {

    private TreeNode<E> root;
    static TreeNode nil;
    Color BLACK = Color.BLACK;
    Color RED = Color.RED;

    public RedBlackTree() {
	this.nil = new TreeNode<>();
	this.nil.color = BLACK;
	this.root = this.nil;
	this.root.parent = this.nil;
    }

    public boolean insertRecursive(E data) {
	if (root == nil) {
	    root = new TreeNode<>(nil, data);
	    root.left = nil;
	    root.right = nil;
	    root.color = BLACK;
	    return true;
	} else {
	    TreeNode<E> z = root.insert(root, data);
	    if (z != nil) {
		z.left = nil;
		z.right = nil;
		z.color = RED;
		insertRBFixup(z);
		return true;
	    }
	    return false;
	}
    }

    private void insertRBFixup(TreeNode<E> z) {
	while (z.parent.color == RED) {
	    if (z.parent == z.parent.parent.left) {
		TreeNode<E> y = z.parent.parent.right;
		if (y.color == RED) {
		    y.color = BLACK;
		    z.parent.color = BLACK;
		    z.parent.parent.color = RED;
		    z = z.parent.parent;
		} else {
		    if (z == z.parent.right) {
			z = z.parent;
			leftRotate(z);
		    }
		    z.parent.color = BLACK;
		    z.parent.parent.color = RED;
		    rightRotate(z.parent.parent);
		}
	    } else {
		TreeNode<E> y = z.parent.parent.left;
		if (y.color == RED) {
		    y.color = BLACK;
		    z.parent.color = BLACK;
		    z.parent.parent.color = RED;
		    z = z.parent.parent;
		} else {
		    if (z == z.parent.left) {
			z = z.parent;
			rightRotate(z);
		    }
		    z.parent.color = BLACK;
		    z.parent.parent.color = RED;
		    leftRotate(z.parent.parent);
		}
	    }
	}
	root.color = BLACK;
    }

    private void rightRotate(TreeNode<E> x) {
	TreeNode<E> y = x.left;
	x.left = y.right;
	if (y.right != nil) {
	    y.right.parent = x;
	}
	y.parent = x.parent;
	if (x.parent == nil) {
	    root = y;
	} else if (x == x.parent.left) {
	    x.parent.left = y;
	} else {
	    x.parent.right = y;
	}
	y.right = x;
	x.parent = y;
    }

    private void leftRotate(TreeNode<E> x) {
	TreeNode<E> y = x.right;
	x.right = y.left;
	if (y.left != nil) {
	    y.left.parent = x;
	}
	y.parent = x.parent;
	if (x.parent == nil) {
	    root = y;
	} else if (x == x.parent.left) {
	    x.parent.left = y;
	} else {
	    x.parent.right = y;
	}
	y.left = x;
	x.parent = y;
    }

    public void levelOrderTraversalIterative() {
	int height = height();
	for (int level = 1; level <= height; level++) {
	    printNodeAtGivenLevel(level, root);
	}
	System.out.println();
    }

    private void printNodeAtGivenLevel(int level, TreeNode<E> node) {
	if (node == nil) {
	    return;
	}
	if (level == 1) {
	    System.out.print(node.data + " ");
	    return;
	}
	printNodeAtGivenLevel(level - 1, node.left);
	printNodeAtGivenLevel(level - 1, node.right);
    }

    public E minRecursive() {
	return minR(root).data;
    }

    private TreeNode<E> minR(TreeNode<E> node) {

	if (node != nil && node.left != nil) {
	    return minR(node.left);
	}
	return node;
    }

    public E maxRecursive() {
	return maxR(root).data;
    }

    private TreeNode<E> maxR(TreeNode<E> node) {
	if (node != nil && node.right != nil) {
	    return maxR(node.right);
	}
	return node;
    }

    public TreeNode<E> getRoot() {
	return root;
    }

    public E successor(E data) {
	TreeNode<E> x = searchRecursive(data);
	if (x != nil && x.right != nil) {
	    return minR(x.right).data;
	}
	TreeNode<E> y = x.parent;
	while (y != nil && x == x.parent.right) {
	    x = y;
	    y = x.parent; // y = y.parent
	}
	return y.data;
    }

    public TreeNode<E> searchRecursive(E data) {
	return searchR(root, data);
    }

    private TreeNode<E> searchR(TreeNode<E> node, E data) {
	if (node == nil || (node != nil && node.data.compareTo(data) == 0)) {
	    return node;
	} else if (data.compareTo(node.data) < 0) {
	    return searchR(node.left, data);
	} else {
	    return searchR(node.right, data);
	}
    }

    public void inorderTraversalIterative() {
	Stack<TreeNode<E>> s = new Stack<>();
	TreeNode<E> curr = root;
	while (curr != nil || !s.isEmpty()) {
	    while (curr != nil) {
		s.push(curr);
		curr = curr.left;
	    }
	    curr = s.pop();
	    System.out.print(curr.data + " ");
	    curr = curr.right;
	}
	System.out.println();
    }

    public E containsIterative(E data) {
	return containsIterative(root, data).data;
    }

    private TreeNode<E> containsIterative(TreeNode<E> node, E data) {
	while (node != nil && data.compareTo(node.data) != 0) {
	    if (data.compareTo(node.data) < 0) {
		node = node.left;
	    } else {
		node = node.right;
	    }
	}
	return node;
    }

    public void levelOrderTraversalQueue() {
	Queue<TreeNode<E>> q = new Queue<>();
	if (root != nil) {
	    q.enqueue(root);
	}
	while (!q.isEmpty()) {
	    TreeNode<E> node = q.dequeue();
	    System.out.print(node.data + " ");
	    if (node.left != nil) {
		q.enqueue(node.left);
	    }
	    if (node.right != nil) {
		q.enqueue(node.right);
	    }
	}
	System.out.println();
    }

    public void inorderTraversalResursive() {
	inorderTraversalHelper(root);
	System.out.println();
    }

    private void inorderTraversalHelper(TreeNode<E> node) {
	if (node == nil) {
	    return;
	}
	inorderTraversalHelper(node.left);
	System.out.print(node.data + " ");
	inorderTraversalHelper(node.right);
    }

    public boolean insertIterative(E data) {
	TreeNode<E> y = nil;
	TreeNode<E> x = root;
	while (x != nil) {
	    y = x;
	    if (data.compareTo(x.data) < 0) {
		x = x.left;
	    } else if (data.compareTo(x.data) > 0) {
		x = x.right;
	    } else {
		return false;
	    }
	}
	TreeNode<E> z = new TreeNode<>(y, data);
	z.left = nil;
	z.right = nil;
	z.color = RED;
	if (y == nil) {
	    root = z;
	} else if (data.compareTo(y.data) < 0) {
	    y.left = z;
	} else {
	    y.right = z;
	}
	insertRBFixup(z);
	return true;
    }

    public void preorderTraversalRecursive() {
	preorderHelper(root);
	System.out.println();
    }

    private void preorderHelper(TreeNode<E> node) {
	if (node == nil) {
	    return;
	}
	System.out.print(node.data + " ");
	preorderHelper(node.left);
	preorderHelper(node.right);
    }

    public void preorderTraversalIterative() {
	Stack<TreeNode<E>> s = new Stack<>();
	if (root != nil) {
	    s.push(root);
	}
	while (!s.isEmpty()) {
	    TreeNode<E> node = s.pop();
	    System.out.print(node.data + " ");
	    if (node.right != nil) {
		s.push(node.right);
	    }
	    if (node.left != nil) {
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
	if (node == nil) {
	    return;
	}
	postorderHelper(node.left);
	postorderHelper(node.right);
	System.out.print(node.data + " ");
    }

    public void postorderTraversalIterative() {
	Stack<TreeNode<E>> s1 = new Stack<>();
	Stack<TreeNode<E>> s2 = new Stack<>();
	if (root != nil) {
	    s1.push(root);
	}
	while (!s1.isEmpty()) {
	    TreeNode<E> node = s1.pop();
	    s2.push(node);
	    if (node.left != nil) {
		s1.push(node.left);
	    }
	    if (node.right != nil) {
		s1.push(node.right);
	    }
	}
	while (!s2.isEmpty()) {
	    System.out.print(s2.pop().data + " ");
	}
	System.out.println();
    }

    public void removeRecursive(E data) {
	root = remove(root, data);
    }

    private TreeNode<E> remove(TreeNode<E> node, E data) {
	if (node == nil) {
	    return node;
	}
	if (data.compareTo(node.data) < 0) {
	    node.left = remove(node.left, data);
	} else if (data.compareTo(node.data) > 0) {
	    node.right = remove(node.right, data);
	} else {
	    if (node.left == nil && node.right == nil) {
		node = nil;
	    } else if (node.left == nil) {
		node = node.right;
	    } else if (node.right == nil) {
		node = node.left;
	    } else {
		TreeNode<E> temp = minR(node.right);
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
	if (node == nil) {
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
	if (node == nil) {
	    return node;
	}
	TreeNode<E> left = invert(node.left);
	TreeNode<E> right = invert(node.right);
	node.left = right;
	node.right = left;
	return node;
    }

    public void removeIteratively(E data) {
	TreeNode<E> z = searchRecursive(data);
	if (z == nil) {
	    System.out.println(data + " not found");
	    return;
	}
	if (z.left == nil) {
	    transplant(z, z.right);
	} else if (z.right == nil) {
	    transplant(z, z.left);
	} else {
	    TreeNode<E> y = minIterative(z.right);
	    if (y.parent != z) {
		transplant(y, y.right);
		y.right = z.right;
		y.right.parent = y;
	    }
	    transplant(z, y);
	    y.left = z.left;
	    y.left.parent = y;
	}
    }

    private void transplant(TreeNode<E> u, TreeNode<E> v) {
	if (u.parent == nil) {
	    root = v;
	} else if (u.parent.left == u) {
	    u.parent.left = v;
	} else {
	    u.parent.right = v;
	}
	if (u.parent != nil) {
	    v.parent = u.parent;
	}
    }

    public void removeIterativeRED_BLACK(E data) {
	TreeNode<E> z = searchRecursive(data);
	if (z == nil) {
	    System.out.println(data + " not found");
	    return;
	}
	TreeNode<E> y = z;
	Color orig_y_color = y.color;
	TreeNode<E> x;
	if (z.left == nil) {
	    x = z.right;
	    transplantRB(z, z.right);
	} else if (z.right == nil) {
	    x = z.left;
	    transplantRB(z, z.left);
	} else {
	    y = minIterative(z.right);
	    orig_y_color = y.color;
	    x = y.right;
	    if (y.parent == z) {
		x.parent = y;
	    } else {
		transplantRB(y, y.right);
		y.right = z.right;
		y.right.parent = y;
	    }
	    transplantRB(z, y);
	    y.left = z.left;
	    y.left.parent = y;
	    y.color = z.color;
	}
	if (orig_y_color == BLACK) {
	    deletedFixupRB(x);
	}
    }

    private void deletedFixupRB(TreeNode<E> x) {
	while (x != root && x.color == BLACK) {
	    if (x == x.parent.left) {
		TreeNode<E> w = x.parent.right;
		if (w.color == RED) { // case 1
		    w.color = BLACK;
		    x.parent.color = RED;
		    leftRotate(x.parent);
		    w = x.parent.right;
		}
		if (w.left.color == BLACK && w.right.color == BLACK) { // case 2
		    w.color = RED;
		    x = x.parent;
		} else {
		    if (w.right.color == BLACK) { // case 3
			w.left.color = BLACK;
			w.color = RED;
			rightRotate(w);
			w = x.parent.right;
		    }
		    // case 4
		    w.color = x.parent.color;
		    x.parent.color = BLACK;
		    w.right.color = BLACK;
		    leftRotate(x.parent);
		    x = root;
		}
	    } else {
		TreeNode<E> w = x.parent.left;
		if (w.color == RED) {
		    w.color = BLACK;
		    x.parent.color = RED;
		    rightRotate(x.parent);
		    w = x.parent.left;
		}
		if (w.left.color == BLACK && w.left.color == BLACK) {
		    w.color = RED;
		    x = x.parent;
		} else {
		    if (w.left.color == BLACK) {
			w.right.color = BLACK;
			w.color = RED;
			leftRotate(w);
			w = x.parent.left;
		    }
		    w.color = x.parent.color;
		    x.parent.color = BLACK;
		    w.left.color = BLACK;
		    rightRotate(x.parent);
		    x = root;
		}
	    }
	}
	x.color = BLACK;
    }

    private void transplantRB(TreeNode<E> u, TreeNode<E> v) {
	if (u.parent == nil) {
	    root = v;
	} else if (u == u.parent.left) {
	    u.parent.left = v;
	} else {
	    u.parent.right = v;
	}
	v.parent = u.parent;
    }

    public E minIterative() {
	return minIterative(root).data;
    }

    private TreeNode<E> minIterative(TreeNode<E> node) {
	while (node.left != nil) {
	    node = node.left;
	}
	return node;
    }

    public E maxIterative() {
	return maxI(root).data;
    }

    private TreeNode<E> maxI(TreeNode<E> node) {
	while (node.right != nil) {
	    node = node.right;
	}
	return node;
    }

    public E predecessor(E data) {
	TreeNode<E> x = searchRecursive(data);
	if (x != nil && x.left != nil) {
	    return maxR(x.left).data;
	}
	TreeNode<E> y = x.parent;
	while (y != nil && x == x.parent.left) {
	    x = y;
	    y = x.parent; // y = y.parent
	}
	return y.data;
    }

    public void removeAll() {
	this.nil = new TreeNode<>();
	this.nil.color = BLACK;
	this.root = this.nil;
	this.root.parent = this.nil;
    }

}
