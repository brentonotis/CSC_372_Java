package searching;

import java.util.Random;

/**
 * Class contains utility methods for array manipulation
 */

public class ArrayUtil {

		private static Random generator = new Random();
		
		/**
		 * Creates array filled with random values
		 * @param length - length of the array
		 * @param n - number of possible random values
		 * @return - array filled with length numbers between 0 and n - 1
		 */
		public static int[] randomIntArray(int length, int n) {
			int[] a = new int[length];
			for (int i = 0; i < a.length; ++i) {
				a[i] = generator.nextInt(n);
			}
			return a;
		}
		
		/**
		 * Swaps two entries of an array
		 * @param a - array to evaluate
		 * @param i - first position to swap
		 * @param j - second position to swap
		 */
		public static void swap(int[] a, int i, int j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
}
