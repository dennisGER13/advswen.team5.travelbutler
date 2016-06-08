/**
 * 
 */
package advswen.team5.travelbutler.api.response;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advswen.team5.travelbutler.api.APIContainerTwitter;
import advswen.team5.travelbutler.api.IAPIContainer;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdvise;
import advswen.team5.travelbutler.api.travelbriefing.TravelbriefingAdviseList;
import twitter4j.Status;


public class TwitterResponseTest {
	
	private IAPIContainer iapiContainer;
	String searchStringCity = "Barcelona";
	String searchStringCountry = "Spain";
	
	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerTwitter();
	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#TwitterResponse(java.util.List)}.
	 */
	@Test
	public void testTwitterResponse() {
		System.out.println("Test: testTwitterResponse");
		TwitterResponse TwitterResp = new APIContainerTwitter().processSearch(searchStringCountry);
		assertNotNull(TwitterResp);

	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#getTweets()}.
	 */
	@Test
	public void testGetTweets() {
		System.out.println("Test: testGetTweets");
		
		TwitterResponse Twitter = new APIContainerTwitter().processSearch(searchStringCountry);
		assertNotNull(Twitter.getTweets());

	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#setTweets(java.util.List)}.
	 */
	@Test
	public void testSetTweets() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#setMissing(boolean)}.
	 */
	@Test
	public void testSetMissing() {
		System.out.println("Test: testSetMissing");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		TwitterResponse Twitter = new APIContainerTwitter().processSearch(searchStringCity);
		Twitter.setMissing(false);
		assertFalse(Twitter.isMissing());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#isMissing()}.
	 */
	@Test
	public void testIsMissing() {
		System.out.println("Test: testIsMissing");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		TwitterResponse Twitter = new APIContainerTwitter().processSearch(searchStringCity);
		Twitter.setMissing(true);
		assertTrue(Twitter.isMissing());
	}
	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}

}
