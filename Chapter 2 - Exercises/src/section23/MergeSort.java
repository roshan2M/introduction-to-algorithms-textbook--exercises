package section23;

public class MergeSort {

	public static void main(String[] args) {
		int[] a = {2, 3, 11, -2, 4, 6, 0};
		mergeSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		System.out.println(linearSearch(a, 4));
	}
	
	
	public static void merge(int[] array, int start, int mid, int end) {
		// Lengths of left and right array to be sorted, respectively
		int n1 = mid - start + 1;
		int n2 = end - mid;
		
		// Left and right sub-arrays
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for (int i = 0; i < n1; i++) left[i] = array[start + i]; // Stores left array
		for (int i = 0; i < n2; i++) right[i] = array[mid + i + 1]; // Stores right array
		
		// Inserting elements from left and right sub-arrays into array
		int l = 0, r = 0;
		for (int i = 0; i < n1 + n2; i++) {
			if (l == n1 || (r < n2 && right[r] < left[l])) {
				array[start + i] = right[r];
				r++;
			} else {
				array[start + i] = left[l];
				l++;
			}
		}
	}
	
	
	public static void mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int mid = (start + end)/2;
			
			// Sort the first and second halves
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			
			// Merge sorted halves
			merge(array, start, mid, end);
		}
	}
	
	
	public static int linearSearch(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) return i;
		}
		return -1;
	}

}
