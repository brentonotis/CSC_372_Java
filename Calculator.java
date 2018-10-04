package calculator;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** Frame that contains a panel and buttons for calculator;
 * Includes text field that displays result
 * Multiplication and addition carry same precedence
 * To be updated to true mathematical operations in the future
 */
@SuppressWarnings("serial")
public class Calculator extends JFrame {
	
	// Variable instances
	private JTextField display;
	private JCheckBox radianCheckBox;
	private JRadioButton baseeButton;
	private JRadioButton base10Button;
	private JRadioButton base2Button;
	@SuppressWarnings("rawtypes")
	private JComboBox mathOpCombo;
	private JButton mathOpButton;
	
	private double lastValue;
	private String lastOperator;
	private boolean startNewValue;
	
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;
	
	// Constructor
	public Calculator() {
		createButtonPanel();
		createControlPanel();
		
		display = new JTextField("0");
		display.setEditable(false);
		add(display, BorderLayout.NORTH);
		
		lastValue = 0;
		lastOperator = "=";
		startNewValue = true;
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	// Helper method - creates control panel w/ text field and buttons
	private void createButtonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 4));
		
		buttonPanel.add(makeDigitButton("7"));
		buttonPanel.add(makeDigitButton("8"));
		buttonPanel.add(makeDigitButton("9"));
		buttonPanel.add(makeOperatorButton("/"));
		buttonPanel.add(makeDigitButton("4"));
		buttonPanel.add(makeDigitButton("5"));
		buttonPanel.add(makeDigitButton("6"));
		buttonPanel.add(makeOperatorButton("*"));
		buttonPanel.add(makeDigitButton("1"));
		buttonPanel.add(makeDigitButton("2"));
		buttonPanel.add(makeDigitButton("3"));
		buttonPanel.add(makeOperatorButton("-"));
		buttonPanel.add(makeDigitButton("0"));
		buttonPanel.add(makeDigitButton("."));
		buttonPanel.add(makeOperatorButton("="));
		buttonPanel.add(makeOperatorButton("+"));
		
		add(buttonPanel, BorderLayout.CENTER);
	}
	
	// Action Listener override 
	class MathOpListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			double value = Double.parseDouble(display.getText());
			String mathOp = (String) mathOpCombo.getSelectedItem();
			
			double base = 10;
			if (baseeButton.isSelected()) {
				base = Math.E;
			}
			else if (base2Button.isSelected()) {
				base = 2;
			}
			
			boolean radian = radianCheckBox.isSelected();
			if (!radian && (mathOp.equals("sin") || mathOp.equals("cos") || mathOp.equals("tan"))) {
				value = Math.toRadians(value);
			}
			if (mathOp.equals("cos")) {
				value = Math.cos(value);
			}
			else if (mathOp.equals("tan")) {
				value = Math.tan(value);
			}
			else if (mathOp.equals("log")) {
				value = Math.log(value) / Math.log(base);
			}
			else if (mathOp.equals("exp")) {
				value = Math.pow(base, value);
			}
			display.setText("" + value);
			
			startNewValue = true;
		}
	}
	
	// Helper method creates radio button panel
	private JPanel createBaseButtons() {
		baseeButton = new JRadioButton("e");
		base10Button = new JRadioButton("10");
		base2Button = new JRadioButton("2");
		
		baseeButton.setSelected(true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(baseeButton);
		group.add(base10Button);
		group.add(base2Button);
		
		JPanel basePanel = new JPanel();
		basePanel.add(baseeButton);
		basePanel.add(base10Button);
		basePanel.add(base2Button);
		basePanel.setBorder(new TitledBorder(new EtchedBorder(), "Base"));
		
		return basePanel;
	}
	
	// Helper method creates control panel
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void createControlPanel() {
		radianCheckBox = new JCheckBox("Radian");
		radianCheckBox.setSelected(true);
		
		mathOpCombo = new JComboBox();
		mathOpCombo.addItem("sin");
		mathOpCombo.addItem("cos");
		mathOpCombo.addItem("tan");
		mathOpCombo.addItem("log");
		mathOpCombo.addItem("exp");
		
		mathOpButton = new JButton("Apply");
		mathOpButton.addActionListener(new MathOpListener());
		
		JPanel controlPanel = new JPanel();
		controlPanel.add(radianCheckBox);
		controlPanel.add(createBaseButtons());
		controlPanel.add(mathOpCombo);
		controlPanel.add(mathOpButton);
		
		add(controlPanel, BorderLayout.SOUTH);
	}
	
	/** Combines two values with operator
	 * @param value1 = first value
	 * @param value2 = second value
	 * @param op = an operator (+,-,*,/, or =)
	 */
	public double calculate(double value1, double value2, String op) {
		if (op.equals("+")) {
			return value1 + value2;
		}
		else if (op.equals("-")) {
			return value1 - value2;
		}
		else if (op.equals("*")) {
			return value1 * value2;
		}
		else if (op.equals("/")) {
			return value1 / value2;
		}
		else {
			return value2;
		}
	}
	
	// Constructs listener whos actionPerformed method adds digit to display
	class DigitButtonListener implements ActionListener {
		private String digit;
		public DigitButtonListener(String aDigit) {
			digit = aDigit;
		}
		public void actionPerformed(ActionEvent event) {
			if (startNewValue) {
				display.setText("");
				startNewValue = false;
			}
			display.setToolTipText(display.getText() + digit);
		}
	}
	
	/** Makes button representing digit of a calculator
	 * @param digit = digit of the calculator
	 * @param return the button of the calculator
	 */
	public JButton makeDigitButton(String digit) {
		JButton button = new JButton(digit);
		ActionListener listener = new DigitButtonListener(digit);
		button.addActionListener(listener);
		return button;
	}
	
	// Constructs listener whos actionPerformed method schedules an operator fo execution
	class OperatorButtonListener implements ActionListener {
		private String operator;
		
		public OperatorButtonListener(String anOperator) {
			operator = anOperator;
		}		
		public void actionPerformed(ActionEvent event) {
			if (!startNewValue) {
				double value = Double.parseDouble(display.getText());
				lastValue = calculate(lastValue, value, lastOperator);
				display.setText("" + lastValue);
				startNewValue = true;
			}			
			lastOperator = operator;
		}	
	}
	
	/** Makes button representing an operator of a calculator
	 * @param op = the operator of the calculator
	 * @return button = the button of the calculator
	 * @param args
	 */
	public JButton makeOperatorButton(String op) {
		JButton button = new JButton(op);
		ActionListener listener = new OperatorButtonListener(op);
		button.addActionListener(listener);
		return button;
	}
	
	// Driver
	public static void main(String[] args) {
		JFrame frame = new Calculator();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calculator");
		frame.setVisible(true);
	}
}
