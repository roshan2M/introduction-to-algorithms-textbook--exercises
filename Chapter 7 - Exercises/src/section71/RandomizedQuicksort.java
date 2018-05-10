package section71;

import section71.Quicksort;
import java.util.Arrays;
import java.util.Random;

public class RandomizedQuicksort {
	
	public static void main(String[] args) {
		int[] array = {1, 8, 5, 3, 7, 10, -2};
		randomizedQuicksort(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
	
	public static void randomizedQuicksort(int[] a, int p, int r) {
		if (p < r) {
			int q = randomizedPartition(a, p, r);
			randomizedQuicksort(a, p, q-1);
			randomizedQuicksort(a, q+1, r);
		}
	}
	
	public static int randomizedPartition(int[] a, int p, int r) {
		Random random = new Random();
		int i = random.nextInt((r - p) + 1) + p;
		Quicksort.swap(a, r, i);
		return Quicksort.partition(a, p, r);
	}

}
