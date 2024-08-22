package random;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Spawn10Threads {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

	Executor es = Executors.newFixedThreadPool(10);
	AtomicInteger ai = new AtomicInteger(0);

	if (Objects.nonNull(args) && args.length > 0) {
	    ai.set(Integer.valueOf(args[0]));
	}

	for (int i = 0; i < 10; i++) {
	    CompletableFuture.runAsync(() -> {
		while (1 > 0) {
		    int val = ai.incrementAndGet();
		    if (isEven(val)) {
			System.out.println(val + " Thread ID: " + Thread.currentThread().getId());
			if (val >= ai.get()) {
			    ai.incrementAndGet();
			}
		    }
		}
	    }, es);
	}
    }

    private static boolean isEven(int val) {
	return val % 2 == 0;
    }
}
