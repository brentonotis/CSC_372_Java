package bar_chart_editor;

import java.awt.Color;
import java.awt.Graphics;

public class Bar {
	
	private String label;
	private double value;
	public static final int HEIGHT = 15;
	
	/** 
	Constructs bar with given label/value
	@param label - label for the bar
	@param value - value for the bar
	*/
	public Bar(String aLabel, double aValue) {
		
		label = aLabel;
		value = aValue;
	}
	
	/**
	Draws the bar
	@param g - the graphics object
	@param y - top of the bar
	@param scale - horizontal scale factor for fitting bar into component
	*/
	public void draw(Graphics g, int y, double scale) {
		
		final int GAP = 2;
		g.fillRect(0,  y,  (int) (value * scale), HEIGHT);
		g.setColor(Color.WHITE);
		g.drawString(label,  GAP,  y + HEIGHT - GAP);
		g.setColor(Color.BLACK);
	}
}
