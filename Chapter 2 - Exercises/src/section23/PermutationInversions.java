package section23;

public class PermutationInversions {
	
	public static void main(String[] args) {
		int[] a = {6, 3, 1, 4, 2, 7, 5, 0};
		int n = countInversions(a, 0, a.length - 1);
		System.out.println(n);
		
		int[] b = {1, 2, 3, 5, 4, 6, 7};
		n = countInversions(b, 0, b.length - 1);
		System.out.println(n);
	}
	
	
	public static int inversions(int[] array, int start, int mid, int end) {
		// Lengths of left and right array to be sorted, respectively
		int n1 = mid - start + 1;
		int n2 = end - mid;
		
		// Left and right sub-arrays
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for (int i = 0; i < n1; i++) left[i] = array[start + i]; // Stores left array
		for (int i = 0; i < n2; i++) right[i] = array[mid + i + 1]; // Stores right array
		
		int count = 0;
		// Inserting elements from left and right sub-arrays into array
		int l = 0, r = 0;
		for (int i = 0; i < n1 + n2; i++) {
			if (l == n1) {
				r++;
			} else if (r < n2 && right[r] < left[l]) {
				r++;
				count++;
			} else {
				l++;
			}
		}
		return count;
	}
	
	
	public static int countInversions(int[] array, int start, int end) {
		int k = 0;
		if (start < end) {
			int mid = (start + end)/2;
			
			// Sort the first and second halves
			k += countInversions(array, start, mid);
			k += countInversions(array, mid + 1, end);
			
			// Merge sorted halves
			k += inversions(array, start, mid, end);
		}
		return k;
	}

}
