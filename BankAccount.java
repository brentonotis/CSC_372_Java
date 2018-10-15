package bank_balance;

public class BankAccount {
	
	private static final double STARTING_SAVINGS = 0;
	private double savingsBalance;
	private static final double STARTING_CHECKING = 0;
	private double checkingBalance;
	
	public BankAccount() {
		
		savingsBalance = STARTING_SAVINGS;
		checkingBalance = STARTING_CHECKING;		
	}
			
	public void depositSavings(double amount) {
			
		savingsBalance += amount;
	}
	
	public void withdrawSavings(double amount) {
			
		savingsBalance -= amount;
	}
		
package bank_balance;

/**
 * Simple BankAccount program allowing user to deposit/withdraw/transfer funds from checking/savings account
 * Used for developing/learning CRC cards and a UML diagram
 * @author Brenton Otis
 */

public class BankAccount {
	
	// Instance variables
	private static final double STARTING_SAVINGS = 0;
	private double savingsBalance;
	private static final double STARTING_CHECKING = 0;
	private double checkingBalance;
	
	// Constructor
	public BankAccount() {
		
		savingsBalance = STARTING_SAVINGS;
		checkingBalance = STARTING_CHECKING;		
	}
	/**
	 * Helper methods - depoist/withdraw/get/transfer to/from checking and savings accounts	
	 * @param amount
	 * @return savingsBalance, checkingBalance
	 */
	public void depositSavings(double amount) {
			
		savingsBalance += amount;
	}
	
	public void withdrawSavings(double amount) {
			
		savingsBalance -= amount;
	}
		
	public double getSavingsBal() {

		return savingsBalance;
	}
	
	public void depositChecking (double amount) {
		
		checkingBalance += amount;
	}		
	
	public void withdrawChecking (double amount) {
			
		checkingBalance -= amount;
	}
		
	public double getCheckingBal() {
			
		return checkingBalance;
	}
	
	public void transferToSavings (double amount) {
		
		// check to ensure requested transfer amount is available
		if (amount <= checkingBalance) {
			// update checking and savings accounts per transfer
			checkingBalance -= amount;
			savingsBalance += amount;
		}
	}
	
	public void transferToChecking (double amount) {
		
		// check to ensure requested transfer amount is available
		if (amount <= savingsBalance) {
			// update checking and savings account per transfer
			checkingBalance += amount;
			savingsBalance -= amount;
		}
	}
	
	// Driver/testing
	public static void main (String[] args) {
		
		BankAccount BrentonAcct = new BankAccount();
		
		BrentonAcct.depositSavings(100);
		BrentonAcct.withdrawSavings(50);
		System.out.println("Savings Balance: $" + BrentonAcct.getSavingsBal());
		
		BrentonAcct.depositChecking(200);
		BrentonAcct.withdrawChecking(100);
		System.out.println("Checking Balance: $" + BrentonAcct.getCheckingBal());
		
		BrentonAcct.transferToSavings(99);
		System.out.println("Savings Balance: $" + BrentonAcct.getSavingsBal());
		
		BrentonAcct.transferToChecking(1);
		System.out.println("Checking Balance: $" + BrentonAcct.getCheckingBal());
				
	}
}
