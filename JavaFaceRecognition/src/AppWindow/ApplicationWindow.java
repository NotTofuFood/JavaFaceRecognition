package AppWindow;

import javax.swing.JFrame;

public class ApplicationWindow {
	//Create Window
	public static void main(String[] args) {
		JFrame f = new JFrame("Face Recegnition");
		WindowContent wc = new WindowContent();
		wc.declareImages();
		f.add(wc);
		f.setVisible(true);
		f.setSize(1200,800);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
