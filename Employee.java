package emp_mgr;

public class Employee {
	// Superclass fields
	private String firstName;
	private String lastName;
	private int employeeID;
	protected double salary;

	// Constructors, initializing salary to 0.0
	public Employee(String firstName, String lastName, int employeeID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeID = employeeID;
		this.salary = 0.0;
	}

	// Getters/Setters for firstName,Lastname, and employeeID
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	
	public int getEmployeeId() {
		return employeeID;
	}
	
	public void setEmployeeId (int employeeID) {
		this.employeeID = employeeID;
	}
	
	// Summary print statement
	public void EmployeeSummary() {
		System.out.println("Employee ID: " + employeeID);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Salary: $" + salary + "/hour");
		return;
	}
	
	// Test main/driver
	public static void main (String[] args) {	
		Employee test = new Employee ("Timothy", "Tim", 987654);
		test.salary = 15.75;
		test.EmployeeSummary();
		
	}
}
