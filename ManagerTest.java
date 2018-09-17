package emp_mgr;

public class ManagerTest extends Manager {
	public ManagerTest(String firstName, String lastName, int employeeID, String department) {
		super(firstName, lastName, employeeID, department);
	}
	
	// Main/driver for test class
	public static void main(String[] args) {

		// Initializing new object testData and int testCounter
		ManagerTest testData = new ManagerTest("", "", 0, "");
		int testCounter = 0;
		
		System.out.println("Testing...");
		
		// Testing firstName getters/setters
		testData.setFirstName("Brenton");				
		if (testData.getFirstName() != "Brenton") {
			System.out.println("TEST FAILED: get/set firstName");
			++testCounter;
		}
		
		// Testing lastName getters/setters
		testData.setLastName("Otis");
		if (testData.getLastName() != "Otis") {
			System.out.println("TEST FAILED: get/set lastName");
			++testCounter;
		}
		
		// Testing employeeID getters/setters
		testData.setEmployeeId(999999);
		if (testData.getEmployeeId() != 999999) {
			System.out.println("TEST FAILED: get/set employeeID");
			++testCounter;
		}
		
		// Testing department getters/setters
		testData.setDepartment("Engineering");
		if (testData.getDepartment() != "Engineering") {
			System.out.println("TEST FAILED: get/set department");
			++testCounter;
		}
		
		// Testing salary functionality
		testData.salary = 9999999.99;
		if (testData.salary != 9999999.99) {
			System.out.println("TEST FAILED: salary");
			++testCounter;
		}
		
		// Sample program output with test object
		System.out.println("Sample EmployeeSummary() output below:");
		testData.EmployeeSummary();
		System.out.println("Department: " + testData.department);

		System.out.println("Testing complete. " + testCounter + " test(s) failed.");
	}
}

