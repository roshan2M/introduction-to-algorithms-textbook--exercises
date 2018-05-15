package section82;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int[] a = {8, 0, 1, 4, 3, 7, 9, 6, 2, 5};
		int[] b = countingSort(a, 9);
		System.out.println(Arrays.toString(b));
	}
	
	public static int[] countingSort(int[] a, int k) {
		int[] b = new int[a.length];
		int[] c = new int[k];
		for (int i = 0; i < a.length; i++) c[a[i]]++;
		for (int i = 1; i < k; i++) c[i] += c[i - 1];
		for (int i = a.length - 1; i > 0; i--) {
			b[c[a[i]] - 1] = a[i];
			c[a[i]]--;
		}
		return b;
	}

}
