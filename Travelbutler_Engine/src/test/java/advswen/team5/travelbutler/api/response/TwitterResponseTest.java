// *************************************************************************************
// File:         [TwitterResponseTest.java]
// Created:      [2016/06/08 Wednesday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für TwitterResponse
//				
//**************************************************************************************
package advswen.team5.travelbutler.api.response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advswen.team5.travelbutler.api.APIContainerTwitter;
import advswen.team5.travelbutler.api.IAPIContainer;
import twitter4j.Status;


public class TwitterResponseTest {
	
	private IAPIContainer iapiContainer = new APIContainerTwitter();
	String searchStringCity = "Barcelona";
	String searchStringCountry = "Spain";
	TwitterResponse TwitterRespCountry = new APIContainerTwitter().processSearch(searchStringCountry);
	TwitterResponse TwitterRespCity = new APIContainerTwitter().processSearch(searchStringCity);
	@Before
	public void setup(){
		System.out.println("Setup");
		
	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#TwitterResponse(java.util.List)}.
	 */
	@Test
	public void testTwitterResponse() {
		System.out.println("Test: testTwitterResponse");
//		TwitterResponse TwitterResp = new APIContainerTwitter().processSearch(searchStringCountry);
		assertNotNull(TwitterRespCountry);

	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#getTweets()}.
	 */
	@Test
	public void testGetTweets() {
		System.out.println("Test: testGetTweets");
		
//		TwitterResponse Twitter = new APIContainerTwitter().processSearch(searchStringCountry);
		assertNotNull(TwitterRespCity.getTweets());

	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#setTweets(java.util.List)}.
	 */
	@Test
	public void testSetTweets() {
		System.out.println("Test: testGetTweets");
		
//		TwitterResponse Twitter1 = new APIContainerTwitter().processSearch(searchStringCountry);
//		TwitterResponse Twitter2 = new APIContainerTwitter().processSearch(searchStringCity);
		List<Status> tweetsCity = TwitterRespCity.getTweets();
		List<Status> tweetsCountry = TwitterRespCountry.getTweets();
		TwitterRespCity.setTweets(tweetsCountry);
		assertEquals(tweetsCountry, TwitterRespCity.getTweets());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#setMissing(boolean)}.
	 */
	@Test
	public void testSetMissing() {
		System.out.println("Test: testSetMissing");
//		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
//		TwitterResponse Twitter = new APIContainerTwitter().processSearch(searchStringCity);
		TwitterRespCity.setMissing(false);
		assertFalse(TwitterRespCity.isMissing());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#isMissing()}.
	 */
	@Test
	public void testIsMissing() {
		System.out.println("Test: testIsMissing");
//		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
//		TwitterResponse Twitter = new APIContainerTwitter().processSearch(searchStringCity);
		TwitterRespCity.setMissing(true);
		assertTrue(TwitterRespCity.isMissing());
	}
	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}

}
