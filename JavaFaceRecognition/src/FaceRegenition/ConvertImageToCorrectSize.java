package FaceRegenition;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ConvertImageToCorrectSize {
	
	//Convert the Image
	public void ImageConverter(String img) {
		File face = new File(img);
		
		
		BufferedImage faceConverted;
		
		try {
			faceConverted = ImageIO.read(face);
			BufferedImage NEWbufferedConvertedImage = new BufferedImage(2040, 1360, BufferedImage.TYPE_INT_ARGB);
			
			for(int i = 0; i < faceConverted.getWidth(); i++) {
				for(int j = 0; j < faceConverted.getHeight(); j++) {
					//Start Converting Image
					Color c = new Color(faceConverted.getRGB(i, j));
					NEWbufferedConvertedImage.setRGB(i, j, c.getRGB());
				}
			}
			
			//Change the Actual Image File and Create A New Image file for comparing

				ImageIO.write(NEWbufferedConvertedImage, "png", new File("res/newFace.png"));	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}


