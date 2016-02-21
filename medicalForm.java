package package1;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class medicalForm {

	public static void main(String[] args) {
		// Sets up a JFrame called frame
		JFrame frame = new JFrame("Medical Form");

		// Sets up basic functions for this frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create menu

		// fileMenu is the menu button that holds quit and new game
		JMenu fileMenu = new JMenu("File");

		// quitItem will quit the game if clicked
		JMenuItem quitItem = new JMenuItem("Exit");

		// newGameItem will reset the game
		JMenuItem newStart = new JMenuItem("Restart");

		// sub Menu
		JMenuItem openTextItem = new JMenuItem("Open Text");

		JMenuItem saveTextItem = new JMenuItem("Save Text");

		// menu is the menu bar for the fileMenu
		JMenuBar menu = new JMenuBar();

		// Add the menu
		fileMenu.add(newStart);
		fileMenu.add(quitItem);
		fileMenu.add(openTextItem);
		fileMenu.add(saveTextItem);
		frame.setJMenuBar(menu);
		menu.add(fileMenu);

		// Calls and implements the SurroundPanel class
		GUIMedicalForm panel = new GUIMedicalForm(newStart, quitItem,
			openTextItem, saveTextItem);
		frame.getContentPane().add(panel);

		frame.pack();
		frame.setVisible(true);
	}
}
