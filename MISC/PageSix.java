package medForm;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
public class PageSix {
	private JFrame g;
	private JPanel a;
	//check Boxes for non-symptom section
	private JCheckBox sixA1, sixA2, sixA3, sixA4, sixA5, sixA6, sixA7, sixA8,
	sixA9, sixA10, sixA11;
	//textfields for non-symptom section
	private JTextField sixAB1, sixAB2;
	//checkBox at beginning of symptom section
	private JCheckBox sixZ1;
	// these checkboxes with go by the groups in on the form from top to bottom
	private JRadioButton sixB1, sixB2, sixB3, sixB4, sixB5, sixB6, sixB7, sixB8, sixB9,
	sixB10, sixB11, sixB12, sixB13, sixB14,sixB15;
	private JRadioButton sixC1, sixC2, sixC3, sixC4, sixC5, sixC6, sixC7, sixC8, sixC9,
	sixC10, sixC11, sixC12;
	private JRadioButton sixD1, sixD2, sixD3, sixD4, sixD5, sixD6, sixD7, sixD8, sixD9;
	private JRadioButton sixE1, sixE2, sixE3, sixE4, sixE5, sixE6;
	private JRadioButton sixF1, sixF2, sixF3, sixF4, sixF5, sixF6, sixF7, sixF8, sixF9,
	sixF10, sixF11, sixF12;
	private JRadioButton sixG1, sixG2, sixG3, sixG4, sixG5, sixG6, sixG7, sixG8, sixG9,
	sixG10, sixG11, sixG12, sixG13, sixG14, sixG15;
	private JRadioButton sixH1, sixH2, sixH3, sixH4, sixH5, sixH6, sixH7, sixH8, sixH9,
	sixH10, sixH11, sixH12;
	private JRadioButton sixI1, sixI2, sixI3, sixI4, sixI5, sixI6, sixI7, sixI8, sixI9;
	private JRadioButton sixJ1, sixJ2, sixJ3, sixJ4, sixJ5, sixJ6;
	private JRadioButton sixK1, sixK2, sixK3;
	private JRadioButton sixL1, sixL2, sixL3;
	//button groups for Jbuttons by symptom
	private ButtonGroup weightL, fever, chills, fatigue, nSweats, abPain, tSwallow, bowels, bStool,
	cough, wheezing, sBreath, depression, anxiety, pUrin, sBladder, dUrin, bUrin, dVision, bVision, dHearing,
	pEars, sGlands, seizures, dizziness, bProblems, nHeadaches, cPain, palpitations, lSwelling, iRashes,
	sMole, jRedness, eBruising, pregnant, hDominance;
	//"Other:" textfield
	private JTextField sixLL1;
	//Pregnant area
	private JRadioButton sixM1, sixM2, sixM3;
	//Height in feet and inches
	private JTextField sixN1, sixN2;
	//Hand Dominance area
	private JRadioButton sixO1, sixO2, sixO3;
	//weight
	private JTextField sixP1;
	
	public PageSix(){
		gui();	
		}
	
	public void gui(){
		
		g = new JFrame("Page Seven");
		 g.setVisible(true);
		 g.setSize(1000,1000);
		 g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
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
		 
		 g.add(a);
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
		 weightL.add(sixB1);
		 weightL.add(sixB2); 
		 weightL.add(sixB3);
		 fever.add(sixB4);
		 fever.add(sixB5);
		 fever.add(sixB6);
		 chills.add(sixB7);
		 chills.add(sixB8);
		 chills.add(sixB9);
		 fatigue.add(sixB10);
		 fatigue.add(sixB11);
		 fatigue.add(sixB12);
		 nSweats.add(sixB13);
		 nSweats.add(sixB14);
		 nSweats.add(sixB15);
		 abPain.add(sixC1);
		 abPain.add(sixC2);
		 abPain.add(sixC3);
		 tSwallow.add(sixC4);
		 tSwallow.add(sixC5);
		 tSwallow.add(sixC6);
		 bowels.add(sixC7);
		 bowels.add(sixC8);
		 bowels.add(sixC9);
		 bStool.add(sixC10);
		 bStool.add(sixC11);
		 bStool.add(sixC12);
		 cough.add(sixD1);
		 cough.add(sixD2);
		 cough.add(sixD3);
		 wheezing.add(sixD4);
		 wheezing.add(sixD5);
		 wheezing.add(sixD6);
		 sBreath.add(sixD7);
		 sBreath.add(sixD8);
		 sBreath.add(sixD9);
		 depression.add(sixE1);
		 depression.add(sixE2);
		 depression.add(sixE3);
		 anxiety.add(sixE4);
		 anxiety.add(sixE5);
		 anxiety.add(sixE6);
		 pUrin.add(sixF1);
		 pUrin.add(sixF2);
		 pUrin.add(sixF3);
		 sBladder.add(sixF4);
		 sBladder.add(sixF5);
		 sBladder.add(sixF6);
		 dUrin.add(sixF7);
		 dUrin.add(sixF8);
		 dUrin.add(sixF9);
		 bUrin.add(sixF10);
		 bUrin.add(sixF11);
		 bUrin.add(sixF12);
		 dVision.add(sixG1);
		 dVision.add(sixG2);
		 dVision.add(sixG3);
		 bVision.add(sixG4);
		 bVision.add(sixG5);
		 bVision.add(sixG6);
		 dHearing.add(sixG7);
		 dHearing.add(sixG8);
		 dHearing.add(sixG9);
		 pEars.add(sixG10);
		 pEars.add(sixG11);
		 pEars.add(sixG12);
		 sGlands.add(sixG13);
		 sGlands.add(sixG14);
		 sGlands.add(sixG15);
		 seizures.add(sixH1);
		 seizures.add(sixH2);
		 seizures.add(sixH3);
		 dizziness.add(sixH4);
		 dizziness.add(sixH5);
		 dizziness.add(sixH6);
		 bProblems.add(sixH7);
		 bProblems.add(sixH8);
		 bProblems.add(sixH9);
		 nHeadaches.add(sixH10);
		 nHeadaches.add(sixH11);
		 nHeadaches.add(sixH12);
		 cPain.add(sixI1);
		 cPain.add(sixI2);
		 cPain.add(sixI3);
		 palpitations.add(sixI4);
		 palpitations.add(sixI5);
		 palpitations.add(sixI6);
		 lSwelling.add(sixI7);
		 lSwelling.add(sixI8);
		 lSwelling.add(sixI9);
		 iRashes.add(sixJ1);
		 iRashes.add(sixJ2);
		 iRashes.add(sixJ3);
		 sMole.add(sixJ4);
		 sMole.add(sixJ5);
		 sMole.add(sixJ6);
		 jRedness.add(sixK1);
		 jRedness.add(sixK2);
		 jRedness.add(sixK3);
		 eBruising.add(sixL1);
		 eBruising.add(sixL2);
		 eBruising.add(sixL3);
		 a.add(sixLL1);
		 pregnant.add(sixM1);
		 pregnant.add(sixM2);
		 pregnant.add(sixM3);
		 a.add(sixN1);
		 a.add(sixN2);
		 hDominance.add(sixO1);
		 hDominance.add(sixO2);
		 hDominance.add(sixO3);
		 a.add(sixP1);
			
		 
		
	}
	public static void main(String[] args){
		 new PageSix();
	 }
}
