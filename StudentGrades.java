package maps;

/**
 * CSC372 Final Portfolio Project
 * Program that keeps HashMap in which keys and values are strings - name of student and course grade
 * Prompts user to add or remove students, modify grades, or print all grades
 * @author Brenton Otis
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

public class StudentGrades {
	
	// variable instance - initialize HashMap
	private static Map<String, String> StudentGrades = new HashMap<String, String>();
	private static String command;
	
	
	// driver
	public static void main (String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		
		getCommand();
		
		if (command == "new") {
			System.out.println("Enter student name: ");				
			String studentName = scnr.nextLine();
			System.out.println("Enter student grade: ");
			String studentGrade = scnr.nextLine();
			StudentGrades.put(studentName, studentGrade);
			getCommand();
		}
		else if (command == "remove") {
			System.out.println("Enter student name to remove: ");
			String nameToRemove = scnr.nextLine();
			StudentGrades.remove(nameToRemove);
			getCommand();
		}
		else if (command == "modify") {
			System.out.println("Enter student name to modify: ");
			String nameToModify = scnr.nextLine();
			System.out.println("Enter new/modified grade for student: ");
			String gradeToModify = scnr.nextLine();
			StudentGrades.put(nameToModify, gradeToModify);
			getCommand();
		}
		else if (command == "print") {
			Set<String> keySet = StudentGrades.keySet();
			for (String key : keySet) {
				String value = StudentGrades.get(key);
				System.out.println(key + " : " + value);
				}
			getCommand();
		}
	}	
	/**
	 * helper method - prompt user for command
	 * @return command variable
	 */
	public static String getCommand() {
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter 'new' to add new student and grade, 'remove' to remove a student, 'modify' to edit a grade, or 'print' to print all students/grades. Enter 'quit' to quit.");
		String command = scnr.nextLine();
		return command;
	}
}
