package random;

public class CountDaysForward {
    public static void main(String[] args) {
	CountDaysForward s = new CountDaysForward();
	System.out.println(s.solution("Wed", 2));
	System.out.println(s.solution("Sat", 23));
    }
    
    String DAYS [] = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
    
    public String solution(String S, int K) {
	String result = null;
	int start = findLocation(S);
	int cur = 0;
	for(int i = start; i < DAYS.length; i++) {
	    if(cur == K) {
		result = DAYS[i];
		i = Integer.MAX_VALUE - 1;// break condition
	    }
	    if(i == 6) {
		i = -1;
	    }
	    cur++;
	}
	return result;
    }

    private int findLocation(String s) {
	for(int i = 0; i < DAYS.length; i++) {
	    if(DAYS[i].equals(s)) {
		return i;
	    }
	}
	return -1;
    }
}
