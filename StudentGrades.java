package maps;

/**
 * CSC372 Final Portfolio Project
 * Program that keeps HashMap in which keys and values are strings - name of student and course grade
 * Prompts user to add or remove students, modify grades, or print all grades (in alphabetical order by key)
 * @author Brenton Otis
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Scanner;

public class StudentGradesHashMap {
	
	// variable instance - initialize HashMap and command variables
	static HashMap<String, String> StudentGrades = new HashMap<String, String>();
	static String command;
	// driver
	public static void main (String[] args) {
		
		command = getCommand();
		
		// while loop allows for user input so long as input is not 'quit' (which terminates program)
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
	 * helper method - enter new student/grade info. to hashMap
	 * @return StudentGrades hashMap
	 */
	public static HashMap<String, String> newStudent() {
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter student name: ");				
		String studentName = scnr.nextLine();
		System.out.println("Enter student grade: ");
		String studentGrade = scnr.nextLine();
		// Creates new entry in hashMap of user input
		StudentGrades.put(studentName, studentGrade);
		System.out.println("New student " + studentName + " succesfully entered.");
		System.out.println("------------------------------------");
		return StudentGrades;
	}
	/**
	 * helper method - remove student from hashMap (by key (name))
	 * @return StudentGrades hashMap
	 */
	public static HashMap<String, String> removeStudent() {
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter student name to remove: ");
		String nameToRemove = scnr.nextLine();
		// check to ensure name entered by user is present in current hashMap
		if (!StudentGrades.containsKey(nameToRemove)) {
			System.out.println(nameToRemove + " not present in student records, please try again. (Enter 'print' to see current student records).");
			System.out.println("----------------------------------------------------------------------------------------------------");
		}
		// if name present, remove from hashMap
		else {
			StudentGrades.remove(nameToRemove);
			System.out.println("Student " + nameToRemove + " succesfully removed.");
			System.out.println("-------------------------------------------------");
		}
		return StudentGrades;
	}
	/**
	 * helper method - modify student grade in hashMap (by key (name))
	 * @return StudentGrades hashMap
	 */
	public static HashMap<String, String> modifyGrade() {
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter student name to modify: ");
		String nameToModify = scnr.nextLine();
		// check that name entered by user is present in HashMap
		if (!StudentGrades.containsKey(nameToModify)) {
			System.out.println(nameToModify + " not present in student records, please try again. (Enter 'print' to see current student records).");
			System.out.println("----------------------------------------------------------------------------------------------------");
		}
		// if name present in hashMap, ask user for new grade
		else {
			System.out.println("Enter new/modified grade for student: ");
			String gradeToModify = scnr.nextLine();
			// Since hashMap doesn't allow duplicate key values, name/grade will effectively replace current name/grade
			StudentGrades.put(nameToModify, gradeToModify);
			System.out.println("Student " + nameToModify + "'s grade succesfully changed to " + gradeToModify + ".");
			System.out.println("-----------------------------------------------");
		}
		return StudentGrades;
	}
	/**
	 * helper method - print hashMap of student names/grades in alphabetical order by key (name)
	 * @return StudentGrades hasMmap
	 */
	public static HashMap<String, String> printAll() {
		// initialize TreeMap as StudentGrades HashMap
		// treeMap implements sortedMap interface, which retains sorted order
		Map<String, String> sortedMap = new TreeMap<String, String>(StudentGrades);
		// initialize set, keySet method returns set view of keys
		Set<String> keySet = sortedMap.keySet();
		System.out.println("Student Grades");
		System.out.println("--------------");
		// iterate through keys of keySet and print key + value
		for (String key : keySet) {
			String value = sortedMap.get(key);
			System.out.println(key + ": " + value);
			}
		System.out.println("--------------");
		return StudentGrades;
	}
}
