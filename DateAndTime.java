package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DateAndTime extends JFrame {
	
	// Variable instances
	private JButton timeButton;
	private JButton dateButton;
	private JButton bothButton;
	private JLabel dateDisplay;
	private JLabel timeDisplay;
	private JLabel titleLabel;
	private JLabel outputLabel;
	private JLabel blankLabelEast;
	private JLabel blankLabelWest;
	
	private static final int FRAME_WIDTH = 475;
	private static final int FRAME_HEIGHT = 250;

	
	
	// Constructor
	public DateAndTime() {		
		
		createLabels();
		createButtons();
		createPanels();		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	static List<Color> COLORS = new ArrayList<>();
	static {
		COLORS.add(Color.YELLOW);
		COLORS.add(Color.GREEN);
		COLORS.add(Color.GRAY);
		COLORS.add(Color.PINK);
	}
	
	
	// Create event listener via ActionListener interface
	class getDateListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Date current = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, Y");
			System.out.println(sdf.format(current));
			dateDisplay.setText("Current Date: " + sdf.format(current));
			outputLabel.setText("Console Output: " + sdf.format(current));
			getContentPane().setBackground(Color.YELLOW);
			
		}
	}
	
	// Create event listener via ActionListener interface
	class getTimeListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Date current = new Date();
			SimpleDateFormat stf = new SimpleDateFormat("hh:mm:ss");
			System.out.println(stf.format(current));
			timeDisplay.setText("Current Time: " + stf.format(current));
			outputLabel.setText("Console Output: " + stf.format(current));
			getContentPane().setBackground(Color.BLUE);
		}
	}
	
	// Create event listener via ActionListener interface
	class getBothListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Date current = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, Y");
			SimpleDateFormat stf = new SimpleDateFormat("hh:mm:ss");
			System.out.print(stf.format(current));
			System.out.println(" on " + sdf.format(current));
			dateDisplay.setText("Current Date: " + sdf.format(current));
			timeDisplay.setText("Current Time: " + stf.format(current));
			outputLabel.setText("Console Output: " + stf.format(current) + " on " + sdf.format(current));
			getContentPane().setBackground(Color.GREEN);
		}
	}	
	/** Helper methods:
	 * TODO: expand
	 */
	public void createButtons() {
				
		dateButton = new JButton("Get Date");
		ActionListener dateListener = new getDateListener();
		dateButton.addActionListener(dateListener);
		
		timeButton = new JButton("Get Time");
		ActionListener timeListener = new getTimeListener();
		timeButton.addActionListener(timeListener);
		
		bothButton = new JButton("Get Both");
		ActionListener bothListener = new getBothListener();
		bothButton.addActionListener(bothListener);			
	}
	
	public void createLabels() {
		
		dateDisplay = new JLabel("Current Date: ");
		dateDisplay.setHorizontalAlignment(JLabel.CENTER);
		timeDisplay = new JLabel("Current Time: ");
		timeDisplay.setHorizontalAlignment(JLabel.CENTER);
		titleLabel = new JLabel("Date/Time Viewer");
		outputLabel = new JLabel("Console Output: ");
		blankLabelWest = new JLabel("                 ");
		blankLabelEast = new JLabel("                 ");
	}
	
	public void createPanels() {
		
		JPanel titlePanel = new JPanel();
		titlePanel.setOpaque(false);
		titlePanel.add(titleLabel);		
		
		JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
		buttonPanel.setOpaque(false);
		buttonPanel.add(timeButton);
		buttonPanel.add(dateButton);
		buttonPanel.add(bothButton);
		
		JPanel displayPanel = new JPanel(new GridLayout(2, 1));
		displayPanel.setOpaque(false);
		displayPanel.add(timeDisplay);
		displayPanel.add(dateDisplay);
		
		JPanel outputPanel = new JPanel();
		outputPanel.add(outputLabel);
		
		JPanel centerPanel = new JPanel (new GridLayout(2, 1));
		centerPanel.setOpaque(false);
		centerPanel.add(buttonPanel);
		centerPanel.add(displayPanel);
		

		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		
		panel.add(titlePanel, BorderLayout.NORTH);
		panel.add(centerPanel, BorderLayout.CENTER);
		panel.add(outputLabel, BorderLayout.SOUTH);
		panel.add(blankLabelEast, BorderLayout.EAST);
		panel.add(blankLabelWest, BorderLayout.WEST);
		
		add(panel);
	}
	

	// Driver
	public static void main(String[] args) {

		JFrame frame = new DateAndTime();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
}

