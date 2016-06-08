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
	public void testIfExtractContainsCityString() {
		System.out.println("Test: checkIfExtractContainsCityString");
		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch(searchStringCity);
		String wikiExtract = wikiResponse.getExtract();
		boolean found = wikiExtract.toLowerCase().contains(searchStringCity.toLowerCase());
		assertTrue(found);
	}
	
	@Test
	public void testIfExtractContainsCountryString() {
		System.out.println("Test: checkIfExtractContainsCountryString");
		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch(searchStringCountry);
		String wikiExtract = wikiResponse.getExtract();
		boolean found = wikiExtract.toLowerCase().contains(searchStringCountry.toLowerCase());
		assertTrue(found);
	}
	
	@Test
	public void testIfTitleContainsCityString() {
		System.out.println("Test: checkIfTitleContainsCityString");		
		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch(searchStringCity);
		String wikiTitle = wikiResponse.getTitle();
		boolean found = wikiTitle.toLowerCase().contains(searchStringCity.toLowerCase());
		assertTrue(found);
	}
	
	@Test
	public void testIfTitleContainsCountryString() {
		System.out.println("Test: checkIfTitleContainsCountryString");	
		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch(searchStringCountry);
		String wikiTitle = wikiResponse.getTitle();
		boolean found = wikiTitle.toLowerCase().contains(searchStringCountry.toLowerCase());
		assertTrue(found);
	}
	
	@Test
	public void testTitleGetter() {
		System.out.println("Test: checkTitleGetter");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		assertEquals("title", wikiResponse.getTitle());
	}
	
	@Test
	public void testTitleSetter() {
		System.out.println("Test: checkTitleSetter");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		wikiResponse.setTitle("Title");
		assertEquals("Title", wikiResponse.getTitle());
	}
	
	@Test
	public void testPageidGetter() {
		System.out.println("Test: checkPageidGetter");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		assertEquals("12", wikiResponse.getPageid());
	}
	
	@Test
	public void testPageidSetter() {
		System.out.println("Test: checkPageidSetter");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		wikiResponse.setPageid("13");
		assertEquals("13", wikiResponse.getPageid());
	}
	
	@Test
	public void testExtractGetter() {
		System.out.println("Test: checkPageidGetter");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		assertEquals("extract", wikiResponse.getExtract());
	}
	
	@Test
	public void testExtractSetter() {
		System.out.println("Test: checkPageidGetter");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		wikiResponse.setExtract("new extract");
		assertEquals("new extract", wikiResponse.getExtract());
	}
	
	@Test
	public void testMissingGetter() {
		System.out.println("Test: checkPageidGetter");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		wikiResponse.setMissing(false);
		assertFalse(wikiResponse.isMissing());
	}
	
	@Test
	public void testMissingSetter() {
		System.out.println("Test: checkPageidGetter");	
		WikipediaResponse wikiResponse = new WikipediaResponse("12", "title", "extract");
		wikiResponse.setMissing(true);
		assertTrue(wikiResponse.isMissing());
	}
	

	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}


}
