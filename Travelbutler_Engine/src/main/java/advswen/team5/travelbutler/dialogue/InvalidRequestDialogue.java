package advswen.team5.travelbutler.dialogue;

/*
 * Author: Dennis Wagenblast
 */

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import advswen.team5.travelbutler.search.GrainEnum;

public class InvalidRequestDialogue extends JFrame implements ActionListener {

	private JFrame frmInvalidRequestDialogue;
	
	private JLabel lblInvalidInputMessage1;
	private JLabel lblInvalidInputMessage2;
	private JLabel lblInvalidInputMessage3;
	private JLabel lblInvalidInputMessage4;
	
	private JButton btnReturnToStart;

	private InputDialogue input;

	private JButton btnCancel;

	private String[] country;

	private String random;
	
	
	//Constructor to inizailize GUI
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
		
				
//		lblInvalidInputMessage4 = new JLabel();
//		lblInvalidInputMessage4.setText("search for: " + random + ", " + country[1] + " or " + country[2]);
//		lblInvalidInputMessage4.setBounds(40, 130, 300, 30);
//		frmInvalidRequestDialogue.getContentPane().add(lblInvalidInputMessage4);
			
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
	
	//Centre the Gui for every computer device
	public static void centreWindow (Window frame) {
			
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
			
		}
	//Starting the program through the GUI
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
	
	public void add3RandomCountriesAsSuugestion(){
		// Getting 3 random countries from countries.csv to suggest to user
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

			//Loading CSV-file to be able to use list of countries
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("countries.CSV").getFile());
			Properties properties = new Properties();
			try {
				properties.load(new FileReader(file));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				while ((line = br.readLine()) != null) {

					country = line.split(cvsSplitBy);
					for (String csvfileString : country) {
						for (int idx=0; idx<3; idx++){
						idx = new Random().nextInt(country.length);
						random = (country[idx]);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}

	
}
