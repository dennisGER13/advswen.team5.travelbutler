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
	String searchString = "Barcelona";
	
	

	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerWikipedia();
		
		
	
	}
	

	@Test
	public void processSearchShouldNotBeNullForValidInputString() {
		System.out.println("Test: processSearchShouldNotBeNullForValidInputString");
		IAPIResponse processSearch = iapiContainer.processSearch(searchString);		
		assertNotNull(processSearch);
		
	}
	
	@Test
	public void isMissingShouldBeFalseForValidInputString() {
		System.out.println("Test: isMissingShouldBeFalseForValidInputString");
		IAPIResponse processSearch = iapiContainer.processSearch(searchString);
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
	public void checkIfExtractContainsSearchString() {
		
		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch(searchString);
		String wikiExtract = wikiResponse.getExtract();
		boolean found = wikiExtract.toLowerCase().contains(searchString.toLowerCase());
		assertTrue(found);
	}
	
	public void checkIfTitleContainsSearchString() {
		
		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch(searchString);
		String wikiTitle = wikiResponse.getTitle();
		boolean found = wikiTitle.toLowerCase().contains(searchString.toLowerCase());
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
