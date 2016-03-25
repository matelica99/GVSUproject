package package1;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class saveLoadCaptureImage {
//Captures image
public static BufferedImage getScreenShot(Component component){
	BufferedImage image = new BufferedImage(component.getWidth(),component.getHeight(),BufferedImage.TYPE_INT_RGB);
	component.paint(image.getGraphics());
	return image;
}
//save image in form of PNG
public static void SaveScreenShot(Component component, String fileName) throws Exception{
	BufferedImage img = getScreenShot(component);
	ImageIO.write(img, "png", new File(fileName));
}
//this method should be activated by the button we put on each page to create the screenshot
//for SaveScreenShot we have a certain paramtes to pass....the panel name to be capture as an image
//name of file to save
//one button for each page?
JButton saveForm1= new JButton("Save Page");

private void SaveForm1(java.awt.event.ActionEvent evt){
	try{
	SaveScreenShot(pageOne, "Form Page One.png");
	}
	catch(Exception e){}
	}
//page 2
JButton saveForm2 = new JButton("Save Page");

private void SaveForm2(java.awt.event.ActionEvent evt){
	try{
	SaveScreenShot(pageTwo, "Form Page Two.png");
	}
	catch(Exception e){
	}
//page 3
JButton saveForm3 = new JButton("Save Page");

private void SaveForm3(java.awt.event.ActionEvent evt){
	try{
	SaveScreenShot(pageThree, "Form Page Three.png");
	}
	catch(Exception e){}
	}
//page 4
JButton saveForm4 = new JButton("Save Page");

private void SaveForm4(java.awt.event.ActionEvent evt){
	try{
	SaveScreenShot(pageFour, "Form Page Four.png");
	}
	catch(Exception e){}
	}
//page 5
JButton saveForm5 = new JButton("Save Page");

private void SaveForm5(java.awt.event.ActionEvent evt){
	try{
	SaveScreenShot(pageFive, "Form Page Five.png");
	}
	catch(Exception e){}
	}
//page 6
JButton saveForm6 = new JButton("Save Page");

private void SaveForm6(java.awt.event.ActionEvent evt){
	try{
	SaveScreenShot(pageSix, "Form Page Six.png");
	}
	catch(Exception e){}
	}
//page 7
JButton saveForm7 = new JButton("Save Page");

private void SaveForm7(java.awt.event.ActionEvent evt){
	try{
	SaveScreenShot(pageSeven, "Form Page Seven.png");
	}
	catch(Exception e){}
	}
//page 8
JButton saveForm8 = new JButton("Save Page");

private void SaveForm8(java.awt.event.ActionEvent evt){
	try{
	SaveScreenShot(pageEight, "Form Page Eight.png");
	}
	catch(Exception e){}
	}

saveForm1.addActionListener(new ActionListener(){
	
	public void actionperformed(ActionEvent e){
		JOptionPane.showMessageDialog(null, "Page has been saved.");
	}
	
});
}
}

