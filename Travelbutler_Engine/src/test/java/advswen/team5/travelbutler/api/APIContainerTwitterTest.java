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

import advswen.team5.travelbutler.api.response.IAPIResponse;
import advswen.team5.travelbutler.api.response.TwitterResponse;
import twitter4j.Status;

public class APIContainerTwitterTest {
	
	private IAPIContainer iapiContainer;
	String searchString = "France";
	
	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerTwitter();
	
	}

	@Test
	public void testProcessSearchNotNull() {
		System.out.println("testProcessSearch");
		IAPIResponse processSearch = iapiContainer.processSearch(searchString);
		assertNotNull(processSearch);
	}
	
	
	@Test
	public void isMissingShouldBeFalseForValidInputString() {
		System.out.println("Test: isMissingShouldBeFalseForValidInputString");
		IAPIResponse processSearch = iapiContainer.processSearch(searchString);
		assertFalse(processSearch.isMissing());
	}
	
	@Test(expected = AssertionError.class)
	public void processSearchShouldThrowAssertionErrorForNullString() {
		System.out.println("Test: processSearchShouldThrowNullPointerExceptionForNullString");
		IAPIResponse processSearch = iapiContainer.processSearch(null);
		assertNull(processSearch);
	}
	
	@Test(expected = AssertionError.class)
	public void processSearchShouldThrowAssertionErrorForBlankString() {
		System.out.println("Test: processSearchShouldThrowNullPointerExceptionForBlankString");
		IAPIResponse processSearch = iapiContainer.processSearch("");
		assertNull(processSearch);
	}
	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}

	@Test
	public void testTwitterFeed() {
		String requestedString = "Barcelona";
		TwitterResponse Twitter = new APIContainerTwitter().processSearch(requestedString);
		List<Status> usedTweets = Twitter.getTweets();
		
		boolean found = true;
		for(Status status: usedTweets) {
		    if(!status.getText().toLowerCase().contains(requestedString.toLowerCase()))
		       found = false;
		}

		assertTrue(found);
		

	}

}