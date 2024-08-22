package random;

public class NonRepeating {
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
	val = "apples";
	answer = firstNonRepeatingCharacter(val);
	System.out.println(answer);
	val = "papaya";
	answer = firstNonRepeatingCharacter(val);
	System.out.println(answer);

    }

    public static char firstNonRepeatingCharacter(String val) throws Exception {

	char[] letters = val.toCharArray();
	System.out.println("length " + letters.length);
	char res = 0;
	for (int i = 0; i < letters.length; i++) {
	    int occ = 1;
	    for (int j = i + 1; j < letters.length; j++) {
		if (letters[i] == letters[j]) {
		    occ++;
		    j = letters.length;
		}
	    }
	    if (occ == 1) {
		for (int j = i - 1; j > -1; j--) {
		    if (letters[j] == letters[i]) {
			occ++;
			j = -1;
		    }
		}
		if (occ == 1) {
		    res = letters[i];
		    i = letters.length;
		}

	    }
	}

	return res;
    }
}
