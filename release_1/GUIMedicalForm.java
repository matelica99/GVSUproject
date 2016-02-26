package package1;

import java.awt.event.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import package1.medicalForm.DefaultViewController;

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
		// namepane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		view.add(namepane);

		JPanel birthpane = createJTextField("Birth Date:",
			dateformat.format(Calendar.getInstance().getTime()));

		// birthpane.setAlignmentX(Component.RIGHT_ALIGNMENT);
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
		JPanel ques2 = createQuestion("<html>What is the main Reason for "
			+ "today's visit <br>	"
			+ "Where is Your Main Compaint (Select One)</html>");
		JPanel ques3 = createQuestion("Which Side?");
		JPanel ques4 = createQuestion("What Type of Problem is It?");
		JPanel ques5 = createQuestion("What Other Problems Have You "
			+ "Had Related to This Problem? (select all that apply)");

		// Combobox/radio

		// question 1
		String[] ques1_1 = { "friend/family", "my doctor",
			"insurance company", "case manager", "ER/med center",
			"newspaper ad", "I am a previous" };
		JPanel rques1_1 = createCheckBoxes(ques1_1, 7, 1);

		String[] ques1_2 = { "internet search", "TV commercial",
			"therapist/trainer", "worker's compensation",
			"billboard", "other" };
		JPanel rques1_2 = createCheckBoxes(ques1_2, 6, 1);
		ques1.add(rques1_1, BorderLayout.WEST);
		ques1.add(rques1_2, BorderLayout.EAST);

		// question 2
		String[] ques2_1 = { "Shoulder", "Forearm", "Neck", "Pelvis",
			"Knee", "Upper Arm", "Wrist", "Neck and Arm", "Hip",
			"LowerLeg", "Elbow", "Hand", "Back", "Leg", "Ankel",
			"Arm", "Finger(s)", "Back and Leg", "Thigh", "Foot" };
		JPanel rques2_1 = createRadios(ques2_1, 4, 5);
		ques2.add(rques2_1, BorderLayout.CENTER);

		// question 3
		String[] ques3_1 = { "Right", "Left", "Both", "N/A" };
		JPanel rques3_1 = createRadios(ques3_1, 4, 1);
		ques3.add(rques3_1, BorderLayout.CENTER);

		// question 4
		String[] ques4_1 = { "Pain", "Fracture/Broken Bone",
			"Swelling", "Numbness", "Deformity", "Injury", "Sprain",
			"Weakness", "Tingling", "Wound", "Instability",
			"Mass/Lump", "Stiffness", "Locking", "Laceration",
			"Clicking" };
		JPanel rques4_1 = createRadios(ques4_1, 4, 4);
		ques4.add(rques4_1, BorderLayout.CENTER);

		// question 5
		String[] ques5_1 = { "Fever", "Numbness/Tingling",
			"Weakness", "Night Pain", "Swelling",
			"Stiffness/Loss of Motion", "Bowel/Bladder Dysfunction",
			"Tenderness", "Joint Locking",
			"Unintentional Weight Loss", "Brusing" };

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
		JPanel ques1 = createQuestion("Describe How It Feels(select "
			+ "all that apply)");
		JPanel ques2 = createQuestion("When Did Your Symptoms Start?");
		JPanel ques3 = createQuestion("Are Your Symptoms: ");
		JPanel ques4 = createQuestion("What Makes Your Symptoms Worse?"
			+ " (select all that apply");
		JPanel ques5 = createQuestion("What Makes Your Symptoms "
			+ "Better? (select all that apply");

		// Combobox/radio

		// question 1
		String[] ques1_1 = { "I have no symptoms", "Aching",
			"Burning", "Dull", "Sharp", "Shooting", "Throbbing",
			"weakness", "On and Off" };
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
		String[] ques4_1 = { "Nothing", "Everything", "Repetition",
			"Exercise", "Forceful Work", "Activity", "Lying",
			"Sitting", "Standing", "Walking", "Driving", "Running",
			"Jumping", "Squatting", "Sitting to Standing",
			"Climbing Stairs", "Pinching", "Gripping", "Lifting",
			"Bending", "Overhead Use", "Pushing", "Throwing", "Cold",
			"Twisting", "Vibration", "Heat" };
		JPanel rques4_1 = createRadios(ques4_1, 4, 7);
		ques4.add(rques4_1, BorderLayout.CENTER);
		ques4.add(createJTextField("Other: "), BorderLayout.SOUTH);

		// question 5
		String[] ques5_1 = { "Nothing", "Rest", "Sling",
			"Brace/Splint", "Elevation", "Sitting", "Standing",
			"Lying", "Walking", "Stretching", "Ice", "Heat",
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

		JPanel pageThree = new JPanel();
		pageThree.setLayout(new GridLayout(20, 3));

		JPanel view = new JPanel();
		view.setLayout(new GridLayout(20, 3));
		// create cancer type textfield
		JTextField cancer = new JTextField();
		// create other textfield
		JTextField other = new JTextField();

		// create heptatis radio buttons and group
		JRadioButton h1 = new JRadioButton("A");
		JRadioButton h2 = new JRadioButton("B");
		JRadioButton h3 = new JRadioButton("C");
		ButtonGroup hepa = new ButtonGroup();
		// create disease related checkboxes
		JCheckBox none = new JCheckBox(
			"I have no significant past medical history.");
		JCheckBox eDisease = new JCheckBox("Eye Disease");
		JCheckBox hLoss = new JCheckBox("Hearing Loss");
		JCheckBox asthma = new JCheckBox("Asthma");
		JCheckBox cOPD = new JCheckBox("COPD");
		JCheckBox emphysema = new JCheckBox("Emphysema");
		JCheckBox tuberculosis = new JCheckBox("Tuberculosis");
		JCheckBox sApnea = new JCheckBox("Sleep Apnea");
		JCheckBox angina = new JCheckBox("Angina");
		JCheckBox aFibrillation = new JCheckBox("Atrial Fibrillation");
		JCheckBox hDisease = new JCheckBox("Heart Disease");
		JCheckBox hAttack = new JCheckBox("Heart Attack");
		JCheckBox hMurmur = new JCheckBox("Heart Murmur");
		JCheckBox hCholesterol = new JCheckBox("High Cholesterol");
		JCheckBox hBPressure = new JCheckBox("High Blood Pressure");
		JCheckBox mVProlapse = new JCheckBox("Mitral Valve Prolapse");
		JCheckBox aids = new JCheckBox("AIDS/HIV");
		JCheckBox anemia = new JCheckBox("Anemia");
		JCheckBox bDisorders = new JCheckBox("Bleeding Disorders");
		JCheckBox bClots = new JCheckBox("Blood Clots");
		JCheckBox hemophilia = new JCheckBox("Hemophilia");
		JCheckBox mrsa = new JCheckBox("MRSA");
		JCheckBox mssa = new JCheckBox("MSSA");
		JCheckBox sCDisease = new JCheckBox("Sickle Cell Disease");
		JCheckBox bDisease = new JCheckBox("Bowel Disease");
		JCheckBox gerd = new JCheckBox("GERD/Ulcers");
		JCheckBox hHernia = new JCheckBox("Hiatal Hernia");
		JCheckBox iHernia = new JCheckBox("Inguinal Hernia");
		JCheckBox iBSyndrome = new JCheckBox("Irrital Bowel Syndrome");
		JCheckBox kDisease = new JCheckBox("Kidney Disease");
		JCheckBox kStones = new JCheckBox("Kidney Stones");
		JCheckBox uHernia = new JCheckBox("Umbilical Hernia");
		JCheckBox uTInfection = new JCheckBox(
			"Urinary Tract Infection");
		JCheckBox cPalsy = new JCheckBox("Cerebral Palsy");
		JCheckBox meningitis = new JCheckBox("Menigitis");
		JCheckBox mHeadaches = new JCheckBox("Migraine Headaches");
		JCheckBox mSclerosis = new JCheckBox("Multiple Sclerosis");
		JCheckBox pDisease = new JCheckBox("Parkinson's Disease");
		JCheckBox pNeuropathy = new JCheckBox("Peripheral Neuropathy");
		JCheckBox polio = new JCheckBox("Polio");
		JCheckBox sDisorder = new JCheckBox("Seizure Disorder");
		JCheckBox sBifida = new JCheckBox("Spina Bifida");
		JCheckBox stroke = new JCheckBox("Stroke");
		JCheckBox bProblems = new JCheckBox("Back Problems");
		JCheckBox fibromyalgia = new JCheckBox("Fibromyalgia");
		JCheckBox mDisease = new JCheckBox("Muscular Diseases");
		JCheckBox scoliosis = new JCheckBox("Scoliosis");
		JCheckBox gout = new JCheckBox("Gout");
		JCheckBox osteopenia = new JCheckBox(
			"Low Bone Mass/Osteopenia");
		JCheckBox lupus = new JCheckBox("Lupus");
		JCheckBox osteoarthritis = new JCheckBox("Osteoarthritis");
		JCheckBox osteoporosis = new JCheckBox("Osteoporosis");
		JCheckBox rArthritis = new JCheckBox("Rheumatoid Arthritis");
		JCheckBox lDisease = new JCheckBox("Liver Disease");
		JCheckBox adhd = new JCheckBox("ADD/ADHD");
		JCheckBox aAbuse = new JCheckBox("Alcohol Abuse");
		JCheckBox anxiety = new JCheckBox("Anxiety");
		JCheckBox bDisorder = new JCheckBox("Bipolar Disorder");
		JCheckBox depression = new JCheckBox("Depression");
		JCheckBox dAbuse = new JCheckBox("Drug Abuse");
		JCheckBox mDisability = new JCheckBox("Mental Disability");
		JCheckBox ocd = new JCheckBox("OCD");
		JCheckBox pDAbuse = new JCheckBox("Prescription Drug Abuse");
		JCheckBox pSAbuse = new JCheckBox(
			"Preadolescent Sexual Abuse");
		JCheckBox schizophrenia = new JCheckBox("Schizophrenia");
		JCheckBox diabetes = new JCheckBox("Diabetes");
		JCheckBox tDisease = new JCheckBox("Thyroid Disease");
		JCheckBox aComplications = new JCheckBox(
			"Anesthesia Complications");
		JCheckBox mHyperthermia = new JCheckBox(
			"Malignant Hyperthermia");

		// add checkboxes
		pageThree.add(view);
		view.add(none);
		view.add(eDisease);
		view.add(hLoss);
		view.add(asthma);
		view.add(cOPD);
		view.add(emphysema);
		view.add(tuberculosis);
		view.add(sApnea);
		view.add(angina);
		view.add(aFibrillation);
		view.add(hDisease);
		view.add(hAttack);
		view.add(hMurmur);
		view.add(hCholesterol);
		view.add(hBPressure);
		view.add(mVProlapse);
		view.add(aids);
		view.add(anemia);
		view.add(bDisorders);
		view.add(bClots);
		view.add(hemophilia);
		view.add(mrsa);
		view.add(mssa);
		view.add(sCDisease);
		view.add(bDisease);
		view.add(gerd);
		view.add(hHernia);
		view.add(iHernia);
		view.add(iBSyndrome);
		view.add(kDisease);
		view.add(kStones);
		view.add(uHernia);
		view.add(uTInfection);
		view.add(cancer);
		view.add(cPalsy);
		view.add(meningitis);
		view.add(mHeadaches);
		view.add(mSclerosis);
		view.add(pDisease);
		view.add(pNeuropathy);
		view.add(polio);
		view.add(sDisorder);
		view.add(sBifida);
		view.add(stroke);
		view.add(bProblems);
		view.add(fibromyalgia);
		view.add(mDisease);
		view.add(scoliosis);
		view.add(gout);
		view.add(osteopenia);
		view.add(lupus);
		view.add(osteoarthritis);
		view.add(osteoporosis);
		view.add(rArthritis);
		hepa.add(h1);
		hepa.add(h2);
		hepa.add(h3);
		view.add(lDisease);
		view.add(adhd);
		view.add(aAbuse);
		view.add(anxiety);
		view.add(bDisorder);
		view.add(depression);
		view.add(dAbuse);
		view.add(mDisability);
		view.add(ocd);
		view.add(pDAbuse);
		view.add(pSAbuse);
		view.add(schizophrenia);
		view.add(diabetes);
		view.add(tDisease);
		view.add(aComplications);
		view.add(mHyperthermia);
		view.add(other);

		pageThree.add(this.createControlPane("PageTwo", "PageFour"),
			BorderLayout.SOUTH);

		JScrollPane scroll = new JScrollPane(pageThree);
		return scroll;
	}

	/******************************************************************
	 * Create Page Four
	 * 
	 * @return panel of Page Four
	 *****************************************************************/
	protected JScrollPane pageFour() {

		JPanel a = new JPanel();
		// 6 items per row with 3 columns
		a.setLayout(new GridLayout(12, 6));
		// creation of allergy area buttons
		JCheckBox none = new JCheckBox(
			"I have had no significant past surgeries.");
		JCheckBox adhesive = new JCheckBox("Adhesive");
		JCheckBox amoxicillin = new JCheckBox("Amoxicillin");
		JCheckBox aspirin = new JCheckBox("Aspirin");
		JCheckBox augmentin = new JCheckBox("Augmentin");
		JCheckBox bactrim = new JCheckBox("Bactrim");
		JCheckBox bSting = new JCheckBox("Bee Sting");
		JCheckBox benadryl = new JCheckBox("Benadryl");
		JCheckBox cipro = new JCheckBox("Cipro");
		JCheckBox codeine = new JCheckBox("Codeine");
		JCheckBox compazine = new JCheckBox("Compazine");
		JCheckBox contrast_dye = new JCheckBox("Contrast Dye");
		JCheckBox demerol = new JCheckBox("Demerol");
		JCheckBox dilaudid = new JCheckBox("Dilaudid");
		JCheckBox doxycycline = new JCheckBox("Doxycycline");
		JCheckBox erythromycin = new JCheckBox("Erythromycin");
		JCheckBox ibuprofen = new JCheckBox("Ibuprofen");
		JCheckBox iodine = new JCheckBox("Iodine");
		JCheckBox keflex = new JCheckBox("Keflex");
		JCheckBox latex = new JCheckBox("Latex");
		JCheckBox levaquin = new JCheckBox("Levaquin");
		JCheckBox lisonopril = new JCheckBox("Lisonopril");
		JCheckBox macrobid = new JCheckBox("Macrobid");
		JCheckBox morphine = new JCheckBox("Morphine");
		JCheckBox naprosyn = new JCheckBox("Naprosyn");
		JCheckBox oxycodone = new JCheckBox("Oxycodone");
		JCheckBox penicillin = new JCheckBox("Penicillin");
		JCheckBox shellfish = new JCheckBox("Shelllfish");
		JCheckBox statins = new JCheckBox("Statins");
		JCheckBox sulfa = new JCheckBox("Sulfa");
		JCheckBox tetracycline = new JCheckBox("Tetracycline");
		JCheckBox tramadol = new JCheckBox("Tramadol");
		JCheckBox vicodin = new JCheckBox("Vicodin");
		JCheckBox zithromax = new JCheckBox("Zithromax");
		JTextField reaction1 = new JTextField();
		JTextField reaction2 = new JTextField();
		JTextField reaction3 = new JTextField();
		JTextField reaction4 = new JTextField();
		JTextField reaction5 = new JTextField();
		JTextField reaction6 = new JTextField();
		JTextField reaction7 = new JTextField();
		JTextField reaction8 = new JTextField();
		JTextField reaction9 = new JTextField();
		JTextField reaction10 = new JTextField();
		JTextField reaction11 = new JTextField();
		JTextField reaction12 = new JTextField();
		JTextField reaction13 = new JTextField();
		JTextField reaction14 = new JTextField();
		JTextField reaction15 = new JTextField();
		JTextField reaction16 = new JTextField();
		JTextField reaction17 = new JTextField();
		JTextField reaction18 = new JTextField();
		JTextField reaction19 = new JTextField();
		JTextField reaction20 = new JTextField();
		JTextField reaction21 = new JTextField();
		JTextField reaction22 = new JTextField();
		JTextField reaction23 = new JTextField();
		JTextField reaction24 = new JTextField();
		JTextField reaction25 = new JTextField();
		JTextField reaction26 = new JTextField();
		JTextField reaction27 = new JTextField();
		JTextField reaction28 = new JTextField();
		JTextField reaction29 = new JTextField();
		JTextField reaction30 = new JTextField();
		JTextField reaction31 = new JTextField();
		JTextField reaction32 = new JTextField();
		JTextField reaction33 = new JTextField();
		// Textfields at bottom of allergy area
		JTextField other1 = new JTextField();
		JTextField other2 = new JTextField();
		JTextField other3 = new JTextField();
		// other4 = other textfield at bottom of page 4
		JTextField other4 = new JTextField();
		// creation of surgery section button
		JRadioButton right1 = new JRadioButton("R");
		JRadioButton right2 = new JRadioButton("R");
		JRadioButton right3 = new JRadioButton("R");
		JRadioButton right4 = new JRadioButton("R");
		JRadioButton right5 = new JRadioButton("R");
		JRadioButton right6 = new JRadioButton("R");
		JRadioButton right7 = new JRadioButton("R");
		JRadioButton right8 = new JRadioButton("R");
		JRadioButton right9 = new JRadioButton("R");
		JRadioButton right10 = new JRadioButton("R");
		JRadioButton right11 = new JRadioButton("R");
		JRadioButton right12 = new JRadioButton("R");
		JRadioButton right13 = new JRadioButton("R");
		JRadioButton left1 = new JRadioButton("L");
		JRadioButton left2 = new JRadioButton("L");
		JRadioButton left3 = new JRadioButton("L");
		JRadioButton left4 = new JRadioButton("L");
		JRadioButton left5 = new JRadioButton("L");
		JRadioButton left6 = new JRadioButton("L");
		JRadioButton left7 = new JRadioButton("L");
		JRadioButton left8 = new JRadioButton("L");
		JRadioButton left9 = new JRadioButton("L");
		JRadioButton left10 = new JRadioButton("L");
		JRadioButton left11 = new JRadioButton("L");
		JRadioButton left12 = new JRadioButton("L");
		JRadioButton left13 = new JRadioButton("L");
		JTextField surgeon1 = new JTextField();
		JTextField surgeon2 = new JTextField();
		JTextField surgeon3 = new JTextField();
		JTextField surgeon4 = new JTextField();
		JTextField surgeon5 = new JTextField();
		JTextField surgeon6 = new JTextField();
		JTextField surgeon7 = new JTextField();
		JTextField surgeon8 = new JTextField();
		JTextField surgeon9 = new JTextField();
		JTextField surgeon10 = new JTextField();
		JTextField surgeon11 = new JTextField();
		JTextField surgeon12 = new JTextField();
		JTextField surgeon13 = new JTextField();
		JTextField year1 = new JTextField();
		JTextField year2 = new JTextField();
		JTextField year3 = new JTextField();
		JTextField year4 = new JTextField();
		JTextField year5 = new JTextField();
		JTextField year6 = new JTextField();
		JTextField year7 = new JTextField();
		JTextField year8 = new JTextField();
		JTextField year9 = new JTextField();
		JTextField year10 = new JTextField();
		JTextField year11 = new JTextField();
		JTextField year12 = new JTextField();
		JTextField year13 = new JTextField();
		JTextField sDescrip1 = new JTextField();
		JTextField sDescrip2 = new JTextField();
		JTextField sDescrip3 = new JTextField();
		JTextField sDescrip4 = new JTextField();
		JTextField sDescrip5 = new JTextField();
		JTextField sDescrip6 = new JTextField();
		JTextField sDescrip7 = new JTextField();
		JTextField sDescrip8 = new JTextField();
		JTextField sDescrip9 = new JTextField();
		JTextField sDescrip10 = new JTextField();
		JTextField sDescrip11 = new JTextField();
		JTextField sDescrip12 = new JTextField();
		JTextField sDescrip13 = new JTextField();
		ButtonGroup rL1 = new ButtonGroup();
		ButtonGroup rL2 = new ButtonGroup();
		ButtonGroup rL3 = new ButtonGroup();
		ButtonGroup rL4 = new ButtonGroup();
		ButtonGroup rL5 = new ButtonGroup();
		ButtonGroup rL6 = new ButtonGroup();
		ButtonGroup rL7 = new ButtonGroup();
		ButtonGroup rL8 = new ButtonGroup();
		ButtonGroup rL9 = new ButtonGroup();
		ButtonGroup rL10 = new ButtonGroup();
		ButtonGroup rL11 = new ButtonGroup();
		ButtonGroup rL12 = new ButtonGroup();
		ButtonGroup rL13 = new ButtonGroup();

		Container b = new JPanel(new BorderLayout());
		b.add(a);
		JPanel empty = new JPanel();

		// adding allergy buttons from left to right, row to row
		// a.add(none);
		// a.add(empty);
		// a.add(empty);
		// a.add(empty);
		// a.add(empty);
		// a.add(empty);
		a.add(adhesive);
		a.add(reaction1);
		a.add(demerol);
		a.add(reaction2);
		a.add(morphine);
		a.add(reaction3);
		a.add(amoxicillin);
		a.add(reaction4);
		a.add(dilaudid);
		a.add(reaction5);
		a.add(naprosyn);
		a.add(reaction6);
		a.add(aspirin);
		a.add(reaction7);
		a.add(doxycycline);
		a.add(reaction8);
		a.add(oxycodone);
		a.add(reaction9);
		a.add(augmentin);
		a.add(reaction10);
		a.add(erythromycin);
		a.add(reaction11);
		a.add(penicillin);
		a.add(reaction12);
		a.add(bactrim);
		a.add(reaction13);
		a.add(ibuprofen);
		a.add(reaction14);
		a.add(shellfish);
		a.add(reaction15);
		a.add(bSting);
		a.add(reaction16);
		a.add(iodine);
		a.add(reaction17);
		a.add(statins);
		a.add(reaction18);
		a.add(benadryl);
		a.add(reaction19);
		a.add(keflex);
		a.add(reaction20);
		a.add(sulfa);
		a.add(reaction21);
		a.add(cipro);
		a.add(reaction22);
		a.add(latex);
		a.add(reaction23);
		a.add(tetracycline);
		a.add(reaction24);
		a.add(codeine);
		a.add(reaction25);
		a.add(levaquin);
		a.add(reaction26);
		a.add(tramadol);
		a.add(reaction27);
		a.add(compazine);
		a.add(reaction28);
		a.add(lisonopril);
		a.add(reaction29);
		a.add(vicodin);
		a.add(reaction30);
		a.add(contrast_dye);
		a.add(reaction31);
		a.add(macrobid);
		a.add(reaction32);
		a.add(zithromax);
		a.add(reaction33);
		a.add(other1);
		a.add(other2);
		a.add(other3);
		// adding right/left buttons to groups
		rL1.add(right1);
		rL1.add(left1);
		rL2.add(right2);
		rL2.add(left2);
		rL3.add(right3);
		rL3.add(left3);
		rL4.add(right4);
		rL4.add(left4);
		rL5.add(right5);
		rL5.add(left5);
		rL6.add(right6);
		rL6.add(left6);
		rL7.add(right7);
		rL7.add(left7);
		rL8.add(right8);
		rL8.add(left8);
		rL9.add(right9);
		rL9.add(left9);
		rL10.add(right10);
		rL10.add(left10);
		rL11.add(right11);
		rL11.add(left11);
		rL12.add(right12);
		rL12.add(left12);
		rL13.add(right13);
		rL13.add(left13);

		// Adding surgery section buttons/textfields
		a.add(right1);
		a.add(left1);
		a.add(sDescrip1);
		a.add(year1);
		a.add(surgeon1);
		a.add(right2);
		a.add(left2);
		a.add(sDescrip2);
		a.add(year2);
		a.add(surgeon2);
		a.add(right3);
		a.add(left3);
		a.add(sDescrip3);
		a.add(year3);
		a.add(surgeon3);
		a.add(right4);
		a.add(left4);
		a.add(sDescrip4);
		a.add(year4);
		a.add(surgeon4);
		a.add(right5);
		a.add(left5);
		a.add(sDescrip5);
		a.add(year5);
		a.add(surgeon5);
		a.add(right6);
		a.add(left6);
		a.add(sDescrip6);
		a.add(year6);
		a.add(surgeon6);
		a.add(right7);
		a.add(left7);
		a.add(sDescrip7);
		a.add(year7);
		a.add(surgeon7);
		a.add(right8);
		a.add(left8);
		a.add(sDescrip8);
		a.add(year8);
		a.add(surgeon8);
		a.add(right9);
		a.add(left9);
		a.add(sDescrip9);
		a.add(year9);
		a.add(surgeon9);
		a.add(right10);
		a.add(left10);
		a.add(sDescrip10);
		a.add(year10);
		a.add(surgeon10);
		a.add(right11);
		a.add(left11);
		a.add(sDescrip11);
		a.add(year11);
		a.add(surgeon11);
		a.add(right12);
		a.add(left12);
		a.add(sDescrip12);
		a.add(year12);
		a.add(surgeon12);
		a.add(right13);
		a.add(left13);
		a.add(sDescrip13);
		a.add(year13);
		a.add(surgeon13);
		a.add(other4);

		b.add(this.createControlPane("PageThree", "PageFive"),
			BorderLayout.SOUTH);

		JScrollPane scroll = new JScrollPane(b);
		return scroll;
	}

	/******************************************************************
	 * Create page five
	 * 
	 * @return panel of page five
	 *****************************************************************/
	protected JScrollPane pageFive() {

		JPanel pageFive = new JPanel(new BorderLayout());
		JPanel a = new JPanel();
		a.setLayout(new GridLayout(36, 1));
		a.setBackground(Color.YELLOW);
		// checkboxes for family history
		JCheckBox fiveA1 = new JCheckBox("Mother");
		JCheckBox fiveA2 = new JCheckBox("Father");
		JCheckBox fiveA3 = new JCheckBox("Sister");
		JCheckBox fiveA4 = new JCheckBox("Brother");
		JCheckBox fiveA5 = new JCheckBox("Daughter");
		JCheckBox fiveA6 = new JCheckBox("Son");
		// "Other:" textbox
		JTextField other = new JTextField();
		// smoking social hisotry
		JRadioButton fiveB1 = new JRadioButton("Never smoker");
		JRadioButton fiveB2 = new JRadioButton("Former smoker");
		JRadioButton fiveB3 = new JRadioButton(
			"Unknown if ever smoked");
		JRadioButton fiveB4 = new JRadioButton(
			"Smoker, current status unknown");
		JRadioButton fiveB5 = new JRadioButton(
			"Current every day smoker");
		JRadioButton fiveB6 = new JRadioButton(
			"Current some day smoker");
		// Packs per day
		JRadioButton fiveC1 = new JRadioButton("<1");
		JRadioButton fiveC2 = new JRadioButton("1");
		JRadioButton fiveC3 = new JRadioButton("2");
		JRadioButton fiveC4 = new JRadioButton("3");
		JRadioButton fiveC5 = new JRadioButton("4+");
		// live in smoke free home
		JRadioButton fiveD1 = new JRadioButton("Yes");
		JRadioButton fiveD2 = new JRadioButton("No");
		// drinking habits
		JRadioButton fiveE1 = new JRadioButton("Never");
		JRadioButton fiveE2 = new JRadioButton("Occasionally");
		JRadioButton fiveE3 = new JRadioButton("Frequently");
		JRadioButton fiveE4 = new JRadioButton("Heavily");
		// race, ethnicity, prefered language
		JTextField race1 = new JTextField();
		JTextField race2 = new JTextField();
		JTextField ethnicity = new JTextField();
		JTextField pLanguage = new JTextField();

		a.add(other);
		a.add(race1);
		a.add(race2);
		a.add(ethnicity);
		a.add(pLanguage);
		a.add(fiveA1);
		a.add(fiveA2);
		a.add(fiveA3);
		a.add(fiveA4);
		a.add(fiveA5);
		a.add(fiveA6);
		a.add(fiveB1);
		a.add(fiveB2);
		a.add(fiveB3);
		a.add(fiveB4);
		a.add(fiveB5);
		a.add(fiveB6);
		a.add(fiveC1);
		a.add(fiveC2);
		a.add(fiveC3);
		a.add(fiveC4);
		a.add(fiveC5);
		a.add(fiveD1);
		a.add(fiveD2);
		a.add(fiveE1);
		a.add(fiveE2);
		a.add(fiveE3);
		a.add(fiveE4);

		JPanel aAbuse = new JPanel();
		// adding buttons to groups
		// alcohol abuse
		aAbuse.add(fiveA1);
		aAbuse.add(fiveA2);
		aAbuse.add(fiveA3);
		aAbuse.add(fiveA4);
		aAbuse.add(fiveA5);
		aAbuse.add(fiveA6);

		JPanel aComplications = new JPanel();
		// anesthesia complications
		aComplications.add(fiveA1);
		aComplications.add(fiveA2);
		aComplications.add(fiveA3);
		aComplications.add(fiveA4);
		aComplications.add(fiveA5);
		aComplications.add(fiveA6);

		JPanel arthritis = new JPanel();
		// arthritis
		arthritis.add(fiveA1);
		arthritis.add(fiveA2);
		arthritis.add(fiveA3);
		arthritis.add(fiveA4);
		arthritis.add(fiveA5);
		arthritis.add(fiveA6);
		// back problems

		JPanel bProblems = new JPanel();
		bProblems.add(fiveA1);
		bProblems.add(fiveA2);
		bProblems.add(fiveA3);
		bProblems.add(fiveA4);
		bProblems.add(fiveA5);
		bProblems.add(fiveA6);
		// bleeding disorder
		JPanel bDisorder = new JPanel();
		bDisorder.add(fiveA1);
		bDisorder.add(fiveA2);
		bDisorder.add(fiveA3);
		bDisorder.add(fiveA4);
		bDisorder.add(fiveA5);
		bDisorder.add(fiveA6);
		// blood clot
		JPanel bClot = new JPanel();
		bClot.add(fiveA1);
		bClot.add(fiveA2);
		bClot.add(fiveA3);
		bClot.add(fiveA4);
		bClot.add(fiveA5);
		bClot.add(fiveA6);
		// cancer
		JPanel cancer = new JPanel();
		cancer.add(fiveA1);
		cancer.add(fiveA2);
		cancer.add(fiveA3);
		cancer.add(fiveA4);
		cancer.add(fiveA5);
		cancer.add(fiveA6);
		// diabetes
		JPanel diabetes = new JPanel();
		diabetes.add(fiveA1);
		diabetes.add(fiveA2);
		diabetes.add(fiveA3);
		diabetes.add(fiveA4);
		diabetes.add(fiveA5);
		diabetes.add(fiveA6);
		// seizure disorder
		JPanel sDisorder = new JPanel();
		sDisorder.add(fiveA1);
		sDisorder.add(fiveA2);
		sDisorder.add(fiveA3);
		sDisorder.add(fiveA4);
		sDisorder.add(fiveA5);
		sDisorder.add(fiveA6);
		// heart disease
		JPanel hDisease = new JPanel();
		hDisease.add(fiveA1);
		hDisease.add(fiveA2);
		hDisease.add(fiveA3);
		hDisease.add(fiveA4);
		hDisease.add(fiveA5);
		hDisease.add(fiveA6);
		// high blood pressure
		JPanel hBPressure = new JPanel();
		hBPressure.add(fiveA1);
		hBPressure.add(fiveA2);
		hBPressure.add(fiveA3);
		hBPressure.add(fiveA4);
		hBPressure.add(fiveA5);
		hBPressure.add(fiveA6);
		// illegal drug abuse

		Container iDAbuse = new JPanel();
		iDAbuse.add(fiveA1);
		iDAbuse.add(fiveA2);
		iDAbuse.add(fiveA3);
		iDAbuse.add(fiveA4);
		iDAbuse.add(fiveA5);
		iDAbuse.add(fiveA6);
		Container kDisease = new JPanel();
		// kidney disease
		kDisease.add(fiveA1);
		kDisease.add(fiveA2);
		kDisease.add(fiveA3);
		kDisease.add(fiveA4);
		kDisease.add(fiveA5);
		kDisease.add(fiveA6);
		Container lDisease = new JPanel();
		// lung disease
		lDisease.add(fiveA1);
		kDisease.add(fiveA2);
		kDisease.add(fiveA3);
		kDisease.add(fiveA4);
		kDisease.add(fiveA5);
		kDisease.add(fiveA6);
		Container mIllness = new JPanel();
		// mental illness
		mIllness.add(fiveA1);
		mIllness.add(fiveA2);
		mIllness.add(fiveA3);
		mIllness.add(fiveA4);
		mIllness.add(fiveA5);
		mIllness.add(fiveA6);
		Container mDisease = new JPanel();
		// muscle disease
		mDisease.add(fiveA1);
		mDisease.add(fiveA2);
		mDisease.add(fiveA3);
		mDisease.add(fiveA4);
		mDisease.add(fiveA5);
		mDisease.add(fiveA6);
		Container pDAbuse = new JPanel();
		// prescription drug abuse
		pDAbuse.add(fiveA1);
		pDAbuse.add(fiveA2);
		pDAbuse.add(fiveA3);
		pDAbuse.add(fiveA4);
		pDAbuse.add(fiveA5);
		pDAbuse.add(fiveA6);
		Container osteoporosis = new JPanel();
		// osteoporosis
		osteoporosis.add(fiveA1);
		osteoporosis.add(fiveA2);
		osteoporosis.add(fiveA3);
		osteoporosis.add(fiveA4);
		osteoporosis.add(fiveA5);
		osteoporosis.add(fiveA6);
		Container scoliosis = new JPanel();
		// scoliosis
		scoliosis.add(fiveA1);
		scoliosis.add(fiveA2);
		scoliosis.add(fiveA3);
		scoliosis.add(fiveA4);
		scoliosis.add(fiveA5);
		scoliosis.add(fiveA6);
		Container stroke = new JPanel();
		// stroke
		stroke.add(fiveA1);
		stroke.add(fiveA2);
		stroke.add(fiveA3);
		stroke.add(fiveA4);
		stroke.add(fiveA5);
		stroke.add(fiveA6);
		
		pageFive.add(a);

		pageFive.add(this.createControlPane("PageFour", "PageSix"),
			BorderLayout.SOUTH);

		JScrollPane scroll = new JScrollPane(pageFive);
		return scroll;
	}
	
	/******************************************************************
	 * Create page Six
	 * 
	 * @return panel of page Six
	 *****************************************************************/
	protected JScrollPane pageSix() {
		JPanel pageSix, a;
		
		JCheckBox sixA1, sixA2, sixA3, sixA4, sixA5, sixA6, sixA7, sixA8,
		sixA9, sixA10, sixA11;
		
		JTextField sixAB1, sixAB2;
		
		JCheckBox sixZ1;
		
		JRadioButton sixB1, sixB2, sixB3, sixB4, sixB5, sixB6, sixB7, sixB8, sixB9,
		sixB10, sixB11, sixB12, sixB13, sixB14,sixB15;
		
		JRadioButton sixC1, sixC2, sixC3, sixC4, sixC5, sixC6, sixC7, sixC8, sixC9,
		sixC10, sixC11, sixC12;
		
		JRadioButton sixD1, sixD2, sixD3, sixD4, sixD5, sixD6, sixD7, sixD8, sixD9;
		
		JRadioButton sixE1, sixE2, sixE3, sixE4, sixE5, sixE6;
		
		JRadioButton sixF1, sixF2, sixF3, sixF4, sixF5, sixF6, sixF7, sixF8, sixF9,
		sixF10, sixF11, sixF12;
		
		JRadioButton sixG1, sixG2, sixG3, sixG4, sixG5, sixG6, sixG7, sixG8, sixG9,
		sixG10, sixG11, sixG12, sixG13, sixG14, sixG15;
		
		JRadioButton sixH1, sixH2, sixH3, sixH4, sixH5, sixH6, sixH7, sixH8, sixH9,
		sixH10, sixH11, sixH12;
		
		JRadioButton sixI1, sixI2, sixI3, sixI4, sixI5, sixI6, sixI7, sixI8, sixI9;
		
		JRadioButton sixJ1, sixJ2, sixJ3, sixJ4, sixJ5, sixJ6;
		
		JRadioButton sixK1, sixK2, sixK3;
		
		JRadioButton sixL1, sixL2, sixL3;
		
		ButtonGroup weightL, fever,  chills, fatigue, nSweats, abPain, tSwallow, bowels, bStool,
		cough, wheezing, sBreath, depression, anxiety, pUrin, sBladder, dUrin, bUrin, dVision, bVision, dHearing,
		pEars, sGlands, seizures, dizziness, bProblems, nHeadaches, cPain, palpitations, lSwelling, iRashes,
		sMole, jRedness, eBruising, pregnant, hDominance;
		
		JTextField sixLL1;
		
		JRadioButton sixM1, sixM2, sixM3;
		
		JTextField sixN1, sixN2;
		
		JRadioButton sixO1, sixO2, sixO3;
		
		JTextField sixP1;
		
		pageSix = new JPanel(new BorderLayout());
		 
		 a = new JPanel();
		 a.setLayout(new GridLayout(36,1));
		 a.setBackground(Color.YELLOW);
		 //non-symptom section
		 sixA1 = new JCheckBox("No, I am a student.");
		 sixA2 = new JCheckBox("Yes");
		 sixA3 = new JCheckBox("Np");
		 sixA4 = new JCheckBox("Disabled");
		 sixA5 = new JCheckBox("Retired");
		 sixA6 = new JCheckBox("N/A");
		 sixA7 = new JCheckBox("Normal Duty");
		 sixA8 = new JCheckBox("Light Duty");
		 sixA9 = new JCheckBox("Not working due to current condition");
		 sixA10 = new JCheckBox("Yes");
		 sixA11= new JCheckBox("No");
		 sixAB1 = new JTextField();
		 sixAB2 = new JTextField();
		 sixZ1 = new JCheckBox("I have no current issues other than the reason I am being see.");
		 //unexplained weight loss
		 sixB1 = new JRadioButton("Yes");
		 sixB2 = new JRadioButton("No");
		 sixB3 = new JRadioButton("Unsure");
		 //Fever
		 sixB4 = new JRadioButton("yes");
		 sixB5 = new JRadioButton("No");
		 sixB6 = new JRadioButton("Unsure");
		 //Chills
		 sixB7 = new JRadioButton("Yes");
		 sixB8 = new JRadioButton("No");
		 sixB9 = new JRadioButton("Unsure");
		 //Fatigue
		 sixB10 = new JRadioButton("Yes");
		 sixB11= new JRadioButton("No");
		 sixB12 = new JRadioButton("Unsure");
		 //night sweats
		 sixB13 = new JRadioButton("Yes");
		 sixB14 = new JRadioButton("No");
		 sixB15 = new JRadioButton("Unsure");
		 //abdominal pain/nausea/vomitting
		 sixC1 = new JRadioButton("Yes");
		 sixC2 = new JRadioButton("No");
		 sixC3 = new JRadioButton("Unsure");
		 //trouble swallowing
		 sixC4 = new JRadioButton("Yes");
		 sixC5 = new JRadioButton("No");
		 sixC6 = new JRadioButton("Unsure");
		 //change in bowel habits
		 sixC7 = new JRadioButton("Yes");
		 sixC8 = new JRadioButton("No");
		 sixC9 = new JRadioButton("Unsure");
		 //blood in stool
		 sixC10 = new JRadioButton("Yes");
		 sixC11 = new JRadioButton("No");
		 sixC12 = new JRadioButton("Unsure");
		 //cough
		 sixD1 = new JRadioButton("Yes");
		 sixD2 = new JRadioButton("No");
		 sixD3 = new JRadioButton("Unsure");
		 //wheezing
		 sixD4 = new JRadioButton("Yes");
		 sixD5 = new JRadioButton("No");
		 sixD6 = new JRadioButton("Unsure");
		 //shortness of breath
		 sixD7 = new JRadioButton("Yes");
		 sixD8 = new JRadioButton("No");
		 sixD9 = new JRadioButton("Unsure");
		 //depression
		 sixE1 = new JRadioButton("Yes");
		 sixE2 = new JRadioButton("No");
		 sixE3 = new JRadioButton("Unsure");
		 //anxiety
		 sixE4 = new JRadioButton("Yes");
		 sixE5 = new JRadioButton("No");
		 sixE6 = new JRadioButton("Unsure");
		 //painful urination
		 sixF1 = new JRadioButton("Yes");
		 sixF2 = new JRadioButton("No");
		 sixF3 = new JRadioButton("Unsure");
		 //sense of full bladder
		 sixF4 = new JRadioButton("Yes");
		 sixF5 = new JRadioButton("No");
		 sixF6 = new JRadioButton("Unsure");
		 //difficulty with urination
		 sixF7 = new JRadioButton("Yes");
		 sixF8 = new JRadioButton("No");
		 sixF9 = new JRadioButton("Unsure");
		 //blood in urine
		 sixF10 = new JRadioButton("Yes");
		 sixF11 = new JRadioButton("No");
		 sixF12= new JRadioButton("Unsure");
		 //double vision, blackouts or headaches
		 sixG1 = new JRadioButton("Yes");
		 sixG2 = new JRadioButton("No");
		 sixG3 = new JRadioButton("Unsure");
		 //blurred vision
		 sixG4 = new JRadioButton("Yes");
		 sixG5 = new JRadioButton("No");
		 sixG6 = new JRadioButton("Unsure");
		 //difficulty hearing
		 sixG7 = new JRadioButton("Yes");
		 sixG8 = new JRadioButton("No");
		 sixG9 = new JRadioButton("Unsure");
		 //pain/ringing in ears
		 sixG10 = new JRadioButton("Yes");
		 sixG11 = new JRadioButton("No");
		 sixG12 = new JRadioButton("Unsure");
		 //swollen neck glands
		 sixG13 = new JRadioButton("Yes");
		 sixG14 = new JRadioButton("No");
		 sixG15 = new JRadioButton("Unsure");
		 //seizures
		 sixH1 = new JRadioButton("Yes");
		 sixH2 = new JRadioButton("No");
		 sixH3 = new JRadioButton("Unsure");
		 //dizziness
		 sixH4 = new JRadioButton("Yes");
		 sixH5 = new JRadioButton("No");
		 sixH6 = new JRadioButton("Unsure");
		 //balance problems
		 sixH7 = new JRadioButton("Yes");
		 sixH8 = new JRadioButton("No");
		 sixH9 = new JRadioButton("Unsure");
		 //New headaches
		 sixH10 = new JRadioButton("Yes");
		 sixH11 = new JRadioButton("No");
		 sixH12 = new JRadioButton("Unsure");
		 //chest pain
		 sixI1 = new JRadioButton("Yes");
		 sixI2 = new JRadioButton("No");
		 sixI3 = new JRadioButton("Unsure");
		 //palpitations
		 sixI4 = new JRadioButton("Yes");
		 sixI5 = new JRadioButton("No");
		 sixI6 = new JRadioButton("Unsure");
		 //leg/feet swelling
		 sixI7 = new JRadioButton("Yes");
		 sixI8 = new JRadioButton("No");
		 sixI9 = new JRadioButton("Unsure");
		 //itching/rashes
		 sixJ1 = new JRadioButton("Yes");
		 sixJ2 = new JRadioButton("No");
		 sixJ3 = new JRadioButton("Unsure");
		 //sores/bleeding mole
		 sixJ4 = new JRadioButton("Yes");
		 sixJ5 = new JRadioButton("No");
		 sixJ6 = new JRadioButton("Unsure");
		 //joint sweling or redness
		 sixK1 = new JRadioButton("Yes");
		 sixK2 = new JRadioButton("No");
		 sixK3 = new JRadioButton("Unsure");
		 //easy bruising
		 sixL1 = new JRadioButton("Yes");
		 sixL2 = new JRadioButton("No");
		 sixL3 = new JRadioButton("Unsure");
		 //"other;" textfield
		 sixLL1 = new JTextField();
		 //pregnant area
		 sixM1 = new JRadioButton("Yes");
		 sixM2 = new JRadioButton("No");
		 sixM3 = new JRadioButton("Unsure");
		 //Height in feet/inches
		 sixN1 = new JTextField();
		 sixN2 = new JTextField();
		 //hand dominance
		 sixO1 = new JRadioButton("Right");
		 sixO2 = new JRadioButton("Left");
		 sixO3 = new JRadioButton("Weight");
		 //weight
		 sixP1 = new JTextField();
		 
		 pageSix.add(a);
		 a.add(sixA1);
		 a.add(sixA2);
		 a.add(sixA3);
		 a.add(sixA4);
		 a.add(sixA5);
		 a.add(sixA6);
		 a.add(sixA7);
		 a.add(sixA8);
		 a.add(sixA9);
		 a.add(sixA10);
		 a.add(sixA11);
		 a.add(sixAB1);
		 a.add(sixAB2);
		 a.add(sixZ1);
		 a.add(sixB1);
		 a.add(sixB2);
		 a.add(sixB3);
		 a.add(sixB4);
		 a.add(sixB5);
		 a.add(sixB6);
		 a.add(sixB7);
		 a.add(sixB8);
		 a.add(sixB9);
		 a.add(sixB10);
		 a.add(sixB11);
		 a.add(sixB12);
		 a.add(sixB13);
		 a.add(sixB14);
		 a.add(sixB15);
		 a.add(sixC1);
		 a.add(sixC2);
		 a.add(sixC3);
		 a.add(sixC4);
		 a.add(sixC5);
		 a.add(sixC6);
		 a.add(sixC7);
		 a.add(sixC8);
		 a.add(sixC9);
		 a.add(sixC10);
		 a.add(sixC11);
		 a.add(sixC12);
		 a.add(sixD1);
		 a.add(sixD2);
		 a.add(sixD3);
		 a.add(sixD4);
		 a.add(sixD5);
		 a.add(sixD6);
		 a.add(sixD7);
		 a.add(sixD8);
		 a.add(sixD9);
		 a.add(sixE1);
		 a.add(sixE2);
		 a.add(sixE3);
		 a.add(sixE4);
		 a.add(sixE5);
		 a.add(sixE6);
		 a.add(sixF1);
		 a.add(sixF2);
		 a.add(sixF3);
		 a.add(sixF4);
		 a.add(sixF5);
		 a.add(sixF6);
		 a.add(sixF7);
		 a.add(sixF8);
		 a.add(sixF9);
		 a.add(sixF10);
		 a.add(sixF11);
		 a.add(sixF12);
		 a.add(sixG1);
		 a.add(sixG2);
		 a.add(sixG3);
		 a.add(sixG4);
		 a.add(sixG5);
		 a.add(sixG6);
		 a.add(sixG7);
		 a.add(sixG8);
		 a.add(sixG9);
		 a.add(sixG10);
		 a.add(sixG11);
		 a.add(sixG12);
		 a.add(sixG13);
		 a.add(sixG14);
		 a.add(sixG15);
		 a.add(sixH1);
		 a.add(sixH2);
		 a.add(sixH3);
		 a.add(sixH4);
		 a.add(sixH5);
		 a.add(sixH6);
		 a.add(sixH7);
		 a.add(sixH8);
		 a.add(sixH9);
		 a.add(sixH10);
		 a.add(sixH11);
		 a.add(sixH12);
		 a.add(sixI1);
		 a.add(sixI2);
		 a.add(sixI3);
		 a.add(sixI4);
		 a.add(sixI5);
		 a.add(sixI6);
		 a.add(sixI7);
		 a.add(sixI8);
		 a.add(sixI9);
		 a.add(sixJ1);
		 a.add(sixJ2);
		 a.add(sixJ3);
		 a.add(sixJ4);
		 a.add(sixJ5);
		 a.add(sixJ6);
		 a.add(sixK1);
		 a.add(sixK2);
		 a.add(sixK3);
		 a.add(sixL1);
		 a.add(sixL2);
		 a.add(sixL3);
		 a.add(sixLL1);
		 a.add(sixM1);
		 a.add(sixM2);
		 a.add(sixM3);
		 a.add(sixN1);
		 a.add(sixN2);
		 a.add(sixO1);
		 a.add(sixO2);
		 a.add(sixO3);
		 a.add(sixP1);
		 //radio button groups by symptom
		 weightL = new ButtonGroup();
		 weightL.add(sixB1);
		 weightL.add(sixB2); 
		 weightL.add(sixB3);
		 fever = new ButtonGroup();
		 fever.add(sixB4);
		 fever.add(sixB5);
		 fever.add(sixB6);
		 chills= new ButtonGroup();
		 chills.add(sixB7);
		 chills.add(sixB8);
		 chills.add(sixB9);
		 fatigue = new ButtonGroup();
		 fatigue.add(sixB10);
		 fatigue.add(sixB11);
		 fatigue.add(sixB12);
		 
		 nSweats = new ButtonGroup();
		 nSweats.add(sixB13);
		 nSweats.add(sixB14);
		 nSweats.add(sixB15);
		 
		 abPain = new ButtonGroup();
		 abPain.add(sixC1);
		 abPain.add(sixC2);
		 abPain.add(sixC3);
		 
		 tSwallow = new ButtonGroup();
		 tSwallow.add(sixC4);
		 tSwallow.add(sixC5);
		 tSwallow.add(sixC6);
		 
		 bowels= new ButtonGroup();
		 bowels.add(sixC7);
		 bowels.add(sixC8);
		 bowels.add(sixC9);
		 
		 bStool = new ButtonGroup();
		 bStool.add(sixC10);
		 bStool.add(sixC11);
		 bStool.add(sixC12);
		 
		 cough = new ButtonGroup();
		 cough.add(sixD1);
		 cough.add(sixD2);
		 cough.add(sixD3);
		 
		 wheezing = new ButtonGroup();
		 wheezing.add(sixD4);
		 wheezing.add(sixD5);
		 wheezing.add(sixD6);
		 
		 sBreath= new ButtonGroup();
		 sBreath.add(sixD7);
		 sBreath.add(sixD8);
		 sBreath.add(sixD9);
		 
		 depression = new ButtonGroup();
		 depression.add(sixE1);
		 depression.add(sixE2);
		 depression.add(sixE3);
		 
		 anxiety = new ButtonGroup();
		 anxiety.add(sixE4);
		 anxiety.add(sixE5);
		 anxiety.add(sixE6);
		 
		 pUrin = new ButtonGroup();
		 pUrin.add(sixF1);
		 pUrin.add(sixF2);
		 pUrin.add(sixF3);
		 
		 sBladder = new ButtonGroup();
		 sBladder.add(sixF4);
		 sBladder.add(sixF5);
		 sBladder.add(sixF6);
		 
		 dUrin = new ButtonGroup();
		 dUrin.add(sixF7);
		 dUrin.add(sixF8);
		 dUrin.add(sixF9);
		 
		 bUrin = new ButtonGroup();
		 bUrin.add(sixF10);
		 bUrin.add(sixF11);
		 bUrin.add(sixF12);
		 
		 dVision = new ButtonGroup();
		 dVision.add(sixG1);
		 dVision.add(sixG2);
		 dVision.add(sixG3);
		 
		 bVision = new ButtonGroup();
		 bVision.add(sixG4);
		 bVision.add(sixG5);
		 bVision.add(sixG6);
		 
		 dHearing = new ButtonGroup();
		 dHearing.add(sixG7);
		 dHearing.add(sixG8);
		 dHearing.add(sixG9);
		 
		 pEars = new ButtonGroup();
		 pEars.add(sixG10);
		 pEars.add(sixG11);
		 pEars.add(sixG12);
		 
		 sGlands = new ButtonGroup();
		 sGlands.add(sixG13);
		 sGlands.add(sixG14);
		 sGlands.add(sixG15);
		 
		 seizures = new ButtonGroup();
		 seizures.add(sixH1);
		 seizures.add(sixH2);
		 seizures.add(sixH3);
		 
		 dizziness = new ButtonGroup();
		 dizziness.add(sixH4);
		 dizziness.add(sixH5);
		 dizziness.add(sixH6);
		 
		 bProblems = new ButtonGroup();
		 bProblems.add(sixH7);
		 bProblems.add(sixH8);
		 bProblems.add(sixH9);
		 
		 nHeadaches = new ButtonGroup();
		 nHeadaches.add(sixH10);
		 nHeadaches.add(sixH11);
		 nHeadaches.add(sixH12);
		 
		 cPain = new ButtonGroup();
		 cPain.add(sixI1);
		 cPain.add(sixI2);
		 cPain.add(sixI3);
		 
		 palpitations= new ButtonGroup();
		 palpitations.add(sixI4);
		 palpitations.add(sixI5);
		 palpitations.add(sixI6);
		 
		 lSwelling = new ButtonGroup();
		 lSwelling.add(sixI7);
		 lSwelling.add(sixI8);
		 lSwelling.add(sixI9);
		 
		 iRashes = new ButtonGroup();
		 iRashes.add(sixJ1);
		 iRashes.add(sixJ2);
		 iRashes.add(sixJ3);
		 
		 sMole = new ButtonGroup();
		 sMole.add(sixJ4);
		 sMole.add(sixJ5);
		 sMole.add(sixJ6);
		 
		 jRedness = new ButtonGroup();
		 jRedness.add(sixK1);
		 jRedness.add(sixK2);
		 jRedness.add(sixK3);
		 
		 eBruising = new ButtonGroup();
		 eBruising.add(sixL1);
		 eBruising.add(sixL2);
		 eBruising.add(sixL3);
		 a.add(sixLL1);
		 
		 pregnant = new ButtonGroup();
		 pregnant.add(sixM1);
		 pregnant.add(sixM2);
		 pregnant.add(sixM3);
		 
		 a.add(sixN1);
		 a.add(sixN2);
		 
		 hDominance = new ButtonGroup();
		 hDominance.add(sixO1);
		 hDominance.add(sixO2);
		 hDominance.add(sixO3);
		 a.add(sixP1);
		 
		 pageSix.add(a, BorderLayout.CENTER);
		 
		 pageSix.add(this.createControlPane("PageFive", "PageSeven"),
				BorderLayout.SOUTH);

			JScrollPane scroll = new JScrollPane(pageSix);
			return scroll;
		 
	}
	
	/******************************************************************
	 * Create page Seven
	 * 
	 * @return panel of page Seven
	 *****************************************************************/
	protected JScrollPane pageSeven() {
		JPanel a;
		JCheckBox sevenA2, sevenA3, sevenB1, sevenB2;
		JTextField sevenA1;
		
		JRadioButton sevenC1, sevenC2, sevenC3, sevenC4, sevenC5, sevenC6,
		sevenD1, sevenD2, sevenD3, sevenD4, sevenD5, sevenD6,
		sevenE1, sevenE2, sevenE3, sevenE4, sevenE5, sevenE6,
		sevenF1, sevenF2, sevenF3, sevenF4, sevenF5, sevenF6;
		
		ButtonGroup sevenC, sevenD, sevenE, sevenF;
		
		JPanel pageSeven = new JPanel(new BorderLayout());
		
		 a = new JPanel();
		 a.setLayout(new GridLayout(36,1));
		 a.setBackground(Color.YELLOW);
		 
		 //Question 1, page 7
		 sevenA1 = new JTextField();
		 sevenA2 = new JCheckBox("Yes");
		 sevenA3 = new JCheckBox("No");
		 //Question 2, page 7
		 sevenB1 = new JCheckBox("Yes");
		 sevenB2 = new JCheckBox("No");
		 
		 // Page 7, letters = question, number = selection to be chosen
		 sevenC1 = new JRadioButton("The pain comes and goes and is very mild.");
		 sevenC2 = new JRadioButton("The pain is mild and does not vary much.");
		 sevenC3 = new JRadioButton("The pain comes and goes and is moderate.");
		 sevenC4 = new JRadioButton("The pain is moderate and does not vary much.");
		 sevenC5 = new JRadioButton("The pain comes and goes and is severe.");
		 sevenC6 = new JRadioButton("The pain is severe and does not vary much.");
		
		 sevenD1 = new JRadioButton("I do not have to change my way of washing or dressing to avoid pain.");
		 sevenD2 = new JRadioButton("I do not normally change my way of washing or dressing even thought it causes some pain.");
		 sevenD3 = new JRadioButton("Washing and dressing increases the pain, but I manage not to change my way of doing it.");
		 sevenD4 = new JRadioButton("Washing and dressing increases the pain, and I find it necessary to change my way of doing it.");
		 sevenD5 = new JRadioButton("Because of pain, i am unable to do some washing and dressing without help.");
		 sevenD6 = new JRadioButton("Because of pain, I am unable to do any washing or dressing without help.");
		 
		 sevenE1 = new JRadioButton("I can lift heavy objects without extra pain.");
		 sevenE2 = new JRadioButton("I can lift heavy object, but it causes extra pain.");
		 sevenE3 = new JRadioButton("Pain prevents me from lifting heavy objects off the floor.");
		 sevenE4 = new JRadioButton("Pain prevents me from lifting heavy objects off the floor, but I can manage if they are conveniently positioned.");
		 sevenE5 = new JRadioButton("Pain prevents me from lifting heavy objects, but I can manage light/medium objects if they are conveniently positioned.");
		 sevenE6 = new JRadioButton("I can only lift very light objects, at the most.");
		 
		 sevenF1 = new JRadioButton("Pain does not prevent me from walking any distance.");
		 sevenF2 = new JRadioButton("I have some pain with walking long distances.");
		 sevenF3 = new JRadioButton("Pain prevents me from walking long distances.");
		 sevenF4 = new JRadioButton("Pain prevents me from walking intermediate distances.");
		 sevenF5 = new JRadioButton("Pain prevents me from walking without a cane or crutches.");
		 sevenF6 = new JRadioButton("Pain prevents me from walking at all.");
		 
		 sevenC = new ButtonGroup();
		 sevenD = new ButtonGroup();
		 sevenE = new ButtonGroup();
		 sevenF = new ButtonGroup();
		 
		 pageSeven.add(a);
		 a.add(sevenA1);
		 a.add(sevenA2);
		 a.add(sevenA3);
		 a.add(sevenB1);
		 a.add(sevenB2);
		 
		 sevenC.add(sevenC1);
		 sevenC.add(sevenC2);
		 sevenC.add(sevenC3);
		 sevenC.add(sevenC4);
		 sevenC.add(sevenC5);
		 sevenC.add(sevenC6);
		 
		 sevenD.add(sevenD1);
		 sevenD.add(sevenD2);
		 sevenD.add(sevenD3);
		 sevenD.add(sevenD4);
		 sevenD.add(sevenD5);
		 sevenD.add(sevenD6);
		 
		 sevenE.add(sevenE1);
		 sevenE.add(sevenE2);
		 sevenE.add(sevenE3);
		 sevenE.add(sevenE4);
		 sevenE.add(sevenE5);
		 sevenE.add(sevenE6);
		 
		 sevenF.add(sevenF1);
		 sevenF.add(sevenF2);
		 sevenF.add(sevenF3);
		 sevenF.add(sevenF4);
		 sevenF.add(sevenF5);
		 sevenF.add(sevenF6);
		 
		 a.add(sevenC1);
		 a.add(sevenC2);
		 a.add(sevenC3);
		 a.add(sevenC4);
		 a.add(sevenC5);
		 a.add(sevenC6);
		 
		 a.add(sevenD1);
		 a.add(sevenD2);
		 a.add(sevenD3);
		 a.add(sevenD4);
		 a.add(sevenD5);
		 a.add(sevenD6);
		 
		 a.add(sevenE1);
		 a.add(sevenE2);
		 a.add(sevenE3);
		 a.add(sevenE4);
		 a.add(sevenE5);
		 a.add(sevenE6);
		 
		 a.add(sevenF1);
		 a.add(sevenF2);
		 a.add(sevenF3);
		 a.add(sevenF4);
		 a.add(sevenF5);
		 a.add(sevenF6);
		 
		 pageSeven.add(this.createControlPane("PageSix", "PageEight"),
				BorderLayout.SOUTH);

			JScrollPane scroll = new JScrollPane(pageSeven);
			return scroll;
	}
	
	/******************************************************************
	 * Create page Eight
	 * 
	 * @return panel of page Eight
	 *****************************************************************/
	protected JScrollPane pageEight() {
		
		JPanel pageEight = new JPanel(new BorderLayout());
		JPanel a;
		JRadioButton eightA1, eightA2, eightA3, eightA4, eightA5, eightA6,
		 eightB1, eightB2, eightB3, eightB4, eightB5, eightB6,
		 eightC1, eightC2, eightC3, eightC4, eightC5, eightC6,
		 eightD1, eightD2, eightD3, eightD4, eightD5, eightD6,
		 eightE1, eightE2, eightE3, eightE4, eightE5, eightE6,
		 eightF1, eightF2, eightF3, eightF4, eightF5, eightF6;
		
		ButtonGroup eightA, eightB, eightC, eightD, eightE, eightF;
		 a = new JPanel();
		 a.setLayout(new GridLayout(36,1));
		 a.setBackground(Color.YELLOW);
		 
		 eightA1 = new JRadioButton("Sitting Does not cause me pain.");
		 eightA2 = new JRadioButton("I can sit as long as I need, provided I have my choice of sitting surfaces.");
		 eightA3 = new JRadioButton("Pain prevents me from sitting more than one hour.");
		 eightA4 = new JRadioButton("Pain prevents me from sitting more than half an hour.");
		 eightA5 = new JRadioButton("Pain prevents me from sitting more than ten minutes.");
		 eightA6 = new JRadioButton("Pain prevents me from sitting at all.");
		 
		 eightB1 = new JRadioButton("I can stand as long as I want without pain.");
		 eightB2 = new JRadioButton("I have some pain while standing, but it does not increase with time.");
		 eightB3 = new JRadioButton("I cannot stand for longer than one hour without increasing pain.");
		 eightB4 = new JRadioButton("I cannot stand for longer than half an hour without increasing pain.");
		 eightB5 = new JRadioButton("I cannot stand for more than ten minutes without increasing pain.");
		 eightB6 = new JRadioButton("I avoid standing because it increases pain right away.");
		 
		 eightC1 = new JRadioButton("I have no pain bed.");
		 eightC2 = new JRadioButton("I have pain in bed, but it does not prevent me from sleeping well.");
		 eightC3 = new JRadioButton("Because of pain, my normal night's sleep is reduced by less than one-quarter.");
		 eightC4 = new JRadioButton("Because of pain, my normail night's sleep is reduced by less than one-half.");
		 eightC5 = new JRadioButton("Because of pain, my normal night's sleep is reduced by less than three-quarters.");
		 eightC6 = new JRadioButton("Pain prevents me from sleeping at all.");
		 
		 eightD1 = new JRadioButton("My social life is normal and gives me no pain.");
		 eightD2 = new JRadioButton("My social life is normal, but icnreases the degree of my pain");
		 eightD3 = new JRadioButton("Pain has no significant effect on my social life apart from limmiting my more energetic interests.");
		 eightD4 = new JRadioButton("Pain has restricted my social life and I do not go out very often.");
		 eightD5 = new JRadioButton("Pain has restricted my social life to my home.");
		 eightD6 = new JRadioButton("Pain prevents me from and social life at all.");
		 
		 eightE1 = new JRadioButton("I get no pain while traveling.");
		 eightE2 = new JRadioButton("I get some pain while traveling, but none of my usual forms of travel make it any worse.");
		 eightE3 = new JRadioButton("I get extra pain while traveling, bit it does not compel me to seek alternative forms of travel.");
		 eightE4 = new JRadioButton("I get extra pain while traveling which compels me to seek alternative forms of travel.");
		 eightE5 = new JRadioButton("Pain restricts all forms of travel.");
		 eightE6 = new JRadioButton("Pain prevents all forms of travel except that done lying down.");
		 
		 eightF1 = new JRadioButton("My normal job/homemaking duties do not cause pain.");
		 eightF2 = new JRadioButton("My normal duties cause me extra paing, but I can still perferm all that is required of me.");
		 eightF3 = new JRadioButton("I can perform most of my duties, but pain prevents me from performing more physically stressful activities.");
		 eightF4 = new JRadioButton("Pain prevents me from doing anything but light duties.");
		 eightF5 = new JRadioButton("Pain prevents me from doing even light duties.");
		 eightF6 = new JRadioButton("Pain prevents me from performing any job or homemaking chore.");
		 
		 eightA = new ButtonGroup();
		 eightB = new ButtonGroup();
		 eightC = new ButtonGroup();
		 eightD = new ButtonGroup();
		 eightE = new ButtonGroup();
		 eightF = new ButtonGroup();
				 
		 pageEight.add(a);
		 
		 a.add(eightA1);
		 a.add(eightA2);
		 a.add(eightA3);
		 a.add(eightA4);
		 a.add(eightA5);
		 a.add(eightA6);
		 
		 a.add(eightB1);
		 a.add(eightB2);
		 a.add(eightB3);
		 a.add(eightB4);
		 a.add(eightB5);
		 a.add(eightB6);
		 
		 a.add(eightC1);
		 a.add(eightC2);
		 a.add(eightC3);
		 a.add(eightC4);
		 a.add(eightC5);
		 a.add(eightC6);
		 
		 a.add(eightD1);
		 a.add(eightD2);
		 a.add(eightD3);
		 a.add(eightD4);
		 a.add(eightD5);
		 a.add(eightD6);
		 
		 a.add(eightE1);
		 a.add(eightE2);
		 a.add(eightE3);
		 a.add(eightE4);
		 a.add(eightE5);
		 a.add(eightE6);
		 
		 a.add(eightF1);
		 a.add(eightF2);
		 a.add(eightF3);
		 a.add(eightF4);
		 a.add(eightF5);
		 a.add(eightF6);
		 
		 eightA.add(eightA1);
		 eightA.add(eightA2);
		 eightA.add(eightA3);
		 eightA.add(eightA4);
		 eightA.add(eightA5);
		 eightA.add(eightA6);
		 
		 eightB.add(eightB1);
		 eightB.add(eightB2);
		 eightB.add(eightB3);
		 eightB.add(eightB4);
		 eightB.add(eightB5);
		 eightB.add(eightB6);
		 
		 eightC.add(eightC1);
		 eightC.add(eightC2);
		 eightC.add(eightC3);
		 eightC.add(eightC4);
		 eightC.add(eightC5);
		 eightC.add(eightC6);
		 
		 eightD.add(eightD1);
		 eightD.add(eightD2);
		 eightD.add(eightD3);
		 eightD.add(eightD4);
		 eightD.add(eightD5);
		 eightD.add(eightD6);
		 
		 eightE.add(eightE1);
		 eightE.add(eightE2);
		 eightE.add(eightE3);
		 eightE.add(eightE4);
		 eightE.add(eightE5);
		 eightE.add(eightE6);
		 
		 eightF.add(eightF1);
		 eightF.add(eightF2);
		 eightF.add(eightF3);
		 eightF.add(eightF4);
		 eightF.add(eightF5);
		 eightF.add(eightF6);
		 
		 pageEight.add(this.createControlPane("PageSeven", null),
				BorderLayout.SOUTH);
		 
		 JScrollPane scroll = new JScrollPane(pageEight);
			return scroll;
	}
	

	/******************************************************************
	 * Add and action where the button upon click will go to the
	 * desired card in CardLayout
	 * 
	 * @param button
	 *            a button which will be modified
	 * @param id
	 *            is the string identifier of what next panel the
	 *            button will access
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
	 * Dynamically create a JLabel and JTextField and populate a
	 * JPanel
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
	 * Dynamically create a JLabel and JTextField and populate a
	 * JPanel
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
	 * @param prev is the id of the previous card
	 * @param next is the id of the next card
	 * @return
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

}
