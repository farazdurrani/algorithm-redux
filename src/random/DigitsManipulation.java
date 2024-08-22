package random;

public class DigitsManipulation {
    public static void main(String[] args) {
	DigitsManipulation d = new DigitsManipulation();
	int n = 123456;
	System.out.println(d.digitsManipulations(n));
    }
    
    int digitsManipulations(int n) {
	String s = String.valueOf(n);
	int product = 1;
	for (char c : s.toCharArray()) {
	    product *= Character.getNumericValue(c);
	}
	int sum = 0;
	for (char c : s.toCharArray()) {
	    sum += Character.getNumericValue(c);
	}
	return product - sum;
    }
}
