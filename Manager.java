package emp_mgr;

/**
 * Java class extending/inheriting Employee class;
 * Has an additional attribute (department);
 * Method:
 * EmployeeSummary();
 * @author Brenton Otis
 */

public class Manager extends Employee {
	
	// Instance variable
	String department;
	
	// Constructor
	public Manager(String firstName, String lastName, int employeeID, String department) {
		super(firstName, lastName, employeeID);
		this.department = department;
	}
	/**
	 * Getter
	 * @return department
	 */
	public String getDepartment() {
		return department;
	}
	// Setter
	public void setDepartment (String department) {
		this.department = department;
	}
	// Driver
	public static void main (String args[]) {
		Manager testMgr = new Manager("Bob", "Bobson", 555666, "Sales");
		testMgr.salary = 20.55;
		testMgr.EmployeeSummary();
		System.out.println("Department: " + testMgr.department);	
	}
}


