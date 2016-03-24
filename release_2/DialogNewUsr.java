package package1;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;

/****************************************************
 * Dialog input info into RV
 * 
 * @author Tuan Nguyen
 *
 ***************************************************/
@SuppressWarnings("serial")
public class DialogNewUsr extends JDialog implements ActionListener {

	/** Field holds the text of the name of the person registering */
	private JTextField nameTxt;

	/** Field holds the text of the date */
	private JTextField dateRegTxt;

	/** Field holds the text of date of birth */
	private JTextField birthTxt;

	/** Field holds the Gender */
	private JRadioButton genderM;

	/** Field holds the Gender */
	private JRadioButton genderF;

	/** Field holds the Gender */
	private JRadioButton genderO;

	/** Field holds the text of gender of other */
	private JTextField genderTxt;

	/** button completes the dialog */
	private JButton okButton;

	/** button cancels the dialog */
	private JButton cancelButton;

	/** Determine if the dialog has closed */
	private boolean closeStatus;

	/** Desired format MM/dd/yyyy */
	private SimpleDateFormat dateformat;

	/** The RV being created */
	private Patient unit;

	/****************************************************
	 * Constuctor for Dialog
	 * 
	 * @param paOccupy
	 * @param r
	 ***************************************************/
	public DialogNewUsr(JFrame parent, Patient p) {

		super(parent, true);
		unit = p;
		setTitle("Add Patient");
		closeStatus = false;
		setSize(400, 200);
		dateformat = new SimpleDateFormat("MM/dd/yyyy");

		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		JPanel textpanel = new JPanel();
		textpanel.setLayout(new GridLayout(6, 2));

		// Name
		textpanel.add(new JLabel("Patient:"));
		nameTxt = new JTextField("Mary Doe", 30);
		textpanel.add(nameTxt);

		// date
		textpanel.add(new JLabel("Birth Date"));
		birthTxt = new JTextField(dateformat.format(Calendar
			.getInstance().getTime()), 30);
		textpanel.add(birthTxt);

		// Gender
		textpanel.add(new JLabel("Gender:"));
		genderM = new JRadioButton("Male");
		genderF = new JRadioButton("Female");
		genderO = new JRadioButton("Other");
		genderTxt = new JTextField("", 30);
		JPanel group = new JPanel();
		group.add(genderM);
		group.add(genderF);
		group.add(genderO);

		textpanel.add(genderTxt);

		getContentPane().add(textpanel, BorderLayout.CENTER);

		// Makes buttons
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		JPanel buttonpanel = new JPanel();
		buttonpanel.add(okButton);
		buttonpanel.add(cancelButton);

		getContentPane().add(buttonpanel, BorderLayout.SOUTH);
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);

		setSize(300, 300);
		setVisible(true);
	}

	/***************************************************
	 * ActionListeners listen to actions
	 ***************************************************/
	public void actionPerformed(ActionEvent e) {

		JButton button = (JButton) e.getSource();

		if (button == okButton) {
			closeStatus = true;

			// the date that will be added
			Date d;

			// checks if name is proper and adds to unit
			if (verifyWord(nameTxt.getText()))
				unit.setName(nameTxt.getText());

			try {
				// properly formats regardless of the number of year
				// digits.

				DateFormat input = new SimpleDateFormat("MM/dd/yy");
				DateFormat output = dateformat;

				Date temp = input.parse(birthTxt.getText().trim());
				d = output.parse(output.format(temp));

				GregorianCalendar opened = new GregorianCalendar();
				opened.setTime(d);
				unit.setBirth(opened);

			} catch (ParseException ex) {
				unit.setBirth(null);
			}
		}
		dispose();
	}

	/****************************************************
	 * Determines if the dialog closed properly
	 * 
	 * @return
	 ***************************************************/
	public boolean isCloseStatus() {
		return closeStatus;
	}

	/****************************************************
	 * verify if the string is an integer
	 * 
	 * @param str
	 *            is string to be verified
	 * @return true if is integer
	 ***************************************************/
	private boolean verifyInteger(String str) {
		if (str != null && str.length() > 0) {
			if (str.matches("[0-9]+"))
				return true;
		}
		return false;
	}

	/****************************************************
	 * Verify if string is alphabetic
	 * 
	 * @param str
	 *            is string to be verified
	 * @return true if is alphabetic
	 ***************************************************/
	private boolean verifyWord(String str) {
		if (str != null && str.length() > 0) {
			if (str.matches("([a-zA-Z]+\\s+)*[a-zA-Z]+"))
				return true;
		}
		return false;
	}

}
