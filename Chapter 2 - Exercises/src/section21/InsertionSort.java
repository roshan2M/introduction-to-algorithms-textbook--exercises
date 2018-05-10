package section21;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a = {2, 3, 11, -2, 4, 6, 0};
		insertionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		
		reverseInsertionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		System.out.println(linearSearch(a, 4));
	}
	
	
	public static void insertionSort(int[] array) {
		if (array.length < 2) return;
		int key, j;
		for (int i = 1; i < array.length; i++) {
			key = array[i]; // key -> current element
			j = i - 1; // j tracks element to swap
			
			// Compares new element to see if it is still greater
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}
	
	
	public static void reverseInsertionSort(int[] array) {
		if (array.length < 2) return;
		int key, j;
		for (int i = 1; i < array.length; i++) {
			key = array[i]; // key -> current element
			j = i - 1; // j -> element to swap
			
			// Compares new element to see if it is still smaller
			while (j >= 0 && array[j] < key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}
	
	
	public static int linearSearch(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) return i;
		}
		return -1;
	}

}
