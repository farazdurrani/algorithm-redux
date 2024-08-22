package random;

//This is not Dynamic Programming example
public class Factorial {
	public static void main(String[] args) {
		System.out.println("Naive approach " + factorial(10));
		System.out.println("Bottom Up approach " + factBottomUp(10));

	}

	private static int factBottomUp(int n) {
		int factorial = 1;
		for (int i = 2; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

	private static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}
}
