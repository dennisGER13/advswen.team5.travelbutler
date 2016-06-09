// *************************************************************************************
// File:         [APIContainerTwitterTest.java]
// Created:      [2016/06/06 Monday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für APIContainerTwitter
//				
//**************************************************************************************
package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advswen.team5.travelbutler.api.response.IAPIResponse;
import advswen.team5.travelbutler.api.response.TwitterResponse;
import twitter4j.Status;



public class APIContainerTwitterTest {
	
	private IAPIContainer iapiContainer;
	String searchStringCity = "Barcelona";
	String searchStringCountry = "Spain";
	
	IAPIResponse iapiRespCity = iapiContainer.processSearch(searchStringCity);
	TwitterResponse TwitterCity = new APIContainerTwitter().processSearch(searchStringCity);
	List<Status> usedTweetsCity = TwitterCity.getTweets();
	TwitterResponse TwitterCountry = new APIContainerTwitter().processSearch(searchStringCountry);
	List<Status> usedTweetsCountry = TwitterCity.getTweets();
	
	
	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerTwitter();
	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTwitter#processSearch(java.lang.String)}.
	 */
	@Test
	public void testProcessSearch() {
		System.out.println("Test: testProcessSearchForValidCityNotNull");
//		IAPIResponse iapiResp = iapiContainer.processSearch(searchStringCity);
		assertNotNull(iapiRespCity);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTwitter#twitterFeed(java.lang.String)}.
	 */
//	@Test
//	public void testTwitterFeed() {
//		System.out.println("Test: testIfTweetsContainsCity");
//		TwitterResponse Twitter = new APIContainerTwitter().processSearch(searchStringCity);
//		List<Status> usedTweets = Twitter.getTweets();
//		
//		boolean found = true;
//		for(Status status: usedTweets) {
//		    if(!status.getText().toLowerCase().contains(searchStringCity.toLowerCase()))
//		       found = false;
//		}
//
//		assertTrue(found);
//	}
	
	@Test
	public void testIfTweetsContainsCity() {
		System.out.println("Test: testIfTweetsContainsCity");
//		TwitterResponse Twitter = new APIContainerTwitter().processSearch(searchStringCity);
//		List<Status> usedTweets = Twitter.getTweets();
		
		boolean found = true;
		for(Status status: usedTweetsCity) {
		    if(!status.getText().toLowerCase().contains(searchStringCity.toLowerCase()))
		       found = false;
		}

		assertTrue(found);
	}
	
	@Test
	public void testIfTweetsContainsCountry() {
		System.out.println("Test: testIfTweetsContainsCountry");
//		TwitterResponse Twitter = new APIContainerTwitter().processSearch(searchStringCountry);
//		List<Status> usedTweets = Twitter.getTweets();
		
		boolean found = true;
		for(Status status: usedTweetsCountry) {
		    if(!status.getText().toLowerCase().contains(searchStringCountry.toLowerCase()))
		       found = false;
		}

		assertTrue(found);
	}
	

	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}

}
