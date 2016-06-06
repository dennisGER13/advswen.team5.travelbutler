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

import advswen.team5.travelbutler.strategy.ConcreteStrategyBasic;
import advswen.team5.travelbutler.strategy.ConcreteStrategyFoo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SearchRequestFassade {
	private String requestString;
	private GrainEnum grain = GrainEnum.foo;
	private LanguageEnum language;
	private SearchEngine searchengine;
	
	public SearchRequestFassade(){
		searchengine  = new SearchEngine();
		this.language = LanguageEnum.english;		
	}
	//search() f�hrt eine Grain Pr�fung durch. Der Grain wird durch die Nutzereingabe bestimmt. Bsp. "Frankreich" = "Land"
	//Anschlie�end wird die suche gestartet, der Grain bestimmt welche Strategie gew�hlt wird.
	public String search(String requestString){
		this.grainDetection();
		if(grain == GrainEnum.land){
			searchengine.setStrategy(new ConcreteStrategyLand());
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

			br = new BufferedReader(new FileReader("/Travelbutler_Engine/src/main/resources/lands.CSV"));
			while ((line = br.readLine()) != null) {

				String[] country = line.split(cvsSplitBy);
				for (String foo : country) {
					// System.out.println(foo);
					if (searchString.equals(foo)) {
						System.out.println("Done");
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
		System.out.println("Done");
		return GrainEnum.foo;
	}
	
	public void languageDetection(){
		
	}
}