package advswen.team5.travelbutler.dialogue;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class ProgressBar {

	private JProgressBar progressBar;
	private Container content;
	private JFrame f;
	private int maxSteps = 0;
	private int step = 0;

	public ProgressBar(int maxValue) {
		this.maxSteps = maxValue;
		f = new JFrame("JProgressBar Sample");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content = f.getContentPane();
		progressBar = new JProgressBar();
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		Border border = BorderFactory.createTitledBorder("Searching Informations...");
		progressBar.setBorder(border);
		content.add(progressBar, BorderLayout.NORTH);
		f.setSize(300, 100);
		f.setVisible(true);
		calculatingSteps();
	}

	private void calculatingSteps(){
		step = 100/maxSteps;
	}
	public void updateProgressBar(int i) {
		
		progressBar.setValue(step*i);
		if(i == maxSteps){
			progressBar.setValue(100);
			f.setVisible(false);
		}
		f.setVisible(true);
	}

}
