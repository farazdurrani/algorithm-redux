package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextWrap {

    public static void main(String[] args) {

	// Assumptions... spaces are delimeters to seperate text
	// and no word in itself can be greater than 13 characters.
	// if a word is longer than 13 characters, it is skipped.
	String text = null;
	if (args.length > 0) {
	    text = args[0];
	} else {
	    text = "Four score and seven years ago our fathers brought forth upon "
	        + "this continent a new nation, conceived in liberty and dedicated to the "
	        + "proposition that all men are created equal";
	}
	List<String> lines = wrapText(text);
	lines.forEach(System.out::println);
    }

    private static List<String> wrapText(String text) {
	String[] words = text.split(" ");
	List<String> lines = new ArrayList<>();
	for (String word : words) {
	    if (word.length() < 14) {
		if (lines.isEmpty()) {
		    lines.add(word);
		} else {
		    String prevWord = lines.get(lines.size() - 1);
		    if (prevWord.length() + " ".length() + word.length() < 14) {
			lines.set(lines.size() - 1, prevWord + " " + word);
		    } else {
			lines.add(word);
		    }
		}
	    }
	}
	return lines;
    }
}
