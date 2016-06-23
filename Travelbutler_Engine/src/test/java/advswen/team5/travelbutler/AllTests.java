// *************************************************************************************
// File:         [AllTests.java]
// Created:      [2016/06/23 Thursday]
// Last Changed: $Date: 2016/06/23 12:37:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Suite für alle Tests
//				
//**************************************************************************************
package advswen.team5.travelbutler;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import advswen.team5.travelbutler.api.APITestSuite;
import advswen.team5.travelbutler.api.response.ResponseTestSuite;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTestSuite;
import advswen.team5.travelbutler.output.PDFGeneratorTest;

@RunWith(Suite.class)
@SuiteClasses({APITestSuite.class, ResponseTestSuite.class, TravelbriefingTestSuite.class, PDFGeneratorTest.class})
public class AllTests {

}
