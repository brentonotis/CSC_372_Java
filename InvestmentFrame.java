package investment_frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InvestmentFrame extends JFrame {
	
	// About to google it, but again, not clue what the line below (13) means; c/o Eclipse to compile
	private static final long serialVersionUID = 1L;
	// Button and label for interface + place to store balance
	private JButton button;
	private JLabel resultLabel;
	private double balance;
	
	// Set frame dimensions
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 100;
	
	// Set interest rate and initial balance
	private static final double INTEREST_RATE = 5;
	private static final double INITIAL_BALANCE = 1000;
	
	// Constructor - initializes balance when frame constructed
	public InvestmentFrame() {
		balance = INITIAL_BALANCE;
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	// Inner-class declares event listener class that implements ActionListener interface
	// Making an inner-class allows access to the balance and resultLabel instance variables
	class AddInterestListener implements ActionListener {
		// *button action must be placed into the actionPerformed method
		public void actionPerformed(ActionEvent event) {
			// calculate interest, add to balance, set label text with result
			double interest = balance * INTEREST_RATE / 100;
			balance += interest;
			resultLabel.setText("Balance: " + balance);			
		}
	}
	
	// helper method
	private void createComponents() {
		// Create button, add instance of listener class to button
		button = new JButton("Add interest");
		ActionListener listener = new AddInterestListener();
		button.addActionListener(listener);
		
		resultLabel = new JLabel("Balance: " + balance);
		
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(resultLabel);
		add(panel);
	}
}
