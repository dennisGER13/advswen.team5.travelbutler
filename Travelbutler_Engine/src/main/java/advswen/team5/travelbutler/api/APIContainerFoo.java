// *************************************************************************************
// File:         [APIContainerFoo.java]
// Created:      [2016/05/24 Tuesday]
// Last Changed: $Date: 2016/05/24 18:19:00 $
// Author:       <A HREF="mailto:[al-161385@hs-weingarten.de]">[Alexander Lohr]</A>
//**************************************************************************************
//Description: 	Klasse für die Beschaffung von Informationen durch eine API
//				
//**************************************************************************************
package advswen.team5.travelbutler.api;

public class APIContainerFoo implements IAPIContainer {

	public String processSearch(String requestString) {
		return "ClassTest Foo succesful " + requestString;

	}
}
