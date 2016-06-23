package advswen.team5.travelbutler.dialogue;

/*
 * Author: Dennis Wagenblast
 */

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import advswen.team5.travelbutler.output.PDFGenerator;
import advswen.team5.travelbutler.search.SearchRequestFassade;

public class InputDialogue extends JFrame implements ActionListener {

	//Elements of GUI
	private JFrame frmInputWindow;
	private JTextField txtInputString;
	private JLabel lblInput;
	private JButton btnSearch;
	private JButton btnCancel;
	
	//Attributs that will be used through Getter and Setter methods
	private String travelDestination;
	
	//Call of the SearchRequestFassade
	private SearchRequestFassade searchRequestFassade;
	private InvalidRequestDialogue invalid;
	
	//Constructor to inizialize the GUI
	public InputDialogue(){
		
		initializeInputWindow();
		
	}

	//Building the GUI
	private void initializeInputWindow() {

		frmInputWindow = new JFrame();
		frmInputWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInputWindow.setTitle("Travelbutler");
		frmInputWindow.setBounds(100, 100, 400, 200);
		frmInputWindow.getContentPane().setLayout(null);
		centreWindow(frmInputWindow);
		
		btnSearch = new JButton();
		btnSearch.setText("Search");
		btnSearch.addActionListener(this);
		btnSearch.setActionCommand("SEARCH");
		btnSearch.setBounds(230, 110, 125, 30);
		frmInputWindow.getContentPane().add(btnSearch);
		
		btnCancel = new JButton();
		btnCancel.setText("Cancel");
		btnCancel.addActionListener(this);
		btnCancel.setActionCommand("CANCEL");
		btnCancel.setBounds(25, 110, 125, 30);
		frmInputWindow.getContentPane().add(btnCancel);
		
		lblInput = new JLabel();
		lblInput.setText("Travel destination: ");
		lblInput.setBounds(40, 45, 125, 30);
		frmInputWindow.getContentPane().add(lblInput);
		
		txtInputString = new JTextField();
		txtInputString.setBounds(160, 45, 180, 30);
		frmInputWindow.add(txtInputString);

	}
	
	//Running the program
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputDialogue window = new InputDialogue();
					window.frmInputWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Centre window on screen
	public static void centreWindow (Window frame) {
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
		
	}
	
	//Treatment of user input through buttons
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("SEARCH")){
				
			System.out.println("Search request is being processed!");
			
			//Close window
			frmInputWindow.dispose();
			
			setTravelDestination();
			
			//String travelDestination give through to SearchRequestFassade			
			searchRequestFassade = new SearchRequestFassade(travelDestination);
			
			if (searchRequestFassade.isValid()){
				
				try {
					File pdf = new PDFGenerator(searchRequestFassade.search()).generate();
					Desktop.getDesktop().open(pdf);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			} else {
				
				invalid = new InvalidRequestDialogue();
				invalid.run();
				
			}
			
		}else if(e.getActionCommand().equals("CANCEL")){
			
			//End application
			System.exit(0);
			
		}
	}

	//Getter and Setter
	public String getTravelDestination() {
		
		return travelDestination;
	
	}

	public void setTravelDestination() {
		
		travelDestination = txtInputString.getText();
	
	}

}