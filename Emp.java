package emp;

//employee identified by name with methods for calculating pay

public class Employee {
	
	private String name;
	
	//Constructor
	public Employee() {
		name = "";
	}
	
	//Set new employee name (setter)
	//@param employeeName
	public void setName(String employeeName) {
		name = employeeName;
	}
	
	//@return name of employee (getter)
	public String getName() {
		return name;	
	}
	
	//@return pay for calculated hours worked in a week
	//@param hoursWorked
	public double weeklyPay(int hoursWorked) {
		return 0;
	}	
}
