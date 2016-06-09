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
import advswen.team5.travelbutler.strategy.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SearchRequestFassade {
	private String requestString;
	private GrainEnum grain = GrainEnum.basic;
	private LanguageEnum language;
	private SearchEngine searchengine;
	
	public SearchRequestFassade(){
		searchengine  = new SearchEngine();
		this.language = LanguageEnum.english;		
		System.out.println("Suche bereit, warte auf Eingabe");
	}
	//search() f�hrt eine Grain Pr�fung durch. Der Grain wird durch die Nutzereingabe bestimmt. Bsp. "Frankreich" = "Land"
	//Anschlie�end wird die suche gestartet, der Grain bestimmt welche Strategie gew�hlt wird.
	public Response search(String requestString){
		System.out.println("Suche wurde gestartet");
		this.requestString = requestString;
		grain = this.grainDetection();
		if(grain == GrainEnum.land){
			System.out.println("Suche wird ausgeführt");
			searchengine.setStrategy(new ConcreteStrategyLand());
		}
		System.out.println("Ergebnisse werden geliefert");
		return searchengine.execute(requestString);
	}
	
	
	public GrainEnum grainDetection() {
		// String csvFile = "src/lands.CSV";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
		String searchString = this.requestString;

		try {

			//CSV-Datei laden und für die Grain-Detection nutzbar machen!
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("lands.CSV").getFile());
			Properties properties = new Properties();
			properties.load(new FileReader(file));
			
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {

				String[] country = line.split(cvsSplitBy);
				for (String foo : country) {
					// System.out.println(foo);
					if (searchString.equals(foo)) {
						System.out.println("Done");
						System.out.println("Grain wurde bestimmt: Land");
						return GrainEnum.land;
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
		System.out.println("Grain konnte nicht bestimmt werden");
		return GrainEnum.basic;
	}
	
	public void languageDetection(){
		
	}
}