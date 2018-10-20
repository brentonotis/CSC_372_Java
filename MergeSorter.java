package selection_sort;

/**
 * Sorts an array using the merge sort algorithm
 */

import java.util.Arrays;
import java.util.Random;

public class MergeSorter {
	
	private static Random generator = new Random();
	/**
	 * Sorts an array using merge sort
	 * @param a - array to sort
	 */
	public static void sort(int[] a) {
		if (a.length <= 1) {
			return;
		}
		int[] first = new int[a.length /2];
		int[] second = new int[a.length - first.length];
		//Copy first half of array into first, second half into second
		for (int i = 0; i < first.length; i++) {
			first[i] = a[i];
		}
		for (int i = 0; i < second.length; i++) {
			second[i] = a[first.length + i];
		}
		sort(first);
		sort(second);
		merge(first, second, a);
	}
	
	/**
	 * Merge two sorted arrays into an array
	 * @param first - first sorted array
	 * @param second - second sorted array
	 * @param a - array for merging first and second into
	 */
	private static void merge(int[] first, int[] second, int[] a) {
		int iFirst = 0; // Next element to consider in first array
		int iSecond = 0; // Next element to consider in second array
		int j = 0; // Next open position in array
		
		// As long as neither iFirst nor iSecond is past end, move smallest elements into array
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst] < second[iSecond]) {
				a[j] = first[iFirst];
				iFirst++;
			}
			else {
				a[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}	
		// Copy any remaining entries of the first array
		while (iFirst < first.length) {
			a[j] = first[iFirst];
			iFirst++; j++;
		}
			// Copy any remaining entries of the second array
		while (iSecond < second.length) {
			a[j] = second[iSecond];
			iSecond++; j++;
		}
	}
	
	/**
	 * Creates array filled with random values
	 * @param length - length of array
	 * @param n - number of possible random values
	 * @return - array filled with length numbers between 0 and n-1
	 */
	public static int[] randomIntArray (int length, int n) {
		int[] a = new int[length];
		for (int i = 0; i < a.length; ++i) {
			a[i] = generator.nextInt(n);
		}
		return a;
	}
	
	// Driver
	public static void main(String[] args) {
		int[] a = randomIntArray(20, 100);
		System.out.println(Arrays.toString(a));
		
		sort(a);
		
		System.out.println(Arrays.toString(a));
	}
}