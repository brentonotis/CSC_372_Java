package investment_frame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class InvestmentFrame3 extends JFrame {
	
	/**
	 Program that shows the growth of an investment using a variable bar chart
	 */
	private static final long serialVersionUID = 1L;
	// Set final instance variables
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 400;
	private static final int CHART_WIDTH = 300;
	private static final int CHART_HEIGHT = 300;
	private static final double DEFAULT_RATE = 5;
	private static final double INITIAL_BALANCE = 1000;
	
	// Initialize variables
	private JLabel rateLabel;
	private JTextField rateField;
	private JButton button;
	private ChartComponent2 chart;
	private double balance;
	
	// Constructor 
	public InvestmentFrame3() {
		
		balance = INITIAL_BALANCE;
		chart = new ChartComponent2(3 * INITIAL_BALANCE);
		chart.setPreferredSize(new Dimension(CHART_WIDTH, CHART_HEIGHT));
		chart.append(INITIAL_BALANCE);
		
		createTextField();
		createButton();
		createPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	// Helper method
	private void createTextField() {
		
		rateLabel = new JLabel("Interest Rate: ");
		
		final int FIELD_WIDTH = 10;
		rateField = new JTextField(FIELD_WIDTH);
		rateField.setText("" + DEFAULT_RATE);
	}
	
	// ActionListener interface
	class AddInterestListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			// Gets string value from tetxt field, creates interest variable, calculates and adds balance
			double rate = Double.parseDouble(rateField.getText());
			double interest = balance * rate / 100;
			balance = balance + interest;
			chart.append(balance);
		}
	}
	
	// Helper method
	private void createButton() {
		button = new JButton("Add Interest");
		ActionListener listener = new AddInterestListener();
		button.addActionListener(listener);
	}
	
	// Helper method
	private void createPanel() {
		
		JPanel panel = new JPanel();
		panel.add(rateLabel);
		panel.add(rateField);
		panel.add(button);
		panel.add(chart);
		add(panel);
	}
	
	// Driver
	public static void main (String[] args) {
		
		JFrame frame = new InvestmentFrame3();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
