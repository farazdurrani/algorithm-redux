package random;

public class BinaryPatternMatching {
    public static void main(String[] args) {
	BinaryPatternMatching b = new BinaryPatternMatching();
	String pattern = "010";
	String s = "amazing";
	System.out.println(b.binaryPatternMatching(pattern, s));
    }

    int binaryPatternMatching(String pattern, String s) {

	int furthest = s.length();
	int moves = 0;
	int matches = 0;
	while (moves <= furthest && pattern.length() + moves <= furthest) {
	    String substring = s.substring(moves, pattern.length() + moves);
	    if (verify(pattern, substring)) {
		matches++;
	    }
	    moves++;
	}
	return matches;
    }

    char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'y' };

    private boolean verify(String pattern, String substring) {
	if (pattern.length() == substring.length()) {
	    char[] c = pattern.toCharArray();
	    int matches = 0;
	    for (int i = 0; i < c.length; i++) {
		if (Character.getNumericValue(c[i]) == 0) {
		    if (isVowel(substring.charAt(i))) {
			matches++;
		    }
		} else if (Character.getNumericValue(c[i]) == 1) {
		    if(notAVowel(substring.charAt(i))){
			matches++;
		    }
		}
	    }
	    return matches == pattern.length();
	}
	return false;
    }

    private boolean notAVowel(char c) {
	return !isVowel(c);
    }

    private boolean isVowel(char c) {
	for (char v : vowels) {
	    if (v == c) {
		return true;
	    }
	}
	return false;
    }
}
