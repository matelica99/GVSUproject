package medForm;
import javax.swing.*;

import java.awt.*;

import javax.swing.ButtonGroup;

public class PageEight {

	private JFrame g;
	private JPanel a;
	
	//Buttons to page(eight), question(letter) and choice(number)
private JRadioButton eightA1, eightA2, eightA3, eightA4, eightA5, eightA6,
			 eightB1, eightB2, eightB3, eightB4, eightB5, eightB6,
			 eightC1, eightC2, eightC3, eightC4, eightC5, eightC6,
			 eightD1, eightD2, eightD3, eightD4, eightD5, eightD6,
			 eightE1, eightE2, eightE3, eightE4, eightE5, eightE6,
			 eightF1, eightF2, eightF3, eightF4, eightF5, eightF6;

//Each group of radiobuttons for each question on page 8
ButtonGroup eightA, eightB, eightC, eightD, eightE, eightF;



 public PageEight() {
	 gui();
 }
 
 public void gui(){
	 
	 g = new JFrame("Page Eight");
	 g.setVisible(true);
	 g.setSize(1000,1000);
	 g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
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
			 
	 g.add(a);
	 
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
 }
 
 public static void main(String[] args){
	 new PageEight();
 }
 
}

