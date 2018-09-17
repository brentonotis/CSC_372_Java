public class Calculate {
	int answer;
	
	public void add(int numOne, int numTwo) {
		answer = numOne + numTwo;
		System.out.println("The sum of " + numOne + " and " + numTwo + " is: " + answer);
	}
	
	public void subtract(int numOne, int numTwo) {
		answer = numOne - numTwo;
		System.out.println("The difference between " + numOne + " and " + numTwo + " is: " + answer);
	}
}

