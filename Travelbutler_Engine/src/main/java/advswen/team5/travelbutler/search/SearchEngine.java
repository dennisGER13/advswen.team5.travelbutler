// *************************************************************************************
// File:         [SearchEngine.java]
// Created:      [2016/05/24 Tuesday]
// Last Changed: $Date: 2016/05/24 18:19:00 $
// Author:       <A HREF="mailto:[al-161385@hs-weingarten.de]">[Alexander Lohr]</A>
//**************************************************************************************
//Description: 	Klasse f�r die Aufbereitung der gefundenen Ergebnisse.
//				
//**************************************************************************************
   
package advswen.team5.travelbutler.search;

import advswen.team5.travelbutler.api.response.*;
import advswen.team5.travelbutler.strategy.ConcreteStrategyCity;
import advswen.team5.travelbutler.strategy.ISearchStrategy;

public class SearchEngine {
	private ISearchStrategy searchstrategy;
	
	//Die SearchEngine wird Standardm��ig mit der Basic Strategie instanziert. (Kann Beispielswei�e Google sein)
	public SearchEngine(){
		searchstrategy = new ConcreteStrategyCity();
	}
	
	
	public Response execute(String requestString){
		return searchstrategy.executeSearch(requestString);
		
	}
	
	//Wird von der SearchRequest genutzt, um die richtige Strategie f�r den jeweiligen Grain auszuw�hlen
	public void setStrategy(ISearchStrategy concreteStrategy){
		searchstrategy = concreteStrategy;
	}
	
	public ISearchStrategy getSearchstrategy() {
		return searchstrategy;
	}


	public void setSearchstrategy(ISearchStrategy searchstrategy) {
		this.searchstrategy = searchstrategy;
	}


	public void getStrategy(){
		
	}
	
}
