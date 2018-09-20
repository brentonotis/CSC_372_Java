package frame;

import javax.swing.JFrame;

public class EmptyFrameViewer {
	public static void main (String[] args) {
		
		// Constructor - constructs object of the JFrame class (JFrame class part of javax.swing; Swing == Java GUI library)
		JFrame frame = new JFrame();
		
		// Set frame size
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 400;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		// Set frame title
		frame.setTitle("My first empty frame, yippee ki yay.");
		
		// Set default close operation to 'exit on close' - otherwise program remains running after frame is closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Make frame visible
		frame.setVisible(true);
		
	}
}
