package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advswen.team5.travelbutler.api.response.IAPIResponse;
import advswen.team5.travelbutler.api.response.TwitterResponse;
import advswen.team5.travelbutler.api.response.WikipediaResponse;
import twitter4j.Status;

public class APIContainerWikipediaTest {
	
	private IAPIContainer iapiContainer;
	String searchStringCity = "Barcelona";
	String searchStringCountry = "Spain";
	
	

	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerWikipedia();
		
		
	
	}
	

	@Test
	public void processSearchShouldNotBeNullForValidCityInput() {
		System.out.println("Test: processSearchShouldNotBeNullForValidCityInput");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);		
		assertNotNull(processSearch);
		
	}
	
	@Test
	public void processSearchShouldNotBeNullForValidCountryInput() {
		System.out.println("Test: processSearchShouldNotBeNullForValidCountryInput");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);		
		assertNotNull(processSearch);
		
	}
	
	@Test
	public void isMissingShouldBeFalseForValidCityString() {
		System.out.println("Test: isMissingShouldBeFalseForValidInputString");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		assertFalse(processSearch.isMissing());
	}
	
	@Test
	public void isMissingShouldBeFalseForValidCountryString() {
		System.out.println("Test: isMissingShouldBeFalseForValidInputString");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);
		assertFalse(processSearch.isMissing());
	}
	
	@Test(expected = NullPointerException.class)
	public void processSearchShouldThrowNullPointerExceptionForNullString() {
		System.out.println("Test: processSearchShouldThrowNullPointerExceptionForNullString");
		IAPIResponse processSearch = iapiContainer.processSearch(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void processSearchShouldThrowNullPointerExceptionForBlankString() {
		System.out.println("Test: processSearchShouldThrowNullPointerExceptionForBlankString");
		IAPIResponse processSearch = iapiContainer.processSearch("");
	}
	
	@Test
	public void checkIfExtractContainsCityString() {
		
		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch(searchStringCity);
		String wikiExtract = wikiResponse.getExtract();
		boolean found = wikiExtract.toLowerCase().contains(searchStringCity.toLowerCase());
		assertTrue(found);
	}
	
	@Test
	public void checkIfExtractContainsCountryString() {
		
		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch(searchStringCountry);
		String wikiExtract = wikiResponse.getExtract();
		boolean found = wikiExtract.toLowerCase().contains(searchStringCountry.toLowerCase());
		assertTrue(found);
	}
	
	public void checkIfTitleContainsCityString() {
		
		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch(searchStringCity);
		String wikiTitle = wikiResponse.getTitle();
		boolean found = wikiTitle.toLowerCase().contains(searchStringCity.toLowerCase());
		assertTrue(found);
	}
	
	public void checkIfTitleContainsCountryString() {
		
		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch(searchStringCountry);
		String wikiTitle = wikiResponse.getTitle();
		boolean found = wikiTitle.toLowerCase().contains(searchStringCountry.toLowerCase());
		assertTrue(found);
	}
	
//	public void checkIfShortExtractContainsSearchString() {
//		
//		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch("Barcelona");
//		String wikiShortExtract = wikiResponse.getShortExtract(20);
//		boolean found = wikiShortExtract.toLowerCase().contains("Barcelona".toLowerCase());
//		assertTrue(found);
//	}
	
	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}


}
