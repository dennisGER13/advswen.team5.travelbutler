// *************************************************************************************
// File:         [ResponseTestSuite.java]
// Created:      [2016/06/23 Thursday]
// Last Changed: $Date: 2016/06/23 12:37:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Suite für alle Response-Tests
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.response;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TravelbriefingResponseTest.class, TwitterResponseTest.class, WikipediaResponseTest.class })
public class ResponseTestSuite {

}
