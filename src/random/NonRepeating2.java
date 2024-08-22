package random;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeating2 {
    /*
     * public char firstNonRepeatingCharacter(String val) {...}
     * 
     * Write a function, that will return the first character in a string that does
     * not repeat.
     * 
     * Examples:
     * 
     * firstNonRepeatingCharacter(â€œapplesâ€�) returns 'a'
     * 
     * firstNonRepeatingCharacter(â€œpapayaâ€�) returns 'y'
     */
    public static void main(String[] args) throws Exception {
	String val = "appeases";
	char answer = firstNonRepeatingCharacter(val);
	System.out.println(answer);
    }

    public static char firstNonRepeatingCharacter(String val) throws Exception {

	Map<String, Integer> map = new LinkedHashMap<>();

	char[] letters = val.toCharArray();
	for (char c : letters) {
	    if (map.containsKey(String.valueOf(c))) {
		int value = map.get(String.valueOf(c));
		value++;
		map.put(String.valueOf(c), value);
	    } else {
		map.put(String.valueOf(c), 1);
	    }
	}
	String data = "";
	for (String s : map.keySet()) {
	    if (map.get(s) == 1) {
		data = s;
		break;
	    }
	}
	if (data.length() < 1) {
	    throw new Exception("Data not found");
	}

	return data.charAt(0);
    }
}
