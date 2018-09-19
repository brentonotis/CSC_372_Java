package emp;
import java.util.Scanner;

public class Driver {
	public static void main (String[] args) {
		Employee[] staff = new Employee[3];
		staff[0] = new hourlyEmployee("Bobson, Bob", 15);
		staff[1] = new salariedEmployee("Janson, Jan", 45000);
		staff[2] = new Manager("Curtson, Curt", 65000, 100);
		
		Scanner in = new Scanner(System.in);
		for (Employee e : staff) {
			System.out.print("Hours worked by " + e.getName() + ": ");
			int hours = in.nextInt();
			System.out.println("Salary: " + e.weeklyPay(hours));			
		}
	}
}
