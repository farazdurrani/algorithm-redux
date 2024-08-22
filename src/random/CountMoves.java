package random;

import java.util.Arrays;
import java.util.Random;

public class CountMoves {

    static Random rand = new Random();
    
    public static void main(String[] args) {
	int[] numbers = { 3, 4, 6, 6, 3 };
	int maxIndex = findMax(numbers);
	int nextIndex = 0;
	int moves = 0;
	while (true) {
	    moves++;
	    nextIndex = getNextIndex(numbers, maxIndex);
	    numbers[nextIndex] += 1;
	    Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
	    System.out.println(" :index worked on: " + nextIndex);
	    if (allNumbersSame(numbers)) {
		break;
	    }
	}

	System.out.println("Moves: " + moves);
    }

    private static int findMax(int[] numbers) {
	int max = Integer.MIN_VALUE;
	int index = -1;
	for (int i = 0; i < numbers.length; i++) {
	    if (numbers[i] > max) {
		max = numbers[i];
		index = i;
	    }
	}
	return index;
    }

    private static boolean allNumbersSame(int[] numbers) {
	for (int i = 1; i < numbers.length; i++) {
	    if (numbers[i] != numbers[i - 1]) {
		return false;
	    }
	}
	return true;
    }

    private static int getNextIndex(int[] numbers, int maxIndex) {
	while (true) {
	    int rn = rand.nextInt(numbers.length);
	    if (numbers[rn] < numbers[maxIndex]) {
		return rn;
	    }
	}

    }
}
