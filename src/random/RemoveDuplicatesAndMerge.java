package random;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveDuplicatesAndMerge {
    public static void main(String[] args) {
	String s1 = "\"JANE\", \"415-454-3232\"";
	String s2 = "\"TOM\", \"402-333-4444\"";
	removeDuplicatesAndMerge(List.of(s1, s2));

    }

    public static List<String> removeDuplicatesAndMerge(List<String> users) {
	Map<String, User> map = new TreeMap<>();
	for (String user : users) {
	    String[] tokens = user.split(",");
	    String name = tokens[0].toUpperCase().replace("\"", "");
	    if (map.containsKey(name)) {
		User _user = map.get(name);
		for (String token : tokens) {
		    token = token.replace("\"", "");
		    if (isPhone(token)) {
			_user.phoneNumbers.add(token);
		    } else if (isEmail(token)) {
			_user.emails.add(token);
		    } else {
			_user.name = token;
		    }
		}
		map.put(name, _user);
	    } else {
		User _user = new User();
		for (String token : tokens) {
		    token = token.replace("\"", "").replace(" ", "");
		    if (isPhone(token)) {
			_user.phoneNumbers.add(token);
		    } else if (isEmail(token)) {
			_user.emails.add(token);
		    } else {
			_user.name = token;
		    }
		}
		map.put(name, _user);
	    }

	}
	List<String> finalUsers = new ArrayList<>();
	map.values().forEach(user -> {
	    StringBuilder sb = new StringBuilder("\"" + user.name + "\", ");
	    for (String phone : user.phoneNumbers) {
		sb.append("\"" + phone + "\", ");
	    }
	    for (String email : user.emails) {
		sb.append("\"" + email + "\", ");
	    }
	    sb.replace(sb.lastIndexOf(", "), sb.lastIndexOf(", ") + 1, "");
	    finalUsers.add(sb.toString());

	});
	return finalUsers;

    }

    private static boolean isEmail(String token) {
	return token.contains("@");
    }

    public static boolean isPhone(String s) {
//	Pattern pattern = Pattern.compile("^\\d{10}$");
//	Matcher matcher = pattern.matcher(s);
//	return matcher.matches();
	return s.contains("-");
    }

    static class User {
	String name;
	List<String> phoneNumbers = new ArrayList<>();
	List<String> emails = new ArrayList<>();

    }
}
