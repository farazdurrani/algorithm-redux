package com.algorithm.tree.binarysearchtree;

import com.algorithm.dynamiclist.seventeen.doublelinkedlist.Queue;
import com.algorithm.dynamiclist.seventeen.doublelinkedlist.Stack;

public class BinarySearchTree<E extends Comparable<E>> {

  private TreeNode<E> root;

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

  public int heightIterativeWhichAlsoDoesLevelOrderTraversal() {
    int height = -1;
    if (root == null) {
      return height;
    }
    Queue<TreeNode<E>> queue = new Queue<>();
    queue.enqueue(root);
    while (!queue.isEmpty()) {
      height++;
      int size = queue.size();
      while (size > 0) {
        TreeNode<E> node = queue.dequeue();
        System.out.print(node.data + " ");
        if (node.left != null) {
          queue.enqueue(node.left);
        }
        if (node.right != null) {
          queue.enqueue(node.right);
        }
        size--;
      }
    }
    System.out.println();
    return height;
  }

  public void invertTreeIterativelyWhichAlsoDoesLevelOrderTraversal() {
    Queue<TreeNode<E>> queue = new Queue<>();
    queue.enqueue(root);
    while (!queue.isEmpty()) {
      TreeNode<E> node = queue.dequeue();
      if (node.left != null) {
        queue.enqueue(node.left);
      }
      if (node.right != null) {
        queue.enqueue(node.right);
      }
      TreeNode<E> ln = node.left;
      TreeNode<E> rn = node.right;
      node.left = rn;
      node.right = ln;
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

  public int height() {
    return height(root);
  }

  private int height(TreeNode<E> node) {
    if (node == null) {
      return 0;
    }

    int lh = height(node.left);
    int rh = height(node.right);
    return Math.max(lh, rh) + 1;
  }

  public void invertTree() {
    root = invert(root);
  }

  private TreeNode<E> invert(TreeNode<E> node) {
    if (node == null) {
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

  public void inorderTraversalIterative() {
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

  public boolean containsRecursive(E data) {
    return containsRecursive(root, data) != null;
  }

  private TreeNode<E> containsRecursive(TreeNode<E> node, E data) {
    if (node == null || (node != null && node.data.compareTo(data) == 0)) {
      return node;
    }
    if (data.compareTo(node.data) < 0) {
      return containsRecursive(node.left, data);
    }
    if (data.compareTo(node.data) > 0) {
      return containsRecursive(node.right, data);
    }
    return null;
  }

  public void insertIterative(E data) {
    TreeNode<E> z = new TreeNode<>(null, data);
    insertIterative(z);
  }

  public void insertIterative(TreeNode<E> z) {
    TreeNode<E> y = null;
    TreeNode<E> x = root;
    while (x != null) {
      y = x;
      if (z.data.compareTo(x.data) < 0) {
        x = x.left;
      } else if (z.data.compareTo(x.data) > 0) {
        x = x.right;
      }
    }
    z.parent = y;
    if (y == null) {
      root = z;
    } else if (z.data.compareTo(y.data) < 0) {
      y.left = z;
    } else {
      y.right = z;
    }
  }

  public void removeIteratively(E data) {
    TreeNode<E> z = search(data);
    if (z == null) {
      System.out.println("Can't find " + data);
      return;
    }
    removeIteratively(z);
  }

  public void removeIteratively(TreeNode<E> z) {
    if (z.left == null) {
      transplant(z, z.right);
    } else if (z.right == null) {
      transplant(z, z.left);
    } else {
      TreeNode<E> y = min(z.right);
      if (y.parent != z) {
        transplant(y, y.right);
        y.right = z.right;
        y.right.parent = y;
      }
      transplant(z, y);
      y.left = z.left;
      y.parent.left = y;
    }
  }

  private void transplant(TreeNode<E> u, TreeNode<E> v) {
    if (u.parent == null) {
      root = v;
    } else if (u.parent.left == u) {
      u.parent.left = v;
    } else {
      u.parent.right = v;
    }
    if (v != null) {
      v.parent = u.parent;
    }
  }
}
