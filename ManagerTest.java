package emp_mgr;

/**
 * Java test class for Manager (and Employee) classes;
 * Tests known scenarios
 * @author Brenton Otis
 */

public class ManagerTest extends Manager {
	// Constructor
	public ManagerTest(String firstName, String lastName, int employeeID, String department) {
		// 'super' used inside subclass method definition to call method defined in super class
		super(firstName, lastName, employeeID, department);
	}
	
	// Driver
	public static void main(String[] args) {
		// Initialize new ManagerTest object
		ManagerTest testData = new ManagerTest("", "", 0, "");
		int testCounter = 0;
		
		System.out.println("Testing...");
		// Set firstName, check Setter/Getter, increment testCounter variable if test fails
		testData.setFirstName("Brenton");				
		if (testData.getFirstName() != "Brenton") {
			System.out.println("TEST FAILED: get/set firstName");
			++testCounter;
		}
		// Set lsatName, check Setter/Getter, increment testCounter variable if test fails
		testData.setLastName("Otis");
		if (testData.getLastName() != "Otis") {
			System.out.println("TEST FAILED: get/set lastName");
			++testCounter;
		}
		// Set EmployeeID, check Setter/Getter, increment testCounter variable if test fails
		testData.setEmployeeId(999999);
		if (testData.getEmployeeId() != 999999) {
			System.out.println("TEST FAILED: get/set employeeID");
			++testCounter;
		}
		
		// Set Department, check Setter/Getter, increment testCounter variable if test fails
		testData.setDepartment("Engineering");
		if (testData.getDepartment() != "Engineering") {
			System.out.println("TEST FAILED: get/set department");
			++testCounter;
		}
		// Set salary, check salary, increment testCounter variable if test fails
		testData.salary = 9999999.99;
		if (testData.salary != 9999999.99) {
			System.out.println("TEST FAILED: salary");
			++testCounter;
		}
		// Print summary
		System.out.println("Sample EmployeeSummary() output below:");
		testData.EmployeeSummary();
		System.out.println("Department: " + testData.department);
		// Print number of test failed if applicable
		System.out.println("Testing complete. " + testCounter + " test(s) failed.");
	}
}

