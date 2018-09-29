package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StopLight {
	
	JPanel lightPanel;
	JPanel buttonPanel;
	JFrame frame;
	JButton goButton;
	JButton yieldButton;
	JButton stopButton;
	int counter = 0;
	
	public void make() {
		frame = new JFrame("Stop Light");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lightPanel = new DrawStopLight();
		buttonPanel = new JPanel();

		
		goButton = new JButton("Go");
		yieldButton = new JButton("Yield");
		stopButton = new JButton("Stop");
		
		goButton.addActionListener(new GoButtonListener());
		yieldButton.addActionListener(new YieldButtonListener());
		stopButton.addActionListener(new StopButtonListener());
		
		buttonPanel.add(goButton);
		buttonPanel.add(yieldButton);
		buttonPanel.add(stopButton);
		
		frame.add(lightPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.NORTH);
		
		frame.setSize(400,  400);
		frame.setVisible(true);	
	}
	
	class GoButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			counter = 1;
			lightPanel.repaint();
		}
	}
	
	class YieldButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			counter = 2;
			lightPanel.repaint();
		}
	}
	
	class StopButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			counter = 3;
			lightPanel.repaint();
		}
	}
	
	class DrawStopLight extends JPanel {
		public void paintComponent(Graphics g) {
			frame.setSize(400, 400);
			g.setColor(Color.ORANGE);
			g.fillRect(150, 10, 100, 280);
			if (counter == 0) {
				g.setColor(Color.BLACK);			
				g.fillOval(160, 20,  80, 80);
				g.fillOval(160, 110, 80, 80);
				g.fillOval(160, 200, 80, 80);
			}
			else if (counter == 1) {
				g.setColor(Color.GREEN);			
				g.fillOval(160, 20,  80, 80);
				g.setColor(Color.BLACK);
				g.fillOval(160, 110, 80, 80);
				g.fillOval(160, 200, 80, 80);
			}
			else if (counter == 2) {
				g.setColor(Color.BLACK);			
				g.fillOval(160, 20,  80, 80);
				g.setColor(Color.YELLOW);
				g.fillOval(160, 110, 80, 80);
				g.setColor(Color.BLACK);
				g.fillOval(160, 200, 80, 80);
			}
			else {
				g.setColor(Color.BLACK);			
				g.fillOval(160, 20,  80, 80);
				g.fillOval(160, 110, 80, 80);
				g.setColor(Color.RED);
				g.fillOval(160, 200, 80, 80);
			}
		}
	}
	
	public static void main (String[] args) {
		StopLight s = new StopLight();
		s.make();
	}
}
