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
import org.junit.BeforeClass;
import org.junit.Test;

import advswen.team5.travelbutler.api.APIContainerTwitter;
import advswen.team5.travelbutler.api.IAPIContainer;
import twitter4j.Status;


public class TwitterResponseTest {
	

private static String searchStringCity;
private static String searchStringCountry;
private TwitterResponse twitterRespCountry;
private TwitterResponse twitterRespCity;


	
	@Before
	public void setup(){
		System.out.println("Setup");
		searchStringCity = "Barcelona";
		searchStringCountry = "Spain";
		twitterRespCountry = new APIContainerTwitter().processSearch(searchStringCountry);
		twitterRespCity = new APIContainerTwitter().processSearch(searchStringCity);

		
	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#TwitterResponse(java.util.List)}.
	 * TwitterResponse should not be null for a valid TwitterResponse.
	 */
	@Test
	public void testTwitterResponseShouldNotBeNullForValidSearchString() {
		assertNotNull(twitterRespCountry);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#getTweets()}.
	 * GetTweets should not return null for a valid TwitterResponse.
	 */
	@Test
	public void testGetTweetsShouldNotBeNullForValidTwitterResponse() {
		assertNotNull(twitterRespCity.getTweets());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#setTweets(java.util.List)}.
	 * The tweets of an TwitterResponse are manually set, thus getTweets should be equal to the new/changed tweets.
	 */
	@Test
	public void testGetTweetsShouldbeEqualToNewTweets() {
		List<Status> tweetsCountry = twitterRespCountry.getTweets();
		twitterRespCity.setTweets(tweetsCountry);
		assertEquals(tweetsCountry, twitterRespCity.getTweets());
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#setMissing(boolean)}.
	 * isMssing returns "false" for a valid TwitterResponse. It's manually set to true.
	 */
	@Test
	public void testIsMissingShouldBeTrueAfterSettingItToTrue() {
		twitterRespCity.setMissing(true);
		assertTrue(twitterRespCity.isMissing());
		twitterRespCity.setMissing(false);
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#isMissing()}.
	 * isMssing returns "false" for a valid TwitterResponse.
	 */
	@Test
	public void testIsMissingShouldBeFalseForValidTwitterResponse() {
		assertFalse(twitterRespCity.isMissing());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.response.TwitterResponse#getTweets()}.
	 * The tweets of the TwitterResponse should contain the searchString.
	 */
	@Test
	public void testTweetShouldContainSearchString() {
		List<Status> usedTweets = twitterRespCity.getTweets();		
		boolean found = true;
		for(Status status: usedTweets) {
		    if(!status.getText().toLowerCase().contains(searchStringCity.toLowerCase()))
		       found = false;
		}

		assertTrue(found);
	}
	

	

}
