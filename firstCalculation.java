public class firstCalculation extends Calculate {
	public void multiply (int numOne, int numTwo) {
		answer = numOne * numTwo;
		System.out.println("The product of num one and num two is: " + answer);
	}
	
	public static void main(String args[]) {
		int myNumOne = 5;
		int myNumTwo = 10;
		firstCalculation test = new firstCalculation();
		test.add(myNumOne,  myNumTwo);
		test.subtract(myNumOne,  myNumTwo);
		test.multiply(myNumOne, myNumTwo);
	}
}