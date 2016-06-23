// *************************************************************************************
// File:         [TravelbriefingTestSuite.java]
// Created:      [2016/06/23 Thursday]
// Last Changed: $Date: 2016/06/23 12:37:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Suite für alle Tests bezüglich Travelbriefing
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.travelbriefing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TravelbriefingAdviseListTest.class, TravelbriefingAdviseTest.class, TravelbriefingCurrencyTest.class,
		TravelbriefingElectricityTest.class, TravelbriefingExchangeRateTest.class, TravelbriefingLanguageTest.class,
		TravelbriefingTimezoneTest.class, TravelbriefingVaccinationTest.class, TravelbriefingWaterTest.class })
public class TravelbriefingTestSuite {

}
