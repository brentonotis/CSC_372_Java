package bank_balance;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/** Program/GUI that allows user to input/output a nominal amount.
  * Program displays balance with each user action
  * Program does not allow user to withdraw if withdrawl amount exceeds available balance
  * Program displays text field that shows each user selected action and result
 **/

@SuppressWarnings("serial") 
public class BankBalance extends JFrame {

	// Declare component instance variables
	private JButton depositButton;
	private JButton withdrawButton;
	private JLabel depositLabel;
	private JLabel balanceLabel;
	private JTextField inputField;
	private JTextArea balanceLedger;
	private double balance;
	
	// Declare final/static instance variables
	private static final double INITIAL_BALANCE = 0;
	private static final int FRAME_WIDTH = 380;
	private static final int FRAME_HEIGHT = 300;
	private static final int AREA_ROWS = 10;
	private static final int AREA_COLUMNS = 30;
	
	// Constructor
	public BankBalance() {
	
		balance = INITIAL_BALANCE;
		createTextInputField();
		createDepositButton();
		createWithdrawButton();
		createBalanceLedger();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	// Creates event listener via ActionListener interface
	class depositActionListener implements ActionListener {
		
		// ActionListener interface method
		public void actionPerformed(ActionEvent event) {
			
			// Create input variable, gets string value from text field, converts to numeric (double) value
			double input = Double.parseDouble(inputField.getText());
			
			// adds input value to balance; Sets balanceLabel text with updated balance
			balance += input;
			balanceLabel.setText("Balance: $" + balance);
			balanceLedger.append("Deposited $" + input + "; New balance: $" + balance + "\n");
		}
	}
	
	// Creates event listener via ActionListener interface
	class withdrawActionListener implements ActionListener {
			
		// ActionListener interface method
		public void actionPerformed(ActionEvent event) {
				
			// Create input variable, gets string value from text field, converts to numeric (double) value
			double input = Double.parseDouble(inputField.getText());
			
			// Check to ensure enough balance available to withdraw
			if (balance - input < 0) {
				
				// If not, notify user
				balanceLedger.append("***  DECLINED: INSUFFICIENT FUNDS  *** \n");
				balanceLedger.append("*** ATTEMPTED: -$" + input + "; AVAILABLE: $" + balance + " ***\n");
			}		
			else {
				// adds input value to balance; Sets balanceLabel text with updated balance
				balance -= input;
				balanceLabel.setText("Balance: $" + balance);
				balanceLedger.append("Withdrew $" + input + "; New balance: $" + balance + "\n");
			}
		}
	}
	
	// Helper method - create text field and deposit label
	public void createTextInputField() {
		
		depositLabel = new JLabel("Amount to deposit/withdraw: $");
		final int FIELD_WIDTH = 10;
		inputField = new JTextField(FIELD_WIDTH);
		inputField.setText("" + balance);	
	}
	
	// Helper method - create deposit button, attach event listener
	public void createDepositButton() {
		
		depositButton = new JButton("Deposit");
		ActionListener depositListener = new depositActionListener();
		depositButton.addActionListener(depositListener);
	}
	
	// Helper method - create withdraw button, attach event listener
	public void createWithdrawButton() {
		
		withdrawButton = new JButton("Withdraw");
		ActionListener withdrawListener = new withdrawActionListener();
		withdrawButton.addActionListener(withdrawListener);
	}
	
	// Helper method - create balance ledger/text area
	public void createBalanceLedger() {
		
		balanceLedger = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		balanceLedger.setText("Beginning Balance: $ " + balance + "\n");
		balanceLedger.setEditable(false);
	}
	
	// Helper method - create panel
	public void createPanel() {
		
		JPanel panel = new JPanel();
		balanceLabel = new JLabel("Balance: $" + balance);
		JScrollPane scrollPane = new JScrollPane(balanceLedger);
		
		panel.add(depositLabel);
		panel.add(inputField);
		panel.add(depositButton);
		panel.add(withdrawButton);
		panel.add(scrollPane);
		panel.add(balanceLabel);
		add(panel);		
	}
	
	// Driver/create frame
	public static void main (String[] args) {
		
		JFrame frame = new BankBalance();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}
}
