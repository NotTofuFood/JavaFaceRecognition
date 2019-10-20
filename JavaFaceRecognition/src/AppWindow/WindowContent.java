package AppWindow;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import FaceRegenition.CompareImage;
import FaceRegenition.FaceRecongnitionRunner;

public class WindowContent extends JPanel {
	//DrawStuffHere

	private static final long serialVersionUID = 2066160653246321714L;

	public BufferedImage faceImage;
	public BufferedImage refImage;
	public static JFileChooser jfc = new JFileChooser();	
	Font font = new Font("Arial", 25, 15);
	Font font2 = new Font("Arial", 45, 35);
	JLabel faceText = new JLabel();
	public WindowContent() {
		setLayout(null);
		//Add Text to the Screen
		JLabel refText = new JLabel("Reference Image");
		JLabel faceText = new JLabel("Face Image");
		JLabel warningText = new JLabel("Try to avoid using glasses or having your clothes get into the picture. Also this is more accurate on Adults.");
		warningText.setBounds(0, 300, 850, 550);
		add(warningText);
		JLabel creditText = new JLabel("Created By: Not Tofu Food (Aiden Thakurdial)");
		creditText.setBounds(0, 500, 750, 250);
		creditText.setFont(font);
		add(creditText);
		refText.setBounds(750, 100, 250, 250);
		refText.setFont(font);
		add(refText);
		faceText.setBounds(300, 100, 250, 250);
		faceText.setFont(font);
		add(faceText);
  		add(this.faceText);
		//Add the upload button
		JButton jb = new JButton("Upload Face Image (.png)");
		jb.setBounds(500, 650, 250, 25);
		add(jb);
		
		//Get the file selected
		jb.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent args) {
				try {
					faceImage = ImageIO.read(jfc.getSelectedFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
		jfc.setBounds(500, 300, 250, 250);
		add(jfc);
		
		//Lastly Add A Button to Confirm the Proccess and Scan the Images
		JButton confirmButton = new JButton("Confirm Image and Detect Face");
		confirmButton.setBounds(500, 700, 250, 25);
		add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
	    		
				FaceRecongnitionRunner.confirmed = true;
				FaceRecongnitionRunner.runFaceRecongnition();
			}
			
		});
	}
	
	
	public void declareImages() {

		try {
			faceImage = ImageIO.read(new File("res/face.png"));
			refImage = ImageIO.read(new File("res/changeFaceScanner.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		//Draw the 2 Pictures to the Screen
		g.drawImage(faceImage, 300, 0, 100, 100,null);
		g.drawImage(refImage, 750, 0, 100, 100,null);
		
		//Draw Text to the Screen If it Detects A Face or Not
		if(FaceRecongnitionRunner.confirmed) {
        if(CompareImage.percentage <= 21.5) {
       		faceText.setOpaque(true);
    		faceText.setFont(font2);
    		faceText.setText("Face Detected");
    		faceText.setBounds(0, 500, 550, 45);
        } else {
    		faceText.setOpaque(true);
        	faceText.setText("Face Not Detected");
    		faceText.setFont(font2);
    		faceText.setBounds(0, 500, 550, 45);
        }
		}
		repaint();
	}
	
}
