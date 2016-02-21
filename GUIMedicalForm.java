package package1;

import java.awt.event.*;
import java.io.File;
import java.util.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUIMedicalForm extends JPanel{

	private JMenuItem newStart;
	
	private JMenuItem quitItem;
	
	private JMenuItem openTextItem;
	
	private JMenuItem saveTextItem;
	
	private JFileChooser fileChooser;
	
	JButton normalUser;
	
	JButton powerUser;
	
	private CardLayout cl;
	
	private ActionListener listen;
	
	public GUIMedicalForm(JMenuItem newStart, JMenuItem quitItem, JMenuItem openTextItem, JMenuItem saveTextItem) {
		
		this.newStart = newStart;
		this.quitItem = quitItem;
		this.openTextItem = openTextItem;
		this.saveTextItem = saveTextItem;
		
		listen = new ButtonListener(); 
		
		newStart.addActionListener(listen);
		quitItem.addActionListener(listen);
		openTextItem.addActionListener(listen);
		saveTextItem.addActionListener(listen);
		fileChooser = new JFileChooser();
		cl = new CardLayout();
		
		setSize(600, 720);
		
		// start
		startPanel();
	}
	
	private void startPanel() {

		JPanel startPanel = new JPanel();

		normalUser = new JButton("Normal User");
		powerUser = new JButton("Power User");
		
		JPanel norm = new JPanel();
		norm.setLayout(new GridLayout(2, 2));
		norm.add(new JLabel("Set this program to be used by Patients"));
		norm.add(normalUser);
		
		JPanel power = new JPanel();
		power.setLayout(new GridLayout(2,2));
		power.add(new JLabel("Set this program to be used by Administrators"));


		norm.add(normalUser);
		power.add(powerUser);

		startPanel.add(norm);
		startPanel.add(power);
		
		normalUser.addActionListener(listen);
		powerUser.addActionListener(listen);
		
		this.add(startPanel);
	}
	
	private void patientStartPanel() {
		
	}
	
	private void newUserSignUp() {
		
	}
	
	private void userLogin() {
		
	}
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if (quitItem == e.getSource()){
				System.exit(0);
			}
			
			// open text file
					if (openTextItem == e.getSource()) {

						// filter file type
						FileNameExtensionFilter filter = new FileNameExtensionFilter(
							"Text Document", "txt");
						
						fileChooser.setFileFilter(filter);
						
						int returnVal = fileChooser.showOpenDialog(null);
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							if (fileChooser.getSelectedFile().canRead()
								&& fileChooser.getSelectedFile().getPath()
									.contains(".txt")) {
								
								File file = fileChooser.getSelectedFile();
								
								// medicalModel openext function
								
							} else
								JOptionPane.showMessageDialog(null,
									"Not executable file");
						}
					}

					// save text file
					if (saveTextItem == e.getSource()) {

						// filter file type
						FileNameExtensionFilter filter = new FileNameExtensionFilter(
							"Text Document",
							"txt");
						fileChooser.setFileFilter(filter);
						int returnVal = fileChooser.showSaveDialog(null);

						if (returnVal == JFileChooser.APPROVE_OPTION) {
							File file = new File(fileChooser
								.getSelectedFile()
								+ ".txt");
							
							// medicalmodel savetext
								
						}
					}
		}
	}
}
