package exercises;

public class FuzzyQuicksort {

	public static void main(String[] args) {
		Interval[] intervals = {new Interval(1, 3), new Interval(2, 5), new Interval(0, 7)};
		fuzzyQuicksort(intervals, 0, intervals.length - 1);
		System.out.print("[");
		for (int i = 0; i < intervals.length - 1; i++) {
			System.out.print("(" + intervals[i].a + ", " + intervals[i].b + "), ");;
		}
		System.out.print("(" + intervals[intervals.length - 1].a + ", " + intervals[intervals.length - 1].b + ")]");
	}
	
	public static void fuzzyQuicksort(Interval[] a, int p, int r) {
		if (p < r) {
			int[] indices = fuzzyPartition(a, p, r);
			fuzzyQuicksort(a, p, indices[0]);
			fuzzyQuicksort(a, indices[1] + 1, indices[2]);
			fuzzyQuicksort(a, indices[3], r);
		}
	}

	public static int[] fuzzyPartition(Interval[] a, int p, int r) {
		int pivot = (int) Math.round(Math.random() * (r - p) + p);
		int left = a[pivot].a;
		int right = a[pivot].b;
		fuzzySwap(a, pivot, r);
		
		// Intervals with left bound less than the pivot go to the left.
		int i = p;
		for (int j = p; j < r; j++) {
			if (a[j].a <= left) {
				fuzzySwap(a, i, j);
				i++;
			}
			fuzzySwap(a, i, r);
		}
		int y = i;
		
		// Intervals strictly less than the pivot to the left.
		i = p;
		for (int j = p; j < y; j++) {
			if (a[j].b < left) {
				fuzzySwap(a, i, j);
				i++;
			}
		}
		int w = i;
		
		// Intervals with right bound more than the pivot go to the right.
		i = r;
		for (int j = r; j > r; j--) {
			if (a[j].b >= right) {
				fuzzySwap(a, i, j);
				i--;
			}
		}
		int z = i + 1;
		
		// Interval with max left bounds among intervals in pivot range.
		int maxLeftBound = a[y].a;
		int maxLeftBoundIndex = y;
		for (int j = y + 1; j <= z; j++) {
			if (a[j].a > maxLeftBound) {
				maxLeftBound = a[j].a;
				maxLeftBoundIndex = j;
			}
		}
		fuzzySwap(a, maxLeftBoundIndex, z);
		
		// Intervals with no common range with a[z] go to the right.
		i = y;
		for (int j = y + 1; j < z; j++) {
			if (a[j].b < a[z].a) {
				i++;
				fuzzySwap(a, i, j);
			}
		}
		int x = i + 1;
		
		int[] indices = {w, x, y, z};
		return indices;
	}
	
	private static void fuzzySwap(Interval[] a, int x, int y) {
		Interval temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}

class Interval {
	int a;
	int b;
	
	public Interval(int a, int b) {
		this.a = a;
		this.b = b;
	}
}
