package com.algorithm.dynamiclist.eighteen;

public class LinkedList<E extends Comparable<E>> {

	private Node<E> first;
	private Node<E> last;

	public void print() {
		if (isEmpty()) {
			System.out.println("List is empty");
		}
		Node<E> temp = first;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertAtFront(E data) {
		if (isEmpty()) {
			first = last = new Node<>(data);
		} else {
			Node<E> node = new Node<>(data);
			node.next = first;
			first = node;
		}
	}

	public void insertAtBack(E data) {
		Node<E> node = new Node<>(data);
		if (isEmpty()) {
			first = last = node;
		} else {
			Node<E> temp = first;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
			last = node;
		}
	}

	public E removeFromFront() {
		if (isEmpty()) {
			System.out.println("List is empty");
			return null;
		}
		E data = first.data;
		if (first == last) {
			first = last = null;
		} else {
			first = first.next;
		}
		return data;
	}

	public E removeFromBack() {
		if (isEmpty()) {
			System.out.println("List is empty");
			return null;
		}
		E data = last.data;
		if (first == last) {
			first = last = null;
		} else {
			Node<E> temp = first;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
			last = temp;
		}
		return data;
	}

	public boolean delete(E data) {
		if (isEmpty()) {
			return false;
		} else {
			if (first.data.compareTo(data) == 0) {
				return removeFromFront() != null;
			} else if (last.data.compareTo(data) == 0) {
				return removeFromBack() != null;
			} else {
				Node<E> node = first;
				while (node != null && node.next != null && node.next.data.compareTo(data) != 0) {
					node = node.next;
				}
				if (node != null && node.next != null && node.next.data.compareTo(data) == 0) {
					node.next = node.next.next;
					return true;
				}
			}
		}
		return false;
	}

	private class Node<E> {
		E data;
		Node<E> next;

		public Node(E data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + (next != null ? next.data : "") + "]";
		}

	}

	public void reverse() {
		last = first;
		Node<E> prev = null;
		Node<E> curr = first;
		
		while(curr != null) {
			Node<E> next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		first = prev;
	}

}
