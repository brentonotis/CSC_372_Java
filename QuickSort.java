package selection_sort;

import java.util.Arrays;

/**
 * Sorts a random array using quick search algorithm
 */

public class QuickSort {
	
	/**
	 * @param - array to sort
	 */
	public static void sort (int[] a) {
		sort(a, 0, a.length - 1);
	}
	
	/**
	 * Sorts portion of an array using quick sort
	 * @param a - array to sort
	 * @param from - first index of the portion to be sorted
	 * @param to - last index of the portion to be sorted
	 */
	public static void sort(int[] a, int from, int to) {
		if (from >= to) {
			return;
		}
		int p = partition(a, from, to);
		sort(a, from, p);
		sort(a, p + 1, to);
	}
	
	/**
	 * Partitions portion of an array
	 * @param a - array to partition
	 * @param from - first index of the portion to be partitioned
	 * @param to - last index of the portion to be partitioned
	 * @return - last index of the first partition
	 */
	private static int partition(int[] a, int from, int to) {
		int pivot = a[from];
		int i = from - 1;
		int j = to + 1;
		while (i < j) {
			i++;
			while (a[i] < pivot) {
				i++;
			}
			j--;
			while (a[j] > pivot) {
				j--;
			}
			if (i < j) {
				SelectionSorter.swap(a,  i,  j);
			}
		}
		return j;		
	}
	
	// Driver
	public static void main (String[] args) {
		int [] a = SelectionSorter.randomIntArray(20,  100);
		System.out.println(Arrays.toString(a));
		
		QuickSort.sort(a);
		
		System.out.println(Arrays.toString(a));
	}
}
