package selection_sort;

import java.util.Arrays;
import java.util.Random;

/**
 *  Example of selection sort
 *  Creates random array of integers and sorts from lowest - highest value
 */

public class SelectionSorter {
	
	private static Random generator = new Random();
	
	/**
	 * Sorts array using selection sort
	 * @param a - array to sort
	 */
	public static void sort(int[] a) {
		
		for (int i = 0; i < a.length - 1; ++i) {
			int minPos = minimumPosition(a, i);
			swap(a, minPos, i);
		}
	}
	
	/**
	 * Finds smallest element in tail range of array
	 * @param a - array to sort
	 * @param from - first position in array to compare to
	 * @return - position of the smallest element in range a[from] -> a[a.length - 1]
	 */
	private static int minimumPosition(int[] a, int from) {
		int minPos = from;
		for (int i = from + 1; i < a.length; ++i) {
			if (a[i] < a[minPos]) {
				minPos = i;
			}
		}
		return minPos;
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
	
	/**
	 * Swaps two entries of an array
	 * @param a - the array
	 * @param i - first position to swap
	 * @param j - second position to swap
	 */
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	// Driver
	public static void main (String[] args) {
		
		int[] a = randomIntArray(20, 100);
		System.out.println(Arrays.toString(a));
		
		SelectionSorter.sort(a);
		
		System.out.println(Arrays.toString(a));
	}
}
