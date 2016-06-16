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
		
		if (grain == GrainEnum.unknown)
			valid = false;
	}
	
	//If search request is valid, there will be a decision if country or city will be the strategy
	public Response search(){
		System.out.println("Starting search");
		
		if(grain == GrainEnum.country){
			searchengine.setStrategy(new ConcreteStrategyCounty());
		}else if (grain == GrainEnum.city){
			searchengine.setStrategy(new ConcreteStrategyCity());
		}else{
			// Return null if no valid search strategy exists
			return null;
		}
		
		return searchengine.execute(requestString);
	}
	
	// Capitalizes each word in the request string
	private String formatInput(String requestString){
		String returnValue = "";
		String[] split = requestString.trim().split(" ");
		for(String word : split){
			returnValue += word.substring(0, 1).toUpperCase();
			returnValue += word.substring(1).toLowerCase();
			returnValue += " ";
		}
		
		// remove the last blank
		return returnValue.trim();
	}
	
	public boolean isValid() {
		return valid;
	}
}