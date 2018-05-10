package section42;

public class MatrixMultiplication {
	
	public static void main(String[] args) {
		int[][] m1 = {{1, 2, 5}, {0, 2, 3}, {1, 3, 0}};
		int[][] m2 = {{3, 1, 0}, {1, 3, 2}, {5, 1, 2}};
		
		int[][] product = naiveMatrixMult(m1, m2);
		
		for (int i = 0; i < product.length; i++) {
			for (int j = 0; j < product[0].length; j++) {
				System.out.print(product[i][j] + ", ");
			}
			System.out.println();
		}
	}
	
	
	public static int[][] naiveMatrixMult(int[][] A, int[][] B) {
		int n = A.length;
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// Sum the corresponding products of entries in A, B
				C[i][j] = 0;
				for (int k = 0; k < n; k++) {
					C[i][j] += A[i][k]*B[k][j];
				}
			}
		}
		return C;
	}
	
}
