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
//import com.sun.xml.internal.txw2.Document;

/**********************************************************************
 * Main GUI
 * 
 * @author Tuan
 *
 *********************************************************************/

public class GUIMedicalForm extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		controller.addView(pageFour(), "PageFour");
		controller.addView(pageFive(), "PageFive");
		controller.addView(pageSix(), "PageSix");
		controller.addView(pageSeven(), "PageSeven");
		controller.addView(pageEight(), "PageEight");
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
		final JPanel view = new JPanel();
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

	 /***************************************************************
	 * Create Page Four
	 *
	 * @return panel of Page Four
	 ***************************************************************/
	 protected JScrollPane pageFour() {
	// main pane
	JPanel pageFour = new JPanel();

	pageFour.setLayout(new BorderLayout());
	pageFour.setBorder(BorderFactory.createEmptyBorder(20, 20,
			20, 20));

	// view panel
	JPanel view = new JPanel();
	view.setLayout(new BoxLayout(view, BoxLayout.PAGE_AXIS));
	view.setBorder(BorderFactory
			.createEmptyBorder(20, 20, 20, 20));

	// sub panels
	JPanel ques1 =
			createQuestion("Medical Allergies "
					+ "(please select all that apply)");
	JPanel ques2 = createQuestion("");
	JPanel ques3 = createQuestion("Past Surgical History");
	JPanel ques4 = createQuestion("Surgery Descriptions");
	JPanel ques5 = createQuestion("");
	JPanel ques6 = createQuestion("");
	JPanel ques7 = createQuestion("");
	JPanel ques8 = createQuestion("");
	JPanel ques9 = createQuestion("");
	JPanel ques10 = createQuestion("");
	JPanel ques11 = createQuestion("");
	JPanel ques12 = createQuestion("");
	JPanel ques13 = createQuestion("");


	// Combobox/radio
	// question 1
	ques1.add(createCheckBox("I have no known medical allergies"));

	// question 2
	String[] sques2_1 = { "Adhesive", "Amoxicillin", "Aspirin",
					"Augmentin", "Bactrim", "Bee Sting", "Beneadryl", 
					"Cipro", "Codaine", "Compazine", "Contrast Dye", 
					"Demeriol", "Dilaudid", "Doxycycline", "Erythromycin", "Ibuprofen",
					"Iodine", "Keflex", "Latex", "Levaquin", "Lisonopril",
					"Macrobid", "Morphine", "Naprosyn", "Oxycodone", "Penicillin",
					"Shellfish", "Statins", "Sulfa", "Tetracycline", "Tramadol",
					"Vicodin", "Zithromax"};
	JPanel cques2_1 = createCheckBoxes(sques2_1, 11, 1);
	ques2.add(cques2_1);
	ques2.add(createJTextField("Other: "), BorderLayout.SOUTH);

	// question 3
	ques3.add(createCheckBox("I have had no significant past surgeries"));
	
	// question 4
	ques4.add(createJTextField("Description: "), BorderLayout.WEST);
	ques4.add(createJTextField("Year: "));
	ques4.add(createJTextField("Surgeon: "), BorderLayout.EAST);

	// question 5
	ques5.add(createJTextField("Description: "), BorderLayout.WEST);
	ques5.add(createJTextField("Year: "));
	ques5.add(createJTextField("Surgeon: "), BorderLayout.EAST);
	
	// question 6
	ques6.add(createJTextField("Description: "), BorderLayout.WEST);
	ques6.add(createJTextField("Year: "));
	ques6.add(createJTextField("Surgeon: "), BorderLayout.EAST);

	// question 7
	ques7.add(createJTextField("Description: "), BorderLayout.WEST);
	ques7.add(createJTextField("Year: "));
	ques7.add(createJTextField("Surgeon: "), BorderLayout.EAST);
	
	// question 8
	ques8.add(createJTextField("Description: "), BorderLayout.WEST);
	ques8.add(createJTextField("Year: "));
	ques8.add(createJTextField("Surgeon: "), BorderLayout.EAST);
	
	// question 9
	ques9.add(createJTextField("Description: "), BorderLayout.WEST);
	ques9.add(createJTextField("Year: "));
	ques9.add(createJTextField("Surgeon: "), BorderLayout.EAST);
	
	// question 10
	ques10.add(createJTextField("Description: "), BorderLayout.WEST);
	ques10.add(createJTextField("Year: "));
	ques10.add(createJTextField("Surgeon: "), BorderLayout.EAST);
   
	// question 11
	ques11.add(createJTextField("Description: "), BorderLayout.WEST);
	ques11.add(createJTextField("Year: "));
	ques11.add(createJTextField("Surgeon: "), BorderLayout.EAST);
		
	// question 12
	ques12.add(createJTextField("Description: "), BorderLayout.WEST);
	ques12.add(createJTextField("Year: "));
	ques12.add(createJTextField("Surgeon: "), BorderLayout.EAST);
	
	// question 13
	ques13.add(createJTextField("Other: "), BorderLayout.SOUTH);


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
	view.add(ques12);
	view.add(ques13);
	

	// Control panel w/ buttons
	JPanel controls = createControlPane("PageThree", "PageFive");

	// add to page
	pageFour.add(view);
	pageFour.add(controls, BorderLayout.SOUTH);

	JScrollPane scroll = new JScrollPane(pageFour);
	return scroll;
	 }
	
	 /***************************************************************
	 * Create page five
	 *
	 * @return panel of page five
	 ***************************************************************/
	 protected JScrollPane pageFive() {
		// main pane
		JPanel pageFive = new JPanel();

		pageFive.setLayout(new BorderLayout());
		pageFive.setBorder(BorderFactory.createEmptyBorder(20, 20,
					20, 20));

		// view panel
			JPanel view = new JPanel();
			view.setLayout(new BoxLayout(view, BoxLayout.PAGE_AXIS));
			view.setBorder(BorderFactory
					.createEmptyBorder(20, 20, 20, 20));

		// sub panels
		JPanel ques1 =
				createQuestion("Family Medical History "
						+ "(select all that apply and the relatives for each)");
		JPanel ques2 = createQuestion("Mother");
		JPanel ques3 = createQuestion("Father");
		JPanel ques4 = createQuestion("Sister");
		JPanel ques5 = createQuestion("Brother");
		JPanel ques6 = createQuestion("Daughter");
		JPanel ques7 = createQuestion("Son");
		JPanel ques8 = createQuestion("Smoking Status");
		JPanel ques9 = createQuestion("If you are a smoker, how many packs per day?");
		JPanel ques10 = createQuestion("Do you live in a smoke free home?");
		JPanel ques11 = createQuestion("How often do you drink alcohol?");

		// Combobox/radio
		// question 1
		String[] sques1_1 = {"Unknown", "I have no significant family medical history."};
		JPanel cques1_1 = createCheckBoxes(sques1_1, 2, 1);
		ques1.add(cques1_1);
			

		// question 2
		String[] sques2_1 = {"Alcohol Abuse", "Anesthesia Complications", "Arthritis",
						"Back Problems", "Bleeding Disorder", "Blood Clot", "Cancer",
						"Diabetes", "Seizure Disorder", "Heart Disease", "High Blood Pressure",
						"Illegal Drug Abuse", "Kidney Disease", "Lung Disease", "Mental Illness",							
						"Muscle Disease", "Prescription Drug Abuse", "Osteoporosis", "Scoliosis",
						"Stroke",};
		
		JPanel cques2_1 = createCheckBoxes(sques2_1, 10, 1);
		ques2.add(cques2_1);
		ques2.add(createJTextField("Other: "), BorderLayout.SOUTH);	
		
		// question 3
		String[] sques3_1 = {"Alcohol Abuse", "Anesthesia Complications", "Arthritis",
				"Back Problems", "Bleeding Disorder", "Blood Clot", "Cancer",
				"Diabetes", "Seizure Disorder", "Heart Disease", "High Blood Pressure",					
				"Illegal Drug Abuse", "Kidney Disease", "Lung Disease", "Mental Illness",
				"Muscle Disease", "Prescription Drug Abuse", "Osteoporosis", "Scoliosis",
				"Stroke",};
		
		JPanel cques3_1 = createCheckBoxes(sques3_1, 10, 1);
		ques3.add(cques3_1);
		ques3.add(createJTextField("Other: "), BorderLayout.SOUTH);
			
		// question 4
		String[] sques4_1 = {"Alcohol Abuse", "Anesthesia Complications", "Arthritis",
				"Back Problems", "Bleeding Disorder", "Blood Clot", "Cancer",
				"Diabetes", "Seizure Disorder", "Heart Disease", "High Blood Pressure",
				"Illegal Drug Abuse", "Kidney Disease", "Lung Disease", "Mental Illness",
				"Muscle Disease", "Prescription Drug Abuse", "Osteoporosis", "Scoliosis",
				"Stroke",};
		
		JPanel cques4_1 = createCheckBoxes(sques4_1, 10, 1);
		ques4.add(cques4_1);
		ques4.add(createJTextField("Other: "), BorderLayout.SOUTH);
			
		// question 5
		String[] sques5_1 = {"Alcohol Abuse", "Anesthesia Complications", "Arthritis",
				"Back Problems", "Bleeding Disorder", "Blood Clot", "Cancer",
				"Diabetes", "Seizure Disorder", "Heart Disease", "High Blood Pressure",
				"Illegal Drug Abuse", "Kidney Disease", "Lung Disease", "Mental Illness",
				"Muscle Disease", "Prescription Drug Abuse", "Osteoporosis", "Scoliosis",
				"Stroke",};
		
		JPanel cques5_1 = createCheckBoxes(sques5_1, 10, 1);
		ques5.add(cques5_1);
		ques5.add(createJTextField("Other: "), BorderLayout.SOUTH);
			
		// question 6
		String[] sques6_1 = {"Alcohol Abuse", "Anesthesia Complications", "Arthritis",
				"Back Problems", "Bleeding Disorder", "Blood Clot", "Cancer",
				"Diabetes", "Seizure Disorder", "Heart Disease", "High Blood Pressure",
				"Illegal Drug Abuse", "Kidney Disease", "Lung Disease", "Mental Illness",
				"Muscle Disease", "Prescription Drug Abuse", "Osteoporosis", "Scoliosis",
				"Stroke",};
		
		JPanel cques6_1 = createCheckBoxes(sques6_1, 10, 1);
		ques6.add(cques6_1);
		ques6.add(createJTextField("Other: "), BorderLayout.SOUTH);

		// question 7
		String[] sques7_1 = {"Alcohol Abuse", "Anesthesia Complications", "Arthritis",
				"Back Problems", "Bleeding Disorder", "Blood Clot", "Cancer",
				"Diabetes", "Seizure Disorder", "Heart Disease", "High Blood Pressure",
				"Illegal Drug Abuse", "Kidney Disease", "Lung Disease", "Mental Illness",
				"Muscle Disease", "Prescription Drug Abuse", "Osteoporosis", "Scoliosis",
				"Stroke",};
		
		JPanel cques7_1 = createCheckBoxes(sques7_1, 10, 1);
		ques7.add(cques7_1);
		ques7.add(createJTextField("Other: "), BorderLayout.SOUTH);
		
		// question 8
		String[] sques8_1 = {"Never smoker", "Former smoker", "Unknown if ever smoked", 
				"Smoker, current status unknown", "Current every day smoker",
				"Current some day smoker"};
		
		JPanel cques8_1 = createCheckBoxes(sques8_1, 6, 1);
		ques8.add(cques8_1);
		
		// question 9
		String[] sques9_1 = {"<1", "1", "2", "3", "4+"};
		JPanel cques9_1 = createCheckBoxes(sques9_1, 1, 1);
		ques9.add(cques9_1);
		
		// question 10
		String[] sques10_1 = {"Yes", "No"};
		JPanel cques10_1 = createCheckBoxes(sques10_1, 1, 1);
		ques10.add(cques10_1);
			
		// question 11
		String[] sques11_1 = {"Never", "Occasionally", "Frequently", "Heavily"};
		JPanel cques11_1 = createCheckBoxes(sques11_1, 4, 1);
		ques11.add(cques11_1);

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
		JPanel controls = createControlPane("PageFour", "PageSix");

		// add to page
		pageFive.add(view);
		pageFive.add(controls, BorderLayout.SOUTH);

		JScrollPane scroll = new JScrollPane(pageFive);
		return scroll;
	 }
	
	/***************************************************************
	 * Create page Six
	 *
	 * @return panel of page Six
	 ***************************************************************/
	 protected JScrollPane pageSix() {
		// main pane
		JPanel pageSix = new JPanel();
		pageSix.setLayout(new BorderLayout());
		pageSix.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// view panel
		JPanel view = new JPanel();
		view.setLayout(new BoxLayout(view, BoxLayout.PAGE_AXIS));
		view.setBorder(BorderFactory
				.createEmptyBorder(20, 20, 20, 20));

		// sub panels
		JPanel ques1 = createQuestion("*** The government requires that we ask questions"
				+ "about your race and ethnicity");
		JPanel ques2 = createQuestion("");
		JPanel ques3 = createQuestion("");
		JPanel ques4 = createQuestion("Are you currently employed? ");
		JPanel ques5 = createQuestion("If yes, are you currently working normal duty? ");
		JPanel ques6 = createQuestion("Is the reason for your visit today work-related? ");
		JPanel ques7 = createQuestion("");
		JPanel ques8 = createQuestion("");
		JPanel ques9 = createQuestion("Is there any pending litigation or insurance settlement regarding this problem? ");
		JPanel ques10 = createQuestion("Have you had a fall in the last year? ");
		JPanel ques11 = createQuestion("Did any of the fall(s) result in an injury? ");

		// Combobox/radio
		
		// question 1
		ques1.add(createJTextField("Which categoty best decribes your race? "));
		ques1.add(createJTextField("2) "), BorderLayout.EAST);	
		
		// question 2
		ques2.add(createJTextField("Which categoty best decribes your ethnicity? "), BorderLayout.WEST);
		
		// question 3
		ques3.add(createJTextField("What is you preferred language? "), BorderLayout.WEST);
				
		// question 4 
		String[] sques4_1 = {"No I am a student", "Yes", "No", "Disabled", "Retired", "N/A"};
		JPanel cques4_1 = createCheckBoxes(sques4_1, 6, 1);
		ques4.add(cques4_1);
		
		// question 5
		String[] sques5_1 = {"Normal Duty", "Light Duty", "Not working due to current condition"};
		JPanel cques5_1 = createCheckBoxes(sques5_1, 3, 1);
		ques5.add(cques5_1);
		
		// question 6
		String[] sques6_1 = {"Yes", "No"};
		JPanel cques6_1 = createCheckBoxes(sques6_1, 2, 1);
		ques6.add(cques6_1);
		
		// question 7
		ques7.add(createJTextField("Occupation/Job Title: "));
		
		// question 8
		ques8.add(createJTextField("Job Description: "));
		
		// question 9
		String[] sques9_1 = {"Yes", "No"};
		JPanel cques9_1 = createCheckBoxes(sques9_1, 2, 1);
		ques9.add(cques9_1);
		
		// question 10
		String[] sques10_1 = {"Yes", "No"};
		JPanel cques10_1 = createCheckBoxes(sques10_1, 1, 1);
		ques10.add(cques10_1);
		
		
		// question 11
		String[] sques11_1 = {"Yes", "No"};
		JPanel cques11_1 = createCheckBoxes(sques11_1, 1, 1);
		ques11.add(cques11_1);
		ques11.add(createJTextField("If yes, number of falls "), BorderLayout.SOUTH);
		
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
		JPanel controls = createControlPane("PageFive", "PageSeven");

		// add to page
		pageSix.add(view);
		pageSix.add(controls, BorderLayout.SOUTH);

		JScrollPane scroll = new JScrollPane(pageSix);
		return scroll;
	 
	 }
	
	 /***************************************************************
	 * Create page Seven
	 *
	 * @return panel of page Seven
	 ***************************************************************/
	 protected JScrollPane pageSeven() {
		// main pane
		JPanel pageSeven = new JPanel();
		pageSeven.setLayout(new BorderLayout());
		pageSeven.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// view panel
		JPanel view = new JPanel();
		view.setLayout(new BoxLayout(view, BoxLayout.PAGE_AXIS));
		view.setBorder(BorderFactory
					.createEmptyBorder(20, 20, 20, 20));

		// sub panels
		JPanel ques1 = createQuestion("Pain Intensity (pick one)");
		JPanel ques2 = createQuestion("Personal Care {e.g. washing, dressing} (pick one)");
		JPanel ques3 = createQuestion("Lifting (pick one)");
		JPanel ques4 = createQuestion("Walking (pick one)");
		JPanel ques5 = createQuestion("Sitting (pick one)");

		// Combobox/radio
		// question 1
		String[] sques1_1 = {"The pain comes and goes and is very mild.", 
				"The pain is mild and does not vary much.", "The pain comes and goes and is moderate.", 
				"The pain is moderate and does not vary much.", "The pain comes and goes and is severe.",
				"The pain is severe and does not vary"};
		JPanel cques1_1 = createCheckBoxes(sques1_1, 6, 1);
		ques1.add(cques1_1);
				
		// question 2
		String[] sques2_1 = {"I do not have to change my way of washing or dressing in order to avoid pain.",
				"I do not normally change my way of washing or dressing even though it causes pain.",
				"Washing and dressing increases the pain, but I manage not to change my way of doing it.",
				"Washing and dressing increases pain, and I find it necessary to change my way of doing it.",
				"Because of pain, I am unable to do some washing and dressing without help.",
				"Because of pain, I am unable to do any washing or dressing without help."};
		JPanel cques2_1 = createCheckBoxes(sques2_1, 6, 1);
		ques2.add(cques2_1);
				
		// question 3
		String[] sques3_1 = {"I can lift heavy objects with out extra pain.",
				"I can lift heavy objects, but it causes extra pain.", 
				"Pain prevents me from lifting heavy objects off of the floor.",
				"Pain prevents me from lifting heavy objects off of the floor, but i can manage if they are conveniently positioned.",
				"Pain prevents me from lifting heavy objects, but I can manage light to medium objects if they are conveniently positioned.",
				"I can only lift very light objects, at the most."};
		JPanel cques3_1 = createCheckBoxes(sques3_1, 6, 1);
		ques3.add(cques3_1);
				
		// question 4
		String[] sques4_1 = {"Pain does not prevent me from walking any distance.",
				"I have some pain with walking but it does not increase with distance.",
				"Pain prevents me from walking long distances.", "Pain prevents me from walking intermediate distances.",
				"Pain prevents me from walking without a cane or crutches.", "Pain prevents me from walking at all."};
		JPanel cques4_1 = createCheckBoxes(sques4_1, 6, 1);
		ques4.add(cques4_1);
				
		// question 5
		String[] sques5_1 = {"Sitting Does not cause me pain.", "I can sit as long as I need, provided I have my choice of sitting surfaces.",
				"Pain prevents me from sitting more than one hour.", "Pain prevents me from sitting more than half an hour.",
				"Pain prevents me from sitting more than ten minutes.", "Pain prevents me from sitting at all."};
		JPanel cques5_1 = createCheckBoxes(sques5_1, 6, 1);
		ques5.add(cques5_1);
		
				
		// add to view
		view.add(ques1);
		view.add(ques2);
		view.add(ques3);
		view.add(ques4);
		view.add(ques5);


		// Control panel w/ buttons
		JPanel controls = createControlPane("PageSix", "PageEight");

		// add to page
		pageSeven.add(view);
		pageSeven.add(controls, BorderLayout.SOUTH);
		JScrollPane scroll = new JScrollPane(pageSeven);
		return scroll;	
	 }
	
	 /***************************************************************
	 * Create page Eight
	 *
	 * @return panel of page Eight
	 ***************************************************************/
	 protected JScrollPane pageEight() {
		// main pane
		JPanel pageEight = new JPanel();
		pageEight.setLayout(new BorderLayout());
		pageEight.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// view panel
		JPanel view = new JPanel();
		view.setLayout(new BoxLayout(view, BoxLayout.PAGE_AXIS));
		view.setBorder(BorderFactory
					.createEmptyBorder(20, 20, 20, 20));

		// sub panels
		JPanel ques1 = createQuestion("Standing (pick one)");
		JPanel ques2 = createQuestion("Sleeping (pick one)");
		JPanel ques3 = createQuestion("Social Life (pick one)");
		JPanel ques4 = createQuestion("Traveling (pick one)");
		JPanel ques5 = createQuestion("Employment/Homemaking (pick one)");


		// Combobox/radio
		// question 1
		String[] sques1_1 = {"I can stand as long as I want without pain.",
				"I have some pain while standing, but it does not increase with time.",
				"I cannot stand for longer than one hour without increasing pain.",
				"I cannot stand for longer than half an hour without increasing pain.",
				"I cannot stand for more than ten minutes without increasing pain.",
				"I avoid standing because it increases pain right away."};
		JPanel cques1_1 = createCheckBoxes(sques1_1, 6, 1);
		ques1.add(cques1_1);
		
		// question 2
		String[] sques2_1 = {"I have no pain bed.",
				"I have pain in bed, but it does not prevent me from sleeping well.", 
				"Because of pain, my normal night's sleep is reduced by less than one-quarter.",
				"Because of pain, my normail night's sleep is reduced by less than one-half.",
				"Because of pain, my normal night's sleep is reduced by less than three-quarters.",
				"Pain prevents me from sleeping at all."};
		JPanel cques2_1 = createCheckBoxes(sques2_1, 6, 1);
		ques2.add(cques2_1);
		
		// question 3
		String[] sques3_1 = {"My social life is normal and gives me no pain.",
				"My social life is normal, but icnreases the degree of my pain.",
				"Pain has no significant effect on my social life apart from limmiting my more energetic interests.",
				"Pain has restricted my social life and I do not go out very often.",
				"Pain has restricted my social life to my home.", "Pain prevents me from and social life at all."};
		JPanel cques3_1 = createCheckBoxes(sques3_1, 6, 1);
		ques3.add(cques3_1);
		
		// question 4
		String[] sques4_1 = {"I get no pain while traveling.", 
				"I get some pain while traveling, but none of my usual forms of travel make it any worse.",
				"I get extra pain while traveling, bit it does not compel me to seek alternative forms of travel.",
				"I get extra pain while traveling which compels me to seek alternative forms of travel.",
				"Pain restricts all forms of travel.", "Pain prevents all forms of travel except that done lying down."};
		JPanel cques4_1 = createCheckBoxes(sques4_1, 6, 1);
		ques4.add(cques4_1);
		
		// question 5
		String[] sques5_1 = {"My normal job/homemaking duties do not cause pain.",
				"My normal duties cause me extra paing, but I can still perferm all that is required of me.",
				"I can perform most of my duties, but pain prevents me from performing more physically stressful activities.",
				"Pain prevents me from doing anything but light duties.",
				"Pain prevents me from doing even light duties.", "Pain prevents me from performing any job or homemaking chore."};
		JPanel cques5_1 = createCheckBoxes(sques5_1, 6, 1);
		ques5.add(cques5_1);
					
		// add to view
		view.add(ques1);
		view.add(ques2);
		view.add(ques3);
		view.add(ques4);
		view.add(ques5);

		// Control panel w/ buttons
		JPanel controls = createControlPane("PageSeven", "PageNine");

		// add to page
		pageEight.add(view);
		pageEight.add(controls, BorderLayout.SOUTH);

		JScrollPane scroll = new JScrollPane(pageEight);
		return scroll;	
	 }

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
	private JButton addAction(JButton button, final String id) {

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
