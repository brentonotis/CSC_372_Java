package emp_mgr;

public class Manager extends Employee {
	String department;
	
	// Constructor
	public Manager(String firstName, String lastName, int employeeID, String department) {
		super(firstName, lastName, employeeID);
		this.department = department;
	}
	
	// Getters/setters for subclass field (department)
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment (String department) {
		this.department = department;
	}
	
	// Test main/driver
	public static void main (String args[]) {
		System.out.println("Testing Main (Manager):");
		Manager testMgr = new Manager("Bob", "Bobson", 666666, "Sales");
		testMgr.salary = 20.55;
		testMgr.EmployeeSummary();
		System.out.println("Department: " + testMgr.department);
		System.out.println("Main (Manager) Testing Complete");	
	}
}

