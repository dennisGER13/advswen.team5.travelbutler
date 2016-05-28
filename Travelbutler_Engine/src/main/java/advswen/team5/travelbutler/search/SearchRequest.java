// *************************************************************************************
// File:         [SearchRequest.java]
// Created:      [2016/05/24 Tuesday]
// Last Changed: $Date: 2016/05/24 18:19:00 $
// Author:       <A HREF="mailto:[al-161385@hs-weingarten.de]">[Alexander Lohr]</A>
//**************************************************************************************
//Description: 	Klasse für Aufnahme der Nutzeranfrage und zum initialisieren der Search
//				Engine. 
//**************************************************************************************
   
package advswen.team5.travelbutler.search;

import advswen.team5.travelbutler.strategy.ConcreteStrategyFoo;

public class SearchRequest {
	private String requestString;
	private GrainEnum grain = GrainEnum.foo;
	private LanguageEnum language;
	private SearchEngine searchengine;
	
	public SearchRequest(String requestString){
		searchengine  = new SearchEngine();
		this.requestString = requestString;
		language = LanguageEnum.english;
		
		this.grainDetection();
		
		this.search();
		
	}
	//search() führt eine Grain Prüfung durch. Der Grain wird durch die Nutzereingabe bestimmt. Bsp. "Frankreich" = "Land"
	//Anschließend wird die suche gestartet, der Grain bestimmt welche Strategie gewählt wird.
	public String search(){
		if(grain == GrainEnum.foo){
			searchengine.setStrategy(new ConcreteStrategyFoo());
		}
		return searchengine.execute(requestString);
	}
	//Aktuell nur mit Dummy Code versehen
	public GrainEnum grainDetection(){
		return grain = GrainEnum.foo;
	}
	
	public void languageDetection(){
		
	}
}