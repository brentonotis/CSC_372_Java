package stacks;

/**
 * Example of a stack in practice
 * Program uses a stack to check if an expression has balanced parentheses
 */

import java.util.Scanner;
import java.util.Stack;

public class ParenthesesCheck {
	@SuppressWarnings("resource")
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter an expression with { [ ( ) ] }: ");
		String expression = in.nextLine();
		
		Stack<Character> parentheses = new Stack<Character>();
		
		for (int i = 0; i < expression.length(); ++i) {
			char ch = expression.charAt(i);
			// if opening parentheses present, push onto stack
			if (ch == '{' || ch == '[' || ch == '(') {
				parentheses.push(ch);
			}
			// if closing parentheses (and stack not empty), pop from stack
			else if (ch == '}' || ch == ']' || ch == ')') {
				if (parentheses.size() == 0) {
					System.out.println("Not balanced.");
					return;
				}
				char open = parentheses.pop();
				// if opening and closing parentheses don't match, exit (not balanced)
				if (!(open == '(' && ch == ')' || open == '[' && ch == ']' || open == '{' && ch == '}')) {
					System.out.println("Not balanced.");
					return;
				}
			}
		}
		// if stack is empty at the end, parentheses are balanced
		if (parentheses.size() == 0) {
			System.out.print("Balanced.");
		}
		// otherwise parentheses are not balanced
		else {
			System.out.println("Not balanced.");
		}	
	}
}
