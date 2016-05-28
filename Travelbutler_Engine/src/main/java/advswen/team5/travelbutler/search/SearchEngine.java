// *************************************************************************************
// File:         [SearchEngine.java]
// Created:      [2016/05/24 Tuesday]
// Last Changed: $Date: 2016/05/24 18:19:00 $
// Author:       <A HREF="mailto:[al-161385@hs-weingarten.de]">[Alexander Lohr]</A>
//**************************************************************************************
//Description: 	Klasse für die Aufbereitung der gefundenen Ergebnisse.
//				
//**************************************************************************************
   
package advswen.team5.travelbutler.search;

import advswen.team5.travelbutler.strategy.ConcreteStrategyBasic;
import advswen.team5.travelbutler.strategy.ISearchStrategy;

public class SearchEngine {
	private ISearchStrategy _searchstrategy;
	
	//Die SearchEngine wird Standardmäßig mit der Basic Strategie instanziert. (Kann Beispielsweiße Google sein)
	public SearchEngine(){
		_searchstrategy = new ConcreteStrategyBasic();
	}
	
	
	public String execute(String requestString){
		return _searchstrategy.executeSearch(requestString);
		
	}
	
	//Wird von der SearchRequest genutzt, um die richtige Strategie für den jeweiligen Grain auszuwählen
	public void setStrategy(ISearchStrategy concreteStrategyFoo){
		_searchstrategy = concreteStrategyFoo;
	}
	
	public void getStrategy(){
		
	}
	
}
