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
import advswen.team5.travelbutler.strategy.AbstractSearchStrategy;

public class SearchEngine implements Listener {
	private AbstractSearchStrategy searchstrategy;
	
	public SearchEngine(){
	
	}
	
	public Response execute(String requestString){
		searchstrategy.registerListener(this);
		return searchstrategy.executeSearch(requestString);	
	}
	
	//Wird von der SearchRequest genutzt, um die richtige Strategie f�r den jeweiligen Grain auszuw�hlen
	public void setStrategy(AbstractSearchStrategy concreteStrategy){
		searchstrategy = concreteStrategy;
	}
	
	public AbstractSearchStrategy getStrategy(){
		return searchstrategy;
	}

	@Override
	public void update() {
		System.out.println(searchstrategy.getProgress());
	}
	
}
