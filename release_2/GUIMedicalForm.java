package package1;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.sun.xml.internal.txw2.Document;

/**********************************************************************
 * Main GUI
 * 
 * @author Tuan
 *
 *********************************************************************/

public class GUIMedicalForm extends JPanel {

	/** controller manipulates CardLayout */
	private final DefaultViewController controller;

	/** List keeps track of all checkboxes */
	private ArrayList<JCheckBox> boxes;

	/** List keeps track of all radio buttons */
	private ArrayList<JRadioButton> radios;

	/** List keeps track of all text fields */
	private ArrayList<JTextField> fields;

	/** Desired format MM/dd/yyyy */
	private SimpleDateFormat dateformat;

	/******************************************************************
	 * Constructor
	 *****************************************************************/
	public GUIMedicalForm() {

		super();

		// instantiate the fields
		CardLayout cl = new CardLayout();
		setLayout(cl);
		boxes = new ArrayList<>();
		radios = new ArrayList<>();
		fields = new ArrayList<>();
		dateformat = new SimpleDateFormat("MM/dd/yyyy");

		// display the view
		controller = new DefaultViewController(this, cl);
		controller.addView(startPane(), DefaultViewController.START);
		controller.addView(nrmUsrPane(), "NrmUsr");
		controller.addView(newUsrPane(), "NewUsr");
		controller.addView(pageOne(), "PageOne");
		controller.addView(pageTwo(), "PageTwo");
		controller.addView(pageThree(), "PageThree");
		// controller.addView(pageFour(), "PageFour");
		// controller.addView(pageFive(), "PageFive");
		// controller.addView(pageSix(), "PageSix");
		// controller.addView(pageSeven(), "PageSeven");
		// controller.addView(pageEight(), "PageEight");
		controller.goHome();

		// set size
		this.setPreferredSize(new Dimension(900, 600));
		this.revalidate();
	}

	/******************************************************************
	 * Create the card for the start
	 * 
	 * @return JPanel of the initial startup pane
	 *****************************************************************/
	protected JPanel startPane() {

		JPanel start = new JPanel();
		start.setBorder(BorderFactory.createEmptyBorder(40, 40, 40,
				40));

		// View panel
		JPanel view = new JPanel(new BorderLayout());

		JPanel norm = new JPanel();
		JPanel power = new JPanel();
		JButton nrmUsr = new JButton("Normal User");
		JButton pwrUsr = new JButton("Power User");

		JPanel normTxt = new JPanel();
		normTxt.setBorder(BorderFactory
				.createEmptyBorder(0, 0, 0, 20));
		normTxt.add(new JLabel("Set up this program for patients"));

		JPanel normButton = new JPanel();
		normButton.add(nrmUsr);

		norm.setLayout(new BorderLayout());
		norm.add(normTxt, BorderLayout.WEST);
		norm.add(normButton, BorderLayout.EAST);

		JPanel powerTxt = new JPanel();
		powerTxt.setBorder(BorderFactory.createEmptyBorder(0, 0, 0,
				20));
		powerTxt.add(new JLabel(
				"Set up this program for Administrators"));

		JPanel powerButton = new JPanel();
		powerButton.add(pwrUsr);

		power.setLayout(new BorderLayout());
		power.add(powerTxt, BorderLayout.WEST);
		power.add(powerButton, BorderLayout.EAST);

		view.setLayout(new BoxLayout(view, BoxLayout.PAGE_AXIS));
		view.setBorder((BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		view.add(Box.createRigidArea(new Dimension(0, 5)));
		view.add(norm);
		view.add(Box.createRigidArea(new Dimension(0, 5)));
		view.add(power);
		view.add(Box.createGlue());

		nrmUsr = addAction(nrmUsr, "NrmUsr");

		start.add(view);

		return start;
	}

	/******************************************************************
	 * Create the pane which Patient will sign-in as new or old
	 * 
	 * @return the sign in Pane
	 *****************************************************************/
	protected JPanel nrmUsrPane() {

		// main pane
		JPanel nrmUsrPane = new JPanel(new BorderLayout());
		nrmUsrPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5,
				5));

		// Control panel w/ buttons
		JPanel controls = new JPanel();
		controls.setBorder(BorderFactory.createEmptyBorder(40, 40,
				40, 40));
		JButton signIn = new JButton("Sign In");
		JButton newUsr = new JButton("Sign In as New ");

		controls.add(signIn);
		controls.add(newUsr);

		nrmUsrPane.add(controls, BorderLayout.CENTER);

		newUsr = addAction(newUsr, "NewUsr");

		nrmUsrPane.setMinimumSize(nrmUsrPane.getSize());

		return nrmUsrPane;
	}

	/******************************************************************
	 * New Users will place in their info
	 * 
	 * @return the New User Pane
	 *****************************************************************/
	protected JPanel newUsrPane() {

		Patient p = new Patient();

		// main pane
		JPanel newUsrPane = new JPanel();
		newUsrPane.setBorder(BorderFactory.createEmptyBorder(20, 20,
				20, 20));

		newUsrPane.setLayout(new BorderLayout());

		// view
		Box view = Box.createVerticalBox();

		view.setBorder(BorderFactory
				.createEmptyBorder(20, 20, 20, 20));
		JPanel namepane = createJTextField("Patient Name:");
		view.add(namepane);
		JPanel birthpane =
				createJTextField("Birth Date:", dateformat
						.format(Calendar.getInstance().getTime()));
		view.add(birthpane);

		// Gender
		JPanel gender = new JPanel();
		JLabel gt = new JLabel("Gender:");
		gt.setAlignmentX(LEFT_ALIGNMENT);
		gender.add(gt);

		String[] genders = { "Male", "Female", "Other" };
		JPanel gpanel = createRadios(genders, 3, 1);
		gender.add(gpanel);
		view.add(gender);
		// add to

		newUsrPane.add(view, BorderLayout.CENTER);

		// Makes buttons
		JButton okButton;
		JButton cancelButton;
		okButton = new JButton("Next");
		cancelButton = new JButton("Cancel");
		JPanel buttonpanel = new JPanel();
		buttonpanel.add(cancelButton);
		buttonpanel.add(okButton);

		newUsrPane.add(buttonpanel, BorderLayout.SOUTH);

		okButton = addAction(okButton, "PageOne");
		cancelButton = addAction(cancelButton, "NrmUsr");

		newUsrPane.setMinimumSize(newUsrPane.getSize());

		return newUsrPane;
	}

	/******************************************************************
	 * Create Page 1
	 * 
	 * @return page 1
	 *****************************************************************/
	protected JScrollPane pageOne() {

		// main pane
		JPanel pageOne = new JPanel();

		pageOne.setLayout(new BorderLayout());
		pageOne.setBorder(BorderFactory.createEmptyBorder(20, 20, 20,
				20));

		// view panel
		JPanel view = new JPanel();
		view.setLayout(new BoxLayout(view, BoxLayout.PAGE_AXIS));
		view.setBorder(BorderFactory
				.createEmptyBorder(20, 20, 20, 20));

		// sub panels
		JPanel ques1 = createQuestion("How did you hear about OAM");
		JPanel ques2 =
				createQuestion("<html>What is the "
						+ "main Reason for " + "today's visit <br>	"
						+ "Where is Your Main "
						+ "Compaint (Select One)</html>");
		JPanel ques3 = createQuestion("Which Side?");
		JPanel ques4 = createQuestion("What Type of Problem is It?");
		JPanel ques5 =
				createQuestion("What Other Problems Have You "
						+ "Had Related to "
						+ "This Problem? (select all that apply)");

		// Combobox/radio

		// question 1
		String[] ques1_1 =
				{ "friend/family", "my doctor", "insurance company",
						"case manager", "ER/med center",
						"newspaper ad", "I am a previous" };
		JPanel rques1_1 = createCheckBoxes(ques1_1, 7, 1);

		String[] ques1_2 =
				{ "internet search", "TV commercial",
						"therapist/trainer", "worker's compensation",
						"billboard", "other" };
		JPanel rques1_2 = createCheckBoxes(ques1_2, 6, 1);
		ques1.add(rques1_1, BorderLayout.WEST);
		ques1.add(rques1_2, BorderLayout.EAST);

		// question 2
		String[] ques2_1 =
				{ "Shoulder", "Forearm", "Neck", "Pelvis", "Knee",
						"Upper Arm", "Wrist", "Neck and Arm", "Hip",
						"LowerLeg", "Elbow", "Hand", "Back", "Leg",
						"Ankel", "Arm", "Finger(s)", "Back and Leg",
						"Thigh", "Foot" };
		JPanel rques2_1 = createRadios(ques2_1, 4, 5);
		ques2.add(rques2_1, BorderLayout.CENTER);

		// question 3
		String[] ques3_1 = { "Right", "Left", "Both", "N/A" };
		JPanel rques3_1 = createRadios(ques3_1, 4, 1);
		ques3.add(rques3_1, BorderLayout.CENTER);

		// question 4
		String[] ques4_1 =
				{ "Pain", "Fracture/Broken Bone", "Swelling",
						"Numbness", "Deformity", "Injury", "Sprain",
						"Weakness", "Tingling", "Wound",
						"Instability", "Mass/Lump", "Stiffness",
						"Locking", "Laceration", "Clicking" };
		JPanel rques4_1 = createRadios(ques4_1, 4, 4);
		ques4.add(rques4_1, BorderLayout.CENTER);

		// question 5
		String[] ques5_1 =
				{ "Fever", "Numbness/Tingling", "Weakness",
						"Night Pain", "Swelling",
						"Stiffness/Loss of Motion",
						"Bowel/Bladder Dysfunction", "Tenderness",
						"Joint Locking", "Unintentional Weight Loss",
						"Brusing" };

		JPanel rques5_1 = createRadios(ques5_1, 4, 3);
		ques5.add(rques5_1, BorderLayout.CENTER);
		ques5.add(createJTextField("Other: "), BorderLayout.SOUTH);

		// add to view
		view.add(ques1);
		view.add(ques2);
		view.add(ques3);
		view.add(ques4);
		view.add(ques5);

		// Control panel w/ buttons
		JPanel controls = createControlPane("NewUsr", "PageTwo");
		JButton capture = new JButton("Capture");
		capture.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				BufferedImage image = getScreenShot(view, true);
				saveScreenShot(image, "pageOne_Capture");
			}
		});

		controls.add(capture);

		// add to page
		pageOne.add(view);
		pageOne.add(controls, BorderLayout.SOUTH);

		JScrollPane scroll = new JScrollPane(pageOne);
		return scroll;
	}

	/******************************************************************
	 * Create second page
	 * 
	 * @return panel of second page
	 *****************************************************************/
	protected JScrollPane pageTwo() {

		// main pane
		JPanel pageTwo = new JPanel();

		pageTwo.setLayout(new BorderLayout());
		pageTwo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20,
				20));

		// view panel
		JPanel view = new JPanel();
		view.setLayout(new BoxLayout(view, BoxLayout.PAGE_AXIS));
		view.setBorder(BorderFactory
				.createEmptyBorder(20, 20, 20, 20));

		// sub panels
		JPanel ques1 =
				createQuestion("Describe How It Feels(select "
						+ "all that apply)");
		JPanel ques2 =
				createQuestion("When Did Your Symptoms Start?");
		JPanel ques3 = createQuestion("Are Your Symptoms: ");
		JPanel ques4 =
				createQuestion("What Makes Your Symptoms Worse?"
						+ " (select all that apply");
		JPanel ques5 =
				createQuestion("What Makes Your Symptoms "
						+ "Better? (select all that apply");

		// Combobox/radio

		// question 1
		String[] ques1_1 =
				{ "I have no symptoms", "Aching", "Burning", "Dull",
						"Sharp", "Shooting", "Throbbing", "weakness",
						"On and Off" };
		JPanel cques1_1 = createCheckBoxes(ques1_1, 3, 4);
		ques1.add(cques1_1);

		// question 2
		String[] ques2_1 = { "At Birth", "Approximately", "Sudden" };
		JPanel rques2_1 = createRadios(ques2_1, 3, 1);
		ques2.add(rques2_1, BorderLayout.WEST);
		ques2.add(this.createJTextField("When: "), BorderLayout.EAST);

		// question 3
		String[] ques3_1 = { "Improving", "No Change", "Worsening" };
		JPanel rques3_1 = createRadios(ques3_1, 3, 1);
		ques3.add(rques3_1, BorderLayout.CENTER);

		// question 4
		String[] ques4_1 =
				{ "Nothing", "Everything", "Repetition", "Exercise",
						"Forceful Work", "Activity", "Lying",
						"Sitting", "Standing", "Walking", "Driving",
						"Running", "Jumping", "Squatting",
						"Sitting to Standing", "Climbing Stairs",
						"Pinching", "Gripping", "Lifting", "Bending",
						"Overhead Use", "Pushing", "Throwing",
						"Cold", "Twisting", "Vibration", "Heat" };
		JPanel rques4_1 = createRadios(ques4_1, 4, 7);
		ques4.add(rques4_1, BorderLayout.CENTER);
		ques4.add(createJTextField("Other: "), BorderLayout.SOUTH);

		// question 5
		String[] ques5_1 =
				{ "Nothing", "Rest", "Sling", "Brace/Splint",
						"Elevation", "Sitting", "Standing", "Lying",
						"Walking", "Stretching", "Ice", "Heat",
						"Therapy", "Injections", "Massage",
						"Prescription medications",
						"Over-the-counter Medications" };

		JPanel rques5_1 = createRadios(ques5_1, 4, 7);
		ques5.add(rques5_1, BorderLayout.CENTER);
		ques5.add(createJTextField("Other: "), BorderLayout.SOUTH);

		// add to view
		view.add(ques1);
		view.add(ques2);
		view.add(ques3);
		view.add(ques4);
		view.add(ques5);

		// Control panel w/ buttons
		JPanel controls = createControlPane("PageOne", "PageThree");

		// add to page
		pageTwo.add(view);
		pageTwo.add(controls, BorderLayout.SOUTH);

		JScrollPane scroll = new JScrollPane(pageTwo);
		return scroll;
	}

	/******************************************************************
	 * Create page Three
	 * 
	 * @return panel of Page Three
	 *****************************************************************/
	protected JScrollPane pageThree() {

		// main pane
		JPanel pageThree = new JPanel();

		pageThree.setLayout(new BorderLayout());
		pageThree.setBorder(BorderFactory.createEmptyBorder(20, 20,
				20, 20));

		// view panel
		JPanel view = new JPanel();
		view.setLayout(new BoxLayout(view, BoxLayout.PAGE_AXIS));
		view.setBorder(BorderFactory
				.createEmptyBorder(20, 20, 20, 20));

		// sub panels
		JPanel ques1 =
				createQuestion("Past Medical History "
						+ "(please select all that apply)");
		JPanel ques2 = createQuestion("");
		JPanel ques3 = createQuestion("");
		JPanel ques4 = createQuestion("");
		JPanel ques5 = createQuestion("");
		JPanel ques6 = createQuestion("Cancer");
		JPanel ques7 = createQuestion("");
		JPanel ques8 = createQuestion("");
		JPanel ques9 = createQuestion("");
		JPanel ques10 = createQuestion("");
		JPanel ques11 = createQuestion("");
		JPanel ques12 = createQuestion("");
		JPanel ques13 = createQuestion("");
		JPanel ques14 = createQuestion("");
		JPanel ques15 = createQuestion("");

		// Combobox/radio
		// question 1
		ques1.add(createCheckBox("I have no significant past medical history"));

		// question 2
		String[] sques2_1 = { "Eye Disease", "Hearing Loss" };
		JPanel cques2_1 = createCheckBoxes(sques2_1, 2, 1);
		ques2.add(cques2_1);

		// question 3
		String[] sques3_1 =
				{ "Asthma", "COPD", "Emphysema", "Turberculosis",
						"Sleep Apnea" };
		JPanel cques3_1 = createCheckBoxes(sques3_1, 5, 1);
		ques3.add(cques3_1);

		// question 4
		String[] sques4_1 =
				{ "Angina", "Atrial Fibrillation", "Heart Disease",
						"Heart Attack", "Heart Murmur",
						"High Cholesterol", "High Blood Pressure",
						"Mitrial Valve Prolapse" };
		JPanel cques4_1 = createCheckBoxes(sques4_1, 8, 1);
		ques4.add(cques4_1);

		// question 5
		String[] sques5 =
				{ "AIDS/HIV", "Anemia", "Bleeding Disorders",
						"Blood Clots", "Hemophilia", "MRSA", "MSSA",
						"Sickle Cell Disease" };
		JPanel cques5 = createCheckBoxes(sques5, 8, 1);
		ques5.add(cques5);
		// question 6
		String[] sques6 =
				{ "Bowel Disese", "GERD/Ulcers",
						"Hiatal Hernia(upper stomach)",
						"Inguinal Hernia(groin)",
						"Irritable Bowel Syndrome", "Kidney Disease",
						"Kidney Stones", "Umbilica Hernia (abdomen)",
						"Urinary Tract Ifections" };
		JPanel cques6 = createCheckBoxes(sques6, 8, 1);
		ques6.add(cques6);

		// question 7
		ques7.setLayout(new BorderLayout());
		ques7.add(new JLabel("Cancer"), BorderLayout.NORTH);
		ques7.add(createJTextField("type"), BorderLayout.SOUTH);

		// question 8
		String sques8[] =
				{ "Cerebral Palsy", "Menigitis",
						"Migraine Headaches", "Migraine Headaches",
						"Multiple Sclerosis", "Parkinson's Disease",
						"Peripheral Neuropathy", "Polio",
						"Seizure Disorder", "Spina Bifida", "Stroke" };
		JPanel cques8 = createCheckBoxes(sques8, 10, 1);
		ques8.add(cques8);

		// question 9
		String sques9[] =
				{ "Back Problems", "Fibromyalgia",
						"Muscular Diseases", "Scoliosis" };
		JPanel cques9 = createCheckBoxes(sques9, 4, 1);
		ques9.add(cques9);

		// question 10
		String sques10[] =
				{ "Gout", "Low Bone Mass/Osteopenia", "Lupus",
						"Osteoarthritis", "Osteoporosis",
						"Rheumatoid Arthritis" };
		JPanel cques10 = createCheckBoxes(sques10, 6, 1);
		ques10.add(cques10);

		// question 11
		String sques11[] =
				{ "Liver Disease", "ADD/ADHD", "Alcohol Abuse",
						"Anxiety", "Bipolar Disorder", "Depression",
						"Drug Abuse", "Mental Disability", "OCD",
						"Prescription Drug Abuse",
						"Preadolescent Sexual Abuse", "Schizophrenia" };
		JPanel cques11 = createCheckBoxes(sques11, 12, 1);
		ques11.add(cques11);

		// add to view
		view.add(ques1);
		view.add(ques2);
		view.add(ques3);
		view.add(ques4);
		view.add(ques5);
		view.add(ques6);
		view.add(ques7);
		view.add(ques8);
		view.add(ques9);
		view.add(ques10);
		view.add(ques11);

		// Control panel w/ buttons
		JPanel controls = createControlPane("PageTwo", "PageFour");

		// add to page
		pageThree.add(view);
		pageThree.add(controls, BorderLayout.SOUTH);

		JScrollPane scroll = new JScrollPane(pageThree);
		return scroll;
	}

	// /***************************************************************
	// * Create Page Four
	// *
	// * @return panel of Page Four
	// ***************************************************************/
	// protected JScrollPane pageFour() {
	//
	// }
	//
	// /***************************************************************
	// * Create page five
	// *
	// * @return panel of page five
	// ***************************************************************/
	// protected JScrollPane pageFive() {
	//
	// }
	//
	// /***************************************************************
	// * Create page Six
	// *
	// * @return panel of page Six
	// ***************************************************************/
	// protected JScrollPane pageSix() {
	//
	// }
	//
	// /***************************************************************
	// * Create page Seven
	// *
	// * @return panel of page Seven
	// ***************************************************************/
	// protected JScrollPane pageSeven() {
	//
	// }
	//
	// /***************************************************************
	// * Create page Eight
	// *
	// * @return panel of page Eight
	// ***************************************************************/
	// protected JScrollPane pageEight() {
	//
	// }

	/******************************************************************
	 * Add and action where the button upon click will go to the desired
	 * card in CardLayout
	 * 
	 * @param button
	 *            a button which will be modified
	 * @param id
	 *            is the string identifier of what next panel the button
	 *            will access
	 * @return the modified button;
	 *
	 *****************************************************************/
	private JButton addAction(JButton button, String id) {

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.gotoView(id);
			}
		});

		return button;
	}

	/******************************************************************
	 * Create a single check box and add to ArrayList
	 * 
	 * @param check
	 *            is the name of box
	 * @return a created JCheckBox
	 *****************************************************************/
	private JCheckBox createCheckBox(String check) {
		JCheckBox box = new JCheckBox(check);
		boxes.add(box);

		return box;
	}

	/******************************************************************
	 * Create a single radio button and add to ArrayList
	 * 
	 * @param check
	 *            is the name of radio button
	 * @return a created JRadioButton
	 *****************************************************************/
	private JRadioButton createRadio(String radio) {
		JRadioButton circle = new JRadioButton(radio);
		radios.add(circle);

		return circle;
	}

	/******************************************************************
	 * Dynamically create checkBoxes from a array of string. The
	 * checkBoxes will be ordered in grid layout
	 * 
	 * @param checklist
	 *            is the list of the names of the check boxes
	 * @param row
	 *            is the number of rows in the grid layout
	 * @param col
	 *            is the number of columns in the grid layout
	 * @return a JPanel containing the check boxes
	 *****************************************************************/
	private JPanel createCheckBoxes(String[] checklist, int row,
			int col) {
		JPanel checks = new JPanel(new GridLayout(row, col));
		for (int i = 0; i < checklist.length; i++) {
			JCheckBox box = createCheckBox(checklist[i]);
			checks.add(box);
		}
		return checks;
	}

	/******************************************************************
	 * Dynamically create radio buttons from a array of string. The
	 * radio buttons will be ordered in grid layout
	 * 
	 * @param radiolist
	 *            is the list of the names of the buttons
	 * @param row
	 *            is the number of rows in the grid layout
	 * @param col
	 *            is the number of columns in the grid layout
	 * @return a JPanel containing the radio buttons
	 *****************************************************************/
	private JPanel createRadios(String[] radiolist, int row, int col) {
		ButtonGroup group = new ButtonGroup();
		JPanel radioB = new JPanel(new GridLayout(row, col));
		for (int i = 0; i < radiolist.length; i++) {
			JRadioButton circle = createRadio(radiolist[i]);
			radioB.add(circle);
			group.add(circle);
		}

		return radioB;
	}

	/******************************************************************
	 * Create The Question box
	 * 
	 * @param questions
	 *            is the question to be ask
	 * @return a JPanel of the desired Question
	 *****************************************************************/
	private JPanel createQuestion(String questions) {

		JPanel question = new JPanel(new BorderLayout());
		question.setBorder(BorderFactory.createMatteBorder(2, 0, 1,
				0, Color.black));

		JLabel quesTxt = new JLabel(questions);
		question.add(quesTxt, BorderLayout.NORTH);

		return question;
	}

	/******************************************************************
	 * Dynamically create a JLabel and JTextField and populate a JPanel
	 * 
	 * @param label
	 *            is the label of the text field
	 * @return the JPanel containing both label and text field
	 *****************************************************************/
	private JPanel createJTextField(String label) {
		JPanel field = new JPanel();
		field.setLayout(new FlowLayout());
		JTextField txtfield = new JTextField(30);
		field.add(new JLabel(label));
		field.add(Box.createHorizontalGlue());
		field.add(txtfield);

		fields.add(txtfield);

		return field;
	}

	/******************************************************************
	 * Dynamically create a JLabel and JTextField and populate a JPanel
	 * 
	 * @param label
	 *            label is the label of the text field
	 * @param f
	 *            is the default string which the text field will
	 *            automatically contain
	 * @return the JPanel containing both label and text field
	 *****************************************************************/
	private JPanel createJTextField(String label, String f) {
		JPanel field = new JPanel();
		field.setLayout(new FlowLayout());
		JTextField txtfield = new JTextField(f, 30);
		field.add(new JLabel(label));
		field.add(txtfield);

		fields.add(txtfield);

		return field;
	}

	/******************************************************************
	 * Create the control pane that navigates through the cardlayout
	 * 
	 * @param prev
	 *            is the id of the previous card
	 * @param next
	 *            is the id of the next card
	 * @return a jpanel with basic control options
	 *****************************************************************/
	private JPanel createControlPane(String prev, String next) {

		// Control panel w/ buttons
		JPanel controls = new JPanel();

		if (prev != null) {
			JButton btnPrev = new JButton("Prev");
			btnPrev = addAction(btnPrev, prev);
			controls.add(btnPrev);
		}

		if (next != null) {
			JButton btnNext = new JButton("Next");
			btnNext = addAction(btnNext, next);
			controls.add(btnNext);
		}

		return controls;
	}

	/******************************************************************
	 * Converts components to images
	 * 
	 * @param component
	 *            is the component to be converted
	 * @param visible
	 *            is true or false wether or not the component is
	 *            currently visible
	 * @return a image of the component
	 *****************************************************************/
	private BufferedImage getScreenShot(Component component,
			boolean visible) {

		if (visible) {
			BufferedImage img =
					new BufferedImage(component.getWidth(), component
							.getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = (Graphics2D) img.getGraphics();
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			component.paintAll(g2d);
			return img;

		} else {

			// if comonent is not currently in view
			component.setSize(component.getPreferredSize());
			layoutComponent(component);
			BufferedImage img =
					new BufferedImage(component.getWidth(), component
							.getHeight(), BufferedImage.TYPE_INT_RGB);
			CellRendererPane crp = new CellRendererPane();
			crp.add(component);
			crp.paintComponent(img.createGraphics(), component, crp,
					component.getBounds());
			return img;
		}
	}

	/******************************************************************
	 * Laysout all of a component's sub component is the component is a
	 * container
	 * 
	 * @param c
	 *            is the component to be layed out
	 *****************************************************************/
	private void layoutComponent(Component c) {

		// synchronize to get each component
		synchronized (c.getTreeLock()) {

			// layout component by layout manager
			c.doLayout();

			// apply recursively to all children of container
			if (c instanceof Container) {
				for (Component child : ((Container) c)
						.getComponents()) {
					layoutComponent(child);
				}
			}
		}
	}

	/******************************************************************
	 * Save a bufferd image
	 * 
	 * @param img
	 *            is the Image to be saved
	 * @param fileName
	 *            is the name of the file
	 *****************************************************************/
	private void saveScreenShot(BufferedImage img, String fileName) {

		try {
			ImageIO.write(img, "jpg", new File(fileName + ".jpg"));
			ImageIO.write(img, "png", new File(fileName + ".png"));
		} catch (IOException exp) {
			exp.printStackTrace();
			JOptionPane.showMessageDialog(this,
					"You have Failed to save file", "Save Error", JOptionPane.ERROR_MESSAGE);
			
		}
		JOptionPane.showMessageDialog(this,
				"You have Saved Successfully", "", JOptionPane.PLAIN_MESSAGE);
	}
}
