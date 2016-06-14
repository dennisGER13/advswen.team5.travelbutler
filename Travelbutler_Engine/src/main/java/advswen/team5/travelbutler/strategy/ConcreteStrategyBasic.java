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
import advswen.team5.travelbutler.api.response.*;
import advswen.team5.travelbutler.dialogue.InvalidRequestDialogue;


public class ConcreteStrategyBasic implements ISearchStrategy {

		private InvalidRequestDialogue invalid;

		public Response executeSearch(String requestString) {
			
		//Wenn ConcreteStrategyBasic ausgewaehlt, dann zeige InvalidRequestDialogue
		//mit der Moeglichkeit die Suche neu zu starten!
		invalid = new InvalidRequestDialogue();
		invalid.run();
		
		return null;
	}
}
