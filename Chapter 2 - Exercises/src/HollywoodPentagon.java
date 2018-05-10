
public class HollywoodPentagon {
	
	public static void main(String[] args) {
		int[] a = find_right_pentagon();
		for (int i = 0; i < 5; i++) System.out.print(a[i] + ", ");
	}
	
	public static int[] find_right_pentagon() {
		int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179};
		
		int[] a = {0, 0, 0, 0, 0};
		for (int i : primes) {
			for (int j : primes) {
				if (i == j) continue;
				for (int k : primes) {
					if (k == j || k == i) continue;
					for (int l : primes) {
						if (l == k || l == j || l == i) continue;
						for (int m : primes) {
							a[0] = i;
							a[1] = j;
							a[2] = k;
							a[3] = l;
							a[4] = m;
							if (i + j + k + l + m != 540) continue;
							if (isRightPentagon(a)) return a;
						}
					}
				}
			}
		}
		return a;
	}
	
	// only accepts cubes until 20^3
	public static boolean isCube(int x) {
		for (int i = 0; i < 20; i++) {
			if (i * i * i == x) return true;
		}
		return false;
	}
	
	public static boolean isRightPentagon(int[] a) {
		int total = 0;
		for (int i = 0; i < a.length; i++) {
			total += sum_digits(a[i]);
		}
		return isCube(total);
	}
	
	// only accepts nonnegative x
	public static int sum_digits(int x) {
		int sum = 0;
		while (x > 0) {
			sum += x % 10;
			x = x/10;
		}
		return sum;
	}
	
}
