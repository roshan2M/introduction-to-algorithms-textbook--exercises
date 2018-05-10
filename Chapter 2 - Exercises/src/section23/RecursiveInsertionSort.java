package section23;

public class RecursiveInsertionSort {
	
	public static void main(String[] args) {
		int[] a = {2, 3, 11, -2, 4, 6, 0};
		insertionSortRecursive(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		System.out.println(linearSearch(a, 4));
	}
	
	
	// insert(array, n) inserts n into array (sorted in ascending order)
	public static void insert(int[] array, int end) {
		// Single insert operation of end element into array
		int last = array[end - 1];
		int j = end - 2;
		
		while (j >= 0 && array[j] > last) {
			array[j + 1] = array[j];
			j--;
		}
		array[j + 1] = last;
	}
	
	
	public static void insertionSortRecursive(int[] array, int end) {
		if (end < 2) return;
		insertionSortRecursive(array, end - 1);
		insert(array, end);
	}
	
	
	public static int linearSearch(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) return i;
		}
		return -1;
	}
	
}
