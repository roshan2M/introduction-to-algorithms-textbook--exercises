package exercises;

import java.util.Arrays;

import section71.Quicksort;

public class TailRecursiveQuicksort {
	
	public static void main(String[] args) {
		int[] array = {-1, 9, 5, 2, 8, -3};
		tailRecursiveQuicksort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	public static void tailRecursiveQuicksort(int[] a, int start, int end) {
		while (start < end) {
			int mid = Quicksort.partition(a, start, end);
			tailRecursiveQuicksort(a, start, mid - 1); // Sorting the left sub-array
			start = mid + 1;
		}
	}

}
