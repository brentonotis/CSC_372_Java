package test;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MovingRectangle extends JFrame {
	
	// instance variables
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;
		
	private RectangleComponent scene;
	
	// action listener interface
	class TimerListener implements ActionListener {
		// @override
		public void actionPerformed(ActionEvent event) {
			scene.moveRectangleBy(1, 1);
		}
	}
	
	// Constructor
	public MovingRectangle() {
		
		scene = new RectangleComponent();
		add(scene);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		ActionListener listener = new TimerListener();
		
		final int DELAY = 10;
		Timer t = new Timer(DELAY, listener);
		t.start();
	}
	
	// Driver
	public static void main (String[] args) {
		
		JFrame frame = new MovingRectangle();
		frame.setTitle("Moving Rectangle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}