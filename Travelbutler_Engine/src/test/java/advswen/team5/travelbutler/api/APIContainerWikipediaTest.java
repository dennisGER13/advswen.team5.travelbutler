// *************************************************************************************
// File:         [APIContainerWikipediaTest.java]
// Created:      [2016/06/07 Tuesday]
// Last Changed: $Date: 2016/06/22 21:41:00 $
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
	private IAPIResponse processSearchCity;
	private IAPIResponse processSearchCountry;
	
	

	@Before
	public void setup(){
		iapiContainer = new APIContainerWikipedia();
		processSearchCity = iapiContainer.processSearch(searchStringCity);
		processSearchCountry = iapiContainer.processSearch(searchStringCountry);	
		
		
	
	}
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerWikipedia#processSearch(java.lang.String)}.
	 * The returned WikipediaResponse should not be Null, if a valid city is provided to the method processSearch.
	 */
	@Test
	public void processSearchShouldNotBeNullForValidCity() {
		assertNotNull(processSearchCity);
		
	}
	
	/**
	 * Test method for {@link advswen.team5.travelbutler.api.APIContainerWikipedia#processSearch(java.lang.String)}.
	 * The returned WikipediaResponse should not be Null, if a valid country is provided to the method processSearch.
	 */
	@Test
	public void processSearchShouldNotBeNullForValidCountry() {
		assertNotNull(processSearchCountry);
		
	}
	
	/**
	 * The method isMissing should return false, if a valid city is provided
	 */
	@Test
	public void isMissingShouldBeFalseForValidCity() {
		assertFalse(processSearchCity.isMissing());
	}
	
	/**
	 * The method isMissing should return false, if a valid country is provided
	 */
	@Test
	public void isMissingShouldBeFalseForValidCountry() {
		assertFalse(processSearchCountry.isMissing());
	}
	
	/**
	 * The method processSearch should throw a NullPointerException, if null is provided
	 */
	@Test(expected = NullPointerException.class)
	public void processSearchShouldThrowNullPointerExceptionForNullString() {
		IAPIResponse processSearchNull = iapiContainer.processSearch(null);
	}
	
	/**
	 * The method processSearch should throw a NullPointerException, if a blank string is provided
	 */
	@Test(expected = NullPointerException.class)
	public void processSearchShouldThrowNullPointerExceptionForBlankString() {
		IAPIResponse processSearchBlank = iapiContainer.processSearch("");
	}
	
	/**
	 * Test if the returned extract contains the search string (city)
	 */
	@Test
	public void testIfExtractContainsCityString() {
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
