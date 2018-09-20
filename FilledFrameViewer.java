package frame;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FilledFrameViewer {
	
	public static void main (String[] args) {
		
		// Constructors
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("I'm a button.");
		JLabel label = new JLabel("And I'm a label.");
		
		// Adding components to panel
		panel.add(button);
		panel.add(label);
		
		// Adding panel to frame
		frame.add(panel);
		
		// Set frame size
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 100;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		// Set frame title
		frame.setTitle("My first frame with two components");
		
		// Set default close operation to 'exit on close'
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Make frame visible
		frame.setVisible(true);
		
	}
}
