package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortByMean {
    public static void main(String[] args) {

	int[][] arr = { { 3, 3, 4, 2 }, { 4, 4 }, { 4, 0, 3, 5 }, { 3, 3 } };

	Map<Integer, List<Integer>> map = new TreeMap<>();

	for (int i = 0; i < arr.length; i++) {
	    int mean = mean(arr[i]);
	    if (map.containsKey(mean)) {
		List<Integer> l = map.get(mean);
		l.add(i);
		map.put(mean, l);
	    } else {
		List<Integer> l = new ArrayList<>();
		l.add(i);
		map.put(mean, l);
	    }
	}

	int finArr[][] = new int[map.values().size()][];

	List<Integer> keys = new ArrayList<>(map.keySet());

	for (int i = 0; i < keys.size(); i++) {
	    finArr[i] = map.remove(keys.get(i)).stream().mapToInt(val -> val).toArray();
	}

	System.out.print("[ ");
	for (int[] is : finArr) {
	    System.out.print(Arrays.toString(is) + " ");
	}
	System.out.println("]");

	for (int i = 1; i < arr.length; i++) {
	    int[] kk = arr[i];
	    int key = mean(arr[i]);
	    int j = i - 1;
	    while (j > -1 && mean(arr[j]) > key) {
		arr[j + 1] = arr[j];
		j--;
	    }
	    arr[j + 1] = kk;
	}

	for (int[] is : arr) {
	    System.out.println(Arrays.toString(is));
	}
    }

    private static int mean(int[] is) {
	int count = 0;
	int sum = 0;
	for (int i : is) {
	    sum += i;
	    count++;
	}
	return sum / count;
    }
}
