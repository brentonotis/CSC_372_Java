package emp_mgr;

/** 
 * Java program highlighting inheritance; Implements superclass Employee that has the following fields:
 * String firstName
 * String lastName
 * int employeeID
 * double Salary
 * 
 * Methods:
 * Constructor();
 * Setter and Getters;
 * EmployeeSummary()
 * 
 * @author Brenton Otis
 */

public class Employee {
	
	// Instance variables
	private String firstName;
	private String lastName;
	private int employeeID;
	protected double salary;
	
	// Constructor
	public Employee(String firstName, String lastName, int employeeID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeID = employeeID;
		this.salary = 0.0;
	}	
	/**
	 * Getter
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	// Setter
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Getter
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	// Setter
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Getter
	 * @return employeeID
	 */
	public int getEmployeeId() {
		return employeeID;
	}
	// Setter
	public void setEmployeeId (int employeeID) {
		this.employeeID = employeeID;
	}
	// Print employee summary
	public void EmployeeSummary() {
		System.out.println("Employee ID: " + employeeID);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Salary: $" + salary + "/hour");
		return;
	}	
	// Driver
	public static void main (String[] args) {		
		Employee test = new Employee ("Timothy", "Tim", 987654);
		test.salary = 15.75;
		test.EmployeeSummary();		
	}
}
