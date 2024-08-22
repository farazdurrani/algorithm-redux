package random;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SquareRootVsDivideBy2 {
    public static void main(String[] args) {
	List<Integer> numbers = IntStream.rangeClosed(2, 100).boxed()
	    .collect(Collectors.toList());
	System.out.printf("%s%20s%n", "Divisible by 2", "Square Root");
	for (Integer num : numbers) {
	    System.out.printf("%d %20.2f %n", num / 2, Math.sqrt(num));
	}
    }
}
