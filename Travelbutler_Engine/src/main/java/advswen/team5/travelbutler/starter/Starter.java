package advswen.team5.travelbutler.starter;

import advswen.team5.travelbutler.output.PDFGenerator;
import advswen.team5.travelbutler.search.SearchRequestFassade;

public class Starter {
	
	public static void main(String[] args){
		
		SearchRequestFassade s1 = new SearchRequestFassade();
		
		
		try {
			new PDFGenerator(s1.search("France")).generate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}