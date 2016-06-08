// *************************************************************************************
// File:         [APIContainerWikipediaTest.java]
// Created:      [2016/06/07 Tuesday]
// Last Changed: $Date: 2016/06/08 18:19:00 $
// Author:       <A HREF="mailto:[ma-152478@hs-weingarten.de]">[Michael Aulbach]</A>
//**************************************************************************************
//Description: 	Test-Klasse für APIContainerWikipedia
//				
//**************************************************************************************
package advswen.team5.travelbutler.api;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import advswen.team5.travelbutler.api.response.IAPIResponse;
import advswen.team5.travelbutler.api.response.WikipediaResponse;

public class APIContainerWikipediaTest {

	private IAPIContainer iapiContainer;
	String searchStringCity = "Barcelona";
	String searchStringCountry = "Spain";
	
	

	@Before
	public void setup(){
		System.out.println("Setup");
		iapiContainer = new APIContainerWikipedia();
		
		
	
	}
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerWikipedia#processSearch(java.lang.String)}.
	 */
	@Test
	public void testProcessSearch() {
		System.out.println("Test: testProcessSearch");
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
		System.out.println("Test: isMissingShouldBeFalseForValidCountryString");
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
	

	
	@After
	public void cleanup() {
		System.out.println("Cleanup");
		iapiContainer = null;
		
	}

}
