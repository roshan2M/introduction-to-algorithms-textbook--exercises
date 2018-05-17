package exercises;

import java.util.Arrays;

import section71.Quicksort;

public class MedianOfThreePartition {
	
	public static void main(String[] args) {
		int[] array = {-1, 9, 5, 2, 8, -3};
		System.out.println(Arrays.toString(array));
	}
	
	public static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public static int medianOfThreePartition(int[] a, int p, int r) {
		int i1, i2, i3;
		
		// Choose random integers
		i1 = (int) (Math.random() * (r - p + 1) + p);
		do i2 = (int) (Math.random() * (r - p + 1) + p); while (i1 == i2);
		do i3 = (int) (Math.random() * (r - p + 1) + p); while (i1 == i3 || i2 == i3);
		
		// Find median of i1, i2, i3
		int median;
		if (a[i1] <= a[i2] && a[i1] >= a[i3]) median = a[i1];
		else if (a[i2] <= a[i1] && a[i2] >= a[i3]) median = a[i2];
		else median = a[i3];
		
		// Partition around pivot element
		int x = median;
		int i = p-1;
		for (int j = p; j < r; j++) {
			if (a[j] <= x) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i+1, r);
		return i+1;
	}
	
	public static void medianOfThreePartitionQuicksort(int[] a, int p, int r) {
		if (p < r) {
			int q = medianOfThreePartition(a, p, r);
			Quicksort.quicksort(a, p, q-1);
			Quicksort.quicksort(a, q+1, r);
		}
	}

}
