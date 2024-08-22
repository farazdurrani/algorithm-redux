package com.algorithm.tree.twenty;

import com.algorithm.dynamiclist.sisteen.Queue;
import com.algorithm.dynamiclist.sisteen.Stack;

@SuppressWarnings({ "static-access", "unchecked", "rawtypes" })
public class RedBlackTree<E extends Comparable<E>> {

    TreeNode<E> root;
    static TreeNode NIL;
    final static Color BLACK = Color.BLACK;
    final static Color RED = Color.RED;

    public RedBlackTree() {
	this.NIL = new TreeNode<>();
	this.NIL.color = BLACK;
	this.root = this.NIL;
	this.root.parent = this.NIL;
    }

    public boolean insertRecursive(E data) {
	if (root == NIL) {
	    root = new TreeNode<>(NIL, data);
	    root.left = this.NIL;
	    root.right = this.NIL;
	    return true;
	} else {
	    TreeNode<E> node = root.insert(root, data);
	    if (node != this.NIL) {
		node.left = this.NIL;
		node.right = this.NIL;
		node.color = RED;
		rbInsertFixup(node);
		return true;
	    }
	}
	return false;
    }

    private void rbInsertFixup(TreeNode<E> z) {
	while (z.parent.color == RED) {
	    if (z.parent.parent.left == z.parent) {
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

    private void leftRotate(TreeNode<E> x) {
	TreeNode<E> y = x.right;
	x.right = y.left;
	if (y.left != this.NIL) {
	    y.left.parent = x;
	}
	y.parent = x.parent;
	if (x.parent == this.NIL) {
	    this.root = y;
	} else if (x == x.parent.left) {
	    x.parent.left = y;
	} else {
	    x.parent.right = y;
	}
	y.left = x;
	x.parent = y;
    }

    private void rightRotate(TreeNode<E> x) {
	TreeNode<E> y = x.left;
	x.left = y.right;
	if (y.right != this.NIL) {
	    y.right.parent = x;
	}
	y.parent = x.parent;
	if (x.parent == this.NIL) {
	    this.root = y;
	} else if (x == x.parent.left) {
	    x.parent.left = y;
	} else {
	    x.parent.right = y;
	}
	y.right = x;
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
	if (node == this.NIL) {
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
	return minRecursive(root).data;
    }

    private TreeNode<E> minRecursive(TreeNode<E> node) {
	if (node != this.NIL && node.left != this.NIL) {
	    return minRecursive(node.left);
	}
	return node;
    }

    public E maxRecursive() {
	return maxRecursive(root).data;
    }

    private TreeNode<E> maxRecursive(TreeNode<E> node) {
	if (node != this.NIL && node.right != this.NIL) {
	    return maxRecursive(node.right);
	}
	return node;
    }

    public E minIterative() {
	return minIterative(root);
    }

    private E minIterative(TreeNode<E> node) {
	while (node.left != this.NIL) {
	    node = node.left;
	}
	return node.data;
    }

    public E maxIterative() {
	return maxIterative(root);
    }

    private E maxIterative(TreeNode<E> node) {
	while (node.right != this.NIL) {
	    node = node.right;
	}
	return node.data;
    }

    public TreeNode<E> getRoot() {
	return root;
    }

    public E successor(E data) {
	TreeNode<E> x = searchRecursive(data);
	if (x.right != this.NIL) {
	    return minRecursive(x.right).data;
	}
	TreeNode<E> y = x.parent;
	while (y != this.NIL && x == x.parent.right) {
	    x = y;
	    y = y.parent;
	}
	return y.data;
    }

    public TreeNode<E> searchRecursive(E data) {
	return search(root, data);
    }

    private TreeNode<E> search(TreeNode<E> node, E data) {
	if (node == this.NIL || (node != this.NIL && node.data.compareTo(data) == 0)) {
	    return node;
	} else if (data.compareTo(node.data) < 0) {
	    return search(node.left, data);
	} else {
	    return search(node.right, data);
	}
    }

    public void inorderTraversalIterative() {
	Stack<TreeNode<E>> s = new Stack<>();
	TreeNode<E> curr = root;
	while (curr != this.NIL || !s.isEmpty()) {
	    while (curr != this.NIL) {
		s.push(curr);
		curr = curr.left;
	    }
	    curr = s.pop();
	    System.out.print(curr.data + " ");
	    curr = curr.right;
	}
	System.out.println();

    }

    private void inorderHelper(TreeNode<E> node) {
	if (node == this.NIL) {
	    return;
	}
	inorderHelper(node.left);
	System.out.print(node.data + " ");
	inorderHelper(node.right);
    }

    public E containsIterative(E data) {
	return containsIterative(root, data).data;
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

    public void levelOrderTraversalQueue() {
	Queue<TreeNode<E>> q = new Queue<>();
	if (root != this.NIL) {
	    q.enqueue(root);
	}
	while (!q.isEmpty()) {
	    TreeNode<E> node = q.dequeue();
	    System.out.print(node.data + " ");
	    if (node.left != this.NIL) {
		q.enqueue(node.left);
	    }
	    if (node.right != this.NIL) {
		q.enqueue(node.right);
	    }
	}
	System.out.println();
    }

    public void inorderTraversalResursive() {
	inorderHelper(root);
	System.out.println();
    }

    public boolean insertIterative(E data) {
	TreeNode<E> y = this.NIL;
	TreeNode<E> x = this.root;
	while (x != this.NIL) {
	    y = x;
	    if (data.compareTo(x.data) == 0) {
		return false;
	    } else if (data.compareTo(x.data) < 0) {
		x = x.left;
	    } else {
		x = x.right;
	    }
	}
	TreeNode<E> z = new TreeNode<>(y, data);
	if (y == this.NIL) {
	    this.root = z;
	} else if (data.compareTo(y.data) < 0) {
	    y.left = z;
	} else {
	    y.right = z;
	}
	z.left = this.NIL;
	z.right = this.NIL;
	z.color = RED;
	rbInsertFixup(z);
	return true;
    }

    public void preorderTraversalRecursive() {
	preorderTraversalHelper(root);
	System.out.println();
    }

    private void preorderTraversalHelper(TreeNode<E> node) {
	if (node == this.NIL) {
	    return;
	}
	System.out.print(node.data + " ");
	preorderTraversalHelper(node.left);
	preorderTraversalHelper(node.right);
    }

    public void preorderTraversalIterative() {
	Stack<TreeNode<E>> s = new Stack<>();
	if (root != NIL) {
	    s.push(root);
	}
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
	postorderTraversalHelper(root);
	System.out.println();
    }

    private void postorderTraversalHelper(TreeNode<E> node) {
	if (node == NIL) {
	    return;
	}
	postorderTraversalHelper(node.left);
	postorderTraversalHelper(node.right);
	System.out.print(node.data + " ");
    }

    public void postorderTraversalIterative() {
	Stack<TreeNode<E>> s1 = new Stack<>();
	Stack<TreeNode<E>> s2 = new Stack<>();

	if (root != NIL) {
	    s1.push(root);
	}
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

    public void removeRecursive(E data) {
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
	    if (node.left == NIL) {
		node = node.right;
	    } else if (node.right == NIL) {
		node = node.left;
	    } else {
		TreeNode<E> tmp = TreeMin(node.right);
		node.data = tmp.data;
		node.right = remove(node.right, node.data);
	    }
	}
	return node;
    }

    private TreeNode<E> TreeMin(TreeNode<E> node) {
	return minRecursive(node);
    }

    public int height() {
	return height(root);
    }

    private int height(TreeNode<E> node) {
	if (node == this.NIL) {
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
	if (node == this.NIL) {
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
	if (z == NIL) {
	    System.out.println(data + " not found");
	    return;
	}

	if (z.left == NIL) {
	    transplant(z, z.right);
	} else if (z.right == NIL) {
	    transplant(z, z.left);
	} else {
	    TreeNode<E> y = TreeMin(z.right);
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
	if (u.parent == NIL) {
	    root = v;
	} else if (u.parent.left == u) {
	    u.parent.left = v;
	} else {
	    u.parent.right = v;
	}
	if (u.parent != NIL) {
	    v.parent = u.parent;
	}
    }

    public void removeIterativeRED_BLACK(E data) {
	TreeNode<E> z = searchRecursive(data);
	if (z == NIL) {
	    System.out.println(data + " not found");
	    return;
	}
	TreeNode<E> y = z;
	Color orignalYColor = y.color;
	TreeNode<E> x = null;
	if (z.left == NIL) {
	    x = z.right;
	    transplantRB(z, z.right);
	} else if (z.right == NIL) {
	    x = z.left;
	    transplantRB(z, z.left);
	} else {
	    y = TreeMin(z.right);
	    orignalYColor = y.color;
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
	if (orignalYColor == BLACK) {
	    deleteREDBLACKFIX(x);
	}
    }

    private void deleteREDBLACKFIX(TreeNode<E> x) {
	//TODO
    }

    private void transplantRB(TreeNode<E> u, TreeNode<E> v) {
	if (u.parent == NIL) {
	    root = v;
	} else if (u.parent.left == u) {
	    u.parent.left = v;
	} else {
	    u.parent.right = v;
	}
	v.parent = u.parent;
    }

    public E predecessor(E data) {
	TreeNode<E> x = searchRecursive(data);
	if (x != this.NIL && x.left != this.NIL) {
	    return maxRecursive(x.left).data;
	}
	TreeNode<E> y = x.parent;
	while (y != this.NIL && x == x.parent.left) {
	    x = y;
	    y = y.parent;
	}
	return y.data;
    }

}
