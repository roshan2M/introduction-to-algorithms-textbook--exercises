package section82;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] a = {124, 23, 0, 45, 1295, 457, 640, 343, 420};
		radixSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	/*
	 * countSort(a, exp) sorts array a by the last digit represented by exp.
	 */
	public static void countSortDigit(int[] a, int exp) {
		int[] output = new int[a.length];
		int[] count = new int[10];
		
		// Counts the frequency of the numbers (0-9) of the exp-th digit of values in a.
		for (int i = 0; i < a.length; i++) count[(a[i] / exp) % 10]++;
		
		// Stores the cumulative count of each digit to get its position.
		for (int i = 1; i < 10; i++) count[i] += count[i - 1];
		
		// Stores the i-th element in the original array in the count-of-digit-of-a[i] element of the output array (-1)
		for (int i = a.length - 1; i >= 0; i--) {
			output[count[(a[i] / exp) % 10] - 1] = a[i];
			count[(a[i] / exp) % 10]--;
		}
		
		// Copies output array into array a.
		for (int i = 0; i < a.length; i++) a[i] = output[i];
	}
	
	/*
	 * radixSort(a) sorts array a based on each digit, starting with the ones digit.
	 */
	public static void radixSort(int[] a) {
		// Attains the maximum of array a.
		int m = arrayMax(a);
		
		// Sorts by each digit of element in a, starting with ones digits.
		for (int i = 1; m/i > 0; i *= 10) {
			countSortDigit(a, i);
		}
	}
	
	/*
	 * arrayMax(a) retrieves the maximum element in array a.
	 */
	public static int arrayMax(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) max = a[i];
		}
		return max;
	}

}
