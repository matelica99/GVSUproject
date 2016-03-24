package medForm;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PageFour {
// Decided to only put 13 rows in past surgical history area, can add more if possible.
//Only 1 text textfield per row for medical allergies area...variables are named "other"
private JFrame b;
private JPanel a;
//medical allergies area variables. reminder: this is page 4
private JCheckBox adhesive, amoxicillin, aspirin, augmentin, bactrim, bSting, benadryl,
cipro, codeine, compazine, contrast_dye, demerol, dilaudid, doxycycline, erythromycin,
ibuprofen, iodine, keflex, latex, levaquin, lisonopril, macrobid, morphine, naprosyn,
oxycodone, penicillin, shellfish, statins, sulfa, tetracycline, tramadol, vicodin, zithromax;
//medical allergy reaction textboxes
private JTextField other1, other2, other3, other4,  reaction1, reaction2, reaction3, reaction4, reaction5,
reaction6, reaction7, reaction8, reaction9, reaction10, reaction11, reaction12, reaction13,
reaction14, reaction15, reaction16, reaction17, reaction18, reaction19, reaction20, reaction21,
reaction22, reaction23, reaction24, reaction25, reaction26, reaction27, reaction28,
reaction29, reaction30, reaction31, reaction32, reaction33;
//surgical history variables
//checkboxes for which side patient had surgery on (left or right)
private JCheckBox none;
private JRadioButton right1, right2, right3, right4, right5, right6, right7, right8 ,right9,
right10, right11, right12,right13, left1, left2, left3, left4, left5, left6, left7, left8,
left9, left10, left11, left12, left13;
//buttongroups for right and left buttons
private ButtonGroup rL1, rL2, rL3, rL4, rL5, rL6, rL7, rL8, rL9, rL10, rL11, rL12, rL13;
//surgery description textfields
private JTextField sDescrip1, sDescrip2, sDescrip3, sDescrip4, sDescrip5, sDescrip6, sDescrip7,
sDescrip8, sDescrip9, sDescrip10, sDescrip11, sDescrip12, sDescrip13;
//year textfield
private JTextField year1, year2, year3, year4, year5, year6, year7, year8, year9, year10,
year11, year12, year13;
//surgeon name textfield
private JTextField surgeon1, surgeon2, surgeon3, surgeon4, surgeon5, surgeon6, surgeon7, surgeon8,
surgeon9, surgeon10, surgeon11, surgeon12, surgeon13;

public PageFour()
{
	gui();
}
public void gui(){
	b = new JFrame("Page Four");
	b.setVisible(true);
	b.setSize(600,600);
	b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	a = new JPanel();
	//6 items per row with 3 columns
	a.setLayout(new GridLayout(6,3));
	//creation of allergy area buttons
	none = new JCheckBox("I have had no significant past surgeries.");
	adhesive = new JCheckBox("Adhesive");
	amoxicillin = new JCheckBox("Amoxicillin");
	aspirin = new JCheckBox("Aspirin");
	augmentin = new JCheckBox("Augmentin");
	bactrim = new JCheckBox("Bactrim");
	bSting = new JCheckBox("Bee Sting");
	benadryl = new JCheckBox("Benadryl");
	cipro = new JCheckBox("Cipro");
	codeine = new JCheckBox("Codeine");
	compazine = new JCheckBox("Compazine");
	contrast_dye = new JCheckBox("Contrast Dye");
	demerol = new JCheckBox("Demerol");
	dilaudid = new JCheckBox("Dilaudid");
	doxycycline = new JCheckBox("Doxycycline");
	erythromycin = new JCheckBox("Erythromycin");
	ibuprofen = new JCheckBox("Ibuprofen");
	iodine = new JCheckBox("Iodine");
	keflex = new JCheckBox("Keflex");
	latex = new JCheckBox("Latex");
	levaquin = new JCheckBox("Levaquin");
	lisonopril = new JCheckBox("Lisonopril");
	macrobid = new JCheckBox("Macrobid");
	morphine = new JCheckBox("Morphine");
	naprosyn = new JCheckBox("Naprosyn");
	oxycodone = new JCheckBox("Oxycodone");
	penicillin = new JCheckBox("Penicillin");
	shellfish = new JCheckBox("Shelllfish");
	statins = new JCheckBox("Statins");
	sulfa = new JCheckBox("Sulfa");
	tetracycline = new JCheckBox("Tetracycline");
	tramadol = new JCheckBox("Tramadol");
	vicodin = new JCheckBox("Vicodin");
	zithromax = new JCheckBox("Zithromax");
	reaction1 = new JTextField();
	reaction2 = new JTextField();
	reaction3 = new JTextField();
	reaction4 = new JTextField();
	reaction5 = new JTextField();
	reaction6 = new JTextField();
	reaction7 = new JTextField();
	reaction8 = new JTextField();
	reaction9 = new JTextField();
	reaction10 = new JTextField();
	reaction11= new JTextField();
	reaction12 = new JTextField();
	reaction13 = new JTextField();
	reaction14 = new JTextField();
	reaction15 = new JTextField();
	reaction16 = new JTextField();
	reaction17 = new JTextField();
	reaction18 = new JTextField();
	reaction19 = new JTextField();
	reaction20 = new JTextField();
	reaction21 = new JTextField();
	reaction22 = new JTextField();
	reaction23 = new JTextField();
	reaction24 = new JTextField();
	reaction25 = new JTextField();
	reaction26 = new JTextField();
	reaction27 = new JTextField();
	reaction28 = new JTextField();
	reaction29 = new JTextField();
	reaction30 = new JTextField();
	reaction31 = new JTextField();
	reaction32 = new JTextField();
	reaction33 = new JTextField();
	//Textfields at bottom of allergy area
	other1 = new JTextField();
	other2 = new JTextField();
	other3 = new JTextField();
	//other4 = other textfield at bottom of page 4
	other4 = new JTextField();
	//creation of surgery section button
	right1 = new JRadioButton("R");
	right2 = new JRadioButton("R");
	right3 = new JRadioButton("R");
	right4 = new JRadioButton("R");
	right5 = new JRadioButton("R");
	right6 = new JRadioButton("R");
	right7 = new JRadioButton("R");
	right8 = new JRadioButton("R");
	right9 = new JRadioButton("R");
	right10 = new JRadioButton("R");
	right11 = new JRadioButton("R");
	right12 = new JRadioButton("R");
	right13 = new JRadioButton("R");
	left1 = new JRadioButton("L");
	left2 = new JRadioButton("L");
	left3 = new JRadioButton("L");
	left4 = new JRadioButton("L");
	left5 = new JRadioButton("L");
	left6 = new JRadioButton("L");
	left7 = new JRadioButton("L");
	left8 = new JRadioButton("L");
	left9 = new JRadioButton("L");
	left10 = new JRadioButton("L");
	left11 = new JRadioButton("L");
	left12 = new JRadioButton("L");
	left13 = new JRadioButton("L");
	surgeon1 = new JTextField();
	surgeon2 = new JTextField();
	surgeon3 = new JTextField();
	surgeon4 = new JTextField();
	surgeon5 = new JTextField();
	surgeon6 = new JTextField();
	surgeon7 = new JTextField();
	surgeon8 = new JTextField();
	surgeon9 = new JTextField();
	surgeon10 = new JTextField();
	surgeon11= new JTextField();
	surgeon12 = new JTextField();
	surgeon13 = new JTextField();
	year1 = new JTextField();
	year2 = new JTextField();
	year3 = new JTextField();
	year4 = new JTextField();
	year5 = new JTextField();
	year6 = new JTextField();
	year7 = new JTextField();
	year8 = new JTextField();
	year9 = new JTextField();
	year10 = new JTextField();
	year11 = new JTextField();
	year12 = new JTextField();
	year13 = new JTextField();
	sDescrip1 = new JTextField();
	sDescrip2 = new JTextField();
	sDescrip3 = new JTextField();
	sDescrip4 = new JTextField();
	sDescrip5 = new JTextField();
	sDescrip6 = new JTextField();
	sDescrip7 = new JTextField();
	sDescrip8 = new JTextField();
	sDescrip9 = new JTextField();
	sDescrip10 = new JTextField();
	sDescrip11= new JTextField();
	sDescrip12 = new JTextField();
	sDescrip13 = new JTextField();
	rL1 = new ButtonGroup();
	rL2 = new ButtonGroup();
	rL3 = new ButtonGroup();
	rL4 = new ButtonGroup();
	rL5 = new ButtonGroup();
	rL6 = new ButtonGroup();
	rL7 = new ButtonGroup();
	rL8 = new ButtonGroup();
	rL9 = new ButtonGroup();
	rL10 = new ButtonGroup();
	rL11 = new ButtonGroup();
	rL12 = new ButtonGroup();
	rL13 = new ButtonGroup();
	b.add(a);
	
	//adding allergy buttons from left to right, row to row
	a.add(none);
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
	//adding right/left buttons to groups
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
	
	
	
	//Adding surgery section buttons/textfields
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
	}
public static void main(String[] args){
	new PageFour();
}
}
