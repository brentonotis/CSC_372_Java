//example of utilizing inheritance to customize frames

package frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FilledFrame extends JFrame {
	
	//absolutely no clue why the line below was needed to compile, but it was; c/o Eclipse
	private static final long serialVersionUID = 1L; 
	//instance variables used as components
	private JButton button;
	private JLabel label;
	
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 100;
	
	public FilledFrame() {
		
		//helper method
		createComponents();
		
		//set size in constructor
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private void createComponents() {
		button = new JButton("I'm a button.");
		label = new JLabel("And I'm a label.");
		
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(label);
		add(panel);
	}
	
	public static void main (String[] args) {
		JFrame frame = new FilledFrame();
		frame.setTitle("A frame with two components");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
	
