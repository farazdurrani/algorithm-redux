package random;

public class MyRunnable implements Runnable {

    private long val;

    public MyRunnable(int i) {
	this.val = i;
    }

    @Override
    public void run() {
	while (this.val < 12) {
	    synchronized (PrimeNumberPrinter.set) {
		if (!PrimeNumberPrinter.set.contains(this.val)) {
		    if (isEven(this.val)) {
			System.out.println(this.val);
			PrimeNumberPrinter.set.add(this.val);
		    }
		    this.val++;
		}
	    }
	}
    }

    private boolean isEven(long n) {
	return n % 2 == 0;
    }

}
