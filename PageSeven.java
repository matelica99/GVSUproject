package medForm;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class PageSeven {
	private JFrame g;
	private JPanel a;
	private JCheckBox sevenA2, sevenA3, sevenB1, sevenB2;
	private JTextField sevenA1;
	
	private JRadioButton sevenC1, sevenC2, sevenC3, sevenC4, sevenC5, sevenC6,
	sevenD1, sevenD2, sevenD3, sevenD4, sevenD5, sevenD6,
	sevenE1, sevenE2, sevenE3, sevenE4, sevenE5, sevenE6,
	sevenF1, sevenF2, sevenF3, sevenF4, sevenF5, sevenF6;
	
	ButtonGroup sevenC, sevenD, sevenE, sevenF;
	public PageSeven(){
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
		 
		 g.add(a);
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
	} 
		 public static void main(String[] args){
			 new PageSeven();
		 }
			 
	
	
	
}
