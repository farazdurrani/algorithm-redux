package random;

import java.util.List;

public class MaxTrail {
    public static void main(String[] args) {
	List<Integer> list = List.of(4, 3, 2, 1); // expected -1
	System.out.println(maxTrailing(list));
	list = List.of(7, 2, 3, 10, 2, 4, 8, 1); // expected 8
	System.out.println(maxTrailing(list));
    }
    
    /**
     * the best accepted solution
     */
    static int maxTrailing(List<Integer> list) {
	int maxDif = -1;
	if (isDescSorted(list)) {
	    return maxDif;
	}

	int smallest = list.get(0);
	for (int i = 0; i < list.size(); i++) {
	    if(list.get(i) < smallest) {
		smallest = list.get(i);
	    }
	    if(list.get(i) >  smallest) {
		int diff = list.get(i) - smallest;
		if(diff > maxDif) {
		    maxDif = diff;
		}
	    }
	}

	return maxDif;
    }

    private static int maxTrailingGoodWorking(List<Integer> list) {
	int maxDif = -1;
	if (isDescSorted(list)) {
	    return maxDif;
	}

	int largest = list.get(0);
	for (int i = 0; i < list.size(); i++) {
	    for (int j = 0; j < i; j++) {
		if (list.get(i) > list.get(j)) {
		    int dif = list.get(i) - list.get(j);
		    if (dif > maxDif) {
			maxDif = dif;
		    }
		}
	    }
	}

	return maxDif;
    }

    public static int maxTrailing7(List<Integer> levels) {
	if (isDescSorted(levels)) {
	    return -1;
	}
	ValueIndex min = new ValueIndex();
	ValueIndex max = new ValueIndex();
	min.value = Integer.MAX_VALUE;
	max.value = Integer.MIN_VALUE;
	minAndMax(levels, min, max);
	return max.value - min.value;
    }

    private static void minAndMax(List<Integer> levels, ValueIndex min, ValueIndex max) {
	for (int j = 0; j < levels.size(); j++) {
	    if (levels.get(j) < min.value) {
		min.value = levels.get(j);
		min.index = j;
	    }
	    if (levels.get(j) > max.value) {
		max.value = levels.get(j);
		max.index = j;
	    }
	}
    }

    public static int maxTrailingWrong(List<Integer> levels) {
	int maxDif = -1;
	for (int i = 0; i < levels.size(); i++) {
	    if (i > 0) {
		if (levels.get(i) > levels.get(i - 1)) {
		    return -1;
		}
		int dif = -1;
		for (int j = i + 1; j < levels.size(); j++) {
		    dif = levels.get(j) - levels.get(i);
		    if (dif > maxDif) {
			maxDif = dif;
		    }
		}
	    }

	}
	return maxDif;
    }

    private static class ValueIndex {

	int value;
	int index;
    }

    public static int maxTrailing6(List<Integer> levels) {
	ValueIndex min = new ValueIndex();
	ValueIndex max = new ValueIndex();
	if (isDescSorted(levels, min, max)) {
	    return -1;
	}
	return max.value - min.value;
    }

    private static boolean isDescSorted(List<Integer> levels, ValueIndex min, ValueIndex max) {
	for (int i = 1, j = 0; i < levels.size(); i++, j++) {
	    if (levels.get(i) > levels.get(i - 1)) {
		return false;
	    }
	    if (levels.get(j) < min.value) {
		min.value = levels.get(j);
		min.index = j;
	    }
	    if (levels.get(j) > max.value) {
		max.value = levels.get(j);
		max.index = j;
	    }
	}
	return true;
    }

    public static int maxTrailing5(List<Integer> levels) {
	if (isDescSorted(levels)) {
	    return -1;
	}
	int maxDif = -1;
	for (int i = 0; i < levels.size(); i++) {
	    int dif = -1;
	    for (int j = i + 1; j < levels.size(); j++) {
		dif = levels.get(j) - levels.get(i);
		if (dif > maxDif) {
		    maxDif = dif;
		    if (j != 0 && j % 30 == 0
		        && isDescSorted(levels.subList(j, levels.size()))) {
			return maxDif;
		    }
		}
	    }
	}
	return maxDif != 0 ? maxDif : -1;
    }

    public static int maxTrailing4(List<Integer> levels) {
	if (isDescSorted(levels)) {
	    return -1;
	}
	int maxDif = maxSubArray(levels, 0, levels.size() - 1);
	return maxDif;
    }

    private static int maxSubArray(List<Integer> levels, int low, int high) {
	if (low == high) {
	    return levels.get(low);
	} else {
	    int mid = (low + high) / 2;
	    int l = maxSubArray(levels, low, mid);
	    int r = maxSubArray(levels, mid + 1, high);
	    int cm = maxSubArrayCrossingMid(levels, low, mid, high);
	    if (l >= r && l >= cm) {
		return l;
	    } else if (r >= l && r >= cm) {
		return r;
	    } else {
		return cm;
	    }
	}
    }

    private static int maxSubArrayCrossingMid(List<Integer> levels, int low, int mid,
        int high) {
	int maxDif = Integer.MIN_VALUE;
	for (int i = low; i <= mid; i++) {
	    int dif = -1;
	    for (int j = i; j <= mid; j++) {
		dif = levels.get(j) - levels.get(i);
		if (dif > maxDif) {
		    maxDif = dif;
		}
	    }
	}
	for (int j = mid + 1; j <= high; j++) {
	    int dif = -1;
	    for (int k = j; k <= high; k++) {
		dif = levels.get(k) - levels.get(j);
		if (dif > maxDif) {
		    maxDif = dif;
		}
	    }
	}
	return maxDif;
    }

    public static int maxTrailing3(List<Integer> levels) {
	if (isDescSorted(levels)) {
	    return -1;
	}
	int maxDif = -1;
	for (int i = 0; i < levels.size(); i++) {
	    int dif = -1;
	    for (int j = i; j < levels.size(); j++) {
		dif = levels.get(j) - levels.get(i);
		if (dif > maxDif) {
		    maxDif = dif;
		}
	    }
	}
	return maxDif;
    }

    private static boolean isDescSorted(List<Integer> levels) {
	for (int i = 1; i < levels.size(); i++) {
	    if (levels.get(i) > levels.get(i - 1)) {
		return false;
	    }
	}
	return true;
    }

    public static int maxTrailing2(List<Integer> levels) {
	if (isDescSorted(levels)) {
	    return -1;
	}
	int maxDif = -1;
	for (int i = 0; i < levels.size(); i++) {
	    int dif = -1;
	    for (int j = i; j < levels.size(); j++) {
		if (levels.get(j) < levels.get(i)) {
		    continue;
		} else if (j > 0) {
		    dif = levels.get(j) - levels.get(i);
		    if (dif > maxDif) {
			maxDif = dif;
		    }
		}
	    }
	}
	return maxDif;
    }
}
