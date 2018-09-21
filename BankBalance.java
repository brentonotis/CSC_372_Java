package bank_balance;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class BankBalance extends JFrame {
		
	/**
	 ** ? **
	 */
	private static final long serialVersionUID = 1L;
	// Declare component instance variables
	private JButton depositButton;
	private JButton withdrawButton;
	private JLabel depositLabel;
	private JLabel balanceLabel;
	private JTextField inputField;
	private double balance;
	
	// Declare final/static instance variables
	private static final double INITIAL_BALANCE = 0;
	private static final int FRAME_WIDTH = 200;
	private static final int FRAME_HEIGHT = 150;
	
	// Constructor
	public BankBalance() {
	
		balance = INITIAL_BALANCE;
		createTextDepositField();
		createDepositButton();
		createWithdrawButton();
		
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
			balanceLabel.setText("Balance: " + balance);
		}
	}
	
	// Creates event listener via ActionListener interface
		class withdrawActionListener implements ActionListener {
			
			// ActionListener interface method
			public void actionPerformed(ActionEvent event) {
				
				// Create input variable, gets string value from text field, converts to numeric (double) value
				double input = Double.parseDouble(inputField.getText());
				
				// adds input value to balance; Sets balanceLabel text with updated balance
				balance -= input;
				balanceLabel.setText("Balance: " + balance);
			}
		}
	
	// Helper method - create text field and deposit label
	public void createTextDepositField() {
		
		depositLabel = new JLabel("Amount to deposit/withdraw: ");
		final int FIELD_WIDTH = 10;
		inputField = new JTextField(FIELD_WIDTH);
		inputField.setText("" + balance);	
	}
	
	// Helper method - create deposit button
	public void createDepositButton() {
		
		depositButton = new JButton("Deposit");
		ActionListener depositListener = new depositActionListener();
		depositButton.addActionListener(depositListener);
	}
	
	// Helper method - create withdraw button
	public void createWithdrawButton() {
		
		withdrawButton = new JButton("Withdraw");
		ActionListener withdrawListener = new withdrawActionListener();
		withdrawButton.addActionListener(withdrawListener);
	}
	
	// Helper method - create panel
	public void createPanel() {
		
		JPanel panel = new JPanel();
		balanceLabel = new JLabel("Balance: " + balance);
		
		panel.add(depositLabel);
		panel.add(inputField);
		panel.add(depositButton);
		panel.add(withdrawButton);
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
