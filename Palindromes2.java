package palindrome;

public class Palindromes2 {

	// Driver
	public static void main (String[] args) {
		
		String firstSentence = "Madam, I'm Adam!";
		System.out.println(firstSentence);
		System.out.println("Palindrome: " + isPalindrome(firstSentence));
		String secondSentence = "Sir, I'm Eve!";
		System.out.println(secondSentence);
		System.out.println("Palindrome: " + isPalindrome(secondSentence));
	}
	
	/**
	 * Tests to determine if text is a palindrome (string equal to itself when all characters reversed)
	 * @param text - string in question/being checked
	 * @return - true if text is palindrome, else false
	 */
	public static boolean isPalindrome(String text) {
		
		// calls recursive helper method with positions that test entire string
		return isPalindrome(text, 0, text.length() -1);
	}
	
	/**
	 * Tests whether a substring is a palindrome
	 * @param text - string in question/being checked
	 * @param start - index of the first character of the substring
	 * @param end - index of the last character of the substring
	 * @return - true, if the substring is a palindrome
	 */
	public static boolean isPalindrome(String text, int start, int end) {
		
		// separate/base case for substrings of length 1 and 0
		if (start >= end) {
			return true;
		}
		else {
			// get first and last characters, convert to lowercase
			char first = Character.toLowerCase(text.charAt(start));
			char last = Character.toLowerCase(text.charAt(end));
			if (Character.isLetter(first) && Character.isLetter(last)) {
				if (first == last) {
					// test substring that doesn't contain matching letters
					return isPalindrome(text, start + 1, end - 1);
				}
				else {
					return false;
				}
			}
			else if (!Character.isLetter(last)) {
				// test substring that doesn't contain last character
				return isPalindrome(text, start, end - 1);
			}
			else {
				// test substring that doesn't contain the first character
				return isPalindrome(text, start + 1, end);
			}
		}		
	}
}