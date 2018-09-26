package test;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Blue");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setBackground(Color.BLUE);
			}
		});
		
		JButton button2 = new JButton("Yellow");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setBackground(Color.YELLOW);
			}
		});
		
		JButton button3 = new JButton("Green");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setBackground(Color.GREEN);
			}
		});
		
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(button);
		frame.getContentPane().add(button2);
		frame.getContentPane().add(button3);
		
		frame.setSize(300,  300);
		frame.setVisible(true);
	}
}
