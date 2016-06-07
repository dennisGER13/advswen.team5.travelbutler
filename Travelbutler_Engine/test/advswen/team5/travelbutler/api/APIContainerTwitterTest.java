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
	String searchString = "Barcelona";
	
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
		System.out.println("Test: processSearchShouldThrowAssertionErrorForBlankString");
		IAPIResponse processSearch = iapiContainer.processSearch("");
		assertNull(processSearch);
	}
	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}

	@Test
	public void testIfTweetsContainSearchString() {
		System.out.println("Test: testIfTweetsContainSearchString");
		TwitterResponse Twitter = new APIContainerTwitter().processSearch(searchString);
		List<Status> usedTweets = Twitter.getTweets();
		
		boolean found = true;
		for(Status status: usedTweets) {
		    if(!status.getText().toLowerCase().contains(searchString.toLowerCase()))
		       found = false;
		}

		assertTrue(found);
		

	}
	



}
