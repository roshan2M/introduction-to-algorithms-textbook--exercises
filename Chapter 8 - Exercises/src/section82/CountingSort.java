package section82;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int[] a = {8, 0, 1, 4, 3, 7, 9, 6, 2, 5};
		int[] b = countingSort(a, 9);
		System.out.println(Arrays.toString(b));
		
		int[] c = {2, 16, 4, 4, 5, 1, 0, 3, 8, 12};
		int[] d = countingSort(c, 16);
		System.out.println(Arrays.toString(d));
	}
	
	public static int[] countingSort(int[] a, int k) {
		int n = a.length;
		int[] b = new int[n];
		int[] count = new int[k + 1];
		
		for (int i = 0; i < n; i++) count[a[i]]++;
		for (int i = 1; i <= k; i++) count[i] += count[i - 1];
		for (int i = 0; i < n; i++) {
			b[count[a[i]]-1] = a[i];
			count[a[i]]--;
		}
		return b;
	}

}