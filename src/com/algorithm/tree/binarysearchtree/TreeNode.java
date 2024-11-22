package com.algorithm.tree.binarysearchtree;

public class TreeNode<V extends Comparable<V>> implements Comparable<TreeNode<V>> {
  TreeNode<V> parent;
  TreeNode<V> left;
  TreeNode<V> right;
  V data;

  public TreeNode(TreeNode<V> parent, V data) {
    this.parent = parent;
    this.data = data;
  }

  @Override
  public String toString() {
    return data + " -> [parent: " + (parent != null ? parent.data : null) + "]";
  }

  @Override
  public int compareTo(TreeNode<V> o) {
    throw new RuntimeException("Don't use please.");
  }
}
