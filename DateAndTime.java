package test;

/** Program displaying a GUI that displays current time and/or date when user clicks appropriate button.
 * Background color changes to a random color each time a user clicks any button.
 * Output label at bottom of GUI displays console output.
 */

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
	
	// Create event listener via ActionListener interface
	class getDateListener implements ActionListener {
		// @override
		public void actionPerformed(ActionEvent event) {
			// Create new Date object (to get the most current date/time when event is triggered)
			Date current = new Date();
			// Create SimpleDateFormat object with specified style (getting date only)
			SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, Y");
			// Output current date in specified SimpleDateFormat
			System.out.println(sdf.format(current));
			dateDisplay.setText("Current Date: " + sdf.format(current));
			outputLabel.setText("Console Output: " + sdf.format(current));
			// Change background color to random color - gets random number and multiplies by hex value
			getContentPane().setBackground(new Color((int)(Math.random() * 0x1000000)));	
		}
	}
	
	// Create event listener via ActionListener interface
	class getTimeListener implements ActionListener {
		// @override
		public void actionPerformed(ActionEvent event) {
			// Create new Date object (to get the most current date/time when event is triggered)
			Date current = new Date();
			// Create SimpleDateFormat object with specified style (getting time only)
			SimpleDateFormat stf = new SimpleDateFormat("hh:mm:ss");
			// Output current time in specified SimpleDateFormat
			System.out.println(stf.format(current));
			timeDisplay.setText("Current Time: " + stf.format(current));
			outputLabel.setText("Console Output: " + stf.format(current));
			// Change background color to random color - gets random number and multiplies by hex value
			getContentPane().setBackground(new Color((int)(Math.random() * 0x1000000)));
		}
	}
	
	// Create event listener via ActionListener interface
	class getBothListener implements ActionListener {
		// @override
		public void actionPerformed(ActionEvent event) {
			// Create new Date object (to get most current date/time when event is triggered)
			Date current = new Date();
			// Create SimpleDateFormat object with specified style (getting both time and date)
			SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, Y");
			SimpleDateFormat stf = new SimpleDateFormat("hh:mm:ss");
			// Output current time and date in specified SimpleDateFormat
			System.out.print(stf.format(current));
			System.out.println(" on " + sdf.format(current));
			dateDisplay.setText("Current Date: " + sdf.format(current));
			timeDisplay.setText("Current Time: " + stf.format(current));
			outputLabel.setText("Console Output: " + stf.format(current) + " on " + sdf.format(current));
			// Change background color to random color - gets random number and multiplies by hex value
			getContentPane().setBackground(new Color((int)(Math.random() * 0x1000000)));
		}
	}	
	/** Helper methods:
	 * Create buttons and action listeners, attach listeners to buttons
	 * Create labels, set horizontal alignment to center where needed
	 * Create panels, set panels to opaque (to reveal content pane for color change)
	 * Set layout managers per panel (Grid & Border) and add panels to main panel
	 * Add main panel to frame
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
