package random;

public class FindLengthOfSquareMatrix {
    public static void main(String[] args) {
	int[][] matrix = new int[2][2];
	matrix[0][0] = 1;
	matrix[0][1] = 2;
	matrix[1][0] = 3;
	matrix[1][1] = 4;
	System.out.println(matrix.length);
	System.out.println(matrix[0].length);
	System.out.println(matrix[1].length);
	
	System.out.println("Done with lengths");
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix.length; j++) {
		System.out.println(matrix[i][j]);
	    }
	}
    }
}
