package random;

import java.util.Objects;
import java.util.stream.IntStream;

//array based stack
public class Stack {
    private int[] data;
    private int index;

    public void push(int data) {
	if (index % 10 == 0) {
	    this.data = createNewArray(this.data);
	}

	this.data[index] = data;
	index++;
    }
    
    public int pop() {
	int val = this.data[index-1];
	this.data[index-1] = 0;
	index--;
	return val;
    }

    public void print() {
	IntStream.of(this.data).filter(x -> x != 0).forEach(x -> System.out.print(x + " "));
	System.out.println();
    }

    private int[] createNewArray(int[] arr) {
	int newArr[] = null;
	if (Objects.nonNull(arr)) {
	    newArr = new int[arr.length + 10];
	    for (int i = 0; i < arr.length; i++) {
		newArr[i] = arr[i];
	    }
	} else {
	    newArr = new int[10];
	}
	return newArr;
    }

    public static void main(String[] args) {
	Stack s = new Stack();
	IntStream.range(0, 37).forEach(s::push);
	s.print();
	s.pop();
	s.print();
	s.push(99);
	s.print();
    }
}
