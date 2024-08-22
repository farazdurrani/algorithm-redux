package random;

public class MostConsecutiveZeroes {
    public static void main(String[] args) {
	int B[] = { 1, 3, 4, 0, 0, 11, 1, 15, 0, 0, 0, 87, 0 };

	int max_zeroes = 0;
	int zeroes = 0;
	int endIndex = -1;
	for (int i = 0; i < B.length; i++) {
	    if (B[i] == 0) {
		zeroes += 1;
		if (zeroes > max_zeroes) {
		    max_zeroes = zeroes;
		    endIndex = i;
		}
	    } else {
		zeroes = 0;
	    }
	}

	int startIndex = endIndex;
	for (int i = endIndex - 1; i > -1; i--) {
	    if(B[i] == 0) {
		startIndex = i;
	    } else {
	        i = -1; //used to get out of this for loop.
	    }
	}

	System.out.println(
		"Max zeroes is: " + max_zeroes + " at start index " + startIndex + " and end index: " + endIndex);
    }
}
