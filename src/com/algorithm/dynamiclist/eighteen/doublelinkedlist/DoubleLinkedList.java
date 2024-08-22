package com.algorithm.dynamiclist.eighteen.doublelinkedlist;

public class DoubleLinkedList<E extends Comparable<E>> {

	private Node<E> first;
	private Node<E> last;

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
			System.out.println("List is empty");
			return;
		}
		printFromFrontRecursive(first);
		System.out.println();

	}

	private void printFromFrontRecursive(Node<E> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			printFromFrontRecursive(node.next);
		}
	}

	public void printFromFront() {
		if (isEmpty()) {
			System.out.println("List is empty");
			return;
		}
		Node<E> temp = first;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;

		}
		System.out.println();
	}

	public void printInReverse() {
		if (isEmpty()) {
			System.out.println("List is empty");
			return;
		}
		Node<E> temp = last;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.prev;

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
			System.out.println("It is empty.");
			return null;
		}
		E data = first.data;
		if (first == last) {
			first = last = null;
			return data;
		} else {
			first = first.next;
			first.prev = null;
		}
		return data;
	}

	public E removeFromBack() {
		if (isEmpty()) {
			System.out.println("It is empty.");
			return null;
		}
		E data = last.data;
		if (first == last) {
			first = last = null;
			return data;
		} else {
			last = last.prev;
			last.next = null;
		}
		return data;
	}

	public boolean delete(E data) {
		if (isEmpty()) {
			System.out.println("List is empty");
			return false;
		}
		if (first.data.compareTo(data) == 0) {
			return removeFromFront() != null;
		} else if (last.data.compareTo(data) == 0) {
			return removeFromBack() != null;
		} else {
			Node<E> node = first;
			while (node != null && node.data.compareTo(data) != 0) {
				node = node.next;
			}
			if (node != null && node.data.compareTo(data) == 0) {
				node.next.prev = node.prev;
				node.prev.next = node.next;
				return true;
			}
		}
		return false;
	}

	public class Node<E> {
		E data;
		Node<E> prev;
		Node<E> next;

		public Node() {

		}

		public Node(E data) {
			this.data = data;
		}

	}

	public void reverse() {
		last = first;
		Node<E> temp = first;
		Node<E> futureFirst = null;
		while (temp != null) {
			futureFirst = temp;
			Node<E> next = temp.next;
			temp.next = temp.prev;
			temp.prev = next;
			temp = next;
		}
		first = futureFirst;
	}

}
