package medForm;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PageOne {
	
	private JFrame a;
	private JPanel b;
	//patient info at top of page?
	private JTextField pName, date, dateOfBirth, gender, mrn, nameOfHealthSystem, other;
	//MRN = Medical Record Number...possibly add later?
	
	private JCheckBox friendFam, myDoc, insurCompany, caseManager, erMedCntr, newsPprAd,
	previousPt, internetSrch, tvCommercial, therapistTrainer, workersComp, billboard, fever, 
	nightPain, bowelBladder, uWeightLoss, numbTingling, swelling1, tenderness, bruising,
	weakness1, stiffMotion, jointLocking;
	
	private JRadioButton shoulder, upperArm, elbow, arm, forearm, wrist, hand, fingers, neck, neck_arm,
	back, back_leg, pelvis, hip, leg, thigh, knee, lower_leg, foot, ankle, right, left, both, na, pain1, injury,
	instability, fractureBrokenBone, sprain, massLump, swelling, weakness, stiffness, numbness, tingling,
	clicking, locking, deformity, wound, laceration;
	
	private ButtonGroup mainReasonForVisit, side, typeOfProblem;
	
 public PageOne(){
	gui();
}

public void gui(){
	//COMPANY LOGO TOP CORNER SOMEWHERE
	//GIANT "MEDICAL HISTORY" TILE at center of page
	
	a = new JFrame("Page One");
	a.setVisible(true);
	a.setSize(1000,1000);
	a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	b = new JPanel();
	
	//creating items
	//textfields at top for patient name, d.o.b., date and MRN
	pName = new JTextField();
	date = new JTextField();
	dateOfBirth = new JTextField();
	gender = new JTextField();
	mrn = new JTextField();
	
	//How did you hear about (Insert Health System Name)? section
	friendFam = new JCheckBox("Friend/Family");
	myDoc = new JCheckBox("My Doctor");
	insurCompany = new JCheckBox("Insurance Company");
	caseManager = new JCheckBox("Case Manager");
	erMedCntr = new JCheckBox("ER/Medical Center");
	newsPprAd = new JCheckBox("Newspaper Ad");
	previousPt = new JCheckBox("Previous Patient");
	//Health System textfield
	nameOfHealthSystem = new JTextField();
	
	internetSrch = new JCheckBox("Internet Search");
	tvCommercial = new JCheckBox("TV Commercial");
	therapistTrainer = new JCheckBox("Therapist/Trainer");
	workersComp = new JCheckBox("Worker's Compensation");
	billboard = new JCheckBox("Billboard");
	other = new JTextField("Other");
	
	//Main reason for visit section...SELECT ONE
	shoulder = new JRadioButton("Shoulder");
	upperArm = new JRadioButton("Upper Arm");
	elbow = new JRadioButton("Elbow");
	arm = new JRadioButton("Arm");
	forearm = new JRadioButton("Forearm");
	wrist = new JRadioButton("Wrist");
	hand = new JRadioButton("Hand");
	fingers = new JRadioButton("Finger(s)");
	neck = new JRadioButton("Neck");
	neck_arm = new JRadioButton("Neck and Arm");
	back = new JRadioButton("Back");
	back_leg = new JRadioButton("Back and Leg");
	pelvis = new JRadioButton("Pelvis");
	hip = new JRadioButton("Hip");
	leg = new JRadioButton("Leg");
	thigh = new JRadioButton("Thigh");
	knee = new JRadioButton("Knee");
	lower_leg = new JRadioButton("Lower Leg");
	ankle = new JRadioButton("Ankle");
	foot = new JRadioButton("Foot");
	
	//Button group for main_reason_for_visit section
	mainReasonForVisit = new ButtonGroup();
	
	//which side section buttons
	right = new JRadioButton("Right");
	left = new JRadioButton("Left");
	both = new JRadioButton("Both");
	na = new JRadioButton("N/A");
	//button group for which_side section
	side = new ButtonGroup();
	
	//Type of problem section...SELECT ONE
	pain1 = new JRadioButton("Pain");
	injury = new JRadioButton("Injury");
	instability = new JRadioButton("Instability");
	fractureBrokenBone = new JRadioButton("Fracture/Broken Bone");
	sprain = new JRadioButton("Sprain");
	massLump = new JRadioButton("Mass/Lump");
	swelling = new JRadioButton("Swelling");
	weakness = new JRadioButton("Weakness");
	stiffness = new JRadioButton("Stiffness");
	numbness = new JRadioButton("Numbness");
	tingling = new JRadioButton("Tingling");
	clicking = new JRadioButton("Clicking");
	locking = new JRadioButton("Locking");
	deformity = new JRadioButton("Deformity");
	wound = new JRadioButton("Wound");
	laceration = new JRadioButton("Laceration");
	
	//button group for type_of_problem section
	typeOfProblem = new ButtonGroup();
	
	//Other possible problems section
	fever = new JCheckBox("Fever");
	nightPain = new JCheckBox("Night Pain");
	bowelBladder = new JCheckBox("Bowel/Bladder Dysfunction");
	uWeightLoss = new JCheckBox("Unintentional Weight Loss");
	numbTingling = new JCheckBox("Numbness/Tingling");
	swelling1 = new JCheckBox("Swelling");
	tenderness = new JCheckBox("Tenderness");
	bruising = new JCheckBox("Bruising");
	weakness1 = new JCheckBox("Weakness");
	stiffMotion = new JCheckBox("Stiffness/Loss of Motion");
	jointLocking = new JCheckBox("Joint Locking");
	other = new JTextField();
	
	a.add(b);
	
	//adding buttons
	//Patient info section
	b.add(pName);
	b.add(date);
	b.add(dateOfBirth);
	b.add(gender);
	b.add(mrn);
	
	//how_did_pt_hear_about_(Health System Name) section
	b.add(friendFam);
	b.add(myDoc);
	b.add(insurCompany);
	b.add(caseManager);
	b.add(erMedCntr);
	b.add(newsPprAd);
	b.add(previousPt);
	b.add(nameOfHealthSystem);
	b.add(internetSrch);
	b.add(tvCommercial);
	b.add(therapistTrainer);
	b.add(workersComp);
	b.add(billboard);
	b.add(other);
	
	//Main_reason_for_visit section
	mainReasonForVisit.add(shoulder);
	mainReasonForVisit.add(upperArm);
	mainReasonForVisit.add(elbow);
	mainReasonForVisit.add(arm);
	mainReasonForVisit.add(forearm);
	mainReasonForVisit.add(wrist);
	mainReasonForVisit.add(hand);
	mainReasonForVisit.add(fingers);
	mainReasonForVisit.add(neck);
	mainReasonForVisit.add(neck_arm);
	mainReasonForVisit.add(back);
	mainReasonForVisit.add(back_leg);
	mainReasonForVisit.add(pelvis);
	mainReasonForVisit.add(hip);
	mainReasonForVisit.add(leg);
	mainReasonForVisit.add(thigh);
	mainReasonForVisit.add(knee);
	mainReasonForVisit.add(shoulder);
	mainReasonForVisit.add(lower_leg);
	mainReasonForVisit.add(ankle);
	mainReasonForVisit.add(foot);
	
	//which_side section
	side.add(right);
	side.add(left);
	side.add(both);
	side.add(na);
	
	//type_of_problem section
	typeOfProblem.add(pain1);
	typeOfProblem.add(injury);
	typeOfProblem.add(instability);
	typeOfProblem.add(fractureBrokenBone);
	typeOfProblem.add(sprain);
	typeOfProblem.add(massLump);
	typeOfProblem.add(swelling);
	typeOfProblem.add(weakness);
	typeOfProblem.add(stiffness);
	typeOfProblem.add(numbness);
	typeOfProblem.add(tingling);
	typeOfProblem.add(clicking);
	typeOfProblem.add(locking);
	typeOfProblem.add(deformity);
	typeOfProblem.add(wound);
	typeOfProblem.add(laceration);
	b.add(other);
	
	//Other_problem section
	b.add(fever);
	b.add(nightPain);
	b.add(bowelBladder);
	b.add(uWeightLoss);
	b.add(numbTingling);
	b.add(swelling1);
	b.add(tenderness);
	b.add(bruising);
	b.add(weakness1);
	b.add(stiffMotion);
	b.add(jointLocking);
	
	
}

public static void main(String[]args){
	new PageOne();
}
}

