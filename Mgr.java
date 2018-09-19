package emp;

public class Manager extends salariedEmployee {
	
	private double weeklyBonus;
	
	//Constructor with name, salary, weekly bonus
	//@param name - name
	//@param salary - annual salry
	//@param bonus - weekly bonus
	public Manager (String name, double salary, double bonus) {
		super(name, salary);
		weeklyBonus = bonus;
	}
	
	public double weeklyPay (int hoursWorked) {
		return super.weeklyPay(hoursWorked) + weeklyBonus;
	}
}
