package random;

public class PrimeNumbers {

  public static void main(String[] args) {
    printPrimes(50); // Prints prime numbers up to 50
  }

  public static void printPrimes(int n) {
    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) {
        System.out.println(i);
      }
    }
  }

  public static boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }
    for (int i = 2; i < num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
