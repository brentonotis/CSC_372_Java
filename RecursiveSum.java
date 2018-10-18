package recursion;

/**
 * Simple example/program that takes 5 user inputs/numbers and returns sum
 * Utilizes recursive method to sum user inputs/numbers
 * @author Brenton Otis
 */

import java.util.Scanner;

public class RecursiveSum {
	
	// initialize array of integers, set length at 5
	public static int[] userNums = new int[5];
	
	// driver - call getUserNums() and sumArray() helper methods to sumer user inputs
	public static void main (String[] args) {
		
		getUserNums();
		int sum = sumArray(userNums, userNums.length-1);
		System.out.println("The sum of your five integers is: " + sum);
	}

	/**
	 * Helper method to sum array
	 * @param a - user array
	 * @param n - length of array (or length to be evaluated)
	 * @return - sum of user array
	 */
	public static int sumArray(int[] a, int n) {
		// if array length == 0, terminate block (base recursion case/calculation)
		if (n == 0) {
			return a[n];
		}
		// return integer of array + next integer of array
		else {
			return a[n] + sumArray(a, n-1);
		}
	}	
	/**
	 * Helper method to get array of 5 integers from user input
	 * @return array of user input integers
	 */
	public static int[] getUserNums() {
		
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		
		// ask for (and store) user input based on length of array
		for (int i = 0; i < userNums.length; ++i) {
			System.out.println("Enter whole number: ");
			userNums[i] = scnr.nextInt();
		}
		return userNums;
	}
}
