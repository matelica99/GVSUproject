package medForm;

import javax.swing.*;


public class PageTwo {
private JFrame a;
private JPanel b;

private JCheckBox none, aching, burning, dull, sharp, shoot, throb, weak, on_off,
nothing, every, rep, exercise, forceWork, activity, lying, sitting, standing,
walk, drive, run, jump, squat, sitStand, climStair, pinch, grip, lift, bend, overHead, push,
throwing, twist, cold, vibration, heat, nothing1, rest, sling, brace, ele, sit1, stand1, lying1,
walk1, stretch, ice, heat1, therapy, inject, massage, meds, meds1;
private JRadioButton aBirth, approx, sudden, improv, nChange, worse;
private ButtonGroup sympStart, sympInfo;
private JTextField when, atBest, atWorst, avg, other, other1;

public PageTwo(){
	gui();
}
public void gui(){
	a = new JFrame("Page Seven");
	 a.setVisible(true);
	 a.setSize(1000,1000);
	 a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 b = new JPanel();
	 
	 //creating checkboxes...describe how it feels section 
	none = new JCheckBox("I have no symptoms.");
	aching = new JCheckBox("Aching");
	burning = new JCheckBox("Burning");
	dull = new JCheckBox("Dull");
	sharp = new JCheckBox("Sharp");
	shoot = new JCheckBox("Shooting");
	throb = new JCheckBox("Throbbing");
	weak = new JCheckBox("weakness");
	on_off = new JCheckBox("On and Off");
	
	//start of symptoms section
	aBirth = new JRadioButton("At Birth");
	approx = new JRadioButton("Approximately");
	sudden = new JRadioButton("Sudden");
	
	// ButtonGroup for 3 above radio buttons
	sympStart = new ButtonGroup();
	
	//textfield for symptom start section
	when = new JTextField();
	
	//3 buttons for symptom info section
	improv = new JRadioButton("Improving");
	nChange = new JRadioButton("No Change");
	worse = new JRadioButton("Worsening");
	
	//Buttongroup for 3 above buttons
	sympInfo = new ButtonGroup();
	//rate pain level section
	atBest = new JTextField();
	atWorst = new JTextField();
	avg = new JTextField();
	
	//What makes symptoms worse...section checkboxes and textfield
	nothing = new JCheckBox("Nothing");
	every = new JCheckBox("Everything");
	rep = new JCheckBox("Repetition");
	exercise = new JCheckBox("Exercise");
	forceWork = new JCheckBox("Forceful Work");
	activity = new JCheckBox("Activity");
	lying = new JCheckBox("Lying");
	sitting = new JCheckBox("Sitting");
	standing = new JCheckBox("Standing");
	walk = new JCheckBox("Walking");
	drive = new JCheckBox("Driving");
	run = new JCheckBox("Running");
	jump = new JCheckBox("Jumping");
	squat = new JCheckBox("Squatting");
	sitStand = new JCheckBox("Sitting to Standing");
	climStair = new JCheckBox("Climbing Stairs");
	pinch = new JCheckBox("Pinching");
	grip = new JCheckBox("Gripping");
	lift = new JCheckBox("Lifting");
	bend = new JCheckBox("Bending");
	overHead = new JCheckBox("Overhead Use");
	push = new JCheckBox("Pushing");
	throwing = new JCheckBox("Throwing");
	cold = new JCheckBox("Cold");
	twist = new JCheckBox("Twisting");
	vibration = new JCheckBox("Vibration");
	heat = new JCheckBox("Heat");
	other = new JTextField();
	
	//What makes symptoms better...section checkboxes and textfield
	nothing1 = new JCheckBox("Nothing");
	rest = new JCheckBox("Rest");
	sling = new JCheckBox("Sling");
	brace = new JCheckBox("Brace/Splint");
	ele = new JCheckBox("Elevation");
	sit1 = new JCheckBox("Sitting");
	stand1 = new JCheckBox("Standing");
	lying1 = new JCheckBox("Lying");
	walk1 = new JCheckBox("Walking");
	stretch = new JCheckBox("Stretching");
	ice = new JCheckBox("Ice");
	heat1 = new JCheckBox("Heat");
	therapy = new JCheckBox("Therapy");
	inject = new JCheckBox("Injections");
	massage = new JCheckBox("Massage");
	meds = new JCheckBox("Prescription medications");
	meds1 = new JCheckBox("Over-the-counter Medications");
	
	//what makes symptoms better textfield
	other1 = new JTextField();
	
	//adding buttons
	//describe how it feels section
	a.add(b);
	b.add(none);
	b.add(aching);
	b.add(burning);
	b.add(dull);
	b.add(sharp);
	b.add(shoot);
	b.add(throb);
	b.add(weak);
	b.add(on_off);
	
	//when did symptoms start section
	//buttongroup
	sympStart.add(aBirth);
	sympStart.add(approx);
	sympStart.add(sudden);
	
	//when textfield
	b.add(when);
	
	//symptoms info section
	//buttongroup
	sympInfo.add(improv);
	sympInfo.add(nChange);
	sympInfo.add(worse);
	
	//rate pain level section
	b.add(atBest);
	b.add(atWorst);
	b.add(avg);
	
	//What makes symptoms worse section
	b.add(nothing);
	b.add(every);
	b.add(rep);
	b.add(exercise);
	b.add(forceWork);
	b.add(activity);
	b.add(lying);
	b.add(sitting);
	b.add(standing);
	b.add(walk);
	b.add(drive);
	b.add(run);
	b.add(jump);
	b.add(squat);
	b.add(sitStand);
	b.add(climStair);
	b.add(pinch);
	b.add(grip);
	b.add(lift);
	b.add(bend);
	b.add(overHead);
	b.add(push);
	b.add(throwing);
	b.add(twist);
	b.add(cold);
	b.add(vibration);
	b.add(heat);
	b.add(other);
	
	//what makes symptoms better section
	b.add(nothing1);
	b.add(rest);
	b.add(sling);
	b.add(brace);
	b.add(ele);
	b.add(sit1);
	b.add(stand1);
	b.add(lying1);
	b.add(walk1);
	b.add(stretch);
	b.add(ice);
	b.add(heat1);
	b.add(therapy);
	b.add(inject);
	b.add(massage);
	b.add(meds);
	b.add(meds1);
	b.add(other1);
}


public static void main(String[]args){
	new PageTwo();
}

}
