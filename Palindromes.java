package palindrome;

public class Palindromes {

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
		
		int length = text.length();
		
		// Shortest/base case
		if (length <= 1) {
			return true;
		}
		else {
			// Get first and last characters (converted to lowercase)
			char first = Character.toLowerCase(text.charAt(0));
			char last = Character.toLowerCase(text.charAt(length - 1));
			
			if (Character.isLetter(first) && Character.isLetter(last)) {
				// If both are equal letters
				if (first == last) {
					// Remove first and last character
					String shorter = text.substring(1, length - 1);
					return isPalindrome(shorter); 
				}
				else {
					return false;
				}
			}
			else if (!Character.isLetter(last)) {
				// Remove last character
				String shorter = text.substring(0, length - 1);
				return isPalindrome(shorter);
			}
			else {
				// Remove first character
				String shorter = text.substring(1);
				return isPalindrome(shorter);
			}			
		}		
	}
}
