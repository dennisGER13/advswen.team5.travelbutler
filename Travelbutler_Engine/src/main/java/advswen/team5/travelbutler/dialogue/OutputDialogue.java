package advswen.team5.travelbutler.dialogue;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class OutputDialogue {

	//Elemente des Outputdialogs
	private JFrame frmOutputWindow;
	private JLabel lblInputString;
	
	public OutputDialogue(){
		
		initializeOutputWindow();
		
	}

	//OutputDialog erstellen
	private void initializeOutputWindow() {
		
		frmOutputWindow = new JFrame();
		frmOutputWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOutputWindow.setTitle("Suchergebnisse - Travelbutler");
		frmOutputWindow.setBounds(100, 100, 350, 300);
		frmOutputWindow.getContentPane().setLayout(null);
		centreWindow(frmOutputWindow);
		
	}
	
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OutputDialogue window = new OutputDialogue();
					window.frmOutputWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
		//Zentrierung des Fensters nach Starten des Programms
		public static void centreWindow (Window frame) {
			
			Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
			int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
			frame.setLocation(x, y);
			
		}
	
}
