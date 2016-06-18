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

import advswen.team5.travelbutler.api.APIContainerGoogleGeoCoding;
import advswen.team5.travelbutler.api.response.*;
import advswen.team5.travelbutler.strategy.*;


public class SearchRequestFassade {
	private String requestString;
	private GrainEnum grain = GrainEnum.unknown;
	private SearchEngine searchengine;
	private boolean valid = true;

	public SearchRequestFassade(String requestString){
		searchengine  = new SearchEngine();
		this.requestString = formatInput(requestString);
		
		GoogleGeoCodingResponse geocode = new APIContainerGoogleGeoCoding().processSearch(requestString);

		grain = geocode.getGrain();
		
		if (grain == GrainEnum.unknown) {
			
			valid = false;
			
		}		
	}
	
	//If search request is valild, there will be a decision if country or city will be the stategy
	public Response search(){
		System.out.println("Starting search");
		
		if(grain == GrainEnum.country){
			searchengine.setStrategy(new ConcreteStrategyCounty());
		}
		
		if (grain == GrainEnum.city){
			searchengine.setStrategy(new ConcreteStrategyCity());
		}
		
		return searchengine.execute(requestString);
	}
	
	private String formatInput(String requestString){
		String returnValue = "";
		String[] split = requestString.trim().split(" ");
		for(String word : split){
			returnValue += word.substring(0, 1).toUpperCase();
			returnValue += word.substring(1).toLowerCase();
			returnValue += " ";
		}
		
		// remove the last blank
		return returnValue.substring(0, returnValue.length()-1);
	}
	
	public boolean isValid() {
		return valid;
	}
}