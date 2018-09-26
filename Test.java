import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Test");
		JPanel panel = new JPanel();
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
		
		JButton button4 = new JButton("Red");
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setBackground(Color.RED);
			}
		});
		
		frame.getContentPane().setLayout(new BorderLayout());
		
		panel.add(button2);
		panel.add(button3);
		
		frame.getContentPane().add(button, BorderLayout.EAST);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		frame.getContentPane().add(button4, BorderLayout.WEST);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
