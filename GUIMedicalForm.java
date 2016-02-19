package package1;

import java.awt.event.*;
import java.io.File;
import java.util.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUIMedicalForm extends JFrame implements ActionListener {

	/** Main menu bar */
	private JMenuBar menus;

	/** Sub menu that hold file comands */
	private JMenu fileMenu;

	/** sub menu checkin */
	private JMenu inMenu;
	
	/** item quits gui */
	private JMenuItem exitItem;
	
	/** item open text file */
	private JMenuItem openTextItem;

	/** item save text file */
	private JMenuItem saveTextItem;
	
	private JButton checkInButton;
	
	
	public GUIMedicalForm() {
		
		// file menu
		fileMenu = new JMenu("File");
		
		// sub Menu
		exitItem = new JMenuItem("Exit");
		openTextItem = new JMenuItem("Open Text");
		saveTextItem = new JMenuItem("Save Text");
		
		fileMenu.add(openTextItem);
		fileMenu.add(saveTextItem);
		fileMenu.add(exitItem);
		
		exitItem.addActionListener(this);
		openTextItem.addActionListener(this);
		saveTextItem.addActionListener(this);
		
		// Button
		checkInButton = new JButton("CHECK IN");
		checkInButton.addActionListener(this);
		
		// menus
		
		menus = new JMenuBar();
		menu 
		
		
	}
	
	
	
	
}
