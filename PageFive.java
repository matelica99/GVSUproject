package medForm;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PageFive {
	private JFrame g;
	private JPanel a;
	private JTextField other, race1, race2, ethnicity, pLanguage;
	private JCheckBox fiveA1, fiveA2, fiveA3, fiveA4, fiveA5, fiveA6;
	private JRadioButton fiveB1, fiveB2, fiveB3, fiveB4, fiveB5, fiveB6, fiveC1, fiveC2, fiveC3, 
	fiveC4, fiveC5,fiveD1,fiveD2, fiveE1, fiveE2, fiveE3, fiveE4, fiveF1, fiveF2;
	private ButtonGroup aAbuse, aComplications, arthritis, bProblems, bDisorder,
	bClot, cancer, diabetes, sDisorder, hDisease, hBPressure, iDAbuse, kDisease,
	lDisease, mIllness, mDisease, pDAbuse, osteoporosis, scoliosis, stroke;
	
	public PageFive(){
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
		 //checkboxes for family history
		 fiveA1 = new JCheckBox("Mother");
		 fiveA2 = new JCheckBox("Father");
		 fiveA3 = new JCheckBox("Sister");
		 fiveA4 = new JCheckBox("Brother");
		 fiveA5 = new JCheckBox("Daughter");
		 fiveA6 = new JCheckBox("Son");
		 //"Other:" textbox
		 other = new JTextField();
		//smoking social hisotry
		 fiveB1 = new JRadioButton("Never smoker");
		 fiveB2 = new JRadioButton("Former smoker");
		 fiveB3 = new JRadioButton("Unknown if ever smoked");
		 fiveB4 = new JRadioButton("Smoker, current status unknown");
		 fiveB5 = new JRadioButton("Current every day smoker");
		 fiveB6 = new JRadioButton("Current some day smoker");
		 //Packs per day
		 fiveC1 = new JRadioButton("<1");
		 fiveC2 = new JRadioButton("1");
		 fiveC3 = new JRadioButton("2");
		 fiveC4 = new JRadioButton("3");
		 fiveC5 = new JRadioButton("4+");
		 //live in smoke free home
		 fiveD1 = new JRadioButton("Yes");
		 fiveD2 = new JRadioButton("No");
		 //drinking habits
		 fiveE1 = new JRadioButton("Never");
		 fiveE2 = new JRadioButton("Occasionally");
		 fiveE3 = new JRadioButton("Frequently");
		 fiveE4 = new JRadioButton("Heavily");
		 //race, ethnicity, prefered language
		 race1 = new JTextField();
		 race2 = new JTextField();
		 ethnicity = new JTextField();
		 pLanguage = new JTextField();
		 
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
		 a.add(fiveF1);
		 a.add(fiveF2);
		 
		//adding buttons to groups
		 //alcohol abuse
		 aAbuse.add(fiveA1);
		 aAbuse.add(fiveA2);
		 aAbuse.add(fiveA3);
		 aAbuse.add(fiveA4);
		 aAbuse.add(fiveA5);
		 aAbuse.add(fiveA6);
		 //anesthesia complications
		 aComplications.add(fiveA1);
		 aComplications.add(fiveA2);
		 aComplications.add(fiveA3);
		 aComplications.add(fiveA4);
		 aComplications.add(fiveA5);
		 aComplications.add(fiveA6);
		 //arthritis
		 arthritis.add(fiveA1);
		 arthritis.add(fiveA2);
		 arthritis.add(fiveA3);
		 arthritis.add(fiveA4);
		 arthritis.add(fiveA5);
		 arthritis.add(fiveA6);
		 //back problems
		 bProblems.add(fiveA1);
		 bProblems.add(fiveA2);
		 bProblems.add(fiveA3);
		 bProblems.add(fiveA4);
		 bProblems.add(fiveA5);
		 bProblems.add(fiveA6);
		 //bleeding disorder
		 bDisorder.add(fiveA1);
		 bDisorder.add(fiveA2);
		 bDisorder.add(fiveA3);
		 bDisorder.add(fiveA4);
		 bDisorder.add(fiveA5);
		 bDisorder.add(fiveA6);
		 //blood clot
		 bClot.add(fiveA1);
		 bClot.add(fiveA2);
		 bClot.add(fiveA3);
		 bClot.add(fiveA4);
		 bClot.add(fiveA5);
		 bClot.add(fiveA6);
		 //cancer
		 cancer.add(fiveA1);
		 cancer.add(fiveA2);
		 cancer.add(fiveA3);
		 cancer.add(fiveA4);
		 cancer.add(fiveA5);
		 cancer.add(fiveA6);
		 //diabetes
		 diabetes.add(fiveA1);
		 diabetes.add(fiveA2);
		 diabetes.add(fiveA3);
		 diabetes.add(fiveA4);
		 diabetes.add(fiveA5);
		 diabetes.add(fiveA6);
		 //seizure disorder
		 sDisorder.add(fiveA1);
		 sDisorder.add(fiveA2);
		 sDisorder.add(fiveA3);
		 sDisorder.add(fiveA4);
		 sDisorder.add(fiveA5);
		 sDisorder.add(fiveA6);
		 //heart disease
		 hDisease.add(fiveA1);
		 hDisease.add(fiveA2);
		 hDisease.add(fiveA3);
		 hDisease.add(fiveA4);
		 hDisease.add(fiveA5);
		 hDisease.add(fiveA6);
		 //high blood pressure
		 hBPressure.add(fiveA1);
		 hBPressure.add(fiveA2);
		 hBPressure.add(fiveA3);
		 hBPressure.add(fiveA4);
		 hBPressure.add(fiveA5);
		 hBPressure.add(fiveA6);
		 //illegal drug abuse
		 iDAbuse.add(fiveA1);
		 iDAbuse.add(fiveA2);
		 iDAbuse.add(fiveA3);
		 iDAbuse.add(fiveA4);
		 iDAbuse.add(fiveA5);
		 iDAbuse.add(fiveA6);
		 //kidney disease
		 kDisease.add(fiveA1);
		 kDisease.add(fiveA2);
		 kDisease.add(fiveA3);
		 kDisease.add(fiveA4);
		 kDisease.add(fiveA5);
		 kDisease.add(fiveA6);
		 //lung disease
		 lDisease.add(fiveA1);
		 kDisease.add(fiveA2);
		 kDisease.add(fiveA3);
		 kDisease.add(fiveA4);
		 kDisease.add(fiveA5);
		 kDisease.add(fiveA6);
		 //mental illness
		 mIllness.add(fiveA1);
		 mIllness.add(fiveA2);
		 mIllness.add(fiveA3);
		 mIllness.add(fiveA4);
		 mIllness.add(fiveA5);
		 mIllness.add(fiveA6);
		 //muscle disease
		 mDisease.add(fiveA1);
		 mDisease.add(fiveA2);
		 mDisease.add(fiveA3);
		 mDisease.add(fiveA4);
		 mDisease.add(fiveA5);
		 mDisease.add(fiveA6);
		 //prescription drug abuse
		 pDAbuse.add(fiveA1);
		 pDAbuse.add(fiveA2);
		 pDAbuse.add(fiveA3);
		 pDAbuse.add(fiveA4);
		 pDAbuse.add(fiveA5);
		 pDAbuse.add(fiveA6);
		 //osteoporosis
		 osteoporosis.add(fiveA1);
		 osteoporosis.add(fiveA2);
		 osteoporosis.add(fiveA3);
		 osteoporosis.add(fiveA4);
		 osteoporosis.add(fiveA5);
		 osteoporosis.add(fiveA6);
		 //scoliosis
		 scoliosis.add(fiveA1);
		 scoliosis.add(fiveA2);
		 scoliosis.add(fiveA3);
		 scoliosis.add(fiveA4);
		 scoliosis.add(fiveA5);
		 scoliosis.add(fiveA6);
		 //stroke
		 stroke.add(fiveA1);
		 stroke.add(fiveA2);
		 stroke.add(fiveA3);
		 stroke.add(fiveA4);
		 stroke.add(fiveA5);
		 stroke.add(fiveA6);
	}
	public static void main(String[] args){
		 new PageFive();
	 }
}
