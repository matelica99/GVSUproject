package medForm;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PageThree {
private JFrame a;
private JPanel b;

private JCheckBox none, eDisease, hLoss, asthma, cOPD, emphysema, tuberculosis, sApnea, angina, aFibrillation, hDisease, hAttack,
hMurmur, hCholesterol, hBPressure, mVProlapse, aids, anemia, bDisorders, bClots, hemophilia, mrsa, mssa, sCDisease, bDisease,
gerd, hHernia, iHernia, iBSyndrome, kDisease, kStones, uHernia, uTInfection, cPalsy, meningitis, mHeadaches, mSclerosis,
pDisease, pNeuropathy, polio, sDisorder, sBifida, stroke, bProblems, fibromyalgia, mDisease, scoliosis, gout, osteopenia, lupus,
osteoarthritis, osteoporosis, rArthritis, lDisease, adhd, aAbuse, anxiety, bDisorder, depression, dAbuse, mDisability, ocd,
pDAbuse, pSAbuse, schizophrenia, diabetes, tDisease, aComplications, mHyperthermia;

private JTextField cancer, other;
// Hepatitis Buttons....Place "Hepatitis" on GUI somehow with buttons next to it
private JRadioButton h1, h2, h3;
private ButtonGroup hepa;

public PageThree(){
	gui();
}

public void gui(){
	a = new JFrame("Page Three");
	a.setVisible(true);
	a.setSize(1200,1200);
	a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	a.setLayout(new GridLayout(3,3));
	
	b = new JPanel();
	//create cancer type textfield
	cancer = new JTextField();
	//create other textfield
	other = new JTextField();
	
	//create heptatis radio buttons and group
	h1 = new JRadioButton("A");
	h2 = new JRadioButton("B");
	h3 = new JRadioButton("C");
	hepa = new ButtonGroup();
	//create disease related checkboxes
	none = new JCheckBox("I have no significant past medical history.");
	eDisease = new JCheckBox("Eye Disease");
	hLoss = new JCheckBox("Hearing Loss");
	asthma = new JCheckBox("Asthma");
	cOPD = new JCheckBox("COPD");
	emphysema = new JCheckBox("Emphysema");
	tuberculosis = new JCheckBox("Tuberculosis");
	sApnea = new JCheckBox("Sleep Apnea");
	angina = new JCheckBox("Angina");
	aFibrillation = new JCheckBox("Atrial Fibrillation");
	hDisease = new JCheckBox("Heart Disease");
	hAttack = new JCheckBox("Heart Attack");
	hMurmur = new JCheckBox("Heart Murmur");
	hCholesterol = new JCheckBox("High Cholesterol");
	hBPressure = new JCheckBox("High Blood Pressure");
	mVProlapse = new JCheckBox("Mitral Valve Prolapse");
	aids = new JCheckBox("AIDS/HIV");
	anemia = new JCheckBox("Anemia");
	bDisorders = new JCheckBox("Bleeding Disorders");
	bClots = new JCheckBox("Blood Clots");
	hemophilia = new JCheckBox("Hemophilia");
	mrsa = new JCheckBox("MRSA");
	mssa = new JCheckBox("MSSA");
	sCDisease = new JCheckBox("Sickle Cell Disease");
	bDisease = new JCheckBox("Bowel Disease");
	gerd = new JCheckBox("GERD/Ulcers");
	hHernia = new JCheckBox("Hiatal Hernia");
	iHernia = new JCheckBox("Inguinal Hernia");
	iBSyndrome = new JCheckBox("Irrital Bowel Syndrome");
	kDisease = new JCheckBox("Kidney Disease");
	kStones = new JCheckBox("Kidney Stones");
	uHernia = new JCheckBox("Umbilical Hernia");
	uTInfection = new JCheckBox("Urinary Tract Infection");
	cPalsy = new JCheckBox("Cerebral Palsy");
	meningitis = new JCheckBox("Menigitis");
	mHeadaches = new JCheckBox("Migraine Headaches");
	mSclerosis = new JCheckBox("Multiple Sclerosis");
	pDisease = new JCheckBox("Parkinson's Disease");
	pNeuropathy = new JCheckBox("Peripheral Neuropathy");
	polio = new JCheckBox("Polio");
	sDisorder = new JCheckBox("Seizure Disorder");
	sBifida = new JCheckBox("Spina Bifida");
	stroke = new JCheckBox("Stroke");
	bProblems = new JCheckBox("Back Problems");
	fibromyalgia = new JCheckBox("Fibromyalgia");
	mDisease = new JCheckBox("Muscular Diseases");
	scoliosis = new JCheckBox("Scoliosis");
	gout = new JCheckBox("Gout");
	osteopenia = new JCheckBox("Low Bone Mass/Osteopenia");
	lupus = new JCheckBox("Lupus");
	osteoarthritis = new JCheckBox("Osteoarthritis");
	osteoporosis = new JCheckBox("Osteoporosis");
	rArthritis = new JCheckBox("Rheumatoid Arthritis");
	lDisease = new JCheckBox("Liver Disease");
	adhd = new JCheckBox("ADD/ADHD");
	aAbuse = new JCheckBox("Alcohol Abuse");
	anxiety = new JCheckBox("Anxiety");
	bDisorder = new JCheckBox("Bipolar Disorder");
	depression = new JCheckBox("Depression");
	dAbuse = new JCheckBox("Drug Abuse");
	mDisability = new JCheckBox("Mental Disability");
	ocd = new JCheckBox("OCD");
	pDAbuse = new JCheckBox("Prescription Drug Abuse");
	pSAbuse = new JCheckBox("Preadolescent Sexual Abuse");
	schizophrenia = new JCheckBox("Schizophrenia");
	diabetes = new JCheckBox("Diabetes");
	tDisease = new JCheckBox("Thyroid Disease");
	aComplications = new JCheckBox("Anesthesia Complications");
	mHyperthermia = new JCheckBox("Malignant Hyperthermia");
	
	//add checkboxes
	a.add(b);
	b.add(none);
	b.add(eDisease);
	b.add(hLoss);
	b.add(asthma);
	b.add(cOPD);
	b.add(emphysema);
	b.add(tuberculosis);
	b.add(sApnea);
	b.add(angina);
	b.add(aFibrillation);
	b.add(hDisease);
	b.add(hAttack);
	b.add(hMurmur);
	b.add(hCholesterol);
	b.add(hBPressure);
	b.add(mVProlapse);
	b.add(aids);
	b.add(anemia);
	b.add(bDisorders);
	b.add(bClots);
	b.add(hemophilia);
	b.add(mrsa);
	b.add(mssa);
	b.add(sCDisease);
	b.add(bDisease);
	b.add(gerd);
	b.add(hHernia);
	b.add(iHernia);
	b.add(iBSyndrome);
	b.add(kDisease);
	b.add(kStones);
	b.add(uHernia);
	b.add(uTInfection);
	b.add(cancer);
	b.add(cPalsy);
	b.add(meningitis);
	b.add(mHeadaches);
	b.add(mSclerosis);
	b.add(pDisease);
	b.add(pNeuropathy);
	b.add(polio);
	b.add(sDisorder);
	b.add(sBifida);
	b.add(stroke);
	b.add(bProblems);
	b.add(fibromyalgia);
	b.add(mDisease);
	b.add(scoliosis);
	b.add(gout);
	b.add(osteopenia);
	b.add(lupus);
	b.add(osteoarthritis);
	b.add(osteoporosis);
	b.add(rArthritis);
	hepa.add(h1);
	hepa.add(h2);
	hepa.add(h3);
	b.add(lDisease);
	b.add(adhd);
	b.add(aAbuse);
	b.add(anxiety);
	b.add(bDisorder);
	b.add(depression);
	b.add(dAbuse);
	b.add(mDisability);
	b.add(ocd);
	b.add(pDAbuse);
	b.add(pSAbuse);
	b.add(schizophrenia);
	b.add(diabetes);
	b.add(tDisease);
	b.add(aComplications);
	b.add(mHyperthermia);
	b.add(other);
}

public static void main(String[]args){
	new PageThree();
}

}
