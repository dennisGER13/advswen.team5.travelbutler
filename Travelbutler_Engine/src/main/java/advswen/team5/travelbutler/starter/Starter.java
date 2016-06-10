package advswen.team5.travelbutler.starter;

import java.awt.Desktop;
import java.io.File;

import advswen.team5.travelbutler.output.PDFGenerator;
import advswen.team5.travelbutler.search.SearchRequestFassade;

public class Starter {
	
	private static final String _destination = "Berlin";
	
	public static void main(String[] args){
		
		SearchRequestFassade s1 = new SearchRequestFassade();
		
		try {
			File pdf = new PDFGenerator(s1.search(_destination)).generate();
			Desktop.getDesktop().open(pdf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}