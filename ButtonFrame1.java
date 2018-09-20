package events;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame1 extends JFrame {
	
	// set frame size - again, no clue on the serialVersionUID line...
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 200;
	private static final int FRAME_HEIGHT = 100;
	
	// construct object
	public ButtonFrame1() {
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	// helper method
	private void createComponents() {
		JButton button = new JButton("I'm a button.");
		JPanel panel = new JPanel();
		panel.add(button);
		add(panel);
		
		// declare listener
		ActionListener listener = new ClickListener();
		
		// attach listener to button
		button.addActionListener(listener);
	}
}
