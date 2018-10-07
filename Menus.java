package menus;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** GUI utilizing menus
 * Menu items act as commands to change text font
 */

@SuppressWarnings("serial")
public class Menus extends JFrame {

	// variable instances
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;
	
	private JLabel label;
	private String facename;
	private int fontstyle;
	private int fontSize;
	
	// constructor
	public Menus() {
		// constructs text sample
		label = new JLabel("Java");
		add(label, BorderLayout.CENTER);
		label.setHorizontalAlignment(JLabel.CENTER);
		// constructs menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		menuBar.add(createFontMenu());
		
		facename = "Serif";
		fontSize = 24;
		fontstyle = Font.PLAIN;
		
		setLabelFont();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	// new exit item ActionListener
	class ExitItemListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}
	
	// creates file menu
	// @return the menu
	public JMenu createFileMenu() {
		JMenu menu =  new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		ActionListener listener = new ExitItemListener();
		exitItem.addActionListener(listener);
		menu.add(exitItem);
		return menu;
	}
	
	// creates font submenu
	// @return the menu
	public JMenu createFontMenu() {
		JMenu menu = new JMenu("Font");
		menu.add(createFaceMenu());
		menu.add(createSizeMenu());
		menu.add(createStyleMenu());
		return menu;
	}
	
	// Creates face submenu
	// @return the menu
	public JMenu createFaceMenu() {
		JMenu menu = new JMenu("Face");
		menu.add(createFaceItem("Serif"));
		menu.add(createFaceItem("SansSerif"));
		menu.add(createFaceItem("Monospaced"));
		return menu;
	}
	
	// Creates size submenu
	// @return the menu
	public JMenu createSizeMenu() {
		JMenu menu = new JMenu("Size");
		menu.add(createSizeItem("Smaller", -1));
		menu.add(createSizeItem("Larger", 1));
		return menu;
	}
	
	// Creates style submenu
	// @return the menu
	public JMenu createStyleMenu() {
		JMenu menu = new JMenu("Style");
		menu.add(createStyleItem("Plain", Font.PLAIN));
		menu.add(createStyleItem("Bold", Font.BOLD));
		menu.add(createStyleItem("Italic", Font.ITALIC));
		menu.add(createStyleItem("Bold Italic", Font.BOLD + Font.ITALIC));
		return menu;
	}
	
	/** Creates menu item to change font face and sets action listener
	 *  @param name the name of the font face
	 *  @return the menu item
	 */
	public JMenuItem createFaceItem(final String name) {
		class FaceItemListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				facename = name;
				setLabelFont();
			}
		}
		
		JMenuItem item = new JMenuItem(name);
		ActionListener listener = new FaceItemListener();
		item.addActionListener(listener);
		return item;
	}
	
	/** Creates menu item to change the font size and set its action listener
	 * @param name the name of the menu item
	 * @param increment the amount by which to change the size
	 * @return the menu item
	 */	
	public JMenuItem createSizeItem(String name, final int increment) {
		class SizeItemListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				fontSize = fontSize + increment;
				setLabelFont();
			}
		}
		
		JMenuItem item = new JMenuItem(name);
		ActionListener listener = new SizeItemListener();
		item.addActionListener(listener);
		return item;
	}
	
	/** Creates menu item to change font style and sets its action listener
	 * @param name the name of the menu item
	 * @param style the new font style
	 * @return the menu item
	 */
	public JMenuItem createStyleItem(String name, final int style) {
		class StyleItemListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				fontstyle = style;
				setLabelFont();
			}
		}
		
		JMenuItem item = new JMenuItem(name);
		ActionListener listener = new StyleItemListener();
		item.addActionListener(listener);
		return item;
	}
	
	// Sets font of sample text
	public void setLabelFont() {
		Font f = new Font(facename, fontstyle, fontSize);
		label.setFont(f);
	}
	
	// Driver
	public static void main (String[] args) {
		
		JFrame frame = new Menus();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Menus");
		frame.setVisible(true);
	}

}
