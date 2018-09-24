package drawings;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Italian_Flag extends JComponent {
	
	/**
		Program that draws two Italian flags
	 */
	
	// Version control
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		
		drawItalianFlag(g, 10, 10, 100);
		drawItalianFlag(g, 10, 125, 150);
	}
	
	// Helper method
	void drawItalianFlag(Graphics g, int xLeft, int yTop, int width) {
		
		/**
		 	@param g - the graphics object
		 	@param xLeft - the x coordinate of the top left corner
		 	@param yTop - the y coordinates of the top left corner
		 	@param width - the width of the flag
		 */
		g.setColor(Color.GREEN);
		g.fillRect(xLeft,  yTop,  width/ 3,  width * 2/3);
		g.setColor(Color.RED);
		g.fillRect(xLeft + 2 * width / 3, yTop, width / 3, width * 2 / 3);
		g.setColor(Color.BLACK);
		g.drawLine(xLeft + width / 3,  yTop,  xLeft + width * 2 / 3,  yTop);
		g.drawLine(xLeft + width / 3,  yTop + width * 2 / 3, xLeft + width * 2 / 3, yTop + width * 2 / 3);			
	}
	
	// Driver
	public static void main (String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComponent component = new Italian_Flag();
		frame.add(component);
		
		frame.setVisible(true);
	}
}
