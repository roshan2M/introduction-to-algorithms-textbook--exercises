package section23;

public class BinarySearch {
	
	public static void main(String[] args) {
		int[] a = {-2, 0, 2, 3, 4, 6, 11};
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		System.out.println(binarySearch(a, 11));
	}
	
	
	public static int binarySearch(int[] array, int item) {
		int lo = 0, hi = array.length - 1;
		int mid;
		
		while (lo <= hi) {
			mid = (lo + hi)/2;
			if (item == array[mid]) return mid;
			else if (item < array[mid]) hi = mid - 1;
			else lo = mid + 1;
		}
		return -1;
	}

}
