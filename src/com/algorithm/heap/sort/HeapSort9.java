package com.algorithm.heap.sort;

import java.util.Arrays;

public class HeapSort9 {
    private static int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };

    static int heapSize;

    private static void print() {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    public static void main(String[] args) {
	print();
	heapSize = arr.length - 1;
	heapSort();
	print();
    }

    private static void heapSort() {
	buildHeap();
	for(int i = arr.length - 1; i > 0; i--) {
	    swap(0, i);
	    heapSize--;
	    maintainHeap(0);
	}
    }

    private static void buildHeap() {
	for (int i = (arr.length - 1) / 2; i > -1; i--) {
	    maintainHeap(i);
	}
    }

    private static void maintainHeap(int parent) {
	int leftChild = getLeftChildIndex(parent);
	int rightChild = getRightChildIndex(parent);
	int largest = parent;
	if(leftChild <= heapSize && arr[leftChild] > arr[largest]) {
	    largest = leftChild;
	}
	if(rightChild <= heapSize && arr[rightChild] > arr[largest]) {
	    largest = rightChild;
	}
	if(largest != parent) {
	    swap(largest, parent);
	    maintainHeap(largest);
	}
    }

    private static void swap(int a, int b) {
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
    }

    private static int getRightChildIndex(int parent) {
	return (2 * parent) + 2;
    }

    private static int getLeftChildIndex(int parent) {
	return (2 * parent) + 1;
    }
}
