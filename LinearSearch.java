package searching;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class for performing linear search of array
 */

public class LinearSearch {
	
	/**
	 * Finds value in an array using linear search algorithm
	 * @param a - array to search
	 * @param value - value to find
	 * @return - the index at which the value occurs, or -1 if it does not occur in the array
	 */
	public static int search (int[] a, int value) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	@SuppressWarnings("resource")
	public static void main (String[] args) {
		int[] a = ArrayUtil.randomIntArray(20,  100);
		System.out.println(Arrays.toString(a));
		Scanner in = new Scanner(System.in);
		  
		boolean done = false;
		while (!done) {
			System.out.print("Enter number to search for, or -1 to quit: ");
			int n = in.nextInt();
			if (n == -1) {
				done = true;
			}
			else {
				int pos = LinearSearch.search(a, n);
				System.out.println("Found in position " + pos);				
			}
		}
	}	
}
