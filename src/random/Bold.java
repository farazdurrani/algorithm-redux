package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bold {
  public static void main(String[] args) {
    boolean[] boldArr = isBold("Hello *world* today");
    System.out.println("is bold: " + Arrays.toString(boldArr));
    boldArr = isBold("**Hi* there*");
    System.out.println("is bold: " + Arrays.toString(boldArr));
  }

  private static boolean[] isBold(String string) {
    List<String> list = convertStringToList(string);
    boolean convert = false;
    for (int i = 0; i < list.size(); i++) {
      if (convert) {
        if (list.get(i).equals("*")) {
          convert = false;
        } else {
          list.set(i, null);
        }
      }
      if (!convert && list.get(i).equals("*") && i + 1 < list.size()
          && Character.isLetter(list.get(i + 1).charAt(0))) {
        convert = true;
      }
    }
    List<String> anotherList = new ArrayList<>();
    for (String s : list) {
      if (s != null && (s.equals(" ") || s.equals("*"))) {
        continue;
      }
      anotherList.add(s);
    }
    boolean[] boldArr = new boolean[anotherList.size()];
    for(int i = 0; i < anotherList.size(); i++){
      boldArr[i] = anotherList.get(i) == null;
    }
    return boldArr;
  }

  private static List<String> convertStringToList(String string) {
    List<String> list = new ArrayList<>();
    for (char c : string.toCharArray()) {
      list.add(String.valueOf(c));
    }
    return list;
  }
}
