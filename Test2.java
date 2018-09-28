package test;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Test2 {
	
	// initialize JButton array (for calculator buttons)
	private static JButton[] arrayBtn;
	
	public static void main(String[] args) {
		
		// create new JFrame
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set grid rows/columns and distance between 
		GridLayout grid = new GridLayout(5, 3, 10, 10);
		
		// set frame layout to grid
		frame.setLayout(grid);
		
		// create new text field and add with text to frame
		JTextArea text = new JTextArea();
		text.setText("Answer");
		text.setEditable(false);
		frame.add(text);
		
		// add buttons to frame
		frame.add(new JButton("+"));
		frame.add(new JButton("="));
		
		// create new JButton array and specify length
		arrayBtn = new JButton[10];
		
		// add JButtons by looping through arrayBtn array
		for (int i = 0; i < arrayBtn.length; ++i) {
			arrayBtn[i] = new JButton(Integer.toString(i));
			frame.add(arrayBtn[i]);
		}
			
		// set frame size and make visible
		frame.setSize(300, 300);
		frame.setVisible(true);
		
	}
}
