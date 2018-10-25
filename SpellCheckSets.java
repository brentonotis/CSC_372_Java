package sets;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Checks which words in a file are not present in a dictionary
 * Example of sets in practice
 */

public class SpellCheckSets {
	
	// Driver
	public static void main (String[] args)
		throws FileNotFoundException
	{
		// Reads/scans dictionary and document
		Set<String> dictionaryWords = readWords("words");
		Set<String> documentWords = readWords("sample.txt");
		
		// Prints all words that are in the document but not dictionary
		for (String word : documentWords) {
			if (!dictionaryWords.contains(word)) {
				System.out.println(word);
			}
		}
	}
	
	/**
	 * Helper method - reads all words from a file
	 * @param filename - name of the file
	 * @return - a set with all lowercase words in the file
	 * In this example, word is a sequence of upper and lowercase letters
	 */
	@SuppressWarnings("resource")
	public static Set<String> readWords(String filename)
		throws FileNotFoundException
	{
		Set<String> words = new HashSet<String>();
		Scanner scnr = new Scanner(new File(filename));
		
		// Use any characters other than a-z or A-Z as delimiters
		scnr.useDelimiter("[^a-zA-Z]+");
		while (scnr.hasNext()) {
			words.add(scnr.next().toLowerCase());
		}
		return words;
	}
}
