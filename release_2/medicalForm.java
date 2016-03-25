package package1;

import java.awt.*;
import java.awt.List;
import java.util.*;

import javax.swing.*;

/**********************************************************************
 * View Controller for the program.
 * 
 * @author Tuan
 *
 *********************************************************************/
public class MedicalForm {
	
	/******************************************************************
	 * Run the main
	 * 
	 * @param args
	 *****************************************************************/
	public static void main(String[] args) {
		new MedicalForm();
	}

	/******************************************************************
	 * Constructor. Overides runnable
	 * 
	 * 
	 *****************************************************************/
	public MedicalForm() {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {

					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException
						| InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
				}

				JFrame frame = new JFrame("GUI");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());
				frame.add(new GUIMedicalForm());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
