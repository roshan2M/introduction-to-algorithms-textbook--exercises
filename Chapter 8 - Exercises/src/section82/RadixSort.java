package section82;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		// Integer radix sort.
		int[] a = {124, 23, 0, 45, 1295, 457, 640, 343, 420};
		radixSortIntegers(a, 10);
		System.out.println(Arrays.toString(a));
		
		// String radix sort.
		String[] s = {"apple", "yard", "algorithm", "sell", "olympic", "australia", "jack", "sleep"};
	    radixSortStrings(s,'a','z');
	    System.out.println(Arrays.toString(s));
	}
	
	/*
	 * countingSortDigit(a, exp) sorts array a by the digit represented in base exp.
	 */
	public static void countingSortDigit(int[] a, int exp) {
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
	 * radixSort(a, base) sorts array a based on each digit, starting with the ones digit in a given base.
	 */
	public static void radixSortIntegers(int[] a, int base) {
		// Attains the maximum of array a.
		int m = getIntegerMax(a);
		
		// Sorts by each digit of element in a, starting with ones digits.
		for (int i = 1; m/i > 0; i *= base) countingSortDigit(a, i);
	}
	
	/*
	 * getIntegerMax(a) retrieves the maximum integer in array a.
	 */
	public static int getIntegerMax(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) if (a[i] > max) max = a[i];
		return max;
	}

	
	/*
	 * countingSortString(s, index) sorts array s by the charIndex given the lower and upper bounds of characters at index.
	 */
	private static void countingSortString(String[] s, int index, char lower, char upper) {
		int[] count = new int[upper - lower + 2];
		String[] output = new String[s.length];
		
		// Increase count for given character at index i.
		int charIndex;
		for (int i = 0; i < s.length; i++) {
			charIndex = (s[i].length() <= index) ? 0 : (s[i].charAt(index) - lower + 1);
			count[charIndex]++;
		}
		
		// Sum up count - count will hold last index for the char at each string's index.
		for (int i = 1; i < count.length; i++) count[i] += count[i - 1];
		
		// Building the output array from the counts of each character at a specified position.
		for (int i = s.length - 1; i >= 0; i--) {
			charIndex = (s[i].length() <= index) ? 0 : (s[i].charAt(index) - lower + 1);
			output[count[charIndex] - 1] = s[i];
			count[charIndex]--;
		}
		
		// Copying the output array into the original array.
		for (int i = 0; i < output.length; i++) s[i] = output[i];
	}
	
	/*
	 * radixSort(s, lower, upper) sorts array s based on their lower and upper character bounds.
	 */
	public static void radixSortStrings(String[] s, char lower, char upper) {
		int maxStringLen = getMaxStringLen(s);
		
		// Radix sorts each index in the string starting from maximum index.
		for (int i = maxStringLen - 1; i >= 0; i--) countingSortString(s, i, lower, upper);
	}

	/*
	 * getIntegerMax(a) retrieves the maximum integer in array a.
	 */
	private static int getMaxStringLen(String[] s) {
		int max = s[0].length();
		for (int i = 1; i < s.length; i++) if (s[i].length() > max) max = s[i].length();
		return max;
	}
	
}
