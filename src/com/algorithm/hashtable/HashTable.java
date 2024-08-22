package com.algorithm.hashtable;

import java.util.Random;

import com.algorithm.dynamiclist.twelve.doublelinkedlist.DoubleLinkedList;

//https://www.youtube.com/watch?v=KyUTuwz_b7Q
public class HashTable {

	@SuppressWarnings("unchecked")
	private static DoubleLinkedList<String>[] store = new DoubleLinkedList[5];

	public static void main(String[] args) {
		String strings[] = generateRandomStrings(20);

		HashTable hashTable = new HashTable();
		for (String string : strings) {
			hashTable.insert(string);
		}

		hashTable.print();

		String deleteKey = null;

		hashTable.delete(deleteKey);

		hashTable.print();

	}

	private void print() {
		System.out.println("Printing Hash Table");
		int i = 0;
		while (i < store.length) {
			System.out.print("At position " + i + " -> ");
			if (store[i] == null) {
				System.out.println("Bucket at index " + i + " is empty");
			} else {
				store[i].printFromFront();
			}
			i++;
		}
	}

	private void delete(String key) {
		int index = hash(key) % store.length;
		if (key != null && store[index].remove(key)) {
			System.out.println("Deleted " + key);
		} else {
			System.out.println(key + " not found");
		}
	}

	private void insert(String key) {
		int index = hash(key) % store.length;
		if (null == store[index]) {
			store[index] = new DoubleLinkedList<String>("Hash Table Bucket at index " + index);
		}
		store[index].insertAtBack(key);
	}

	private int hash(String key) {
		int hash = 0;
		if (key != null) {
			for (char c : key.toCharArray()) {
				hash += getAscii(c);
			}
		}
		return hash;
	}

	private static String[] generateRandomStrings(int number) {
		return new Random().ints(65, 123).mapToObj(HashTable::convert).limit(number).toArray(String[]::new);
	}

	private static String convert(int i) {
		while (true) {
			if (Character.isLetter((char) i)) {
				return String.valueOf((char) i);
			}
			i++;
		}
	}

	private static int getAscii(char ch) {
		return ch;
	}
}
