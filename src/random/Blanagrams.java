package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Blanagrams {
    public static void main(String[] args) {
	Blanagrams b = new Blanagrams();
	System.out.println(b.checkBlanagrams("aba", "bab"));
//	System.out.println(b.checkBlanagrams("silent", "listen"));
//	System.out.println(b.checkBlanagrams("tangram", "anagram"));
//	System.out.println(b.checkBlanagrams("tangram", "pangram"));

    }

    boolean checkBlanagrams(String word1, String word2) {

	boolean anagram = checkAnagram(word1, word2);
	if (anagram) {
	    return !anagram;
	}

	if (word1.length() != word2.length()) {
	    return false;
	}

	List<String> word1Letters = word1.chars().mapToObj(c -> (char) c)
	    .map(c -> String.valueOf(c)).collect(Collectors.toList());

	List<String> word2Letters = word2.chars().mapToObj(c -> (char) c)
	    .map(c -> String.valueOf(c)).collect(Collectors.toList());

	List<String> w1Diffs = new ArrayList<>();

	for (String string : word1Letters) {
	    if (!word2Letters.contains(string)) {
		w1Diffs.add(string);
	    }
	}

	List<String> w2Diffs = new ArrayList<>();
	for (String string : word2Letters) {
	    if (!word1Letters.contains(string)) {
		w2Diffs.add(string);
	    }
	}

	if(!w1Diffs.isEmpty()) {
	    for(int i = 0; i < word2.length(); i++) {
		StringBuilder sb = new StringBuilder(word2);
		sb.setCharAt(i, w1Diffs.get(0).charAt(0));
		if(checkAnagram(word1, sb.toString())){
		    return true;
		}
	    }
	}
	
	if(!w2Diffs.isEmpty()) {
	    for(int i = 0; i < word1.length(); i++) {
		StringBuilder sb = new StringBuilder(word1);
		sb.setCharAt(i, w2Diffs.get(0).charAt(0));
		if(checkAnagram(word2, sb.toString())){
		    return true;
		}
	    }
	}
	
	return false;
    }
    
    private boolean checkAnagram(String word1, String word2) {
	Map<String, Integer> word1Count = new HashMap<>();
	
	for (char c : word1.toCharArray()) {
	    if(word1Count.containsKey(String.valueOf(c))) {
		Integer count = word1Count.get(String.valueOf(c));
		word1Count.put(String.valueOf(c), count + 1);
	    } else {
		word1Count.put(String.valueOf(c), 1);
	    }
	}
	return true;
    }
    private boolean checkAnagram2(String word1, String word2) {
	for (char c : word1.toCharArray()) {
	    if (!word2.contains(String.valueOf(c))) {
		return false;
	    }
	}
	return true;
    }

    boolean checkBlanagrams2(String word1, String word2) {
	boolean anagram = checkAnagram(word1, word2);
	if (anagram) {
	    return !anagram;
	}

	if (word1.length() != word2.length()) {
	    return false;
	}
	Map<String, String> letters = new HashMap<>();

	return false;
    }

}
