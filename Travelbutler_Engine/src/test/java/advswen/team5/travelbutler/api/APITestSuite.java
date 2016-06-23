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
