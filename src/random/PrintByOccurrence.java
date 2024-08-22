package random;

import java.util.HashMap;
import java.util.Map;

public class PrintByOccurrence {
    public static void main(String[] args) {

	String s1 = "aba";
	String s2 = "12323";

	calculateOccurence(s1);
	calculateOccurence(s2);
    }

    public static void calculateOccurence(String s) {
	Map<String, Integer> map = new HashMap<>();
	int max = 1;
	for (char c : s.toCharArray()) {
	    String letter = String.valueOf(c);
	    if (map.containsKey(letter)) {
		Integer count = map.get(letter);
		count = count + 1;
		map.put(letter, count);
		if (count > max) {
		    max = count;
		}
	    } else {
		map.put(letter, 1);
	    }
	}
	while (max > 0) {
	    for (String letter : map.keySet()) {
		if (map.get(letter) == max) {
		    for (int i = max; i > 0; i--) {
			System.out.print(letter);
		    }
		}
	    }
	    max--;
	}
	System.out.println();

    }
}