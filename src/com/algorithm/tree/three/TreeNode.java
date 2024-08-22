package com.algorithm.tree.three;

public class TreeNode<E extends Comparable<E>> {
    TreeNode<E> left;
    TreeNode<E> right;
    E data;

    public TreeNode(E data) {
	this.data = data;
	left = right = null;
    }
    
    public void insert(E insertData) {
	if(insertData.compareTo(this.data) < 0) {
	    if (null == left) {
		left = new TreeNode<>(insertData);
	    } else {
		left.insert(insertData);
	    }
	} else if (insertData.compareTo(this.data) > 0 ) {
	    if(null == right) {
		right = new TreeNode<>(insertData);
	    } else {
		right.insert(insertData);
	    }
	}
	//ignore the duplicates
    }

    @Override
    public String toString() {
	return "data=" + data;
    }
    
    
}
