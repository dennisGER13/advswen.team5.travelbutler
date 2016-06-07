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
	
	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerTwitter();
	
	}

	@Test
	public void testProcessSearchForValidCityNotNull() {
		System.out.println("Test: testProcessSearchForValidCityNotNull");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		assertNotNull(processSearch);
	}
	
	@Test
	public void testProcessSearchForValidCountryNotNull() {
		System.out.println("Test: testProcessSearchForValidCountryNotNull");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);
		assertNotNull(processSearch);
	}
	
	
	@Test
	public void isMissingShouldBeFalseForValidCity() {
		System.out.println("Test: isMissingShouldBeFalseForValidCity");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		assertFalse(processSearch.isMissing());
	}
	
	@Test
	public void isMissingShouldBeFalseForValidCountry() {
		System.out.println("Test: isMissingShouldBeFalseForValidCountry");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);
		assertFalse(processSearch.isMissing());
	}
	
	@Test(expected = AssertionError.class)
	public void processSearchShouldThrowAssertionErrorForNullString() {
		System.out.println("Test: processSearchShouldThrowAssertionErrorForNullString");
		IAPIResponse processSearch = iapiContainer.processSearch(null);
		assertNull(processSearch);
	}
	
	@Test(expected = AssertionError.class)
	public void processSearchShouldThrowAssertionErrorForBlankString() {
		System.out.println("Test: processSearchShouldThrowAssertionErrorForBlankString");
		IAPIResponse processSearch = iapiContainer.processSearch("");
		assertNull(processSearch);
	}
	

	@Test
	public void testIfTweetsContainsCity() {
		System.out.println("Test: testIfTweetsContainsCity");
		TwitterResponse Twitter = new APIContainerTwitter().processSearch(searchStringCity);
		List<Status> usedTweets = Twitter.getTweets();
		
		boolean found = true;
		for(Status status: usedTweets) {
		    if(!status.getText().toLowerCase().contains(searchStringCity.toLowerCase()))
		       found = false;
		}

		assertTrue(found);
	}
	
	@Test
	public void testIfTweetsContainsCountry() {
		System.out.println("Test: testIfTweetsContainsCountry");
		TwitterResponse Twitter = new APIContainerTwitter().processSearch(searchStringCountry);
		List<Status> usedTweets = Twitter.getTweets();
		
		boolean found = true;
		for(Status status: usedTweets) {
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
