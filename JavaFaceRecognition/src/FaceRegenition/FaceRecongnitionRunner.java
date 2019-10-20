package FaceRegenition;

import AppWindow.WindowContent;

public class FaceRecongnitionRunner {
	
	
	//check if the file has been uploaded
	public static boolean confirmed = false;
	
	public static void runFaceRecongnition() {
		//Change All Images and then Compare Them
		if(confirmed) {
			CompareImage ci = new CompareImage();
			ConvertImageToCorrectSize citcs = new ConvertImageToCorrectSize();
			citcs.ImageConverter(WindowContent.jfc.getSelectedFile().toString());
			ci.compare();	
		}
	}
	
}
