package section71;

import java.util.Arrays;

import section71.Quicksort;

public class HoarePartition {

	public static void main(String[] args) {
		int[] a = {-1, 9, 0, -3, 5, 8, 2};
		hoarePartitionQuicksort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
	public static int hoarePartition(int[] a, int p, int r) {
		int x = a[p];
		int i = p;
		int j = r;
		while (true) {
			while (a[j] > x) j--;
			while (a[i] < x) i++;
			if (i < j) Quicksort.swap(a, i, j);
			else return j;
		}
	}
	
	public static void hoarePartitionQuicksort(int[] a, int p, int r) {
		if (p < r) {
			int q = hoarePartition(a, p, r);
			Quicksort.quicksort(a, p, q-1);
			Quicksort.quicksort(a, q+1, r);
		}
	}

}
