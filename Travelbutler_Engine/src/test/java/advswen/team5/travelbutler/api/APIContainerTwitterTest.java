// *************************************************************************************
// File:         [APIContainerTwitterTest.java]
// Created:      [2016/06/08 Wednesday]
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
import org.mockito.internal.matchers.Null;

import advswen.team5.travelbutler.api.response.IAPIResponse;
import advswen.team5.travelbutler.api.response.TwitterResponse;
import advswen.team5.travelbutler.api.response.WikipediaResponse;
import twitter4j.Status;

public class APIContainerTwitterTest {
	
	
	
	String searchStringCountry = "France";
	String searchStringCity = "Paris";
	private IAPIContainer iapiContainer = new APIContainerTwitter();
	IAPIResponse iapiRespCountry = iapiContainer.processSearch(searchStringCountry);
	TwitterResponse TwitterRespCountry = new APIContainerTwitter().processSearch(searchStringCountry);
	IAPIResponse iapiRespCity = iapiContainer.processSearch(searchStringCity);
	TwitterResponse TwitterRespCity = new APIContainerTwitter().processSearch(searchStringCity);
	IAPIResponse iapiRespNull = iapiContainer.processSearch(null);
	TwitterResponse TwitterRespNull = new APIContainerTwitter().processSearch(null);
	IAPIResponse iapiRespBlank = iapiContainer.processSearch("");
	TwitterResponse TwitterRespBlank = new APIContainerTwitter().processSearch("");

	
	@Before
	public void setup(){
		System.out.println("Setup");
		
	
	}

	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTwitter#processSearch(java.lang.String)}.
	 * The returned TwitterResponse should not be Null, if a valid city is entered/provided.
	 */
	@Test
	public void testProcessSearchShouldNotBeNullForValidCity() {
		System.out.println("Test: testProcessSearchShouldNotBeNullForValidCity");
//		IAPIResponse processSearch = iapiContainer.processSearch(searchString);
		assertNotNull(iapiRespCity);
	}
	
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTwitter#processSearch(java.lang.String)}.
	 * The returned TwitterResponse should not be Null, if a valid country is entered/provided.
	 */
	@Test
	public void testProcessSearchShouldNotBeNullForValidCountry() {
		System.out.println("Test: testProcessSearchShouldNotBeNullForValidCountry");
//		IAPIResponse processSearch = iapiContainer.processSearch(searchString);
		assertNotNull(iapiRespCountry);
	}
	
	
	@Test
	public void isMissingShouldBeFalseForValidInputString() {
		System.out.println("Test: isMissingShouldBeFalseForValidInputString");
//		IAPIResponse processSearch = iapiContainer.processSearch(searchString);
		assertFalse(iapiRespCity.isMissing());
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTwitter#processSearch(java.lang.String)}.
	 * The method processSearch should throw an AssertionError, if Null is provided
	 */
	@Test(expected = AssertionError.class)
	public void processSearchShouldThrowAssertionErrorForNullString() {
		System.out.println("Test: processSearchShouldThrowNullPointerExceptionForNullString");
//		IAPIResponse processSearchNull = iapiContainer.processSearch(null);
		assertNull(iapiRespNull);
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerTwitter#processSearch(java.lang.String)}.
	 * The method processSearch should throw an AssertionError, if a blank string is provided
	 */
	@Test(expected = AssertionError.class)
	public void processSearchShouldThrowAssertionErrorForBlankString() {
		System.out.println("Test: processSearchShouldThrowAssertionErrorForBlankString");
//		IAPIResponse processSearch = iapiContainer.processSearch("");
		assertNull(iapiRespBlank);
	}
	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}

//	@Test
//	public void testTwitterFeed() {
//		List<Status> twitterContainer = new APIContainerTwitter().twitterFeed(searchString);
//		
//
//	}
	
	/**
	 * Test if the tweets contain the provided search-string. In this case a city
	 */
	@Test
	public void testIfTweetsContainSearchStringCity() {
		
//		TwitterResponse Twitter = new APIContainerTwitter().processSearch(requestedString);
		List<Status> usedTweets = TwitterRespCity.getTweets();
		
		boolean found = true;
		for(Status status: usedTweets) {
		    if(!status.getText().toLowerCase().contains(searchStringCity.toLowerCase()))
		       found = false;
		}

		assertTrue(found);
		

	}
	
	/**
	 * Test if the tweets contain the provided search-string. In this case a country
	 */
	@Test
	public void testIfTweetsContainSearchStringCountry() {
		
//		TwitterResponse Twitter = new APIContainerTwitter().processSearch(requestedString);
		List<Status> usedTweets = TwitterRespCountry.getTweets();
		
		boolean found = true;
		for(Status status: usedTweets) {
		    if(!status.getText().toLowerCase().contains(searchStringCountry.toLowerCase()))
		       found = false;
		}

		assertTrue(found);
		

	}

}