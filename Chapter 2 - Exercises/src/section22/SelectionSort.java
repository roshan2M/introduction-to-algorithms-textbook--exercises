package section22;

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] a = {2, 3, 11, -2, 4, 6, 0};
		selectionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		System.out.println(linearSearch(a, 4));
	}
	
	
	public static void selectionSort(int[] array) {
		int pos, temp;
		for (int i = 0; i < array.length; i++) {
			pos = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[pos]) pos = j;
			}
			
			// Swap elements
			temp = array[pos];
			array[pos] = array[i];
			array[i] = temp;
		}
	}
	
	
	public static int linearSearch(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) return i;
		}
		return -1;
	}

}
