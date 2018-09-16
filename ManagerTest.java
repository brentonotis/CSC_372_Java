package emp_mgr;

public class ManagerTest extends Manager {
	public ManagerTest(String firstName, String lastName, int employeeID, String department) {
		super(firstName, lastName, employeeID, department);
	}
	
	
	public static void main(String[] args) {
		ManagerTest testData = new ManagerTest("", "", 0, "");
		int testCounter = 0;
		
		System.out.println("Testing...");
		
		testData.setFirstName("Brenton");				
		if (testData.getFirstName() != "Brenton") {
			System.out.println("TEST FAILED: get/set firstName");
			++testCounter;
		}
		
		testData.setLastName("Otis");
		if (testData.getLastName() != "Otis") {
			System.out.println("TEST FAILED: get/set lastName");
			++testCounter;
		}
		
		testData.setEmployeeId(999999);
		if (testData.getEmployeeId() != 999999) {
			System.out.println("TEST FAILED: get/set employeeID");
			++testCounter;
		}
		
		testData.setDepartment("Engineering");
		if (testData.getDepartment() != "Engineering") {
			System.out.println("TEST FAILED: get/set department");
			++testCounter;
		}
		
		testData.salary = 9999999.99;
		if (testData.salary != 9999999.99) {
			System.out.println("TEST FAILED: salary");
			++testCounter;
		}
		
		System.out.println("Sample EmployeeSummary() output below:");
		testData.EmployeeSummary();
		System.out.println("Department: " + testData.department);

		System.out.println("Testing complete. " + testCounter + " test(s) failed.");
	}
}

