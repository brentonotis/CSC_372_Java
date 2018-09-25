package bar_chart_editor;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

public class ChartConstructor extends JComponent {

	private static final long serialVersionUID = 1L;
	private ArrayList<Bar> bars;
	private double maxValue;
	
	// Constructor - constructs empty chart
	public ChartConstructor() {
		
		bars = new ArrayList<Bar>();
		maxValue = 1;
	}
	
	/**
	 * Appends bar to the chart
	 * @param label - label of the bar
	 * @param value - value (size) of the bar
	 */
	public void append(String label, double value) {
		
		bars.add(new Bar(label, value));
		
		// Sets new maxValue if greater than current maxValue
		if (value > maxValue) {
			maxValue = value;
		}		
		// invokes repaint to display changes
		repaint();	
	}
	
	// Removes last bar from the chart
	public void removeLast() {
		
		int n = bars.size();
		
		// Checks to ensure a bar is present for removal
		if (n == 0) {
			return;
		}
		// Removes last bar and invokes repaint() method to display changes
		bars.remove(n - 1);
		repaint();
	}
	
	// Asks each bar to draw itself; stacks/spaces bars vertically and fits to component	
	public void paintComponent (Graphics g) {
		
		final int GAP = 5;
		
		int y = GAP;
		double scale = getWidth() / maxValue;
		for (Bar b : bars) {
			b.draw(g, y, scale);
			y += Bar.HEIGHT + GAP;
		}	
	}
}
