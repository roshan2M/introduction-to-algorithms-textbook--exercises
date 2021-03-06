package section64;

public class Heapsort {
	
	public static void main(String[] args) {
		int a[] = {6, 3, 1, 7, 9, 5, 2};
		heapsort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}
	
	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void max_heapify(int a[], int index, int length) {
		int l = 2 * index + 1;
		int r = 2 * index + 2;
		int largest = index;
		
		if (l < length && a[l] > a[largest]) largest = l;
		if (r < length && a[r] > a[largest]) largest = r;
		if (largest != index) {
			swap(a, index, largest);
			max_heapify(a, largest, length);
		}
	}
	
	public static void build_max_heap(int[] a, int length) {
		for (int i = length/2 - 1; i >= 0; i--) max_heapify(a, i, length);
	}
	
	public static void heapsort(int a[]) {
		build_max_heap(a, a.length - 1);
		for (int i = a.length - 1; i > 0; i--) {
			swap(a, 0, i);
			max_heapify(a, 0, i);
		}
	}
	
}
