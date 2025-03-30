package test;

import java.util.Arrays;
import java.util.List;

public class Example {
  public static void main(String[] args) {
    /**
     * Find the missing number from the unsorted array sequences.
     *
     * int[] testCase1= {3, 0, 1,4,5,7,6};
     * int[] testCase2 = {10, 8, 11,12,13};
     *
     * output of test1: 2
     * output of test2: 9
     */
    int[] testCase1 = {3, 0, 1, 4, 5, 7, 6};
//    int[] testCase1 = {10, 8, 11, 12, 13};
    List<Integer> list1 = Arrays.stream(testCase1).sorted().boxed().toList();

    for (int i = 1; i < list1.size(); i++) {
      if (list1.get(i) != list1.get(i - 1) + 1) {
        System.out.println(list1.get(i) - 1);
        break;
      }
    }
  }
}
