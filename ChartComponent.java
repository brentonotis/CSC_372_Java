package drawings;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JFrame;

// Extend JComponent class -> Must be done to display drawing; Cannot draw directly onto frame
public class ChartComponent extends JComponent {
	
	// Version control
	private static final long serialVersionUID = 1L;

	// Override JComponent's method paintComponent
	public void paintComponent(Graphics g) {
		
		// paintComponent method receives object type of Graphics -> Stores state and can call on its own methods
		// fillRect method draws solid rectangle from (x,y) with user-defined (height, width) -> (x, y, height, width)
		g.fillRect(0, 10, 200, 10);
		g.fillRect(0,  30, 300, 10);
		g.fillRect(0, 50, 100, 10);
		
		// draw arrow
		g.drawLine(350, 35, 305, 35);
		g.drawLine(305, 35, 310, 40);
		g.drawLine(305, 35, 310, 30);
		
		// draw highlighted oval w/ text
		g.setColor(Color.YELLOW);
		g.fillOval(350, 25, 35, 20);
		g.setColor(Color.BLACK);
		g.drawString("Best", 355, 40);	
	}
	
	// Driver
	public static void main (String[] args) {
		
		// Create frame and configure
		JFrame frame = new JFrame();	
		frame.setSize(500, 400);
		frame.setTitle("Bar Chart");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create new ChartComponent() object and add to frame
		JComponent component = new ChartComponent();
		frame.add(component);
		frame.setVisible(true);	
	}
}

	