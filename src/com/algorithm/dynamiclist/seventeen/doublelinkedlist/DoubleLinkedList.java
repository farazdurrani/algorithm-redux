package com.algorithm.dynamiclist.seventeen.doublelinkedlist;

public class DoubleLinkedList<E extends Comparable<E>> {

	private Node<E> first;
	private Node<E> last;
	private String name;

	public DoubleLinkedList() {
		this("Doubly-Linked Linked List");
	}

	public DoubleLinkedList(String name) {
		this.name = name;
	}

	public void insertAtFront(E data) {
		Node<E> node = new Node<>(data);
		if (isEmpty()) {
			first = last = node;
		} else {
			first.prev = node;
			node.next = first;
			first = node;
		}

	}

	boolean isEmpty() {
		return first == null;
	}

	public void printFromFrontRecursive() {
		if (isEmpty()) {
			print();
			return;
		}
		printRecursive(first);
		System.out.println();
	}

	private void printRecursive(Node<E> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			printRecursive(node.next);
		}
	}

	private void print() {
		System.out.println(this.name + " is empty.");
	}

	public void printFromFront() {
		if (isEmpty()) {
			print();
			return;
		}
		Node<E> node = first;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();

	}

	public void printInReverse() {
		if (isEmpty()) {
			print();
			return;
		}
		Node<E> node = last;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.prev;
		}
		System.out.println();
	}

	public void insertAtBack(E data) {
		Node<E> node = new Node<>(data);
		if (isEmpty()) {
			first = last = node;
		} else {
			last.next = node;
			node.prev = last;
			last = node;
		}
	}

	public E removeFromFront() {
		if (isEmpty()) {
			print();
			return null;
		}
		E data = first.data;
		first = first.next;
		if (first != null) {
			first.prev = null;
		}
		return data;
	}

	public E removeFromBack() {
		if (isEmpty()) {
			print();
			return null;
		}
		E data = last.data;
		last = last.prev;
		last.next = null;
		return data;
	}

	public boolean delete(E data) {
		if (isEmpty()) {
			print();
			return false;
		}
		if (first.data.compareTo(data) == 0) {
			return removeFromFront() != null;
		}
		if (last.data.compareTo(data) == 0) {
			return removeFromBack() != null;
		}
		Node<E> node = first;
		while (node != null && node.data.compareTo(data) != 0) {
			node = node.next;
		}
		if (node != null && node.data.compareTo(data) == 0) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			return true;
		}
		return false;
	}

	public void reverse() {
		last = first;
		Node<E> node = first;
		Node<E> futureFirst = null;
		while (node != null) {
			futureFirst = node;
			Node<E> next = node.next;
			node.next = node.prev;
			node.prev = next;
			node = next;
		}
		first = futureFirst;
	}

	private class Node<E> {
		E data;
		Node<E> next;
		Node<E> prev;

		public Node(E data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + this.data + "]";
		}
	}

}
