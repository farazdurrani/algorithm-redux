package com.algorithm.heap.sort;

import java.util.Arrays;

public class HeapSort8 {
    
    private static int arr[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
    
    static int heapSize;

    private static void print(int[] arr) {
	Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    public static void main(String[] args) {
	print(arr);
	heapSize = arr.length - 1;
	heapSort(arr);
	print(arr);
    }

    private static void heapSort(int[] arr) {
	buildMaxHeap();
	for(int i = arr.length - 1; i > 0; i--) {
	    swap(arr, 0, i);
	    heapSize--;
	    maintainHeap(arr, 0);
	}
    }

    private static void buildMaxHeap() {
	for(int i = (arr.length - 1) / 2; i > -1; i--) {
	    maintainHeap(arr, i);
	}
    }

    private static void maintainHeap(int[] arr, int parent) {
	int leftChild = leftChild(parent);
	int rightChild = rightChild(parent);
	int largest = parent;
	if(leftChild <= heapSize && arr[leftChild] > arr[largest]) {
	    largest = leftChild;
	}
	if(rightChild <= heapSize && arr[rightChild] > arr[largest]) {
	    largest = rightChild;
	}
	if(largest != parent) {
	    swap(arr, largest, parent);
	    maintainHeap(arr, largest);
	}
    }

    private static void swap(int[] arr, int a, int b) {
	int temp = arr[a];
	arr[a] = arr[b];
	arr[b] = temp;
    }

    private static int rightChild(int parent) {
	return (2 * parent) + 2;
    }

    private static int leftChild(int parent) {
	return (2 * parent) + 1;
    }
    
    private static int parent(int child) {
	return (child - 1)  / 2;
    }
}
