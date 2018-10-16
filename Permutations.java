package permutations;

import java.util.ArrayList;

public class Permutations {
	
	/**
	 * Gets all permutations of a string
	 * @param word - string to be evaluated
	 * @return - list of all permutations
	 */
	
	public static ArrayList<String> permutations(String word) {
		
		ArrayList<String> result = new ArrayList<String>();
		
		// If empty string, add since it's the only possible permutation
		if (word.length() == 0) {
			result.add(word);
			return result;
		}
		else {
			// Loop through all characters in string
			for (int i = 0; i < word.length(); i++) {
				// Form shorter word by removing ith character
				String shorter = word.substring(0, i) + word.substring(i + 1);
				// Get all permutations of shorter word
				ArrayList<String> shorterPermutations = permutations(shorter);
				// Add removed character to the front of each permutation of the shorter word
				for (String s : shorterPermutations) {
					result.add(word.charAt(i) + s);
				}
			}
			// Return all permutations
			return result;
		}
	}
	
	// Driver
	public static void main (String[] args) {
		
		for (String s : permutations("ant")) {
			System.out.println(s);
		}
	}
}
