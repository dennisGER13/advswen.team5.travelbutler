package advswen.team5.travelbutler.dialogue;

import java.awt.Desktop;

/*
 * Author: Dennis Wagenblast
 */


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import advswen.team5.travelbutler.output.PDFGenerator;
import advswen.team5.travelbutler.search.SearchRequestFassade;

public class InputDialogue extends JFrame implements ActionListener {

	//Elemente der GUI
	private JFrame frmInputWindow;
	private JTextField txtInputString;
	private JLabel lblInput;
	private JButton btnSearch;
	private JButton btnCancel;
	private JLabel lblStartDate;
	private JLabel lblEndDate;
	private JXDatePicker pickerStartDate;
	private JXDatePicker pickerEndDate;
	
	//Attribute mit Getter und Setter, um Eingaben verwenden zu k�nnen
	private Date startDate;
	private Date endDate;
	private String travelDestination;
	
	//Aufruf der SearchRequest mit �bergabe des InputString 
	private SearchRequestFassade request;
	
	//Constructor, der die GUI initialisiert �ber die Methode inizializeWindow();
	public InputDialogue(){
		
		initializeInputWindow();
		
	}

	//Bauplan f�r die GUI mit Anordnung der Button, Label und Eingabefelder
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
		txtInputString.setText("Type in your travel destination");
		txtInputString.setBounds(160, 45, 180, 30);
		frmInputWindow.add(txtInputString);
	
//		lblStartDate = new JLabel();
//		lblStartDate.setText("Check-In");
//		lblStartDate.setBounds(40, 80, 125, 30);
//		frmInputWindow.getContentPane().add(lblStartDate);
//		
//		pickerStartDate = new JXDatePicker();
//		pickerStartDate.setBounds(160, 80, 125, 30);
//		frmInputWindow.getContentPane().add(pickerStartDate);
//		pickerStartDate.setDate(Calendar.getInstance().getTime());
//		pickerStartDate.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
//		
//		lblEndDate = new JLabel();
//		lblEndDate.setText("Check-Out");
//		lblEndDate.setBounds(40, 115, 125, 30);
//		frmInputWindow.getContentPane().add(lblEndDate);
//		
//		pickerEndDate = new JXDatePicker();
//		pickerEndDate.setBounds(160, 115, 125, 28);
//		frmInputWindow.getContentPane().add(pickerEndDate);
//		pickerEndDate.setDate(Calendar.getInstance().getTime());
//		pickerEndDate.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
		
	}
	
	//Auf�hren des Programms
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
	
	//Zentrierung des Fensters nach Starten des Programms
	public static void centreWindow (Window frame) {
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);
		
	}
	
	//Behandeln der ActionEvents je nach Eingabekommando
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("SEARCH")){
			
//			Methode, die nach der Suchbet�tigung weitere Operationen in die Wege leiten soll
//			doSomething();
			
			//Attribute setzen, um keine null-Werte zu bekommen
			setTravelDestination();
//			setStartDate();
//			setEndDate();
			
			//String travelDestination an SearchRequest �bergeben!!			
			request = new SearchRequestFassade();
			
			SearchRequestFassade s1 = new SearchRequestFassade();
			
			try {
				File pdf = new PDFGenerator(s1.search(travelDestination)).generate();
				Desktop.getDesktop().open(pdf);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			//Fenster nach Sucheingabe schlie�en!!
			frmInputWindow.dispose();

		}else if(e.getActionCommand().equals("CANCEL")){
			
			//Bei "Abbrechen" endet das Programm!
			System.exit(0);
			
		}
	}

	//Getter und Setter der Attribute, die weiter Verwendung finden werden
	public String getTravelDestination() {
		
		return travelDestination;
	
	}

	public void setTravelDestination() {
		
		travelDestination = txtInputString.getText();
	
	}

	public Date getStartDate() {
		
		return startDate;
	
	}

	public void setStartDate() {
		
		startDate = pickerStartDate.getDate();
	
	}

	public Date getEndDate() {
	
		return endDate;
	
	}

	public void setEndDate() {
	
		endDate = pickerEndDate.getDate();
	
	}

}