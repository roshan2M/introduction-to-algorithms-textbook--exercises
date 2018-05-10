package section23;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] a = {8, 2, 3, 11, -2, 4, 6, 0};
		
		bubbleSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		System.out.println(BinarySearch.binarySearch(a, 4));
	}
	
	
	public static void bubbleSort(int[] array) {
		int temp;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = array.length - 1; j > i; j--) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

}
