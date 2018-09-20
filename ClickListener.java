package events;

//action listener that prints message

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//button listeners must belong to a class that implements the ActionListener interface
//ActionListener interface has one method -> actionPerformed(ActionEvent event);
public class ClickListener implements ActionListener {
	
	public void actionPerformed(ActionEvent event) {
		System.out.println("Button was clicked.");
	}

}
