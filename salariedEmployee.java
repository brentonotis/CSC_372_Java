package emp;

public class salariedEmployee extends Employee {
	
	private double annualSalary;
	
	//Constructor
	//@param nam - name
	//@param salary - annual salary
	public salariedEmployee (String name, double salary) {
		setName(name);
		annualSalary = salary;
	}
	
	public double weeklyPay (int hoursWorked) {
		final int WEEKS_PER_YEAR = 52;
		return annualSalary / WEEKS_PER_YEAR;
	}
}

