// *************************************************************************************
// File:         [SearchRequest.java]
// Created:      [2016/05/24 Tuesday]
// Last Changed: $Date: 2016/05/24 18:19:00 $
// Author:       <A HREF="mailto:[al-161385@hs-weingarten.de]">[Alexander Lohr]</A>
//**************************************************************************************
//Description: 	Klasse f�r Aufnahme der Nutzeranfrage und zum initialisieren der Search
//				Engine. 
//**************************************************************************************
   
package advswen.team5.travelbutler.search;

import advswen.team5.travelbutler.api.response.*;
import advswen.team5.travelbutler.dialogue.InvalidRequestDialogue;
import advswen.team5.travelbutler.strategy.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SearchRequestFassade {
	private String requestString;
	private GrainEnum grain = GrainEnum.unknown;
	private LanguageEnum language;
	private SearchEngine searchengine;
	private InvalidRequestDialogue invalid;
	
	public SearchRequestFassade(){
		searchengine  = new SearchEngine();
		this.language = LanguageEnum.english;		
	}
	//search() f�hrt eine Grain Pr�fung durch. Der Grain wird durch die Nutzereingabe bestimmt. Bsp. "Frankreich" = "Land"
	//Anschlie�end wird die suche gestartet, der Grain bestimmt welche Strategie gew�hlt wird.
	public Response search(String requestString){
		System.out.println("Starting search");
		this.requestString = requestString;
		grain = this.grainDetection();
		
		if(grain == GrainEnum.country){
			searchengine.setStrategy(new ConcreteStrategyCounty());
		}
		
		if (grain == GrainEnum.city){
			searchengine.setStrategy(new ConcreteStrategyCity());
		}
		
		if (grain == GrainEnum.unknown) {
			
			//If grain unknown is detected, there will open GUI to redirect user to search dialogue
			invalid = new InvalidRequestDialogue();
			invalid.run();
			
		}
		return searchengine.execute(requestString);
	}
	
	
	public GrainEnum grainDetection() {
		// String csvFile = "src/lands.CSV";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		String searchString = this.requestString;

		try {

			//Loading CSV-File to be able to use list of countries
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("countries.CSV").getFile());
			Properties properties = new Properties();
			properties.load(new FileReader(file));
			
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {

				String[] country = line.split(cvsSplitBy);
				for (String foo : country) {
					// System.out.println(foo);
					if (searchString.toLowerCase().equals(foo.toLowerCase())) {
						return GrainEnum.country;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
//		if(){
		//TODO GrainDetection City to be implemented here!
		
		
		
//		return GrainEnum.city;
//		} else {
//			return GrainEnum.unknown;
//	}
		
		return null;
	}
	
	public void languageDetection(){
		
	}
}