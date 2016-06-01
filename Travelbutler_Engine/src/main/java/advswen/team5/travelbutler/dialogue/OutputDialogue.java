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
	private InputDialogue inputDialogue;
	
	
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
		
		//InputString auf der Ergebnisseite anzeigen
//		lblInputString = new JLabel();
//		inputDialogue = new InputDialogue();
//		inputDialogue.setTravelDestination();
//		lblInputString.setText(inputDialogue.getTravelDestination());
//		lblInputString.setBounds(20, 0, 500, 30);
//		frmOutputWindow.add(lblInputString);
		
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
