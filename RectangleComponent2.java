package mouse_events;

import java.awt.Graphics;
import javax.swing.JComponent;

/** 
Component displays rectangle that can be moved
*/

@SuppressWarnings("serial")
public class RectangleComponent2 extends JComponent {
	// Instance variables
	private static final int RECTANGLE_WIDTH = 20;
	private static final int RECTANGLE_HEIGHT = 30;
	
	private int xLeft;
	private int yTop;
	
	// Constructor
	public RectangleComponent2() {
		xLeft = 0;
		yTop = 0;
	}
	
	// @override paintComponent
	public void paintComponent(Graphics g) {
		// draw rectangle
		g.fillRect(xLeft,  yTop,  RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
	}
	
	/**
	  Moves rectangle to the given location
	  @param x - the x-position of the new location
	  @param y - the y-position of the new locationo
	 */
	public void moveRectangleTo(int x, int y) {
		xLeft = x;
		yTop = y;
		repaint();
	}
}
