
public class Main {

	public static void main(String[] args) {
		int[] primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179];
		
		int[] a = new int[5];
		for (int i : primes) {
			for (int j : primes) {
				for (int k : primes) {
					for (int l : primes) {
						a[0] = i;
						a[1] = j;
						a[2] = k;
						a[3] = l;
						if (i + j + k + l > 540) break;
						a[4] = 540 - (i + j + k + l);
						if (isRightPentagon(a)) return;
					}
				}
			}
		}
		for (int i = 0; i < 5; i++) System.out.println(a[i] + ", ");
	}
	
	public static boolean isCube(int x) {
		double cubeRoot = Math.cbrt(x);
		return (int) Math.round(cubeRoot) == cubeRoot;
	}
	
	public static boolean isRightPentagon(int[] a) {
		int total = 0;
		for (int i = 0; i < a.length; i++) {
			total += sum_digits(a[i]);
		}
		return isCube(total);
	}
	
	public static int sum_digits(int x) {
		// positive x
		int sum = 0;
		while (x > 0) {
			sum += x % 10;
			x = x/10;
		}
		return sum;
	}

}
