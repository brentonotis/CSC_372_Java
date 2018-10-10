package mouse_events;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

/** 
Frame containing a moving rectangle
*/

@SuppressWarnings("serial")
public class RectangleFrame2 extends JFrame {
	// Instance variables
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;
	
	private RectangleComponent2 scene;
	
	// MouseListener interface
	class MousePressListener implements MouseListener {
		// @override
		public void mousePressed(MouseEvent event) {
			// gets x & y value of mouse point, sets to x & y
			int x = event.getX();
			int y = event.getY();
			// moves rectangle component to mouse point (x & y)
			scene.moveRectangleTo(x, y);
		}
		
		// Do-nothing methods
		public void mouseReleased(MouseEvent event) {}
		public void mouseClicked(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
	}
	
	// Constructor
	public RectangleFrame2() {
		scene = new RectangleComponent2();
		add(scene);
		
		MouseListener listener = new MousePressListener();
		scene.addMouseListener(listener);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	// Driver
	public static void main (String[] args) {
		JFrame frame = new RectangleFrame2();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
	

