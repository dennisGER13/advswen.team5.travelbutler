// *************************************************************************************
// File:         [APIContainerWikipediaTest.java]
// Created:      [2016/06/07 Tuesday]
// Last Changed: $Date: 2016/06/13 17:29:00 $
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
	 * The returned WikipediaResponse should not be Null, if a valid city is provided to the method processSearch.
	 */
	@Test
	public void processSearchShouldNotBeNullForValidCity() {
		System.out.println("Test: processSearchShouldNotBeNullForValidCity");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);		
		assertNotNull(processSearch);
		
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerWikipedia#processSearch(java.lang.String)}.
	 * The returned WikipediaResponse should not be Null, if a valid country is provided to the method processSearch.
	 */
	@Test
	public void processSearchShouldNotBeNullForValidCountry() {
		System.out.println("Test: processSearchShouldNotBeNullForValidCountry");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);		
		assertNotNull(processSearch);
		
	}
	
	/**
	 * The method isMissing should return false, if a valid city is provided
	 */
	@Test
	public void isMissingShouldBeFalseForValidCity() {
		System.out.println("Test: isMissingShouldBeFalseForValidCity");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCity);
		assertFalse(processSearch.isMissing());
	}
	
	/**
	 * The method isMissing should return false, if a valid country is provided
	 */
	@Test
	public void isMissingShouldBeFalseForValidCountry() {
		System.out.println("Test: isMissingShouldBeFalseForValidCountry");
		IAPIResponse processSearch = iapiContainer.processSearch(searchStringCountry);
		assertFalse(processSearch.isMissing());
	}
	
	/**
	 * The method processSearch should throw a NullPointerException, if null is provided
	 */
	@Test(expected = NullPointerException.class)
	public void processSearchShouldThrowNullPointerExceptionForNullString() {
		System.out.println("Test: processSearchShouldThrowNullPointerExceptionForNullString");
		IAPIResponse processSearch = iapiContainer.processSearch(null);
	}
	
	/**
	 * The method processSearch should throw a NullPointerException, if a blank string is provided
	 */
	@Test(expected = NullPointerException.class)
	public void processSearchShouldThrowNullPointerExceptionForBlankString() {
		System.out.println("Test: processSearchShouldThrowNullPointerExceptionForBlankString");
		IAPIResponse processSearch = iapiContainer.processSearch("");
	}
	
	/**
	 * Test if the returned extract contains the search string (city)
	 */
	@Test
	public void testIfExtractContainsCityString() {
		System.out.println("Test: checkIfExtractContainsCityString");
		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch(searchStringCity);
		String wikiExtract = wikiResponse.getExtract();
		boolean found = wikiExtract.toLowerCase().contains(searchStringCity.toLowerCase());
		assertTrue(found);
	}
	
	/**
	 * Test if the returned extract contains the search string (country)
	 */
	@Test
	public void testIfExtractContainsCountryString() {
		System.out.println("Test: checkIfExtractContainsCountryString");
		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch(searchStringCountry);
		String wikiExtract = wikiResponse.getExtract();
		boolean found = wikiExtract.toLowerCase().contains(searchStringCountry.toLowerCase());
		assertTrue(found);
	}
	
	/**
	 * Test if the returned title contains the search string (city)
	 */
	@Test
	public void testIfTitleContainsCityString() {
		System.out.println("Test: checkIfTitleContainsCityString");		
		WikipediaResponse wikiResponse = new APIContainerWikipedia().processSearch(searchStringCity);
		String wikiTitle = wikiResponse.getTitle();
		boolean found = wikiTitle.toLowerCase().contains(searchStringCity.toLowerCase());
		assertTrue(found);
	}
	
	/**
	 * Test if the returned title contains the search string (country)
	 */
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
