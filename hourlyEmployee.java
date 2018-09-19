package emp;

public class hourlyEmployee extends Employee {
	
	private double hourlyWage;
	
	//Constructor
	//@param name - name
	//@param wage - hourly wage
	public hourlyEmployee (String name, double wage) {
		setName(name);
		hourlyWage = wage;
	}
	
	public double weeklyPay (int hoursWorked) {
		
		double pay = hoursWorked * hourlyWage;
		
		//add overtime
		if (hoursWorked > 40) {
			pay += ((hoursWorked - 40) * 0.5) * hourlyWage;
		}
		return pay;
	}
}
