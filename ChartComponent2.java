package investment_frame;

import javax.swing.JComponent;
import java.util.ArrayList;
import java.awt.Graphics;

public class ChartComponent2 extends JComponent {
	
	// Version control
	private static final long serialVersionUID = 1L;
	// Initialize ArrayList to store bar chart values & maxValue for max
	private ArrayList<Double> values;
	private double maxValue;
	
	// Constructor
	public ChartComponent2(double max) {		
		values = new ArrayList<Double>();
		maxValue = max;		
	}
	
	// adds value to ArrayList, repaint() forces call to paintComponent() method
	public void append (double value) {		
		values.add(value);
		repaint();
	}
	
	public void paintComponent (Graphics g) {
		final int GAP = 5;
		final int BAR_HEIGHT = 10;
		
		int y = GAP;
		for (double value: values) {
			// getWidth() returns width of component in pixels; maxValue = stretches across entire width of component
			int barWidth = (int) (getWidth() * value / maxValue);
			g.fillRect(0, y, barWidth, BAR_HEIGHT);
			y = y + BAR_HEIGHT + GAP;
		}	
	}
}
