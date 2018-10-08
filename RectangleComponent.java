package test;

import java.awt.Graphics;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class RectangleComponent extends JComponent {
	
	// instance variables
	private static final int RECTANGLE_WIDTH = 20;
	private static final int RECTANGLE_HEIGHT = 30;
	
	private int xLeft;
	private int yTop;
	
	// Constructor, initialize rectangle to upper left-hand corner of frame
	public RectangleComponent() {
		xLeft = 0;
		yTop = 0;
	}
	
	// @override
	public void paintComponent(Graphics g) {
		g.fillRect(xLeft,  yTop,  RECTANGLE_WIDTH,  RECTANGLE_HEIGHT);
	}
	
	// moves rectangle by 1px down and to the right
	public void moveRectangleBy(int dx, int dy) {
		xLeft = xLeft + dx;
		yTop = yTop + dy;
		repaint();
	}
}
