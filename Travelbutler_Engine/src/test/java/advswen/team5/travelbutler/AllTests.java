package advswen.team5.travelbutler;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import advswen.team5.travelbutler.api.APITestSuite;
import advswen.team5.travelbutler.api.response.ResponseTestSuite;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingTestSuite;

@RunWith(Suite.class)
@SuiteClasses({APITestSuite.class, ResponseTestSuite.class, TravelbriefingTestSuite.class})
public class AllTests {

}
