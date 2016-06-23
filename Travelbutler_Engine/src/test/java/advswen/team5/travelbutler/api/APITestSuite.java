// *************************************************************************************
// File:         [APITestSuite.java]
// Created:      [2016/06/23 Thursday]
// Last Changed: $Date: 2016/06/23 12:37:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Suite für alle API-Tests
//				
//**************************************************************************************
package advswen.team5.travelbutler.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ APIContainerGoogleGeoCodingTest.class, APIContainerOWMTest.class, APIContainerTravelbriefingTest.class,
		APIContainerTwitterExceptionsTest.class, APIContainerTwitterMockTest.class, APIContainerTwitterTest.class,
		APIContainerWikipediaTest.class })
public class APITestSuite {

}
