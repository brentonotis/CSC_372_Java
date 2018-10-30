package selection_sorter;

/**
 * Class using selection sort to return array list of names in alphabetical order
 * Also sorts in reversed alphabetical order
 * Gets array list of names from user input
 * @author Brenton Otis
 */

import java.util.Scanner;
import java.util.ArrayList;

public class SelectionSort {
	
	// Initialize array list of user Strings (names)
	public static ArrayList<String> userNames = new ArrayList<String>();
	
	// Driver
	public static void main (String[] args) {
		getUserNames();
		System.out.println("Unsorted array of names: " + userNames);
		
		sort(userNames);
		System.out.println("Sorted alphabetically: " + userNames);
		
		sortReverse(userNames);
		System.out.println("Sorted alphabetically and in reverse: " + userNames);
	}
	
	/**
	 * Helper method to get array list of names via user input
	 * @return userNames array list
	 */	
	@SuppressWarnings("resource")
	public static ArrayList<String> getUserNames() {
		
		Scanner scnr = new Scanner(System.in);		
		
		for (int i = 0; i < 10; ++i) {
			System.out.println("Enter a name: ");
			userNames.add(scnr.next());
			}
		return userNames;
	}
	
	/**
	 * Sorts array list via selection sort algorithm in reverse alphabetical order
	 * Implements compareTo() method from Comparable interface
	 * @param userNames - array to sort
	 */	
	public static void sortReverse (ArrayList<String> userNames) {
		
		// Loops through array list, sets minIndex at each pass
		for (int i = 0; i < userNames.size() - 1; i++) {
			int minIndex = i;
			// Loops through array list after evaluated position (i)
			for (int j = i + 1; j < userNames.size(); ++j) {
				// If second position > evaluated position, sets minIndex at next position
				// Uses compareTo() method since String type implements Comparable interface
				if (userNames.get(j).compareTo(userNames.get(minIndex)) > 0) {
					minIndex = j;
				}
			}
			// Swaps the two entries
			String temp = userNames.get(i);
			userNames.set(i, userNames.get(minIndex));
			userNames.set(minIndex, temp);
		}
	}
	
	/**
	 * Sorts array list via selection sort algorithm in alphabetical order
	 * Implements compareTo() method from Comparable interface
	 * @param userNames - array to sort
	 */	
	public static void sort (ArrayList<String> userNames) {
		
		// Loops through array list, sets minIndex at each pass
		for (int i = 0; i < userNames.size() - 1; i++) {
			int minIndex = i;
			// Loops through array list after evaluated position (i)
			for (int j = i + 1; j < userNames.size(); ++j) {
				// If second position > evaluated position, sets minIndex at next position
				// Uses compareTo() method since String type implements Comparable interface
				if (userNames.get(j).compareTo(userNames.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			// Swaps the two entries
			String temp = userNames.get(i);
			userNames.set(i, userNames.get(minIndex));
			userNames.set(minIndex, temp);
		}
	}
}
