package random;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PrimeNumberPrinter {
    static Set<Long> set = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
	if (Objects.nonNull(args)) {

	    int val = Integer.valueOf(args[0]);
	    for (int i = 0; i < val; i++) {
		Thread t = new Thread(new MyRunnable(i));
		t.start();
	    }
	}
	System.exit(0);
    }

}
