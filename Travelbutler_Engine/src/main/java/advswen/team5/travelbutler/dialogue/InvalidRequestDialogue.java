package advswen.team5.travelbutler.dialogue;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InvalidRequestDialogue extends JFrame implements ActionListener {

	private JFrame frmInvalidRequestDialogue;
	
	private JLabel lblInvalidInputMessage1;
	private JLabel lblInvalidInputMessage2;
	private JLabel lblInvalidInputMessage3;
	
	JButton btnReturnToStart;

	private InputDialogue input;

	private JButton btnCancel;
	
	
	//Constructor, der die GUI initialisiert ueber die Methode inizializeWindow();
	public InvalidRequestDialogue() {
					
		initializeInputWindow();
			
		}

	private void initializeInputWindow() {
			

		frmInvalidRequestDialogue = new JFrame();
		frmInvalidRequestDialogue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInvalidRequestDialogue.setTitle("Travelbutler");
		frmInvalidRequestDialogue.setBounds(100, 100, 400, 300);
		frmInvalidRequestDialogue.getContentPane().setLayout(null);
		centreWindow(frmInvalidRequestDialogue);
		
		lblInvalidInputMessage1 = new JLabel();
		lblInvalidInputMessage1.setText("We're sorry!");
		lblInvalidInputMessage1.setBounds(40, 45, 300, 30);
		frmInvalidRequestDialogue.getContentPane().add(lblInvalidInputMessage1);
			
		lblInvalidInputMessage2 = new JLabel();
		lblInvalidInputMessage2.setText("Your search request could not be processed");
		lblInvalidInputMessage2.setBounds(40, 80, 300, 30);
		frmInvalidRequestDialogue.getContentPane().add(lblInvalidInputMessage2);
			
		
		lblInvalidInputMessage3 = new JLabel();
		lblInvalidInputMessage3.setText("Press 'Go back!' to return to search");
		lblInvalidInputMessage3.setBounds(40, 115, 300, 30);
		frmInvalidRequestDialogue.getContentPane().add(lblInvalidInputMessage3);
			
		btnReturnToStart = new JButton();
		btnReturnToStart.setText("Go back!");
		btnReturnToStart.addActionListener(this);
		btnReturnToStart.setActionCommand("RETURNTOSTART");
		btnReturnToStart.setBounds(230, 200, 125, 30);
		frmInvalidRequestDialogue.getContentPane().add(btnReturnToStart);
		
		btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setActionCommand("CANCEL");
		btnCancel.setBounds(25, 200, 125, 30);
		frmInvalidRequestDialogue.getContentPane().add(btnCancel);
		
		}
	//Zentrierung des Fensters nach Starten des Programms
	public static void centreWindow (Window frame) {
			
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
			
		}
	//Aufuehren des Programms
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvalidRequestDialogue window = new InvalidRequestDialogue();
					window.frmInvalidRequestDialogue.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("RETURNTOSTART")){
			
			frmInvalidRequestDialogue.dispose();
			
			input = new InputDialogue();
			input.run();
		}
		
		if(e.getActionCommand().equals("CANCEL")){
			System.exit(0);
		}
		
	}

	
}
