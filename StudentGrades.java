package maps;

/**
 * CSC372 Final Portfolio Project
 * Program that keeps HashMap in which keys and values are strings - name of student and course grade
 * Prompts user to add or remove students, modify grades, or print all grades
 * @author Brenton Otis
 */

import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;

public class StudentGradesHashMap {
	
	// variable instance - initialize HashMap
	static HashMap<String, String> StudentGrades = new HashMap<String, String>();
	static String command;
	// driver
	public static void main (String[] args) {
		
		command = getCommand();
		
		while (!command.equalsIgnoreCase("quit")) {
			if (command.equals("new")) {
				StudentGrades = newStudent();
			}
			if (command.equalsIgnoreCase("remove")) {
				StudentGrades = removeStudent();
			}
			if (command.equalsIgnoreCase("modify")) {
				StudentGrades = modifyGrade();
			}
			if (command.equalsIgnoreCase("print")) {
				StudentGrades = printAll();
			}
			if (!command.equalsIgnoreCase("modify") || !command.equalsIgnoreCase("remove") ||
					!command.equalsIgnoreCase("print") || !command.equalsIgnoreCase("new")) {
				// TODO: Trying to get error message to display when incorrect command entered; But whatever I put here shows up on each new/remove/modify command as well?
				// Tried stand alone else statement to trigger error but behaves the same as indicated in above line
				// Not affected by print command, however?
			}
			command = getCommand();
		}
		// prints exit message when while loop breaks/program terminates (command.equals("quit"))
		System.out.println("Exiting program.");
	}
	
	/**
	 * helper method - prompt user for command
	 * @return command variable
	 */
	public static String getCommand() {
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter 'new' to add new student and grade");
		System.out.println("Enter 'remove' to remove a student");
		System.out.println("Enter 'modify' to edit a student's grade");
		System.out.println("Enter 'print' to view all student's grades");
		System.out.println("Enter 'quit' to exit program");
		String command = scnr.nextLine();
		return command;
	}
	/**
	 * helper method - enter new student/grade info. to hashmap
	 * @return StudentGrades hashmap
	 */
	public static HashMap<String, String> newStudent() {
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter student name: ");				
		String studentName = scnr.nextLine();
		System.out.println("Enter student grade: ");
		String studentGrade = scnr.nextLine();
		StudentGrades.put(studentName, studentGrade);
		System.out.println("New student " + studentName + " succesfully entered.");
		System.out.println("------------------------------------");
		return StudentGrades;
	}
	/**
	 * helper method - remove student from hashmap (by key (name))
	 * @return StudentGrades hashmap
	 */
	public static HashMap<String, String> removeStudent() {
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter student name to remove: ");
		String nameToRemove = scnr.nextLine();
		if (!StudentGrades.containsKey(nameToRemove)) {
			System.out.println(nameToRemove + " not present in student records, please try again. (Enter 'print' to see current student records).");
			System.out.println("----------------------------------------------------------------------------------------------------");
		}
		else {
			StudentGrades.remove(nameToRemove);
			System.out.println("Student " + nameToRemove + " succesfully removed.");
			System.out.println("-------------------------------------------------");
		}
		return StudentGrades;
	}
	/**
	 * helper method - modify student grade in hashmap (by key (name))
	 * @return StudentGrades hashmap
	 */
	public static HashMap<String, String> modifyGrade() {
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter student name to modify: ");
		String nameToModify = scnr.nextLine();
		if (!StudentGrades.containsKey(nameToModify)) {
			System.out.println(nameToModify + " not present in student records, please try again. (Enter 'print' to see current student records).");
			System.out.println("----------------------------------------------------------------------------------------------------");
		}
		else {
			System.out.println("Enter new/modified grade for student: ");
			String gradeToModify = scnr.nextLine();
			StudentGrades.put(nameToModify, gradeToModify);
			System.out.println("Student " + nameToModify + "'s grade succesfully changed to " + gradeToModify + ".");
			System.out.println("-----------------------------------------------");
		}
		return StudentGrades;
	}
	/**
	 * helper method - print hashmap of student names/grades
	 * @return StudentGrades hashmap
	 */
	public static HashMap<String, String> printAll() {
		// TODO: document keySet/loop
		// TODO: print sorted in alphabetical order by key
		Set<String> keySet = StudentGrades.keySet();
		System.out.println("Student Grades");
		System.out.println("--------------");
		for (String key : keySet) {
			String value = StudentGrades.get(key);
			System.out.println(key + ": " + value);
			}
		System.out.println("--------------");
		return StudentGrades;
	}
}
