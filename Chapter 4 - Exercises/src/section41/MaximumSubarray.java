package section41;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] a = {2, -3, 11, -2, 4, 6, 0};
		int[] retVals = findMaximumSubarray(a, 0, 6);
		for (int i = 0; i < retVals.length; i++) {
			System.out.println(retVals[i]);
		}
		System.out.println();
		retVals = findMaximumSubarrayKadane(a);
		for (int i = 0; i < retVals.length; i++) {
			System.out.println(retVals[i]);
		}
	}
	
	
	public static int[] findMaxCrossingSubarray(int[] array, int low, int mid, int high) {
		// Find the maximum sum left of the center
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = -1;
		for (int i = mid; i >= low; i--) {
			sum += array[i];
			// Compare new sum to the previous sum
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		
		// Find the maximum sum right of the center
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		int maxRight = -1;
		for (int i = mid + 1; i <= high; i++) {
			sum += array[i];
			// Compare new sum to the previous sum
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = i;
			}
		}
		
		// Return array of indices and current sum
		int[] retVals = {maxLeft, maxRight, leftSum + rightSum};
		return retVals;
	}
	
	
	public static int[] findMaximumSubarray(int[] array, int low, int high) {
		if (low == high) { // Base case
			int[] retVals = {low, high, array[low]};
			return retVals;
		}
		int mid = (low + high)/2;
		
		// Finds the sums of the left, right and crossing sections
		int[] left = findMaximumSubarray(array, low, mid);
		int[] right = findMaximumSubarray(array, mid + 1, high);
		int[] crossing = findMaxCrossingSubarray(array, low, mid, high);
		
		// Finds and returns the larger of the left, right and crossing sums
		if (left[2] >= right[2] && left[2] >= crossing[2]) return left;
		else if (right[2] >= left[2] && right[2] >= crossing[2]) return right;
		else return crossing;
	}
	
	
	// Kadane's Algorithm with 
	// time: O(n)
	public static int[] findMaximumSubarrayKadane(int[] array) {
		int start = 0, end = 0, beg = 0;
		int maxEndingHere = array[0];
		int maxSoFar = array[0];
		
		for (int i = 1; i < array.length; i++) {
			maxEndingHere += array[i];
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
				beg = i + 1;
			}
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				start = beg;
				end = i;
			}
		}
		int[] retVals = {start, end, maxSoFar};
		return retVals;
	}

}