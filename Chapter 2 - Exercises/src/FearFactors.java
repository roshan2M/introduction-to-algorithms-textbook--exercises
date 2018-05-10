public class FearFactors {
	
	public static void main(String[] args) {
		
		int[] factors = {46, 191, 89, 265, 539, 369, 38, 80, 33, 135, 147, 106, 44, 95, 181, 55, 81, 319, 75, 32};
		int[] numbers = {2341584, 50350, 328251, 61200};
		
		for (int n : numbers) {
			System.out.print(n + ": ");
			for (int f : factors) {
				if (n % f == 0) System.out.print(f + ", ");
			}
			System.out.println();
		}
		
	}
	
}