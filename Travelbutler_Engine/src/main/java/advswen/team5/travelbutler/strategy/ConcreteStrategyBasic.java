// *************************************************************************************
// File:         [ConcreteStrategyBasic.java]
// Created:      [2016/05/24 Tuesday]
// Last Changed: $Date: 2016/05/24 18:19:00 $
// Author:       <A HREF="mailto:[al-161385@hs-weingarten.de]">[Alexander Lohr]</A>
//**************************************************************************************
//Description: 	Klasse f�r die Zusammenf�hrung verschiedener APIs
//				
//**************************************************************************************
package advswen.team5.travelbutler.strategy;

import java.util.ArrayList;
import java.util.List;

import advswen.team5.travelbutler.api.*;
import advswen.team5.travelbutler.api.response.Response;
import advswen.team5.travelbutler.api.response.*;


public class ConcreteStrategyBasic implements ISearchStrategy {

		public Response executeSearch(String requestString) {
		Response response = new Response(requestString);
		WikipediaResponse wiki = new APIContainerWikipedia().processSearch(response.getDestination());
		response.setWikipediaResponse(wiki);
			
		return response;
	}
}
